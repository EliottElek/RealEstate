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
public class MyLogIn extends JPanel implements ActionListener {
    private JRadioButton choice1;
    private JRadioButton choice2;
    private JRadioButton choice3;
    private ButtonGroup group;
    private boolean logedin = false;
    private Vector<User> listOfUsers = new Vector();
    private JButton enter;
    private JLabel mail;
    private JLabel password;
    private JLabel employeenb;
    private JTextField usermail;
    private JPasswordField userpassword;
    private JPasswordField useremployeenb;
    boolean employeeuser = false;
    boolean buyeruser = false;
    boolean selleruser = false;
    Vector<Seller> listOfSellers = new Vector();
    Vector<Buyer> listOfBuyers = new Vector();
    Vector<Employee> listOfEmployees = new Vector();

    MyLogIn() {
        Font font = new Font("Consolas", Font.PLAIN, 30);
        group = new ButtonGroup();
        choice1 = new JRadioButton("Seller");
        choice2 = new JRadioButton("Buyer");
        choice3 = new JRadioButton("Employee");
        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);
        choice1.setBounds(260, 10, 400, 30);
        choice2.setBounds(260, 60, 400, 30);
        choice3.setBounds(260, 110, 400, 30);
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
        userpassword.addActionListener(this);
        usermail.addActionListener(this);
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
        GregorianCalendar date = new GregorianCalendar();
        date.set(GregorianCalendar.YEAR, 1999);
        date.set(GregorianCalendar.MONTH, 5);
        date.set(GregorianCalendar.DAY_OF_MONTH, 29);
        listOfSellers.add(new Seller("Eliott", "Morcillo", date, "12 Rue du Chien", "eliott.morcillo@edu.ece.fr"));
        listOfBuyers.add(new Buyer("Eliott", "Morcillo", date, "12 Rue du Chien", "eliott.morcillo@edu.ece.fr"));
        listOfEmployees.add(new Employee("Eliott", "Morcillo", date, "12 Rue du Chien", "eliott.morcillo@edu.ece.fr", "elektra1"));
        listOfSellers.elementAt(0).setPassword("1234");
        listOfBuyers.elementAt(0).setPassword("1234");
        listOfEmployees.elementAt(0).setPassword("1234");
        this.setLayout(null);
        enter = new JButton("login");
        enter.addActionListener(this);
        enter.setFont(font);
        enter.setFocusable(false);
        //enter.setSize(100, 30);
        enter.setBounds(310, 300, 300, 50);
        this.add(choice1);
        this.add(choice2);
        this.add(choice3);
        this.add(enter);
        this.add(mail);
        this.add(usermail);
        this.add(password);
        this.add(userpassword);

    }

    //can be used by the main frame to know if the user is loged or not

    public boolean isLoged() {
        return this.logedin;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
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
                    Employee user = this.listOfEmployees.elementAt(0);
                    if ((usermail.getText().equals(user.getEmail())) && (userpassword.getText().equals(user.getPassword())) && (useremployeenb.getText().equals(user.getEmployeeNb()))) {
                        JOptionPane.showMessageDialog(null, "Successfully loged in. welcome " + user.getFirstName(), "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        this.logedin = true;
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not log in. Email or password may not be correct.", "FAILED", JOptionPane.WARNING_MESSAGE);
                        this.logedin = false;
                    }
                } else if (selleruser) {
                    Seller user = this.listOfSellers.elementAt(0);
                    if ((usermail.getText().equals(user.getEmail())) && (userpassword.getText().equals(user.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Successfully loged in. welcome " + user.getFirstName(), "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        this.logedin = true;
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not log in. Email or password may not be correct.", "FAILED", JOptionPane.WARNING_MESSAGE);
                        this.logedin = false;
                    }
                } else if (buyeruser) {
                    Buyer user = this.listOfBuyers.elementAt(0);
                    if ((usermail.getText().equals(user.getEmail())) && (userpassword.getText().equals(user.getPassword()))) {
                        JOptionPane.showMessageDialog(null, "Successfully loged in. welcome " + user.getFirstName(), "SUCCESS", JOptionPane.PLAIN_MESSAGE);
                        this.logedin = true;
                        this.setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Could not log in. Email or password may not be correct.", "FAILED", JOptionPane.WARNING_MESSAGE);
                        this.logedin = false;
                    }
                }
            }
        }
    }
}
