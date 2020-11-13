/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.GregorianCalendar;

/**
 *
 * @author eliot
 */
public class Employee extends User{
private String employeenb;
    public Employee(String firstname, String lastname, GregorianCalendar birthdate, String adress, String mail,String employeenb) {
        super(firstname, lastname, birthdate, adress, mail);
        this.employeenb=employeenb;
    }
    public String getEmployeeNb()
    {
        return this.employeenb;
    }
}
