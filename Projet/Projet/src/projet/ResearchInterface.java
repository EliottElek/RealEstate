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
public class ResearchInterface extends JPanel implements BuyerConstInterface {

    int factor = 1;
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
    JLabel minareacursor;
    JLabel maxareacursor;
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
    JSlider minarea;
    JSlider maxarea;
    JRadioButton buybutton;
    JRadioButton rentbutton;
    ButtonGroup group;
    JButton search;

    ResearchInterface(int factor) {
        this.factor = factor;
        //creating default font
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        //setting the layout
        this.setLayout(null);
        this.setSize(1000*factor,600*factor);
        //this.setBackground(Color.blue);
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
        minareacursor = new JLabel("min m²");
        maxareacursor = new JLabel("max m²");
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
        price = new JSlider(5, 80,20);
        minarea = new JSlider(9, 500,60);
        maxarea = new JSlider(20, 1000,120);
        //setting buttons to not focudable
        buybutton.setFocusable(false);
        rentbutton.setFocusable(false);
        search.setFocusable(false);
        //creating the button group
        group = new ButtonGroup();
        //setting all bounds
        location.setBounds(50 * factor, 20 * factor, 300 * factor, 30 * factor);
        locate.setBounds(50 * factor, 55 * factor, 300 * factor, 30 * factor);
        typeofproperty.setBounds(50 * factor, 100 * factor, 300 * factor, 30 * factor);
        pricerange.setBounds(50 * factor, 180 * factor, 150 * factor, 30 * factor);
        proximity.setBounds(50 * factor, 260 * factor, 300 * factor, 30 * factor);
        locateorbuy.setBounds(50 * factor, 340 * factor, 300 * factor, 30 * factor);
        nbminrooms.setBounds(420 * factor, 20 * factor, 300 * factor, 30 * factor);
        nbmaxrooms.setBounds(575 * factor, 20 * factor, 300 * factor, 30 * factor);
        nbminbthrooms.setBounds(400 * factor, 100 * factor, 300 * factor, 30 * factor);
        nbmaxbthrooms.setBounds(560 * factor, 100 * factor, 300 * factor, 30 * factor);
        buybutton.setBounds(50 * factor, 380 * factor, 80 * factor, 30 * factor);
        rentbutton.setBounds(130 * factor, 380 * factor, 80 * factor, 30 * factor);
        typechosen.setBounds(50 * factor, 135 * factor, 300 * factor, 30 * factor);
        proximitychosen.setBounds(50 * factor, 295 * factor, 300 * factor, 30 * factor);
        nbminroomschosen.setBounds(420 * factor, 55 * factor, 90 * factor, 30 * factor);
        nbmaxroomschosen.setBounds(575 * factor, 55 * factor, 90 * factor, 30 * factor);
        nbminbthroomschosen.setBounds(420 * factor, 135 * factor, 90 * factor, 30 * factor);
        nbmaxbthroomschosen.setBounds(575 * factor, 135 * factor, 90 * factor, 30 * factor);
        pricerangecursor.setBounds(280 * factor, 180 * factor, 80 * factor, 30 * factor);
        price.setBounds(50 * factor, 215 * factor, 300 * factor, 30 * factor);
        minarea.setBounds(700 * factor, 75 * factor, 150 * factor, 20 * factor);
        maxarea.setBounds(700 * factor, 140 * factor, 150 * factor, 20 * factor);
        minareacursor.setBounds(700 * factor, 100 * factor, 150 * factor, 30 * factor);
        maxareacursor.setBounds(700 * factor, 160 * factor, 150 * factor, 30 * factor);
        renovate.setBounds(400 * factor, 180 * factor, 300 * factor, 30 * factor);
        renovation.setBounds(400 * factor, 215 * factor, 300 * factor, 30 * factor);
        stateofproperty.setBounds(400 * factor, 260 * factor, 300 * factor, 30 * factor);
        state.setBounds(400 * factor, 295 * factor, 300 * factor, 30 * factor);
        search.setBounds(300 * factor, 400 * factor, 200 * factor, 60 * factor);
        //initializing sliders
        price.setPaintTicks(true);
        price.setPaintTrack(true);
        price.setPaintLabels(true);
        //setting initial values to sliders
        pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "$");
        maxareacursor.setText(Integer.toString(maxarea.getValue()) + "m²");
        minareacursor.setText(Integer.toString(minarea.getValue()) + "m²");
        //setting all fonts
        pricerangecursor.setFont(font);
        maxareacursor.setFont(font);
        minareacursor.setFont(font);
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
        search.setFont(font);
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
        this.add(minarea);
        this.add(maxarea);
        this.add(minareacursor);
        this.add(maxareacursor);

    }

    public void BuyerResearch(ChangeEvent ce) {
        pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "$");
        if (price.getValue() > 79) {
            pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "+$");
        } else {
            pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "$");
        }
        if (minarea.getValue() > 499) {
            minareacursor.setText(Integer.toString(minarea.getValue()) + "+m²");
        } else {
            minareacursor.setText(Integer.toString(minarea.getValue()) + "m²");
        }
        if (maxarea.getValue() >999) {
            maxareacursor.setText(Integer.toString(maxarea.getValue()) + "+m²");
        } else {
            maxareacursor.setText(Integer.toString(maxarea.getValue()) + "m²");
        }
    }
}
