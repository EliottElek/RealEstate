/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author eliot
 */
public class BuyerInterface extends JPanel implements BuyerConstInterface {

    int factor;
    Estate[] properties;
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
    JScrollPane SCROLLER;
    JLabel location;
    JLabel typeofproperty;
    JLabel pricerange;
    JLabel pricerangecursor;
    JLabel proximity;
    JLabel locateorbuy;
    JLabel nbrooms;
    JLabel nbbthrooms;
    JLabel renovate;
    JLabel stateofproperty;
    JLabel minareacursor;
    JLabel maxareacursor;
    JLabel area;
    JLabel garden;
    JLabel gardenarea;
    JComboBox typechosen;
    JComboBox proximitychosen;
    JComboBox nbminroomschosen;
    JComboBox nbmaxroomschosen;
    JComboBox nbminbthroomschosen;
    JComboBox nbmaxbthroomschosen;
    JComboBox renovation;
    JComboBox state;
    JComboBox locate;
    JComboBox gardenchoice;

    JSlider price;
    JSlider minarea;
    JSlider maxarea;
    JSlider gardenareachosen;
    JRadioButton buybutton;
    JRadioButton rentbutton;
    ButtonGroup group;
    JButton search;
    JButton logout;
    JButton myprofile;
    JButton back;
    JButton latestadds;

