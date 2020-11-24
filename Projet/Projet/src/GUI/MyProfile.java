package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyProfile extends JPanel {

    User user;
    JPanel PANEL1;
    JPanel PANEL2;
    JPanel PANEL3;
    JPanel PANEL4;
    JPanel PANEL5;
    JPanel COMMANDPANEL;
    JPanel back;
    JButton modify;
    JButton delete;
    JButton seebookings;
    JButton backbutton;
    JButton save;
    JButton logout;
    boolean modif = false;
    SellerDAO sellerdao;
    BuyerDAO buyerdao;
    EmployeeDAO employeedao;

    MyProfile() throws Exception {
        sellerdao = new SellerDAO();
        buyerdao = new BuyerDAO();
        employeedao = new EmployeeDAO();
        this.setVisible(true);
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL3 = new JPanel();
        PANEL4 = new JPanel();
        PANEL5 = new JPanel();
        COMMANDPANEL = new JPanel();
        back = new JPanel();
        backbutton = new JButton("<- back");
        modify = new JButton("modify profile");
        delete = new JButton("delete my account");
        seebookings = new JButton("see my bookings");
        logout = new JButton("log out");
        save = new JButton("save");
        save.setVisible(false);
        delete.setBackground(Color.red);
        this.setLayout(new BorderLayout(10, 10));
        PANEL1.setLayout(new BorderLayout(10, 10));
        back.setLayout(new GridLayout(3, 1));
        PANEL5.setLayout(new GridLayout(2, 1));
        COMMANDPANEL.setLayout(new GridLayout(6, 5));
        //setting the sizes of PANELS
        PANEL1.setPreferredSize(new Dimension(200, 100));
        PANEL2.setPreferredSize(new Dimension(200, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL4.setPreferredSize(new Dimension(200, 100));
        PANEL5.setPreferredSize(new Dimension(200, 100));
        back.setPreferredSize(new Dimension(200, 100));
        //setting PANELS colors 
        PANEL1.setBackground(Color.gray);
        PANEL2.setBackground(Color.gray);
        PANEL3.setBackground(Color.gray);
        PANEL4.setBackground(Color.gray);
        PANEL5.setBackground(Color.gray);
        back.setBackground(Color.gray);
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.SOUTH);
        this.add(PANEL3, BorderLayout.WEST);
        this.add(PANEL4, BorderLayout.EAST);
        this.add(PANEL5, BorderLayout.CENTER);
        COMMANDPANEL.add(modify);
        COMMANDPANEL.add(seebookings);
        COMMANDPANEL.add(logout);
        COMMANDPANEL.add(delete);
        COMMANDPANEL.add(save);
        back.add(new JLabel());
        back.add(backbutton);
        PANEL1.add(back, BorderLayout.WEST);
        for (int i = 0; i < 22; i++) {
            COMMANDPANEL.add(new JLabel());
        }

    }

    public void ShowInfosOfProfile(User user) {
        save.setVisible(false);
        delete.setVisible(true);
        seebookings.setVisible(true);
        modify.setVisible(true);
        logout.setVisible(true);
        this.user = user;
        modif = false;
        PANEL5.add(user.PANELINFOS);
        PANEL5.add(COMMANDPANEL, BorderLayout.NORTH);
        repaint();
        invalidate();
        validate();
    }

    public void modifyProfile(User user) {
        this.user = user;
        save.setVisible(true);
        delete.setVisible(false);
        seebookings.setVisible(false);
        modify.setVisible(false);
        logout.setVisible(false);
        modif = true;
        removeInfosOfProfile(user);
        PANEL5.add(user.PANELMODIFY);
        PANEL5.add(COMMANDPANEL, BorderLayout.NORTH);
        repaint();
        invalidate();
        validate();
    }

    public void removeInfosOfProfile(User user) {
        PANEL5.remove(user.PANELINFOS);
        PANEL5.remove(COMMANDPANEL);
        if (modif = true) {
            PANEL5.remove(user.PANELMODIFY);
        }
        modif = false;
        repaint();
        invalidate();
        validate();
    }

    public void saveNewBuyer() throws SQLException {
        buyerdao.modifyBuyerProfile(user, returnBuyerModifiedProfile());
        user = returnBuyerModifiedProfile();
        modif = true;
    }

    public void saveNewSeller(int i) throws SQLException {
        sellerdao.modifySellerProfile(user, returnSellerModifiedProfile());
        user = returnSellerModifiedProfile();
        modif = true;
        System.out.println("ptn "+i);
    }

    public void saveNewEmployee() throws SQLException {
        employeedao.modifyEmployeeProfile(user, returnEmployeeModifiedProfile());
        user = returnEmployeeModifiedProfile();
        modif = true;
    }

    public Buyer returnBuyerModifiedProfile() {
        Buyer finalbuyer = null;
        String firstname = user.PANELMODIFY.firstname.getText();
        String lastname = user.PANELMODIFY.lastname.getText();
        String adress = user.PANELMODIFY.adress.getText();
        String mail = user.PANELMODIFY.mail.getText();
        Date date = new Date(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()) - 1900, Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem()) - 1, Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        //date.setDate(Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        //date.setMonth(Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem()));
        //date.setYear(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()));
        finalbuyer = new Buyer(1, firstname, lastname, date, adress, mail);
        System.out.println("date :" + date);
        return finalbuyer;
    }

    public Seller returnSellerModifiedProfile() {
        Seller finalseller = null;
        String firstname = user.PANELMODIFY.firstname.getText();
        String lastname = user.PANELMODIFY.lastname.getText();
        String adress = user.PANELMODIFY.adress.getText();
        String mail = user.PANELMODIFY.mail.getText();
        Date date = new Date(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()) - 1900, Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem()) - 1, Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        finalseller = new Seller(1, firstname, lastname, date, adress, mail);
        System.out.println("date :" + date);
        return finalseller;
    }

    public Employee returnEmployeeModifiedProfile() {
        Employee finalemployee = null;
        String firstname = user.PANELMODIFY.firstname.getText();
        String lastname = user.PANELMODIFY.lastname.getText();
        String adress = user.PANELMODIFY.adress.getText();
        String mail = user.PANELMODIFY.mail.getText();
        Date date = new Date(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()) - 1900, Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem()) - 1, Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        System.out.println("date :" + date);
        finalemployee = new Employee(1, firstname, lastname, date, adress, mail);
        return finalemployee;
    }
}
