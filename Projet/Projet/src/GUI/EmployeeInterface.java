package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
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
    JPanel panelsellers;
    JPanel panelbuyers;
    JPanel panelemployees;
    ArrayList<Estate> properties;
    JScrollPane SCROLLER;
    boolean allprop = false;

    EmployeeInterface() throws Exception {

        properties = new ArrayList();
        estatedao = new EstateDAO();
        employeedao = new EmployeeDAO();
        buyerdao = new BuyerDAO();
        sellerdao = new SellerDAO();
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
        PANEL1.setBackground(Color.gray);
        PANEL2.setBackground(Color.gray);
        PANEL3.setBackground(Color.gray);
        PANEL4.setBackground(Color.gray);
        PANEL5.setBackground(Color.blue);
        PANEL6.setBackground(Color.lightGray);
        PANEL1.setPreferredSize(new Dimension(100, 100));
        PANEL2.setPreferredSize(new Dimension(100, 100));
        PANEL3.setPreferredSize(new Dimension(100, 100));
        PANEL4.setPreferredSize(new Dimension(100, 100));
        PANEL5.setPreferredSize(new Dimension(100, 100));
        ShowPANEL.setPreferredSize(new Dimension(100, 100));
        PANEL6.setPreferredSize(new Dimension(100, 100));
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

    public void EmployeeInteface(ActionEvent ae) {
        if (ae.getSource() == viewprofiles) {
            viewprofiles.setVisible(false);
            viewproperties.setVisible(false);
            back.setVisible(true);
            try {
                showAllProfilesOnPanel();
            } catch (Exception ex) {
                Logger.getLogger(EmployeeInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ((ae.getSource() == back) && !allprop) {
            ShowPANEL.remove(panelbuyers);
            ShowPANEL.remove(panelsellers);
            ShowPANEL.remove(panelemployees);
            PANEL5.remove(ShowPANEL);
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
                showResults();
                repaint();
                invalidate();
                validate();
            } catch (Exception ex) {
                Logger.getLogger(MyInterface.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if ((ae.getSource() == back) && allprop) {
            viewprofiles.setVisible(true);
            viewproperties.setVisible(true);
            backToSearchMenu();
            allprop = false;
            repaint();
            invalidate();
            validate();
        }
    }

    public void showAllProfilesOnPanel() throws Exception {
        ArrayList<Buyer> buyerslist = new ArrayList();
        buyerslist = buyerdao.getAllBuyers();
        ArrayList<Seller> sellerslist = new ArrayList();
        sellerslist = sellerdao.getAllSellers();
        ArrayList<Employee> employeeslist = new ArrayList();
        employeeslist = employeedao.getAllEmployees();
        int nbbuyers = buyerslist.size();
        int nbsellers = sellerslist.size();
        int nbemployees = employeeslist.size();
        //finding out which has the most users
        ShowPANEL.setLayout(new GridLayout(3, 1));
        ShowPANEL.setBackground(Color.yellow);
        JLabel buyers = new JLabel("             Buyers");
        buyers.setForeground(Color.green);
        // ShowPANEL.add(buyers);
        JLabel sellers = new JLabel("          Sellers");
        sellers.setForeground(Color.red);
        //ShowPANEL.add(sellers);
        JLabel employees = new JLabel("          Employees");
        employees.setForeground(Color.blue);
        //ShowPANEL.add(employees);
        PANEL5.add(ShowPANEL);
        Object[][] databuyers = new Object[nbbuyers][5];
        for (int i = 0; i < nbbuyers; i++) {
            databuyers[i][0] = buyerslist.get(i).getFirstName();
            databuyers[i][1] = buyerslist.get(i).getLastName();
            databuyers[i][2] = "     " + buyerslist.get(i).getY() + "-" + buyerslist.get(i).getM() + "-" + buyerslist.get(i).getD();
            databuyers[i][3] = buyerslist.get(i).getAdress();
            databuyers[i][4] = buyerslist.get(i).getEmail();

        }

        String[] entetes1 = {"firstname", "lastname", "birthdate", "adress", "mail"};
        String[] entetes2 = {"firstname", "lastname", "birthdate", "adress", "mail", "number"};

        JTable tableau1 = new JTable(databuyers, entetes1);
        tableau1.setAutoResizeMode(WIDTH);
        tableau1.setAutoResizeMode(HEIGHT);
        tableau1.getAutoResizeMode();
        tableau1.getIntercellSpacing();
        tableau1.setPreferredSize(new Dimension(1000, 20 * nbbuyers));
        panelbuyers = new JPanel();

        Object[][] datasellers = new Object[nbsellers][5];
        for (int i = 0; i < nbsellers; i++) {
            datasellers[i][0] = sellerslist.get(i).getFirstName();
            datasellers[i][1] = sellerslist.get(i).getLastName();
            datasellers[i][2] = "     " + sellerslist.get(i).getY() + "-" + sellerslist.get(i).getM() + "-" + sellerslist.get(i).getD();
            datasellers[i][3] = sellerslist.get(i).getAdress();
            datasellers[i][4] = sellerslist.get(i).getEmail();

        }

        JTable tableau2 = new JTable(datasellers, entetes1);
        tableau2.setAutoResizeMode(WIDTH);
        tableau2.setAutoResizeMode(HEIGHT);
        tableau2.getAutoResizeMode();
        tableau2.getIntercellSpacing();
        tableau2.setPreferredSize(new Dimension(1000, 20 * nbsellers));
        panelsellers = new JPanel();

        Object[][] dataemployees = new Object[nbemployees][6];
        for (int i = 0; i < nbemployees; i++) {
            dataemployees[i][0] = employeeslist.get(i).getFirstName();
            dataemployees[i][1] = employeeslist.get(i).getLastName();
            dataemployees[i][2] = "     " + employeeslist.get(i).getY() + "-" + employeeslist.get(i).getM() + "-" + employeeslist.get(i).getD();
            dataemployees[i][3] = employeeslist.get(i).getAdress();
            dataemployees[i][4] = employeeslist.get(i).getEmail();
            dataemployees[i][5] = employeeslist.get(i).getEmployeeNb();

        }

        JTable tableau3 = new JTable(dataemployees, entetes2);
        tableau3.setAutoResizeMode(WIDTH);
        tableau3.setAutoResizeMode(HEIGHT);
        tableau3.getAutoResizeMode();
        tableau3.getIntercellSpacing();
        tableau3.setPreferredSize(new Dimension(1000, 20 * nbemployees));
        panelemployees = new JPanel();

        panelbuyers.add(tableau1);
        panelsellers.add(tableau2);
        panelemployees.add(tableau3);
        ShowPANEL.add(panelbuyers);
        ShowPANEL.add(panelsellers);
        ShowPANEL.add(panelemployees);
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
        properties = estatedao.getAllEstates();
    }

    public void showResults() throws IOException {
        //PANEL11.setLayout(new GridLayout(properties.size(), 2));
        PANEL5.remove(ShowPANEL);
        PANEL7.setLayout(new GridLayout(this.properties.size(), 2));
        PANEL7.setPreferredSize(new Dimension(200, 800 * (this.properties.size())));
        showAllPropertiesImage(PANEL7);
        SCROLLER = new JScrollPane(PANEL7);
        SCROLLER.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLLER.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        PANEL5.add(SCROLLER);
        back.setVisible(true);
        repaint();
    }

    void showAllPropertiesImage(JPanel panel) throws IOException {
        for (Estate propertie : properties) {
            propertie.setVisibleButton(true);
            propertie.addInfosOnPanel(PANEL7);
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
