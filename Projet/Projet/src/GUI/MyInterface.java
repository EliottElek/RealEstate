package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

public class MyInterface extends JFrame implements ActionListener, ChangeListener {

    /**
     *
     */
    int i = 0;
    SellerDAO sellerdao;
    BuyerDAO buyerdao;
    EmployeeDAO employeedao;
    EstateDAO estatedao;
    BookingDAO bookingdao;
    User actualuser;
    MyLogIn login;
    NewAccount newaccount;
    BuyerInterface buyerinterface;
    SellerInterface sellerinterface;
    MyProfile myprofile;
    boolean actionput = false;
    ArrayList<Estate> propertysample;
    EmployeeInterface employeeinterface;
    Vector<Seller> listOfSellers = new Vector();
    Vector<Buyer> listOfBuyers = new Vector();
    Vector<Employee> listOfEmployees = new Vector();

    MyInterface(int factor, int w, int h) throws IOException, Exception {
        this.setResizable(true);
        sellerdao = new SellerDAO();
        buyerdao = new BuyerDAO();
        employeedao = new EmployeeDAO();
        estatedao = new EstateDAO();
        bookingdao = new BookingDAO();
        login = new MyLogIn(factor, sellerdao, buyerdao, employeedao);
        newaccount = new NewAccount(factor, sellerdao, buyerdao, employeedao);
        propertysample = new ArrayList();
        sellerinterface = new SellerInterface(factor, estatedao);
        buyerinterface = new BuyerInterface(propertysample, factor, estatedao, bookingdao);
        myprofile = new MyProfile(actualuser, sellerdao, buyerdao, employeedao);
        employeeinterface = new EmployeeInterface(sellerdao, buyerdao, employeedao);
        this.setSize(w, h);
        this.setTitle("Estate Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //adding actionlisteners to all buttons from MyLogIn panel
        login.newaccount.addActionListener(this);
        login.enter.addActionListener(this);
        login.userpassword.addActionListener(this);
        login.usermail.addActionListener(this);
        login.user.addActionListener(this);
        login.visitor.addActionListener(this);
        //adding actionlisteners to all buttons from NewAccount panel
        newaccount.createaccount.addActionListener(this);
        newaccount.newfirstname.addActionListener(this);
        newaccount.newlastname.addActionListener(this);
        newaccount.newmail.addActionListener(this);
        newaccount.newpassword.addActionListener(this);
        newaccount.newadress.addActionListener(this);
        newaccount.birthday.addActionListener(this);
        newaccount.birthmonth.addActionListener(this);
        newaccount.birthyear.addActionListener(this);
        newaccount.back.addActionListener(this);
        newaccount.user.addActionListener(this);
        buyerinterface.search.addActionListener(this);
        //adding actionlisteners to all button from BuyerInterface panel
        buyerinterface.price.addChangeListener(this);
        buyerinterface.minarea.addChangeListener(this);
        buyerinterface.maxarea.addChangeListener(this);
        buyerinterface.gardenareachosen.addChangeListener(this);
        buyerinterface.gardenchoice.addActionListener(this);
        buyerinterface.back.addActionListener(this);
        buyerinterface.logout.addActionListener(this);
        buyerinterface.viewall.addActionListener(this);
        buyerinterface.myprofile.addActionListener(this);

        employeeinterface.profile.addActionListener(this);
        employeeinterface.logout.addActionListener(this);
        employeeinterface.viewprofiles.addActionListener(this);
        employeeinterface.back.addActionListener(this);
        employeeinterface.viewproperties.addActionListener(this);
        //addibg actionlisteners to all button from SellerInterface panel
        sellerinterface.add.addActionListener(this);
        sellerinterface.locate.addActionListener(this);
        sellerinterface.proximitychosen.addActionListener(this);
        sellerinterface.nbroomschosen.addActionListener(this);
        sellerinterface.nbbthroomschosen.addActionListener(this);
        sellerinterface.back.addActionListener(this);
        sellerinterface.logout.addActionListener(this);
        sellerinterface.addpicture1.addActionListener(this);
        sellerinterface.addpicture2.addActionListener(this);
        sellerinterface.addpicture3.addActionListener(this);
        sellerinterface.gardenyes.addActionListener(this);
        sellerinterface.gardenno.addActionListener(this);
        sellerinterface.rent.addActionListener(this);
        sellerinterface.sell.addActionListener(this);
        sellerinterface.myprofile.addActionListener(this);

        myprofile.backbutton.addActionListener(this);
        myprofile.modify.addActionListener(this);
        myprofile.save.addActionListener(this);
        myprofile.delete.addActionListener(this);
        this.add(login);
    }

    public void setPropertiesArray(ArrayList<Estate> properties) {
        this.propertysample = properties;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login.visitor) {
            //chart();
            setContentPane(employeeinterface);
            invalidate();
            validate();
        }
        if (ae.getSource() == employeeinterface.logout) {
            setContentPane(login);
            invalidate();
            validate();
        }
        sellerinterface.SellerAddProperty(ae);
        try {
            employeeinterface.EmployeeInteface(ae, this);
        } catch (SQLException ex) {
            Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            login.login(ae);
        } catch (Exception ex) {
            Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        newaccount.createAccount(ae, listOfSellers, listOfBuyers, listOfEmployees);
        if (ae.getSource() == login.newaccount) {
            setContentPane(newaccount);
            invalidate();
            validate();
        } else if (ae.getSource() == newaccount.back) {
            setContentPane(login);
            invalidate();
            validate();
        } else if ((ae.getSource() == login.enter) && (login.logedin)) {
            if (login.buyeruser) {
                actualuser = login.actualuser;
                System.out.println("ACTUAL USER");
                actualuser.showInfos();
                setContentPane(buyerinterface);
            } else if (login.selleruser) {
                actualuser = login.actualuser;
                System.out.println("ACTUAL USER");
                actualuser.showInfos();
                setContentPane(sellerinterface);
            } else if (login.employeeuser) {
                actualuser = login.actualuser;
                System.out.println("ACTUAL USER");
                actualuser.showInfos();
                setContentPane(employeeinterface);
            }
            System.out.println("actual ID : " + actualuser.getID());
            if (!actionput) {
                actualuser.PANELMODIFY.day.addActionListener(this);
                actualuser.PANELMODIFY.month.addActionListener(this);
                actualuser.PANELMODIFY.year.addActionListener(this);
                actionput = false;
            }
            invalidate();
            validate();
        }
        {
            if (ae.getSource() == buyerinterface.search) {
                buyerinterface.cleanProperties();
                buyerinterface.viewall.setVisible(false);
                try {
                    try {
                        buyerinterface.showResearchResults(ae);
                    } catch (Exception ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    buyerinterface.showResults(this);
                    invalidate();
                    validate();
                } catch (IOException ex) {
                    Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                buyerinterface.bookFunction(ae,actualuser,this);
            } catch (SQLException ex) {
                Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ae.getSource() == myprofile.backbutton) {
                myprofile.removeInfosOfProfile(actualuser);
                if (login.buyeruser) {
                    setContentPane(buyerinterface);
                } else if (login.selleruser) {
                    setContentPane(sellerinterface);
                } else if (login.employeeuser) {
                    setContentPane(employeeinterface);
                }
                invalidate();
                validate();
            }
            if ((ae.getSource() == buyerinterface.myprofile) || (ae.getSource() == sellerinterface.myprofile) || (ae.getSource() == employeeinterface.profile)) {
                myprofile.modif = false;
                myprofile.ShowInfosOfProfile(actualuser);
                setContentPane(myprofile);
                invalidate();
                validate();
            }
            if (ae.getSource() == myprofile.modify) {
                myprofile.modif = true;
                myprofile.removeInfosOfProfile(actualuser);
                myprofile.modifyProfile(actualuser);
                invalidate();
                validate();
            }
            if (ae.getSource() == myprofile.save) {
                myprofile.modif = true;
                if (login.selleruser) {
                    try {
                        myprofile.SellerModifiedProfile();
                        actualuser = myprofile.user;
                    } catch (SQLException ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    myprofile.removeInfosOfProfile(actualuser);

                    if (login.buyeruser) {
                        setContentPane(buyerinterface);
                    } else if (login.selleruser) {
                        setContentPane(sellerinterface);
                    } else if (login.employeeuser) {
                        setContentPane(employeeinterface);
                    }

                } else if (login.buyeruser) {
                    try {
                        myprofile.BuyerModifiedProfile();
                        actualuser = myprofile.user;
                    } catch (SQLException ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    myprofile.removeInfosOfProfile(actualuser);
                    if (login.buyeruser) {
                        setContentPane(buyerinterface);
                    } else if (login.selleruser) {
                        setContentPane(sellerinterface);
                    } else if (login.employeeuser) {
                        setContentPane(employeeinterface);
                    }

                } else if (login.employeeuser) {
                    try {
                        myprofile.EmployeeModifiedProfile();
                        actualuser = myprofile.user;
                    } catch (SQLException ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    myprofile.removeInfosOfProfile(actualuser);
                    if (login.buyeruser) {
                        setContentPane(buyerinterface);
                    } else if (login.selleruser) {
                        setContentPane(sellerinterface);
                    } else if (login.employeeuser) {
                        setContentPane(employeeinterface);
                    }

                }
                invalidate();
                validate();
            } else if (ae.getSource() == myprofile.delete) {
                if (login.buyeruser) {
                    try {
                        buyerdao.removeBuyer(this.actualuser);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (login.selleruser) {
                    try {
                        sellerdao.removeSeller(this.actualuser);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (login.employeeuser) {
                    try {
                        employeedao.removeEmployee(this.actualuser);
                    } catch (SQLException ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                login.logedin = false;
                actualuser = null;
                setContentPane(login);
                invalidate();
                validate();
            }

            if (ae.getSource() == buyerinterface.viewall) {
                buyerinterface.cleanProperties();
                buyerinterface.viewall.setVisible(false);
                try {
                    try {
                        buyerinterface.showAllResults(this);
                    } catch (Exception ex) {
                        Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    buyerinterface.showResults(this);
                    invalidate();
                    validate();
                } catch (IOException ex) {
                    Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getSource() == buyerinterface.back) {
                buyerinterface.viewall.setVisible(true);
                buyerinterface.backToSearchMenu();
                invalidate();
                validate();
            } else if ((ae.getSource() == buyerinterface.logout) || (ae.getSource() == sellerinterface.logout) || (ae.getSource() == employeeinterface.logout)) {
                login.logedin = false;
                actualuser = null;
                setContentPane(login);
                invalidate();
                validate();
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        buyerinterface.BuyerResearch(ce);
    }

    /* public void chart() {
     DefaultCategoryDataset dataset = new DefaultCategoryDataset();
     dataset.setValue(80, "Marks", "Student1");
     dataset.setValue(50, "Marks", "Student2");
     dataset.setValue(75, "Marks", "Student3");
     dataset.setValue(95, "Marks", "Student4");
     JFreeChart chart = ChartFactory.createBarChart("Sudent score", "Student name", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
     CategoryPlot p = chart.getCategoryPlot();
     p.setRangeGridlinePaint(Color.black);
     ChartPanel chartframe = new ChartPanel(chart);
     employeeinterface.PANEL5.add(chartframe);

     }*/
}
