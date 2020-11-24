/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eliot
 */
public class CreateInterface implements ActionListener {

    FirstFrame first = new FirstFrame();
    

    CreateInterface() {
        first.full.addActionListener(this);
        first.small.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == first.full) {
            try {
                new MyInterface(2, 2000, 1200);
            } catch (IOException ex) {
                Logger.getLogger(CreateInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CreateInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            first.dispose();
        }
        if (ae.getSource() == first.small) {
            try {
                new MyInterface(1, 1000, 600);
            } catch (IOException ex) {
                Logger.getLogger(CreateInterface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(CreateInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            first.dispose();
        }
    }

}
