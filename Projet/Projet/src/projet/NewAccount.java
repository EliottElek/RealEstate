/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class NewAccount extends JPanel {

    int factor = 1;
    boolean iscreated = false;
    boolean iscomplete = false;
    boolean newbuyer = false;
    boolean newseller = false;
    boolean newemployee = false;
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
    JTextField newfirstname;
    JTextField newlastname;
    JTextField newmail;
    JPasswordField newpassword;
    JPasswordField newnumber;
    JTextField newadress;
    JComboBox birthday;
    JComboBox birthmonth;
    JComboBox birthyear;
    JButton createaccount;
    JButton back;
    JRadioButton choice1;
    JRadioButton choice2;
    JRadioButton choice3;
    ButtonGroup group;

    public NewAccount(int factor) {
        this.factor = factor;
        this.setSize(1000 * this.factor, 600 * this.factor);
        GroupLayout groupl = new GroupLayout(this);
        this.setLayout(groupl);
        groupl.setAutoCreateContainerGaps(true);
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
        choice1 = new JRadioButton("Seller");
        choice2 = new JRadioButton("Buyer");
        choice3 = new JRadioButton("Employee");
        group = new ButtonGroup();
        group.add(choice1);
        group.add(choice2);
        group.add(choice3);

        //creation of the labels 
        firstname = new JLabel("firstname :");
        lastname = new JLabel("lastname :");
        mail = new JLabel("mail :");
        password = new JLabel("password :");
        number = new JLabel("employee number :");
        adress = new JLabel("adress :");
        birthdate = new JLabel("birthdate :");
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
        choice1.setFont(font);
        choice2.setFont(font);
        choice3.setFont(font);
        createaccount.setFont(font);
        back.setFont(font);
        //setting the bounds
        firstname.setBounds(121 * factor, 60 * factor, 400 * factor, 30 * factor);
        lastname.setBounds(131 * factor, 100 * factor, 400 * factor, 30 * factor);
        mail.setBounds(171 * factor, 140 * factor, 400 * factor, 30 * factor);
        password.setBounds(131 * factor, 180 * factor, 400 * factor, 30 * factor);
        adress.setBounds(151 * factor, 220 * factor, 400 * factor, 30 * factor);
        birthdate.setBounds(121 * factor, 265 * factor, 400 * factor, 30 * factor);
        number.setBounds(61 * factor, 320 * factor, 400 * factor, 30 * factor);
        newfirstname.setBounds(240 * factor, 60 * factor, 400 * factor, 30 * factor);
        newlastname.setBounds(240 * factor, 100 * factor, 400 * factor, 30 * factor);
        newmail.setBounds(240 * factor, 140 * factor, 400 * factor, 30 * factor);
        newpassword.setBounds(240 * factor, 180 * factor, 400 * factor, 30 * factor);
        newadress.setBounds(240 * factor, 220 * factor, 400 * factor, 30 * factor);
        newnumber.setBounds(240 * factor, 320 * factor, 400 * factor, 30 * factor);
        createaccount.setBounds(310 * factor, 365 * factor, 200 * factor, 50 * factor);
        back.setBounds(310 * factor, 420 * factor, 200 * factor, 50 * factor);
        choice1.setBounds(150 * factor, 20 * factor, 100 * factor, 30 * factor);
        choice2.setBounds(330 * factor, 20 * factor, 100 * factor, 30 * factor);
        choice3.setBounds(510 * factor, 20 * factor, 200 * factor, 30 * factor);
        createaccount.setFocusable(false);
        back.setFocusable(false);
        choice1.setFocusable(false);
        choice2.setFocusable(false);
        choice3.setFocusable(false);
        //creating comboboxes
        birthday = new JComboBox(days);
        birthmonth = new JComboBox(months);
        birthyear = new JComboBox(years);
        //setting combo boxes bounds
        birthday.setBounds(260 * factor, 260 * factor, 70 * factor, 35 * factor);
        birthmonth.setBounds(330 * factor, 260 * factor, 80 * factor, 35 * factor);
        birthyear.setBounds(410 * factor, 260 * factor, 100 * factor, 35 * factor);
        birthday.setFont(font);
        birthmonth.setFont(font);
        birthyear.setFont(font);
        //adding all components
        this.add(firstname);
        this.add(newfirstname);
        this.add(lastname);
        this.add(newlastname);
        this.add(mail);
        this.add(newmail);
        this.add(adress);
        this.add(newadress);
        this.add(password);
        this.add(newpassword);
        this.add(birthdate);
        this.add(birthday);
        this.add(birthmonth);
        this.add(birthyear);
        this.add(createaccount);
        this.add(back);
        this.add(choice1);
        this.add(choice2);
        this.add(choice3);

    }

    public void createAccount(ActionEvent ae, Vector<Seller> listOfSellers, Vector<Buyer> listOfBuyers, Vector<Employee> listOfEmployees) {
        createaccount.setEnabled(false);
        if (ae.getSource() == choice3) {
            this.add(number);
            this.add(newnumber);
            JOptionPane.showMessageDialog(null, "You must have an employee number to create an account. This number is given by your superior.", "Employee account", JOptionPane.INFORMATION_MESSAGE);
            newemployee = true;
            newbuyer = false;
            newseller = false;
        } else if (ae.getSource() == choice2) {
            this.remove(number);
            this.remove(newnumber);
            newbuyer = true;
            newseller = false;
            newemployee = false;
        } else if (ae.getSource() == choice1) {
            this.remove(number);
            this.remove(newnumber);
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
                && (!mail.equals(""))
                && (!adress.equals("")))) {
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
                String day = (String) birthday.getSelectedItem();
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                y = Integer.parseInt(year);
                GregorianCalendar date = new GregorianCalendar(y, m, d);
                System.out.println("new seller :");
                Seller seller = new Seller(fstname, lstname, date, adress, mail);
                iscreated = true;
                seller.setPassword(pass);
                seller.showInfos();
                listOfSellers.add(seller);
            } else if (newbuyer) {
                String day = (String) birthday.getSelectedItem();
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                y = Integer.parseInt(year);
                GregorianCalendar date = new GregorianCalendar(y, m, d);
                System.out.println("new buyer :");
                Buyer buyer = new Buyer(fstname, lstname, date, adress, mail);
                iscreated = true;
                buyer.setPassword(pass);
                buyer.showInfos();
                listOfBuyers.add(buyer);
            } else if (newemployee) {
                String day = (String) birthday.getSelectedItem();
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                y = Integer.parseInt(year);
                GregorianCalendar date = new GregorianCalendar(y, m, d);
                System.out.println("new employee :");
                String employeenb = newnumber.getText();
                Employee employee = new Employee(fstname, lstname, date, adress, mail, employeenb);
                iscreated = true;
                employee.setPassword(pass);
                listOfEmployees.add(employee);
                employee.showInfos();
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
