/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

    public MyProfileModify(User user) {

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
        birthdate = new JPanel();
        birthdate.setLayout(new GridLayout(1, 3));
        firstname = new JTextField(user.getFirstName());
        lastname = new JTextField(user.getLastName());
        adress = new JTextField(user.getAdress());
        mail = new JTextField(user.getEmail());
        this.setLayout(new GridLayout(5, 2));
        this.add(new JLabel("FIRSTNAME"));
        this.add(firstname);
        this.add(new JLabel("LASTNAME"));
        this.add(lastname);
        this.add(new JLabel("ADRESS"));
        this.add(adress);
        this.add(new JLabel("MAIL"));
        this.add(mail);
        this.add(new JLabel("BIRTHDATE"));
        this.day.setSelectedItem(Integer.toString(user.getD()));
        System.out.println("selected day : "+this.day.getSelectedItem());
        this.month.setSelectedItem(Integer.toString(user.getM()));
         System.out.println("selected month : "+this.month.getSelectedItem());
        this.year.setSelectedItem(Integer.toString((user.getY()) + 1900));
         System.out.println("selected year : "+this.year.getSelectedItem());
        System.out.println("getyear : " + user.getY());
        System.out.println("getmonth : " + user.getM());
        birthdate.add(day);
        birthdate.add(month);
        birthdate.add(year);
        this.add(birthdate);
    }
    
    public void updateModifyProfile(User user)
    {
        firstname = new JTextField(user.getFirstName());
        lastname = new JTextField(user.getLastName());
        adress = new JTextField(user.getAdress());
        mail = new JTextField(user.getEmail());
         this.day.setSelectedItem(Integer.toString(user.getD()));
        System.out.println("selected day : "+this.day.getSelectedItem());
        this.month.setSelectedItem(Integer.toString(user.getM()));
         System.out.println("selected month : "+this.month.getSelectedItem());
        this.year.setSelectedItem(Integer.toString((user.getY()) + 1900));
    }

}
