/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eliot
 */
public class MyProfileModify extends JPanel {

    JTextField firstname;
    JTextField lastname;
    JTextField adress;
    JTextField mail;
    JComboBox day;
    JComboBox month;
    JComboBox year;
    JPanel birthdate;
    Font font;

    public MyProfileModify(User user) {

        font = new Font("Consolas", Font.PLAIN, 18);
        String[] days = new String[31];
        String[] months = new String[13];
        String[] years = new String[101];
        for (int i = 0; i < 31; i++) {
            days[i] = Integer.toString(i + 1);
        }
        for (int i = 1; i <= 12; i++) {
            months[i] = Integer.toString(i);
        }
        for (int i = 100; i >= 0; i--) {
            years[i] = Integer.toString(2020 - i);
        }

        this.day = new JComboBox(days);
        this.month = new JComboBox(months);
        this.year = new JComboBox(years);
        this.birthdate = new JPanel();
        this.birthdate.setLayout(new GridLayout(1, 3));
        this.firstname = new JTextField(user.getFirstName());
        this.lastname = new JTextField(user.getLastName());
        this.adress = new JTextField(user.getAdress());
        this.mail = new JTextField(user.getEmail());
        this.day.setFont(font);
        this.month.setFont(font);
        this.birthdate.setFont(font);
        this.firstname.setFont(font);
        this.lastname.setFont(font);
        this.adress.setFont(font);
        this.mail.setFont(font);
        this.year.setFont(font);
        JLabel label1 = new JLabel("FIRSTNAME");
        JLabel label2 = new JLabel("LASTNAME");
        JLabel label3 = new JLabel("ADRESS");
        JLabel label4 = new JLabel("MAIL");
        JLabel label5 = new JLabel("BIRTHDATE");

        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        this.setLayout(new GridLayout(5, 2));
        this.add(label1);
        this.add(firstname);
        this.add(label2);
        this.add(lastname);
        this.add(label3);
        this.add(adress);
        this.add(label4);
        this.add(mail);
        this.add(label5);
        this.day.setSelectedItem(Integer.toString(user.getD()));
        this.month.setSelectedItem(Integer.toString(user.getM()));
        this.year.setSelectedItem(Integer.toString((user.getY()) + 1900));
        System.out.println("getyear : " + user.getY());
        System.out.println("getmonth : " + user.getM());
        birthdate.add(day);
        birthdate.add(month);
        birthdate.add(year);
        this.add(birthdate);
    }

    public void updateModifyProfile(User user) {
        firstname = new JTextField(user.getFirstName());
        lastname = new JTextField(user.getLastName());
        adress = new JTextField(user.getAdress());
        mail = new JTextField(user.getEmail());
        this.day.setSelectedItem(Integer.toString(user.getD()));
        System.out.println("selected day : " + this.day.getSelectedItem());
        this.month.setSelectedItem(Integer.toString(user.getM()));
        System.out.println("selected month : " + this.month.getSelectedItem());
        this.year.setSelectedItem(Integer.toString((user.getY()) + 1900));
    }

}
