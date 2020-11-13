/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.GregorianCalendar;

public class Seller extends User {

    public Seller(String firstname, String lastname, GregorianCalendar birthdate, String adress, String mail) {
        super(firstname, lastname, birthdate, adress, mail);
    }

    @Override
    public void showInfos() {
        System.out.println("firstname : " + this.firstname);
        System.out.println("lastname : " + this.lastname);
        System.out.println("adress : " + this.adress);
        System.out.println("email : " + this.mail);
        System.out.println("birthdate : " + this.birthdate.get(this.birthdate.DAY_OF_MONTH) + "/" + this.birthdate.get(this.birthdate.MONTH) + "/" + this.birthdate.get(this.birthdate.YEAR));
    }

}