    BuyerInterface(Estate[] properties, int factor) {
        this.factor = factor;
        this.properties = new Estate[properties.length];
        this.properties = properties;
        //this.setBackground(Color.lightGray);
        //creating default font
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        Font font2 = new Font("Consolas", Font.PLAIN, 10);
        //setting the layout
        this.setLayout(new BorderLayout(10, 10));
        //setting the size
        this.setSize(1000 * factor, 600 * factor);
        //creating the PANELS
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
        //setting the sizes of PANELS
        PANEL1.setPreferredSize(new Dimension(200, 100));
        PANEL2.setPreferredSize(new Dimension(200, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL4.setPreferredSize(new Dimension(200, 100));
        PANEL5.setPreferredSize(new Dimension(200, 100));
        PANEL10.setPreferredSize(new Dimension(200, 100));
        PANEL11.setPreferredSize(new Dimension(200, 3000));
        //setting PANELS colors 
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
        //PANEL5 is the center panel. We mant a gridLayout in it
        PANEL1.setLayout(new BorderLayout());
        PANEL10.setLayout(new BorderLayout());
        PANEL11.setLayout(new GridLayout(properties.length, 2));
        PANEL5.setLayout(new GridLayout(1, 2));
        PANEL6.setLayout(new GridLayout(2, 1));
        PANEL7.setLayout(new GridLayout(14, 2));
        PANEL8.setLayout(new GridLayout(7, 1));
        PANEL9.setLayout(new GridLayout(7, 2));
        PANEL3.setLayout(new GridLayout(7, 1, 2, 2));
        //creating labels
        location = new JLabel("Location");
        typeofproperty = new JLabel("property type");
        pricerange = new JLabel("max price");
        proximity = new JLabel("transportation proximity");
        locateorbuy = new JLabel("want to");
        nbrooms = new JLabel("rooms");
        nbbthrooms = new JLabel("bathrooms");
        renovate = new JLabel("renovation");
        stateofproperty = new JLabel("state of property");
        minareacursor = new JLabel("min m²");
        maxareacursor = new JLabel("max m²");
        area = new JLabel("area");
        garden = new JLabel("garden");
        gardenarea = new JLabel();
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
        gardenchoice = new JComboBox(gardentype);
        //creating radion buttons
        buybutton = new JRadioButton("Buy");
        rentbutton = new JRadioButton("Rent");
        //creating buttons
        search = new JButton("SEARCH");
        logout = new JButton("LOG OUT");
        myprofile = new JButton("My profile");
        back = new JButton("back");
        latestadds = new JButton("latest additions");
        //creating sliders
        price = new JSlider(5, 80, 20);
        minarea = new JSlider(9, 500, 60);
        maxarea = new JSlider(20, 1000, 120);
        gardenareachosen = new JSlider(9, 500, 60);
        //setting buttons to not focudable
        buybutton.setFocusable(false);
        rentbutton.setFocusable(false);
        search.setFocusable(false);
        logout.setFocusable(false);
        myprofile.setFocusable(false);
        back.setFocusable(false);
        latestadds.setFocusable(false);
        back.setVisible(false);
        //creating the button group
        group = new ButtonGroup();
        //initializing sliders
        price.setPaintTicks(true);
        price.setPaintTrack(true);
        price.setPaintLabels(true);
        //setting initial values to sliders
        pricerangecursor.setText("   " + Integer.toString(price.getValue() * 10000) + "$");
        maxareacursor.setText("   max area : " + Integer.toString(maxarea.getValue()) + "m²");
        minareacursor.setText("   min area : " + Integer.toString(minarea.getValue()) + "m²");
        gardenarea.setText("   garden area : " + Integer.toString(gardenareachosen.getValue()) + "m²");
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
        nbbthrooms.setFont(font);
        nbrooms.setFont(font);
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
        area.setFont(font);
        garden.setFont(font);
        gardenchoice.setFont(font);
        gardenareachosen.setFont(font);
        gardenarea.setFont(font2);
        back.setFont(font);
        //adding buttons to group
        group.add(buybutton);
        group.add(rentbutton);
        //adding every PANELS
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.SOUTH);
        this.add(PANEL3, BorderLayout.WEST);
        this.add(PANEL4, BorderLayout.EAST);
        this.add(PANEL5, BorderLayout.CENTER);
        PANEL1.add(PANEL10, BorderLayout.EAST);
        PANEL10.add(myprofile, BorderLayout.CENTER);
        PANEL10.add(logout, BorderLayout.NORTH);
        //adding PANEL6 and PANEL7 to PANEL5
        PANEL5.add(PANEL6);
        PANEL5.add(PANEL7);
        //adding PANELS 8 and 9 to PANEL6
        //add everything to the PANELS
        PANEL6.add(PANEL8);
        PANEL6.add(PANEL9);

        PANEL8.add(location);
        PANEL8.add(locate);
        PANEL8.add(typeofproperty);
        PANEL8.add(typechosen);
        PANEL8.add(renovate);
        PANEL8.add(renovation);
        PANEL8.add(locateorbuy);
        PANEL9.add(buybutton);
        PANEL9.add(rentbutton);
        PANEL9.add(nbrooms);
        PANEL9.add(new JLabel());
        PANEL9.add(nbminroomschosen);
        PANEL9.add(nbmaxroomschosen);
        PANEL9.add(nbbthrooms);
        PANEL9.add(new JLabel());
        PANEL9.add(nbminbthroomschosen);
        PANEL9.add(nbmaxbthroomschosen);
        PANEL9.add(pricerange);
        PANEL9.add(new JLabel());
        PANEL9.add(price);
        PANEL9.add(pricerangecursor);
        PANEL7.add(proximity);
        PANEL7.add(proximitychosen);
        PANEL7.add(area);
        PANEL7.add(minarea);
        PANEL7.add(minareacursor);
        PANEL7.add(maxarea);
        PANEL7.add(maxareacursor);
        PANEL7.add(garden);
        PANEL7.add(gardenchoice);
        PANEL7.add(gardenareachosen);
        PANEL7.add(gardenarea);
        PANEL7.add(search);
        PANEL3.add(latestadds, BorderLayout.CENTER);
        PANEL3.add(back);
        PANEL3.add(latestadds);

    }

    public void showResults() {
        PANEL5.remove(PANEL6);
        PANEL5.remove(PANEL7);
        showAllPropertiesImage(PANEL11);
        SCROLLER = new JScrollPane(PANEL11);
        SCROLLER.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLLER.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        PANEL5.add(SCROLLER);
        back.setVisible(true);
        repaint();
    }
    public void hideResults() {
        hideAllPropertiesImage(PANEL11);
    }

    public void backToSearchMenu() {
        PANEL5.remove(SCROLLER);
        PANEL5.remove(PANEL11);
        PANEL5.add(PANEL6);
        PANEL5.add(PANEL7);
        back.setVisible(false);
        repaint();
    }

    void showAllPropertiesImage(JPanel panel) {
        for (int i = 0; i < properties.length; i++) {
            properties[i].addInfosOnPanel(PANEL11);
        }
    }
      void hideAllPropertiesImage(JPanel panel) {
        for (int i = 0; i < properties.length; i++) {
            properties[i].removeInfos(PANEL11);
        }
    }

    public void BuyerResearch(ChangeEvent ce) {
        pricerangecursor.setText(Integer.toString(price.getValue() * 10000) + "$");
        if (price.getValue() > 79) {
            pricerangecursor.setText("   " + Integer.toString(price.getValue() * 10000) + "+$");
        } else {
            pricerangecursor.setText("   " + Integer.toString(price.getValue() * 10000) + "$");
        }
        if (minarea.getValue() > 499) {
            minareacursor.setText("   max area : " + Integer.toString(minarea.getValue()) + "+m²");
        } else {
            minareacursor.setText("   max area : " + Integer.toString(minarea.getValue()) + "m²");
        }
        if (maxarea.getValue() > 999) {
            maxareacursor.setText("   max area : " + Integer.toString(maxarea.getValue()) + "+m²");
        } else {
            maxareacursor.setText("   max area : " + Integer.toString(maxarea.getValue()) + "m²");
        }
        if (gardenareachosen.getValue() > 499) {
            gardenarea.setText("   garden area : " + Integer.toString(gardenareachosen.getValue()) + "+m²");
        } else {
            gardenarea.setText("   garden area : " + Integer.toString(gardenareachosen.getValue()) + "m²");
        }
        if (gardenchoice.getSelectedItem().equals("No garden")) {
            gardenareachosen.setEnabled(false);
        } else {
            gardenareachosen.setEnabled(true);
        }
    }

}
