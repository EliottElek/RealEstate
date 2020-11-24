/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.sql.Blob;

/**
 *
 * @author eliot
 */
public class RealEstate extends Estate {

    public RealEstate(String location, String adress, double price, int area, String description, Blob image1, Blob image2, Blob image3, int factor) throws IOException {
        super(location, adress, price, area, description, image1, image2, image3, factor);
    }

}
