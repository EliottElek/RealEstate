package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeeInterface extends JPanel {

    JPanel PANEL1;
    JPanel PANEL2;
    JPanel PANEL3;
    JPanel PANEL4;
    JPanel PANEL5;
    JPanel PANEL6;
    JPanel PANEL7;
    JPanel ShowPANEL;
    JButton logout;
    JButton profile;
    JButton viewprofiles;
    JButton searchprofile;
    JButton back;
    JButton viewproperties;
    JComboBox menuderoulant;
    EstateDAO estatedao;
    EmployeeDAO employeedao;
    BuyerDAO buyerdao;
    SellerDAO sellerdao;
    BookingDAO bookingdao;
    JPanel panelsellers;
    JPanel panelbuyers;
    JPanel panelemployees;
    ArrayList<Estate> properties;
    JScrollPane SCROLLER;
    JScrollPane SCROLLER2;
    MyProfile[] buyersProfiles;
    MyProfile[] sellersProfiles;
    MyProfile[] employeesProfiles;
    JPanel[] bufferBuyersProfiles;
    JPanel[] bufferSellersProfiles;
    JPanel[] bufferEmployeesProfiles;
    boolean allprop = false;
    ArrayList<Buyer> buyerslist;
    ArrayList<Seller> sellerslist;
    ArrayList<Employee> employeeslist;
    Estate actualestate;

    EmployeeInterface(SellerDAO sellerdao, BuyerDAO buyerdao, EmployeeDAO employeedao) throws Exception {

        buyerslist = new ArrayList();
        sellerslist = new ArrayList();
        employeeslist = new ArrayList();
        properties = new ArrayList();
        estatedao = new EstateDAO();
        this.employeedao = employeedao;
        this.buyerdao = buyerdao;
        this.sellerdao = sellerdao;
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setLayout(new BorderLayout(8, 8));
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL3 = new JPanel();
        PANEL4 = new JPanel();
        PANEL5 = new JPanel();
        PANEL6 = new JPanel();
        PANEL7 = new JPanel();
        ShowPANEL = new JPanel();
        profile = new JButton("my profile");
        logout = new JButton("log out");
        searchprofile = new JButton("search user");
        viewprofiles = new JButton("view all profiles");
        back = new JButton("back");
        viewproperties = new JButton("view properties");
        profile.setFocusable(false);
        logout.setFocusable(false);
        viewprofiles.setFocusable(false);
        back.setFocusable(false);
        PANEL1.setLayout(new BorderLayout());
        PANEL6.setLayout(new BorderLayout());
        PANEL5.setLayout(new BorderLayout());
        Color col = new Color(155, 155, 70);//darker
        Color col2 = new Color(200, 200, 130);//lighter
        PANEL1.setBackground(col);
        PANEL2.setBackground(col);
        PANEL3.setBackground(col);
        PANEL4.setBackground(col);
        PANEL5.setBackground(col2);
        PANEL6.setBackground(col2);
        PANEL7.setBackground(col);
        PANEL1.setPreferredSize(new Dimension(100, 100));
        PANEL2.setPreferredSize(new Dimension(100, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL4.setPreferredSize(new Dimension(200, 100));
        PANEL5.setPreferredSize(new Dimension(100, 100));
        PANEL6.setPreferredSize(new Dimension(250, 100));
        PANEL7.setPreferredSize(new Dimension(200, 800 * (this.properties.size() + 1)));

        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.SOUTH);
        this.add(PANEL3, BorderLayout.WEST);
        this.add(PANEL4, BorderLayout.EAST);
        this.add(PANEL5, BorderLayout.CENTER);
        PANEL1.add(PANEL6, BorderLayout.EAST);
        PANEL6.add(profile, BorderLayout.CENTER);
        PANEL6.add(logout, BorderLayout.NORTH);
        PANEL4.add(viewprofiles);
        PANEL4.add(viewproperties);
        PANEL4.add(back);
        back.setVisible(false);
    }

    public void EmployeeInteface(ActionEvent ae, ActionListener al) throws SQLException, Exception {
        if (ae.getSource() == viewprofiles) {
            viewprofiles.setVisible(false);
            viewproperties.setVisible(false);
            back.setVisible(true);
            try {
                showAllProfilesOnPanel(al);
            } catch (Exception ex) {
                Logger.getLogger(EmployeeInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((ae.getSource() == back) && !allprop) {
            PANEL7.removeAll();
            ShowPANEL.removeAll();
            PANEL5.removeAll();
            viewprofiles.setVisible(true);
            viewproperties.setVisible(true);
            back.setVisible(false);
            repaint();
            invalidate();
            validate();
        }
        if (ae.getSource() == viewproperties) {
            viewprofiles.setVisible(false);
            viewproperties.setVisible(false);
            allprop = true;
            cleanProperties();
            try {
                showAllResults();
                showResults(al);
                repaint();
                invalidate();
                validate();
            } catch (Exception ex) {
                Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if ((ae.getSource() == back) && allprop) {
            PANEL7.removeAll();
            viewprofiles.setVisible(true);
            viewproperties.setVisible(true);
            backToSearchMenu();
            allprop = false;
            repaint();
            invalidate();
            validate();
        }
        if (!buyerslist.isEmpty()) {
            for (int i = 0; i < buyerslist.size(); i++) {
                if (ae.getSource() == buyersProfiles[i].modify) {
                    buyersProfiles[i].modif = true;
                    buyersProfiles[i].removeInfosOfProfile(buyerslist.get(i));
                    buyersProfiles[i].modifyProfile(buyerslist.get(i));
                    invalidate();
                    validate();
                } else if (ae.getSource() == buyersProfiles[i].save) {
                    buyersProfiles[i].modif = true;
                    buyersProfiles[i].BuyerModifiedProfile();
                    bufferBuyersProfiles[i].removeAll();
                    buyerslist.get(i).updateInfosMyProfile();
                    buyersProfiles[i].removeInfosOfProfile(buyerslist.get(i));
                    buyersProfiles[i].ShowInfosOfProfile(buyerslist.get(i));
                    buyersProfiles[i].logout.setVisible(false);
                    buyersProfiles[i].seebookings.setVisible(false);
                    buyersProfiles[i].backbutton.setVisible(false);
                    buyersProfiles[i].delete.setText("delete account");
                    buyersProfiles[i].delete.addActionListener(al);
                    buyersProfiles[i].modify.addActionListener(al);
                    buyersProfiles[i].save.addActionListener(al);
                    buyerslist.get(i).PANELMODIFY.day.addActionListener(al);
                    buyerslist.get(i).PANELMODIFY.month.addActionListener(al);
                    buyerslist.get(i).PANELMODIFY.year.addActionListener(al);
                    bufferBuyersProfiles[i].add(buyersProfiles[i]);
                    repaint();
                    invalidate();
                    validate();
                } else if (ae.getSource() == buyersProfiles[i].delete) {
                    buyerdao.removeBuyer(buyerslist.get(i));
                    buyerslist.remove(i);
                    bufferBuyersProfiles[i].removeAll();
                    PANEL7.removeAll();
                    ShowPANEL.removeAll();
                    PANEL5.removeAll();
                    viewprofiles.setVisible(true);
                    viewproperties.setVisible(true);
                    back.setVisible(false);
                    repaint();
                    invalidate();
                    validate();

                }
            }
        }
        if (!sellerslist.isEmpty()) {
            for (int i = 0; i < sellerslist.size(); i++) {
                if (ae.getSource() == sellersProfiles[i].modify) {
                    sellersProfiles[i].modif = true;
                    sellersProfiles[i].removeInfosOfProfile(sellerslist.get(i));
                    sellersProfiles[i].modifyProfile(sellerslist.get(i));
                    invalidate();
                    validate();
                } else if (ae.getSource() == sellersProfiles[i].save) {
                    sellersProfiles[i].modif = true;
                    sellersProfiles[i].SellerModifiedProfile();
                    bufferSellersProfiles[i].removeAll();
                    sellerslist.get(i).updateInfosMyProfile();
                    sellersProfiles[i].removeInfosOfProfile(sellerslist.get(i));
                    sellersProfiles[i].ShowInfosOfProfile(sellerslist.get(i));
                    sellersProfiles[i].logout.setVisible(false);
                    sellersProfiles[i].seebookings.setVisible(false);
                    sellersProfiles[i].backbutton.setVisible(false);
                    sellersProfiles[i].delete.setText("delete account");
                    sellersProfiles[i].delete.addActionListener(al);
                    sellersProfiles[i].modify.addActionListener(al);
                    sellersProfiles[i].save.addActionListener(al);
                    sellerslist.get(i).PANELMODIFY.day.addActionListener(al);
                    sellerslist.get(i).PANELMODIFY.month.addActionListener(al);
                    sellerslist.get(i).PANELMODIFY.year.addActionListener(al);
                    bufferSellersProfiles[i].add(sellersProfiles[i]);
                    repaint();
                    invalidate();
                    validate();
                } else if (ae.getSource() == sellersProfiles[i].delete) {
                    sellerdao.removeSeller(sellerslist.get(i));
                    sellerslist.remove(i);
                    bufferSellersProfiles[i].removeAll();
                    PANEL7.removeAll();
                    ShowPANEL.removeAll();
                    PANEL5.removeAll();
                    back.setVisible(false);
                    repaint();
                    invalidate();
                    validate();

                }
            }
        }
        if (!employeeslist.isEmpty()) {
            for (int i = 0; i < employeeslist.size(); i++) {
                if (ae.getSource() == employeesProfiles[i].modify) {
                    employeesProfiles[i].modif = true;
                    employeesProfiles[i].removeInfosOfProfile(employeeslist.get(i));
                    employeesProfiles[i].modifyProfile(employeeslist.get(i));
                    invalidate();
                    validate();
                } else if (ae.getSource() == employeesProfiles[i].save) {
                    employeesProfiles[i].modif = true;
                    employeesProfiles[i].EmployeeModifiedProfile();
                    bufferEmployeesProfiles[i].removeAll();
                    employeeslist.get(i).updateInfosMyProfile();
                    employeesProfiles[i].removeInfosOfProfile(employeeslist.get(i));
                    employeesProfiles[i].ShowInfosOfProfile(employeeslist.get(i));
                    employeesProfiles[i].logout.setVisible(false);
                    employeesProfiles[i].seebookings.setVisible(false);
                    employeesProfiles[i].backbutton.setVisible(false);
                    employeesProfiles[i].delete.setText("delete account");
                    employeesProfiles[i].delete.addActionListener(al);
                    employeesProfiles[i].modify.addActionListener(al);
                    employeesProfiles[i].save.addActionListener(al);
                    employeeslist.get(i).PANELMODIFY.day.addActionListener(al);
                    employeeslist.get(i).PANELMODIFY.month.addActionListener(al);
                    employeeslist.get(i).PANELMODIFY.year.addActionListener(al);
                    bufferEmployeesProfiles[i].add(employeesProfiles[i]);
                    repaint();
                    invalidate();
                    validate();
                } else if (ae.getSource() == employeesProfiles[i].delete) {
                    employeedao.removeEmployee(employeeslist.get(i));
                    employeeslist.remove(i);
                    bufferSellersProfiles[i].removeAll();
                    PANEL7.removeAll();
                    ShowPANEL.removeAll();
                    PANEL5.removeAll();
                    back.setVisible(false);
                    repaint();
                    invalidate();
                    validate();

                }
            }
        }

        for (Estate propertie : properties) {
            if (ae.getSource() == propertie.modify) {
                this.actualestate = propertie;
                PANEL5.removeAll();
                EstateModify em = new EstateModify(propertie);
                PANEL5.setLayout(new GridLayout(1, 1));
                PANEL5.add(em);
                repaint();
                invalidate();
                validate();
            } else if (ae.getSource() == propertie.save) {
                this.actualestate = propertie;
                PANEL7.removeAll();
                modifyEstate(actualestate);
                PANEL5.remove(PANEL7);
                PANEL5.removeAll();
                repaint();
                invalidate();
                validate();
                back.setVisible(false);
                repaint();
                viewprofiles.setVisible(true);
                viewproperties.setVisible(true);
                back.setVisible(false);
                showAllResults();
                showResults(al);
                repaint();
                invalidate();
                validate();
                break;
            } else if (ae.getSource() == propertie.delete) {
                this.actualestate = propertie;
                estatedao.removeEstate(actualestate);
                repaint();
                invalidate();
                validate();
            }

        }

    }

    public void modifyEstate(Estate estate) throws SQLException {
        String newlocation = (String) estate.newlocation.getSelectedItem();
        String newadress = estate.newadress.getText();
        String newdescription = estate.newdescription.getText();
        int newprice = Integer.parseInt(estate.newprice.getText());
        int newarea = Integer.parseInt(estate.newarea.getText());
        this.actualestate.setLocation(newlocation);
        this.actualestate.setAdress(newadress);
        this.actualestate.setDescription(newdescription);
        this.actualestate.setPrice(newprice);
        this.actualestate.setArea(newarea);
        estatedao.modifyEstate(this.actualestate);
    }

    public void showAllProfilesOnPanel(ActionListener ae) throws Exception {
        //ShowPANEL.removeAll();
        buyerslist = buyerdao.getAllBuyers();
        sellerslist = sellerdao.getAllSellers();
        employeeslist = employeedao.getAllEmployees();
        int nbbuyers = buyerslist.size();
        int nbsellers = sellerslist.size();
        int nbemployees = employeeslist.size();
        int total = nbbuyers + nbsellers + nbemployees;
        buyersProfiles = new MyProfile[nbbuyers];
        sellersProfiles = new MyProfile[nbsellers];
        employeesProfiles = new MyProfile[nbemployees];
        bufferBuyersProfiles = new JPanel[nbbuyers];
        bufferSellersProfiles = new JPanel[nbsellers];
        bufferEmployeesProfiles = new JPanel[nbemployees];
        ShowPANEL.setPreferredSize(new Dimension(100, 600 * total));
        ShowPANEL.setLayout(new GridLayout(total + 3, 1));
        ShowPANEL.add(new JLabel("BUYERS"));
        for (int i = 0; i < buyerslist.size(); i++) {
            buyersProfiles[i] = new MyProfile(buyerslist.get(i), sellerdao, buyerdao, employeedao);
            buyersProfiles[i].ShowInfosOfProfile(buyerslist.get(i));
            buyersProfiles[i].logout.setVisible(false);
            buyersProfiles[i].seebookings.setVisible(false);
            buyersProfiles[i].backbutton.setVisible(false);
            buyersProfiles[i].delete.setText("delete account");
            buyersProfiles[i].delete.addActionListener(ae);
            buyersProfiles[i].modify.addActionListener(ae);
            buyersProfiles[i].save.addActionListener(ae);
            buyerslist.get(i).PANELMODIFY.day.addActionListener(ae);
            buyerslist.get(i).PANELMODIFY.month.addActionListener(ae);
            buyerslist.get(i).PANELMODIFY.year.addActionListener(ae);
            bufferBuyersProfiles[i] = new JPanel();
            buyersProfiles[i].remove(PANEL1);
            buyersProfiles[i].remove(PANEL2);
            buyersProfiles[i].remove(PANEL3);
            buyersProfiles[i].remove(PANEL4);
            buyersProfiles[i].setPreferredSize(new Dimension(1000, 2000));
            bufferBuyersProfiles[i].setLayout(new BorderLayout());
            bufferBuyersProfiles[i].setPreferredSize(new Dimension(1000, 1000));
            bufferBuyersProfiles[i].setBackground(Color.blue);
            bufferBuyersProfiles[i].add(buyersProfiles[i], BorderLayout.CENTER);
            ShowPANEL.add(bufferBuyersProfiles[i]);
        }
        ShowPANEL.add(new JLabel("SELLERS"));
        for (int i = 0; i < sellerslist.size(); i++) {
            sellersProfiles[i] = new MyProfile(sellerslist.get(i), sellerdao, buyerdao, employeedao);
            sellersProfiles[i].ShowInfosOfProfile(sellerslist.get(i));
            sellersProfiles[i].logout.setVisible(false);
            sellersProfiles[i].seebookings.setVisible(false);
            sellersProfiles[i].backbutton.setVisible(false);
            sellersProfiles[i].delete.setText("delete account");
            sellersProfiles[i].delete.addActionListener(ae);
            sellersProfiles[i].modify.addActionListener(ae);
            sellersProfiles[i].save.addActionListener(ae);
            sellerslist.get(i).PANELMODIFY.month.addActionListener(ae);
            sellerslist.get(i).PANELMODIFY.year.addActionListener(ae);
            sellerslist.get(i).PANELMODIFY.day.addActionListener(ae);
            sellerslist.get(i).PANELMODIFY.month.addActionListener(ae);
            sellerslist.get(i).PANELMODIFY.year.addActionListener(ae);
            sellersProfiles[i].remove(PANEL1);
            sellersProfiles[i].remove(PANEL2);
            sellersProfiles[i].remove(PANEL3);
            sellersProfiles[i].remove(PANEL4);
            sellersProfiles[i].setPreferredSize(new Dimension(1000, 2000));
            bufferSellersProfiles[i] = new JPanel();
            bufferSellersProfiles[i].setLayout(new BorderLayout());
            bufferSellersProfiles[i].setPreferredSize(new Dimension(1000, 2000));
            bufferSellersProfiles[i].setBackground(Color.blue);
            bufferSellersProfiles[i].add(sellersProfiles[i]);
            ShowPANEL.add(bufferSellersProfiles[i]);
        }
        ShowPANEL.add(new JLabel("EMPLOYEES"));
        for (int i = 0; i < employeeslist.size(); i++) {
            employeesProfiles[i] = new MyProfile(employeeslist.get(i), sellerdao, buyerdao, employeedao);
            employeesProfiles[i].ShowInfosOfProfile(employeeslist.get(i));
            employeesProfiles[i].logout.setVisible(false);
            employeesProfiles[i].backbutton.setVisible(false);
            employeesProfiles[i].seebookings.setVisible(false);
            employeesProfiles[i].delete.setText("delete account");
            employeesProfiles[i].delete.addActionListener(ae);
            employeesProfiles[i].modify.addActionListener(ae);
            employeesProfiles[i].save.addActionListener(ae);
            employeeslist.get(i).PANELMODIFY.month.addActionListener(ae);
            employeeslist.get(i).PANELMODIFY.year.addActionListener(ae);
            employeeslist.get(i).PANELMODIFY.day.addActionListener(ae);
            employeeslist.get(i).PANELMODIFY.month.addActionListener(ae);
            employeeslist.get(i).PANELMODIFY.year.addActionListener(ae);
            employeesProfiles[i].remove(PANEL1);
            employeesProfiles[i].remove(PANEL2);
            employeesProfiles[i].remove(PANEL3);
            employeesProfiles[i].remove(PANEL4);
            employeesProfiles[i].setPreferredSize(new Dimension(1000, 2000));
            bufferEmployeesProfiles[i] = new JPanel();
            bufferEmployeesProfiles[i].setLayout(new BorderLayout());
            bufferEmployeesProfiles[i].setPreferredSize(new Dimension(1000, 1000));
            bufferEmployeesProfiles[i].setBackground(Color.blue);
            bufferEmployeesProfiles[i].add(employeesProfiles[i]);
            ShowPANEL.add(bufferEmployeesProfiles[i]);
        }
        SCROLLER2 = new JScrollPane(ShowPANEL);
        SCROLLER2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLLER2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        PANEL5.add(SCROLLER2);

        repaint();
        invalidate();
        validate();

    }

    void cleanProperties() {

        for (Estate propertie : properties) {
            propertie.removeInfos(ShowPANEL);
        }

        properties.removeAll(properties);

    }

    void showAllResults() throws Exception {
        cleanProperties();
        properties = estatedao.getAllEstates();
    }

    public void showResults(ActionListener al) throws IOException {
        PANEL5.removeAll();
        //PANEL11.setLayout(new GridLayout(properties.size(), 2));
        PANEL5.remove(ShowPANEL);
        PANEL7.setLayout(new GridLayout(this.properties.size(), 2));
        PANEL7.setPreferredSize(new Dimension(200, 800 * (this.properties.size())));
        showAllPropertiesImage(PANEL7, al);
        SCROLLER = new JScrollPane(PANEL7);
        SCROLLER.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLLER.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        PANEL5.add(SCROLLER);
        back.setVisible(true);
        repaint();
    }

    void showAllPropertiesImage(JPanel panel, ActionListener al) throws IOException {
        for (Estate propertie : properties) {
            propertie.setVisibleButton(true);
            propertie.delete.setVisible(true);
            propertie.booking.setVisible(false);
            propertie.addInfosOnPanel(PANEL7, false);
            propertie.modify.addActionListener(al);
            propertie.save.addActionListener(al);
            propertie.delete.addActionListener(al);

        }
    }

    public void backToSearchMenu() {
        cleanProperties();
        PANEL5.remove(PANEL7);
        PANEL5.remove(SCROLLER);
        PANEL5.add(ShowPANEL);
        back.setVisible(false);
        repaint();
    }
}
