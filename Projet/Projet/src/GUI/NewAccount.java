/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author eliot
 */
public class NewAccount extends JPanel implements MyLogInConstant {

    SellerDAO sellerdao;
    BuyerDAO buyerdao;
    EmployeeDAO employeedao;
    int factor = 1;
    int i = 0;
    JPanel PANEL1;
    JPanel PANEL2;
    JPanel PANEL3;
    JPanel PANELDATE;
    boolean iscreated = false;
    boolean iscomplete = false;
    boolean newbuyer = false;
    boolean newseller = false;
    boolean newemployee = false;
    boolean mailok = false;
    String[] days;
    String[] months;
    String[] years;
    JLabel firstname;
    JLabel lastname;
    JLabel mail;
    JLabel password;
    JLabel number;
    JLabel adress;
    JLabel birthdate;
    JLabel usermail;
    JLabel typeofuser;
    JTextField newfirstname;
    JTextField newlastname;
    JTextField newmail;
    JPasswordField newpassword;
    JPasswordField newnumber;
    JTextField newadress;
    JComboBox birthday;
    JComboBox birthmonth;
    JComboBox birthyear;
    JComboBox user;
    JButton createaccount;
    JButton back;

    public NewAccount(int factor) throws Exception {
        sellerdao = new SellerDAO();
        buyerdao = new BuyerDAO();
        employeedao = new EmployeeDAO();
        this.factor = factor;
        this.setSize(1000 * this.factor, 600 * this.factor);
        this.setLayout(new BorderLayout(8, 8));
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL3 = new JPanel();
        PANELDATE = new JPanel();
        PANEL1.setPreferredSize(new Dimension(100, 150));
        PANEL2.setPreferredSize(new Dimension(100, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL1.setBackground(Color.gray);
        PANEL2.setBackground(Color.lightGray);
        PANEL3.setBackground(Color.gray);
        PANEL2.setLayout(new GridLayout(12, 3, 8, 8));
        PANELDATE.setLayout(new GridLayout(1, 3));
        days = new String[31];
        months = new String[13];
        years = new String[101];
        //creation of the date comboboxes 
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        for (int i = 0; i < 12; i++) {
            months[i] = Integer.toString(i + 1);
        }
        for (int i = 100; i >= 0; i--) {
            years[i] = Integer.toString(2020 - i);
        }
        //creation of the text fields for user's info prompting
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        newfirstname = new JTextField();
        newlastname = new JTextField();
        newmail = new JTextField();
        newpassword = new JPasswordField();
        newnumber = new JPasswordField();
        newadress = new JTextField();
        user = new JComboBox(usertype);

        //creation of the labels 
        firstname = new JLabel("                    firstname :");
        lastname = new JLabel("                     lastname :");
        mail = new JLabel("                         mail :");
        password = new JLabel("                     password :");
        number = new JLabel("              employee number :");
        adress = new JLabel("                       adress :");
        birthdate = new JLabel("                    birthdate :");
        typeofuser = new JLabel("                 type of user :");
        createaccount = new JButton("create account");
        back = new JButton("back");
        createaccount.setEnabled(false);
        //setting the fonts
        firstname.setFont(font);
        lastname.setFont(font);
        mail.setFont(font);
        password.setFont(font);
        number.setFont(font);
        adress.setFont(font);
        birthdate.setFont(font);
        createaccount.setFont(font);
        typeofuser.setFont(font);
        back.setFont(font);
        newlastname.setFont(font);
        newfirstname.setFont(font);
        newmail.setFont(font);
        newnumber.setFont(font);
        newpassword.setFont(font);
        createaccount.setFocusable(false);
        back.setFocusable(false);
        newnumber.setEnabled(false);
        //creating comboboxes
        birthday = new JComboBox(days);
        birthmonth = new JComboBox(months);
        birthyear = new JComboBox(years);
        //setting combo boxes bounds
        birthday.setFont(font);
        birthmonth.setFont(font);
        birthyear.setFont(font);
        //adding all components
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.CENTER);
        PANEL1.add(PANEL3, BorderLayout.EAST);
        PANELDATE.add(birthday);
        PANELDATE.add(birthmonth);
        PANELDATE.add(birthyear);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(typeofuser);
        PANEL2.add(user);
        PANEL2.add(new JLabel());
        PANEL2.add(firstname);
        PANEL2.add(newfirstname);
        PANEL2.add(new JLabel());
        PANEL2.add(lastname);
        PANEL2.add(newlastname);
        PANEL2.add(new JLabel());
        PANEL2.add(adress);
        PANEL2.add(newadress);
        PANEL2.add(new JLabel());
        PANEL2.add(mail);
        PANEL2.add(newmail);
        PANEL2.add(new JLabel());
        PANEL2.add(password);
        PANEL2.add(newpassword);
        PANEL2.add(new JLabel());
        PANEL2.add(number);
        PANEL2.add(newnumber);
        PANEL2.add(new JLabel());
        PANEL2.add(birthdate);
        PANEL2.add(PANELDATE);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(createaccount);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(back);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());

    }

