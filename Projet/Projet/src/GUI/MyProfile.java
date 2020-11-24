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
        user.updateInfosMyProfile();
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
        //this.user = user;
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
        PANEL5.removeAll();
        modif = false;
        repaint();
        invalidate();
        validate();
    }

    public void BuyerModifiedProfile() throws SQLException {
        String firstname = user.PANELMODIFY.firstname.getText();
        String lastname = user.PANELMODIFY.lastname.getText();
        String adress = user.PANELMODIFY.adress.getText();
        String mail = user.PANELMODIFY.mail.getText();
        Date date = new Date(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()) - 1900, Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem())-1, Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        this.user.setFirstName(firstname);
        this.user.setLastName(lastname);
        this.user.setAdress(adress);
        this.user.setBirthDate(date);
        this.user.setEmail(mail);
        System.out.println("date buyer:" + date);
        buyerdao.modifyBuyerProfile(this.user);
    }

    public void SellerModifiedProfile() throws SQLException {
        String firstname = user.PANELMODIFY.firstname.getText();
        String lastname = user.PANELMODIFY.lastname.getText();
        String adress = user.PANELMODIFY.adress.getText();
        String mail = user.PANELMODIFY.mail.getText();
        Date date = new Date(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()) - 1900, Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem())-1, Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        this.user.setFirstName(firstname);
        this.user.setLastName(lastname);
        this.user.setAdress(adress);
        this.user.setBirthDate(date);
        this.user.setEmail(mail);
        System.out.println("date buyer:" + date);
        sellerdao.modifySellerProfile(this.user);
    }

    public void EmployeeModifiedProfile() throws SQLException {
        String firstname = user.PANELMODIFY.firstname.getText();
        String lastname = user.PANELMODIFY.lastname.getText();
        String adress = user.PANELMODIFY.adress.getText();
        String mail = user.PANELMODIFY.mail.getText();
        Date date = new Date(Integer.parseInt((String) user.PANELMODIFY.year.getSelectedItem()) - 1900, Integer.parseInt((String) user.PANELMODIFY.month.getSelectedItem())-1, Integer.parseInt((String) user.PANELMODIFY.day.getSelectedItem()));
        this.user.setFirstName(firstname);
        this.user.setLastName(lastname);
        this.user.setAdress(adress);
        this.user.setBirthDate(date);
        this.user.setEmail(mail);
        System.out.println("date buyer:" + date);
        employeedao.modifyEmployeeProfile(this.user);
    }
}
