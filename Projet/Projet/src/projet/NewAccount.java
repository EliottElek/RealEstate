/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.ButtonGroup;
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

    public NewAccount() {
        this.setLayout(null);
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
        Font font = new Font("Consolas", Font.PLAIN, 18);
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
        //setting the bounds
        firstname.setBounds(121, 60, 400, 30);
        lastname.setBounds(131, 100, 400, 30);
        mail.setBounds(171, 140, 400, 30);
        password.setBounds(131, 180, 400, 30);
        adress.setBounds(151, 220, 400, 30);
        birthdate.setBounds(121, 265, 400, 30);
        number.setBounds(61, 320, 400, 30);
        newfirstname.setBounds(240, 60, 400, 30);
        newlastname.setBounds(240, 100, 400, 30);
        newmail.setBounds(240, 140, 400, 30);
        newpassword.setBounds(240, 180, 400, 30);
        newadress.setBounds(240, 220, 400, 30);
        newnumber.setBounds(240, 320, 400, 30);
        createaccount.setBounds(310, 400, 200, 50);
        back.setBounds(310, 460, 200, 50);
        choice1.setBounds(150, 20, 100, 30);
        choice2.setBounds(330, 20, 100, 30);
        choice3.setBounds(510, 20, 200, 30);
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
        birthday.setBounds(260, 260, 70, 35);
        birthmonth.setBounds(330, 260, 80, 35);
        birthyear.setBounds(410, 260, 100, 35);
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
                System.out.println("day :" + day);
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                System.out.println("month :" + month);
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                System.out.println("year :" + year);
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
                System.out.println("day :" + day);
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                System.out.println("month :" + month);
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                System.out.println("year :" + year);
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
                System.out.println("day :" + day);
                d = Integer.parseInt(day);
                String month = (String) birthmonth.getSelectedItem();
                System.out.println("month :" + month);
                m = Integer.parseInt(month);
                String year = (String) birthyear.getSelectedItem();
                System.out.println("year :" + year);
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
            JOptionPane.showMessageDialog(null, "your account has uccessfully been created ", "Account created", JOptionPane.PLAIN_MESSAGE);
            iscreated = false;
        }

    }

    public boolean accountCreated() {
        return iscreated;
    }
}
