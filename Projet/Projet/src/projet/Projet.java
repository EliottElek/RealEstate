/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author eliot
 */
public class Projet {

    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        MyMainInterface main = new MyMainInterface();
        MyLogIn login = new MyLogIn();
        myFrame.setSize(800, 500);
        myFrame.setTitle("Estate Manager");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        myFrame.add(main);
        myFrame.add(login);

    }

}
