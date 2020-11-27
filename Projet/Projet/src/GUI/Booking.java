/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Date;

/**
 *
 * @author eliott
 */
public class Booking {

    private int ID;
    private Date date;
    private int buyerID;
    private int estateID;
    private String lastname;
    private String adress;

    public Booking(Date date, int buyerID, int estateID, String adress, String lastname) {
        this.date = date;
        this.buyerID = buyerID;
        this.estateID = estateID;
        this.adress = adress;
        this.lastname = lastname;

    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setbuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public void setestateID(int estateID) {
        this.estateID = estateID;
    }

    public int getEstateID() {
        return this.estateID;
    }

    public int getUserID() {
        return this.buyerID;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getLastname() {
        return this.lastname;
    }
}
