/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author eliot
 */
public class MyLogIn extends JPanel {

    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;
    ButtonGroup group;
    boolean logedin = false;
    boolean createnewaccount = false;
    Vector<User> listOfUsers = new Vector();
    JButton enter;
    JButton newaccount;
    JLabel mail;
    JLabel password;
    JLabel employeenb;
    JTextField usermail;
    JPasswordField userpassword;
    JPasswordField useremployeenb;
    boolean employeeuser = false;
    boolean buyeruser = false;
    boolean selleruser = false;

    MyLogIn() {
        Font font = new Font("Consolas", Font.ITALIC, 30);
        group = new ButtonGroup();
        choice1 = new JRadioButton("Seller");
        choice2 = new JRadioButton("Buyer");
        choice3 = new JRadioButton("Employee");
        choice1.setBounds(380, 30, 400, 30);
        choice2.setBounds(380, 90, 400, 30);
        choice3.setBounds(380, 140, 400, 30);
        choice1.setFont(font);
        choice2.setFont(font);
        choice3.setFont(font);
        choice1.setFocusable(false);
        choice2.setFocusable(false);
        choice3.setFocusable(false);
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);
        mail = new JLabel("e-mail :");
        password = new JLabel("password :");
        employeenb = new JLabel("employee number :");
        usermail = new JTextField();
        userpassword = new JPasswordField();
        useremployeenb = new JPasswordField();
        /*
         userpassword.addActionListener(this);
         usermail.addActionListener(this);
         */
        usermail.setBounds(260, 200, 400, 30);
        userpassword.setBounds(260, 250, 400, 30);
        employeenb.setBounds(70, 140, 300, 50);
        useremployeenb.setBounds(260, 150, 400, 30);
        userpassword.setFont(new Font("Consolas", Font.PLAIN, 18));
        usermail.setFont(new Font("Consolas", Font.PLAIN, 18));
        mail.setFont(new Font("Consolas", Font.PLAIN, 18));
        password.setFont(new Font("Consolas", Font.PLAIN, 18));
        employeenb.setFont(new Font("Consolas", Font.PLAIN, 18));
        mail.setBounds(160, 190, 300, 50);
        password.setBounds(140, 241, 300, 50);
        this.setLayout(null);
        enter = new JButton("login");
        newaccount = new JButton("new account");
        enter.setFont(font);
        newaccount.setFont(font);
        enter.setFocusable(false);
        newaccount.setFocusable(false);
        //enter.setSize(100, 30);
        enter.setBounds(310, 300, 300, 50);
        newaccount.setBounds(310, 370, 300, 50);
        this.add(choice1);
        this.add(choice2);
        this.add(choice3);
        this.add(enter);
        this.add(newaccount);
        this.add(mail);
        this.add(usermail);
        this.add(password);
        this.add(userpassword);

    }

    //can be used by the main frame to know if the user is loged or not
    public boolean isLoged() {
        return this.logedin;
    }

    public boolean createNewAccount() {
        return this.createnewaccount;
    }

    public void login(ActionEvent ae, Vector<Seller> listOfSellers, Vector<Buyer> listOfBuyers, Vector<Employee> listOfEmployees) {
        if (!logedin) {
            if (ae.getSource() == choice3) {
                this.add(employeenb);
                this.add(useremployeenb);
                employeeuser = true;
                buyeruser = false;
                selleruser = false;
                repaint();
            } else if (ae.getSource() == choice2) {
                this.remove(employeenb);
                this.remove(useremployeenb);
                buyeruser = true;
                selleruser = false;
                employeeuser = false;
                repaint();
            } else if (ae.getSource() == choice1) {
                this.remove(employeenb);
                this.remove(useremployeenb);
                selleruser = true;
                employeeuser = false;
                buyeruser = false;
                repaint();
            }

            if (ae.getSource() == enter) {
                if (employeeuser) {
                    for (int i = 0; i < listOfEmployees.size(); i++) {
                        Employee user = listOfEmployees.elementAt(i);
                        if ((usermail.getText().equals(user.getEmail())) && (userpassword.getText().equals(user.getPassword())) && (useremployeenb.getText().equals(user.getEmployeeNb()))) {
                            JOptionPane.showMessageDialog(null, "Successfully loged in. welcome " + user.getFirstName(), "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                            this.logedin = true;
                            this.setVisible(false);
                        } else {
                            this.logedin = false;
                        }
                    }
                    if (!this.logedin) {
                        JOptionPane.showMessageDialog(null, "Cannot find account.", "Account created", JOptionPane.WARNING_MESSAGE);
                    }

                } else if (selleruser) {
                    for (int i = 0; i < listOfSellers.size(); i++) {
                        Seller user = listOfSellers.elementAt(i);
                        if ((usermail.getText().equals(user.getEmail())) && (userpassword.getText().equals(user.getPassword()))) {
                            JOptionPane.showMessageDialog(null, "Successfully loged in. welcome " + user.getFirstName(), "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                            this.logedin = true;
                            this.setVisible(false);
                        } else {

                            this.logedin = false;
                        }
                    }
                    if (!this.logedin) {
                        JOptionPane.showMessageDialog(null, "Cannot find account.", "Account created", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (buyeruser) {
                    for (int i = 0; i < listOfBuyers.size(); i++) {
                        Buyer user = listOfBuyers.elementAt(i);
                        if ((usermail.getText().equals(user.getEmail())) && (userpassword.getText().equals(user.getPassword()))) {
                            JOptionPane.showMessageDialog(null, "Successfully loged in. welcome " + user.getFirstName(), "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                            this.logedin = true;
                            this.setVisible(false);
                        } else {

                            this.logedin = false;
                        }
                    }
                    if (!this.logedin) {
                        JOptionPane.showMessageDialog(null, "Cannot find account.", "Account created", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (ae.getSource() == newaccount) {
                    this.createnewaccount = true;
                }

            }
        }
    }
}
