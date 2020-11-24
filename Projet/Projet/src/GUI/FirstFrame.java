/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eliot
 */
public class FirstFrame extends JFrame {

    JButton full;
    JButton small;
    JPanel PANEL1;
    JPanel PANEL2;

    FirstFrame() {
        this.setSize(600, 400);
        this.setLayout(new BorderLayout());
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL2.setLayout(new GridLayout(3, 2));
        PANEL1.setBackground(Color.gray);
        PANEL2.setBackground(Color.lightGray);
        PANEL1.setPreferredSize(new Dimension(100, 50));
        PANEL2.setPreferredSize(new Dimension(100, 100));
        JLabel qst = new JLabel("Do you want to visualize this interface");
        JLabel qst2 = new JLabel(" in a small or full screen ?");
        Font font = new Font("Consolas", Font.PLAIN, 18);
        qst.setFont(font);
        qst2.setFont(font);
        full = new JButton("FULL SCREEN");
        small = new JButton("SMALL SCREEN");
        small.setFont(font);
        full.setFont(font);
        full.setFocusable(false);
        small.setFocusable(false);
        this.setTitle("before we start...");
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        PANEL2.add(small);
        PANEL2.add(full);

    }
}
