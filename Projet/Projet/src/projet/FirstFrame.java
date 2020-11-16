/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author eliot
 */
public class FirstFrame extends JFrame {

    JButton full;
    JButton small;

    FirstFrame() {
        this.setSize(600, 400);
        this.setLayout(null);
        JLabel qst = new JLabel("Do you want to visualize this interface");
        JLabel qst2 = new JLabel(" in a small or full screen ?");
        Font font = new Font("Consolas", Font.PLAIN, 20);
        qst.setBounds(40, 40, 500, 40);
        qst.setFont(font);
        qst2.setBounds(70, 80, 500, 40);
        qst2.setFont(font);
        full = new JButton("FULL SCREEN");
        small = new JButton("SMALL SCREEN");
        small.setFont(font);
        full.setFont(font);
        full.setBounds(100, 120, 200, 50);
        small.setBounds(300, 120, 200, 50);
        full.setFocusable(false);
        small.setFocusable(false);
        this.setTitle("before we start...");
        this.add(qst);
        this.add(qst2);
        this.add(full);
        this.add(small);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
