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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author eliot
 */
public class BuyerInterface extends JPanel implements BuyerConstInterface {

    JLabel location;
    JLabel typeofproperty;
    JLabel pricerange;
    JLabel pricerangecursor;
    JLabel proximity;
    JLabel locateorbuy;
    JLabel nbminrooms;
    JLabel nbmaxrooms;
    JLabel nbminbthrooms;
    JLabel nbmaxbthrooms;
    JLabel renovate;
    JLabel stateofproperty;
    JComboBox typechosen;
    JComboBox proximitychosen;
    JComboBox nbminroomschosen;
    JComboBox nbmaxroomschosen;
    JComboBox nbminbthroomschosen;
    JComboBox nbmaxbthroomschosen;
    JComboBox renovation;
    JComboBox state;
    JComboBox locate;
    JSlider price;
    JRadioButton buybutton;
    JRadioButton rentbutton;
    ButtonGroup group;
    JButton search;

    BuyerInterface() {
        //creating default font
        Font font = new Font("Consolas", Font.PLAIN, 18);
        //setting the layout
        this.setLayout(null);
        //creating labels
        location = new JLabel("Location");
        typeofproperty = new JLabel("property type");
        pricerange = new JLabel("max price");
        proximity = new JLabel("transportation proximity");
        locateorbuy = new JLabel("want to");
        nbminrooms = new JLabel("min rooms");
        nbmaxrooms = new JLabel("max rooms");
        nbminbthrooms = new JLabel("min bathrooms");
        nbmaxbthrooms = new JLabel("max bathrooms");
        renovate = new JLabel("renovation");
        stateofproperty = new JLabel("state of property");
        pricerangecursor = new JLabel();
        //creating combo boxes
        locate = new JComboBox(typesoflocations);
        typechosen = new JComboBox(typesofproperties);
        proximitychosen = new JComboBox(typesofproximities);
        nbminroomschosen = new JComboBox(minrooms);
        nbmaxroomschosen = new JComboBox(maxrooms);
        nbminbthroomschosen = new JComboBox(minrooms);
        nbmaxbthroomschosen = new JComboBox(maxrooms);
        renovation = new JComboBox(typesrenovation);
        state = new JComboBox(propertystate);
        //creating radion buttons
        buybutton = new JRadioButton("Buy");
        rentbutton = new JRadioButton("Rent");
        //creating buttons
        search = new JButton("SEARCH");
        //creating sliders
        price = new JSlider(5, 80);
        //setting buttons to not focudable
        buybutton.setFocusable(false);
        rentbutton.setFocusable(false);
        search.setFocusable(false);
        //creating the button group
        group = new ButtonGroup();
        //setting all bounds
        location.setBounds(50, 20, 300, 30);
        locate.setBounds(50, 55, 300, 30);
        typeofproperty.setBounds(50, 100, 300, 30);
        pricerange.setBounds(50, 180, 150, 30);
        proximity.setBounds(50, 260, 300, 30);
        locateorbuy.setBounds(50, 340, 300, 30);
        nbminrooms.setBounds(420, 20, 300, 30);
        nbmaxrooms.setBounds(575, 20, 300, 30);
        nbminbthrooms.setBounds(400, 100, 300, 30);
        nbmaxbthrooms.setBounds(560, 100, 300, 30);
        buybutton.setBounds(50, 380, 80, 30);
        rentbutton.setBounds(130, 380, 80, 30);
        typechosen.setBounds(50, 135, 300, 30);
        proximitychosen.setBounds(50, 295, 300, 30);
        nbminroomschosen.setBounds(420, 55, 90, 30);
        nbmaxroomschosen.setBounds(575, 55, 90, 30);
        nbminbthroomschosen.setBounds(420, 135, 90, 30);
        nbmaxbthroomschosen.setBounds(575, 135, 90, 30);
        pricerangecursor.setBounds(280, 180, 80, 30);
        price.setBounds(50, 215, 300, 30);
        renovate.setBounds(400, 180, 300, 30);
        renovation.setBounds(400, 215, 300, 30);
        stateofproperty.setBounds(400, 260, 300, 30);
        state.setBounds(400, 295, 300, 30);
        search.setBounds(300, 400, 200, 60);
        //initializing sliders
        price.setPaintTicks(true);
        price.setPaintTrack(true);
        price.setPaintLabels(true);
        //setting initial values to sliders
        pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "$");
        //setting all fonts
        locate.setFont(font);
        location.setFont(font);
        typeofproperty.setFont(font);
        pricerange.setFont(font);
        proximity.setFont(font);
        locateorbuy.setFont(font);
        nbminrooms.setFont(font);
        nbmaxrooms.setFont(font);
        nbminbthrooms.setFont(font);
        nbmaxbthrooms.setFont(font);
        buybutton.setFont(font);
        rentbutton.setFont(font);
        typechosen.setFont(font);
        proximitychosen.setFont(font);
        nbminroomschosen.setFont(font);
        nbmaxroomschosen.setFont(font);
        nbminbthroomschosen.setFont(font);
        nbmaxbthroomschosen.setFont(font);
        price.setFont(font);
        pricerangecursor.setFont(font);
        renovate.setFont(font);
        renovation.setFont(font);
        state.setFont(font);
        stateofproperty.setFont(font);
        //adding buttons to group
        group.add(buybutton);
        group.add(rentbutton);
        //add everything to the panel
        this.add(typeofproperty);
        this.add(pricerange);
        this.add(proximity);
        this.add(locateorbuy);
        this.add(nbminrooms);
        this.add(nbmaxrooms);
        this.add(nbminbthrooms);
        this.add(nbmaxbthrooms);
        this.add(typechosen);
        this.add(proximitychosen);
        this.add(nbminroomschosen);
        this.add(nbmaxroomschosen);
        this.add(nbminbthroomschosen);
        this.add(nbmaxbthroomschosen);
        this.add(buybutton);
        this.add(rentbutton);
        this.add(typechosen);
        this.add(price);
        this.add(pricerangecursor);
        this.add(renovate);
        this.add(renovation);
        this.add(state);
        this.add(stateofproperty);
        this.add(search);
        this.add(locate);
        this.add(location);

    }

    public void BuyerResearch(ChangeEvent ce) {
        pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "$");
        if (price.getValue() > 79) {
            pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "+$");
        }
    }
}
