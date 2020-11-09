/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author eliot
 */
public abstract class Estate {

    private String location;
    private String adress;
    private double price;
    private int size;
    private String description;

    public Estate(String location, String adress, double price, int size, String description) {
        this.location = location;
        this.adress = adress;
        this.price = price;
        this.size = size;
        this.description = description;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
