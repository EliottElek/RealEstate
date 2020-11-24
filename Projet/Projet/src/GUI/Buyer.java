/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Date;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author eliot
 */
public class Buyer extends User {

    public Buyer(int id, String firstname, String lastname, Date birthdate, String adress, String mail) {
        super(id, firstname, lastname, birthdate, adress, mail);
    }

    @Override
    public void showInfos() {
        System.out.println("firstname : " + this.firstname);
        System.out.println("lastname : " + this.lastname);
        System.out.println("adress : " + this.adress);
        System.out.println("email : " + this.mail);
        System.out.println("birthdate : " + this.birthdate.getDate() + "/" + this.birthdate.getMonth() + "/" + this.birthdate.getYear());
    }

    @Override
    public JPanel showInfosMyProfile() {
        PANELINFOS.setLayout(new GridLayout(5, 2));
        PANELINFOS.add(new JLabel("FIRSTNAME"));
        PANELINFOS.add(new JLabel(this.firstname));
        PANELINFOS.add(new JLabel("LASTNAME"));
        PANELINFOS.add(new JLabel(this.lastname));
        PANELINFOS.add(new JLabel("ADRESS"));
        PANELINFOS.add(new JLabel(this.adress));
        PANELINFOS.add(new JLabel("MAIL"));
        PANELINFOS.add(new JLabel(this.mail));
        PANELINFOS.add(new JLabel("BIRTHDATE"));
        PANELINFOS.add(new JLabel(this.birthdate.getDate() + "/" + this.birthdate.getMonth() + "/" + this.birthdate.getYear()));
        return PANELINFOS;
    }

}
