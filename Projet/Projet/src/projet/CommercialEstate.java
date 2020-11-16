/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.IOException;

/**
 *
 * @author eliot
 */
public abstract class CommercialEstate extends Estate{

    public CommercialEstate(String location, String adress, double price, int area, String description, String[] imagesnames,int factor) throws IOException {
        super(location, adress, price, area, description,imagesnames,factor);
    }
    
}
