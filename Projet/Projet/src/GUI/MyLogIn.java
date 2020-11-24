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
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class MyLogIn extends JPanel implements MyLogInConstant {

    User actualuser;
    SellerDAO sellerdao;
    BuyerDAO buyerdao;
    EmployeeDAO employeedao;
    int factor = 1;
    JPanel PANEL1;
    JPanel PANEL2;
    JPanel PANEL3;
    JComboBox user;
    boolean logedin = false;
    boolean createnewaccount = false;
    JButton enter;
    JButton newaccount;
    JButton visitor;
    JLabel mail;
    JLabel typeofuser;
    JLabel password;
    JLabel employeenb;
    JTextField usermail;
    JPasswordField userpassword;
    JPasswordField useremployeenb;
    boolean employeeuser = false;
    boolean buyeruser = false;
    boolean selleruser = false;

    MyLogIn(int factor) throws Exception {
        buyerdao = new BuyerDAO();
        employeedao = new EmployeeDAO();
        sellerdao = new SellerDAO();
        this.factor = factor;
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        this.setLayout(new BorderLayout(10, 10));
        this.setSize(1000 * this.factor, 600 * this.factor);
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL3 = new JPanel();
        PANEL1.setPreferredSize(new Dimension(100, 150));
        PANEL2.setPreferredSize(new Dimension(100, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL1.setBackground(Color.gray);
        PANEL2.setBackground(Color.lightGray);
        PANEL3.setBackground(Color.gray);
        PANEL1.setLayout(new BorderLayout(5, 5));
        PANEL2.setLayout(new GridLayout(9, 3, 8, 8));
        PANEL3.setLayout(new GridLayout(3, 1, 3, 3));
        user = new JComboBox(usertype);
        typeofuser = new JLabel("                 type of user :");
        mail = new JLabel("                       e-mail :");
        password = new JLabel("                     password :");
        employeenb = new JLabel("              employee number :");
        enter = new JButton("login");
        newaccount = new JButton("new account");
        visitor = new JButton("continue as a visitor");
        usermail = new JTextField();
        userpassword = new JPasswordField();
        useremployeenb = new JPasswordField();
        enter.setEnabled(false);
        userpassword.setFont(font);
        typeofuser.setFont(font);
        usermail.setFont(font);
        mail.setFont(font);
        password.setFont(font);
        employeenb.setFont(font);
        user.setFont(font);
        enter.setFont(font);
        enter.setFocusable(false);
        newaccount.setFocusable(false);
        visitor.setFocusable(false);
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.CENTER);
        PANEL1.add(PANEL3, BorderLayout.EAST);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(typeofuser);
        PANEL2.add(user);
        PANEL2.add(new JLabel());
        PANEL2.add(mail);
        PANEL2.add(usermail);
        PANEL2.add(new JLabel());
        PANEL2.add(password);
        PANEL2.add(userpassword);
        PANEL2.add(new JLabel());
        PANEL2.add(employeenb);
        PANEL2.add(useremployeenb);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(enter);
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL2.add(new JLabel());
        PANEL3.add(new JLabel());
        PANEL3.add(newaccount);
        PANEL3.add(visitor);

    }

    //can be used by the main frame to know if the user is loged or not
    public boolean isLoged() {
        return this.logedin;
    }

    public boolean createNewAccount() {
        return this.createnewaccount;
    }

    public void login(ActionEvent ae) throws Exception {
        if (!logedin) {
            if (user.getSelectedItem().equals("Employee")) {
                useremployeenb.setEnabled(true);
                employeeuser = true;
                buyeruser = false;
                selleruser = false;
                enter.setEnabled(true);
                repaint();
            } else if (user.getSelectedItem().equals("Buyer")) {
                useremployeenb.setEnabled(false);
                buyeruser = true;
                selleruser = false;
                employeeuser = false;
                enter.setEnabled(true);
                repaint();
            } else if (user.getSelectedItem().equals("Seller")) {
                useremployeenb.setEnabled(false);
                selleruser = true;
                employeeuser = false;
                buyeruser = false;
                enter.setEnabled(true);
                repaint();
            } else {
                enter.setEnabled(false);
            }
            if (ae.getSource() == enter) {
                if (employeeuser) {

                    if (employeedao.profileCheck(usermail.getText(), userpassword.getText(), Integer.parseInt(useremployeenb.getText()))) {
                        actualuser = employeedao.getEmployeeAccount(usermail.getText(), userpassword.getText(), Integer.parseInt(useremployeenb.getText()));
                        this.logedin = true;
                    } else {
                        this.logedin = false;
                    }
                    if (!this.logedin) {
                        JOptionPane.showMessageDialog(null, "Cannot find account.", "fail", JOptionPane.WARNING_MESSAGE);
                    }

                } else if (selleruser) {
                    if (sellerdao.profileCheck(usermail.getText(), userpassword.getText())) {
                        actualuser = sellerdao.getSellerAccount(usermail.getText(), userpassword.getText());
                        this.logedin = true;
                    } else {
                        this.logedin = false;
                    }
                    if (!this.logedin) {
                        JOptionPane.showMessageDialog(null, "Cannot find account.", "fail", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (buyeruser) {
                    if (buyerdao.profileCheck(usermail.getText(), userpassword.getText())) {
                        actualuser = buyerdao.getBuyerAccount(usermail.getText(), userpassword.getText());
                        this.logedin = true;
                    } else {
                        this.logedin = false;
                    }
                    if (!this.logedin) {
                        JOptionPane.showMessageDialog(null, "Cannot find account.", "fail", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (ae.getSource() == newaccount) {
                    this.createnewaccount = true;
                }

            }
        }
    }
}
