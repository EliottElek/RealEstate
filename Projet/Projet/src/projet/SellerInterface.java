/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import static projet.BuyerConstInterface.maxrooms;
import static projet.BuyerConstInterface.minrooms;
import static projet.BuyerConstInterface.propertystate;
import static projet.BuyerConstInterface.typesoflocations;
import static projet.BuyerConstInterface.typesofproperties;
import static projet.BuyerConstInterface.typesofproximities;
import static projet.BuyerConstInterface.typesrenovation;

/**
 *
 * @author eliot
 */
public class SellerInterface extends JPanel implements SellerConstInterface {

    int factor = 1;
    JPanel PANEL1;
    JPanel PANEL2;
    JPanel PANEL3;
    JPanel PANEL4;
    JPanel PANEL5;
    JPanel PANEL6;
    JPanel PANEL7;
    JPanel PANEL8;
    JPanel PANEL9;
    JPanel PANEL10;
    JPanel PANEL11;
    JLabel location;
    JLabel typeofproperty;
    JLabel pricerange;
    JLabel proximity;
    JLabel nbrooms;
    JLabel nbbthrooms;
    JLabel renovate;
    JLabel stateofproperty;
    JLabel desc;
    JComboBox typechosen;
    JComboBox proximitychosen;
    JComboBox nbroomschosen;
    JComboBox nbbthroomschosen;
    JComboBox renovation;
    JComboBox state;
    JComboBox locate;
    JTextField price;
    JTextField description;
    JButton add;
    JButton back;

    SellerInterface(int factor) {
        this.setLayout(new BorderLayout(10, 10));
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL3 = new JPanel();
        PANEL4 = new JPanel();
        PANEL5 = new JPanel();
        PANEL6 = new JPanel();
        PANEL7 = new JPanel();
        PANEL8 = new JPanel();
        PANEL9 = new JPanel();
        PANEL10 = new JPanel();
        PANEL11 = new JPanel();
        PANEL1.setPreferredSize(new Dimension(200, 100));
        PANEL2.setPreferredSize(new Dimension(200, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL4.setPreferredSize(new Dimension(200, 100));
        PANEL5.setPreferredSize(new Dimension(200, 100));
        PANEL10.setPreferredSize(new Dimension(200, 100));
        PANEL11.setPreferredSize(new Dimension(200, 3000));
        PANEL1.setBackground(Color.gray);
        PANEL2.setBackground(Color.gray);
        PANEL3.setBackground(Color.gray);
        PANEL4.setBackground(Color.gray);
        PANEL5.setBackground(Color.lightGray);
        PANEL6.setBackground(Color.gray);
        PANEL7.setBackground(Color.lightGray);
        PANEL8.setBackground(Color.orange);
        PANEL9.setBackground(Color.gray);
        PANEL11.setBackground(Color.lightGray);
        PANEL1.setLayout(new BorderLayout());
        PANEL10.setLayout(new BorderLayout());
        //PANEL11.setLayout(new GridLayout(properties.length, 2));
        PANEL5.setLayout(new GridLayout(1, 2));
        PANEL6.setLayout(new GridLayout(2, 1));
        PANEL7.setLayout(new GridLayout(14, 2));
        PANEL8.setLayout(new GridLayout(7, 1));
        PANEL9.setLayout(new GridLayout(7, 2));
        PANEL1.add(PANEL10, BorderLayout.EAST);
        //adding PANEL6 and PANEL7 to PANEL5
        PANEL5.add(PANEL6);
        PANEL5.add(PANEL7);
        //adding PANELS 8 and 9 to PANEL6
        //add everything to the PANELS
        PANEL6.add(PANEL8);
        PANEL6.add(PANEL9);
        this.setSize(1000 * this.factor, 600 * this.factor);
// Add Textarea in to middle panel
        this.factor = factor;
        //creating default font
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        //creating labels
        location = new JLabel("Location");
        typeofproperty = new JLabel("property type");
        pricerange = new JLabel("price ($)");
        proximity = new JLabel("transportation proximity");
        nbrooms = new JLabel("number of rooms");
        nbbthrooms = new JLabel("number of bathrooms");
        renovate = new JLabel("renovation");
        stateofproperty = new JLabel("state of property");
        desc = new JLabel("Add a descritpion...");
        //creating combo boxes
        locate = new JComboBox(typesoflocations);
        typechosen = new JComboBox(typesofproperties);
        proximitychosen = new JComboBox(typesofproximities);
        nbroomschosen = new JComboBox(maxrooms);
        nbbthroomschosen = new JComboBox(maxrooms);
        renovation = new JComboBox(typesrenovation);
        state = new JComboBox(propertystate);
        //creating buttons
        add = new JButton("ADD PROPERTY");
        back = new JButton("back");
        //creating texfields
        price = new JTextField();
        description = new JTextField();
        //setting buttons to not focudable
        add.setFocusable(false);
        //setting initial values to sliders
        //setting all fonts
        locate.setFont(font);
        location.setFont(font);
        typeofproperty.setFont(font);
        pricerange.setFont(font);
        proximity.setFont(font);
        nbrooms.setFont(font);
        nbbthrooms.setFont(font);
        typechosen.setFont(font);
        proximitychosen.setFont(font);
        nbroomschosen.setFont(font);
        nbbthroomschosen.setFont(font);
        price.setFont(font);
        renovate.setFont(font);
        renovation.setFont(font);
        state.setFont(font);
        stateofproperty.setFont(font);
        desc.setFont(font);
        description.setFont(font);
        add.setFont(font);
        //disable add button
        add.setEnabled(false);
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.SOUTH);
        this.add(PANEL3, BorderLayout.WEST);
        this.add(PANEL4, BorderLayout.EAST);
        this.add(PANEL5, BorderLayout.CENTER);
        PANEL2.add(back,  BorderLayout.WEST);
        this.setVisible(true);

    }

    public void SellerAddProperty(ActionEvent ce) {
        if ((!locate.getSelectedItem().equals(" "))
                && (!proximitychosen.getSelectedItem().equals(" "))
                && (!nbroomschosen.getSelectedItem().equals(" "))
                && (!nbbthroomschosen.getSelectedItem().equals(" "))
                && (!typechosen.getSelectedItem().equals(" "))
                && (!description.getText().equals(" "))
                && (!price.getText().equals(""))
                && (!description.getText().equals(""))
                && (!renovation.getSelectedItem().equals(" "))) {
            add.setEnabled(true);
        }

    }
}
