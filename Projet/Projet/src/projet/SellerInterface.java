/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.Color;
import java.awt.Font;
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

    SellerInterface(int factor) {
        JScrollPane scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.setSize(1000*this.factor,600*this.factor);
// Add Textarea in to middle panel
        this.add(scroll);
        this.factor = factor;
        //creating default font
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        //setting the layout
        this.setLayout(null);
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
        //creating texfields
        price = new JTextField();
        description = new JTextField();
        //setting buttons to not focudable
        add.setFocusable(false);
        //creating the button group
        //setting all bounds
        location.setBounds(50 * factor, 20 * factor, 300 * factor, 30 * factor);
        locate.setBounds(50 * factor, 55 * factor, 300 * factor, 30 * factor);
        typeofproperty.setBounds(50 * factor, 100 * factor, 300 * factor, 30 * factor);
        pricerange.setBounds(50 * factor, 180 * factor, 150 * factor, 30 * factor);
        proximity.setBounds(50 * factor, 260 * factor, 300 * factor, 30 * factor);
        nbrooms.setBounds(420 * factor, 20 * factor, 300 * factor, 30 * factor);
        nbbthrooms.setBounds(420 * factor, 100 * factor, 300 * factor, 30 * factor);
        typechosen.setBounds(50 * factor, 135 * factor, 300 * factor, 30 * factor);
        proximitychosen.setBounds(50 * factor, 295 * factor, 300 * factor, 30 * factor);
        nbroomschosen.setBounds(420 * factor, 55 * factor, 90 * factor, 30 * factor);
        nbbthroomschosen.setBounds(420 * factor, 135 * factor, 90 * factor, 30 * factor);
        price.setBounds(50 * factor, 215 * factor, 300 * factor, 30 * factor);
        renovate.setBounds(400 * factor, 180 * factor, 300 * factor, 30 * factor);
        renovation.setBounds(400 * factor, 215 * factor, 300 * factor, 30 * factor);
        stateofproperty.setBounds(400 * factor, 260 * factor, 300 * factor, 30 * factor);
        state.setBounds(400 * factor, 295 * factor, 300 * factor, 30 * factor);
        if (factor == 1) {
            add.setBounds(300 * factor, 465 * factor, 200 * factor, 60 * factor);
        } else if (factor == 2) {
            add.setBounds(730 * factor, 370 * factor, 200 * factor, 70 * factor);
        }
        description.setBounds(50 * factor, 370 * factor, 660 * factor, 70 * factor);
        desc.setBounds(50 * factor, 320 * factor, 200 * factor, 60 * factor);

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
        //add everything to the panel
        this.add(typeofproperty);
        this.add(pricerange);
        this.add(proximity);
        this.add(nbrooms);
        this.add(nbbthrooms);
        this.add(typechosen);
        this.add(proximitychosen);
        this.add(nbroomschosen);
        this.add(nbbthroomschosen);
        this.add(typechosen);
        this.add(price);
        this.add(renovate);
        this.add(renovation);
        this.add(state);
        this.add(stateofproperty);
        this.add(add);
        this.add(locate);
        this.add(location);
        this.add(desc);
        this.add(description);

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