    public void createAccount(ActionEvent ae, Vector<Seller> listOfSellers, Vector<Buyer> listOfBuyers, Vector<Employee> listOfEmployees, Connection con) {
        createaccount.setEnabled(false);
        if (user.getSelectedItem().equals("Employee")) {
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "You must have an employee number to create an account. This number is given by your superior.", "Employee account", JOptionPane.INFORMATION_MESSAGE);
            }
            i = 1;
            newnumber.setEnabled(true);
            newemployee = true;
            newbuyer = false;
            newseller = false;
        } else if (user.getSelectedItem().equals("Buyer")) {
            newnumber.setEnabled(false);
            newbuyer = true;
            newseller = false;
            newemployee = false;
        } else if (user.getSelectedItem().equals("Seller")) {
            newnumber.setEnabled(false);
            newseller = true;
            newemployee = false;
            newbuyer = false;

        }
        String fstname = newfirstname.getText();
        String lstname = newlastname.getText();
        String mail = newmail.getText();
        String pass = newpassword.getText();
        String adress = newadress.getText();
        int d = 0;
        int m = 0;
        int y = 0;
        if (ae.getSource() == birthday) {
            String day = (String) birthday.getSelectedItem();
            System.out.println("day :" + day);
            d = Integer.parseInt(day);
        }
        if (ae.getSource() == birthmonth) {
            String month = (String) birthmonth.getSelectedItem();
            System.out.println("month :" + month);
            m = Integer.parseInt(month);
        }
        if (ae.getSource() == birthyear) {
            String year = (String) birthyear.getSelectedItem();
            System.out.println("year :" + year);
            y = Integer.parseInt(year);
        }

        if (!newemployee && (newseller || newbuyer) && ((!fstname.equals(""))
                && (!lstname.equals(""))
                && (!pass.equals(""))
                && (!adress.equals(""))
                && (!mail.equals("")))) {
            iscomplete = true;
        } else {
            iscomplete = false;
        }
        if (newemployee) {
            String employeenb = newnumber.getText();
            createaccount.setEnabled(false);
            if (newemployee && (!fstname.equals(""))
                    && (!lstname.equals(""))
                    && (!mail.equals(""))
                    && (!adress.equals(""))
                    && (!pass.equals(""))
                    && (!employeenb.equals(""))) {
                iscomplete = true;
                repaint();
            } else {
                iscomplete = false;
            }

        }
        if (iscomplete) {
            createaccount.setEnabled(true);
            repaint();
        } else {
            createaccount.setEnabled(false);
            repaint();
        }
        if (ae.getSource() == createaccount) {
            if (newseller) {
                try {
                    if (!buyerdao.mailCheck(mail)) {
                        newmail.setText("");
                        mailok = false;
                        iscreated = false;
                    } else {
                        mailok = true;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Could not create your account.", "Account creation failed", JOptionPane.WARNING_MESSAGE);
                    Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
                String day = (String) birthday.getSelectedItem();
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                y = Integer.parseInt(year);
                Date date = new Date(y,m,d);
                date.setDate(d);
                date.setMonth(m);
                date.setYear(y);
                int id = 1;
                System.out.println("new seller :");
                Seller seller = new Seller(id, fstname, lstname, date, adress, mail);
                seller.setPassword(pass);
                seller.showInfos();
                listOfSellers.add(seller);
                if (mailok) {
                    try {
                        sellerdao.addSellerToDataBase(seller);
                        iscreated = true;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Could not create your account.", "Account creation failed", JOptionPane.WARNING_MESSAGE);
                        Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
            } else if (newbuyer) {
                try {
                    if (!buyerdao.mailCheck(mail)) {
                        newmail.setText("");
                        mailok = false;
                        iscreated = false;
                    } else {
                        mailok = true;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Could not create your account.", "Account creation failed", JOptionPane.WARNING_MESSAGE);
                    Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
                String day = (String) birthday.getSelectedItem();
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                y = Integer.parseInt(year);
                Date date = new Date(y,m,d);
                date.setDate(d);
                date.setMonth(m);
                date.setYear(y);
                int id = 1;
                System.out.println("new buyer :");
                Buyer buyer = new Buyer(id, fstname, lstname, date, adress, mail);
                buyer.setPassword(pass);
                buyer.showInfos();
                listOfBuyers.add(buyer);
                if (mailok) {
                    try {
                        buyerdao.addBuyerToDataBase(buyer);
                        iscreated = true;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Could not create your account.", "Account creation failed", JOptionPane.WARNING_MESSAGE);
                        Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
            } else if (newemployee) {
                try {
                    if (!employeedao.mailCheck(mail)) {
                        newmail.setText("");
                        mailok = false;
                        iscreated = false;
                    } else {
                        mailok = true;
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Could not create your account.", "Account creation failed", JOptionPane.WARNING_MESSAGE);
                    Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
                String day = (String) birthday.getSelectedItem();
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                y = Integer.parseInt(year);
                Date date = new Date(y,m,d);
                date.setDate(d);
                date.setMonth(m);
                date.setYear(y);
                int id = 1;
                System.out.println("new employee :");
                int employeenb = Integer.parseInt(newnumber.getText());
                Employee employee = new Employee(id, fstname, lstname, date, adress, mail);
                employee.setPassword(pass);
                employee.setEmployeeNb(employeenb);
                listOfEmployees.add(employee);
                employee.showInfos();
                if (mailok) {
                    try {
                        employeedao.addEmployeeToDataBase(employee);
                        iscreated = true;
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Could not create your account.", "Account creation failed", JOptionPane.WARNING_MESSAGE);
                        Logger.getLogger(NewAccount.class.getName()).log(Level.SEVERE, null, ex);

                    }
                }
            }
        }
        if (iscreated) {
            JOptionPane.showMessageDialog(null, "your account has successfully been created ", "Account created", JOptionPane.PLAIN_MESSAGE);
            iscreated = false;
        }

    }

    public boolean accountCreated() {
        return iscreated;
    }
}
