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
public abstract class ResidentialEstate extends Estate{

    public ResidentialEstate(String location, String adress, double price, int size, String description) {
        super(location, adress, price, size, description);
    }
    
}
