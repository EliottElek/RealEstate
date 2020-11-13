/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.GregorianCalendar;
import static javax.swing.UIManager.get;

/**
 *
 * @author eliot
 */
public class Employee extends User {

    private String employeenb;

    public Employee(String firstname, String lastname, GregorianCalendar birthdate, String adress, String mail, String employeenb) {
        super(firstname, lastname, birthdate, adress, mail);
        this.employeenb = employeenb;
    }

    public String getEmployeeNb() {
        return this.employeenb;
    }

    @Override
    public void showInfos() {
        System.out.println("firstname : " + this.firstname);
        System.out.println("lastname : " + this.lastname);
        System.out.println("adress : " + this.adress);
        System.out.println("email : " + this.mail);
        System.out.println("birthdate : " + this.birthdate.get(this.birthdate.DAY_OF_MONTH) + "/" + this.birthdate.get(this.birthdate.MONTH) + "/" + this.birthdate.get(this.birthdate.YEAR));
        System.out.println("employee number : " + this.employeenb);
    }
}
