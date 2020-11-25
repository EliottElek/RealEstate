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
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author eliot
 */
public class SellerInterface extends JPanel implements SellerConstInterface {

    String thisadress;
    String thislocation;
    int thisprice;
    String thisdescription;
    String thispicturepath;
    String thispicturepath2;
    String thispicturepath3;
    int thisarea;
    String thistype;
    String thisrenovation;
    String thisproximity;
    String thisstate;
    String thisrent;
    int thisbedrooms;
    int thisbathrooms;
    int thisgardenarea;
    String thisgardenchoice = "no";
    EstateDAO estatedao;
    int factor = 1;
    JPanel PANEL1;
    JPanel PANEL2;
    JPanel PANEL3;
    JPanel PANEL4;
    JPanel PANEL5;
    JPanel PANEL6;
    JPanel PANEL7;
    JPanel PANEL10;
    JPanel PANEL11;
    JPanel gardenpanel;
    JPanel rentorsellpanel;
    JLabel location;
    JLabel typeofproperty;
    JLabel pricerange;
    JLabel proximity;
    JLabel nbrooms;
    JLabel nbbthrooms;
    JLabel renovate;
    JLabel stateofproperty;
    JLabel desc;
    JLabel area;
    JLabel gardenchoice;
    JLabel gardenarea;
    JLabel rentorsell;
    JLabel adress;
    JComboBox typechosen;
    JComboBox proximitychosen;
    JComboBox nbroomschosen;
    JComboBox nbbthroomschosen;
    JComboBox renovation;
    JComboBox state;
    JComboBox locate;
    JTextField price;
    JTextField description;
    JTextField areachosen;
    JTextField gardenareachosen;
    JTextField adresschosen;
    JButton add;
    JButton back;
    JButton logout;
    JButton myprofile;
    JButton addpicture1;
    JButton addpicture2;
    JButton addpicture3;
    JRadioButton gardenyes;
    JRadioButton gardenno;
    JRadioButton sell;
    JRadioButton rent;
    ButtonGroup gardengroup;
    ButtonGroup rentorsellgroup;
    JScrollPane SCROLLER;

    SellerInterface(int factor, EstateDAO estatedao) throws Exception {
        this.estatedao = estatedao;
        this.factor = factor;
        this.setLayout(new BorderLayout(10, 10));
        PANEL1 = new JPanel();
        PANEL2 = new JPanel();
        PANEL3 = new JPanel();
        PANEL4 = new JPanel();
        PANEL5 = new JPanel();
        PANEL6 = new JPanel();
        PANEL7 = new JPanel();
        PANEL10 = new JPanel();
        PANEL11 = new JPanel();
        gardenpanel = new JPanel();
        rentorsellpanel = new JPanel();
        PANEL1.setPreferredSize(new Dimension(200, 100));
        PANEL2.setPreferredSize(new Dimension(200, 100));
        PANEL3.setPreferredSize(new Dimension(200, 100));
        PANEL4.setPreferredSize(new Dimension(200, 100));
        PANEL5.setPreferredSize(new Dimension(200, 700));
        PANEL6.setPreferredSize(new Dimension(200, 700));
        PANEL7.setPreferredSize(new Dimension(200, 700));
        PANEL10.setPreferredSize(new Dimension(200, 100));
        PANEL11.setPreferredSize(new Dimension(200, 3000));
        Color col = new Color(155, 155, 70);//darker
        Color col2 = new Color(200, 200, 130);//lighter
        PANEL1.setBackground(col);
        PANEL2.setBackground(col);
        PANEL3.setBackground(col);
        PANEL4.setBackground(col);
        PANEL5.setBackground(col);
        PANEL6.setBackground(col2);
        PANEL7.setBackground(col2);
        PANEL1.setLayout(new BorderLayout());
        PANEL10.setLayout(new BorderLayout());
        //PANEL11.setLayout(new GridLayout(properties.length, 2));
        PANEL5.setLayout(new GridLayout(1, 2));
        PANEL6.setLayout(new GridLayout(22, 1));
        PANEL7.setLayout(new GridLayout(22, 1));
        gardenpanel.setLayout(new GridLayout(1, 2));
        rentorsellpanel.setLayout(new GridLayout(1, 2));
        PANEL1.add(PANEL10, BorderLayout.EAST);
        //adding PANEL6 and PANEL7 to PANEL5
        //adding PANELS 8 and 9 to PANEL6
        //add everything to the PANELS
        this.setSize(1000 * this.factor, 600 * this.factor);
        //creating default font
        Font font = new Font("Times New Roman", Font.PLAIN, 18 * factor);
        //creating labels
        location = new JLabel("Location");
        typeofproperty = new JLabel("property type");
        pricerange = new JLabel("price ($)");
        proximity = new JLabel("proximity");
        nbrooms = new JLabel("number of rooms");
        nbbthrooms = new JLabel("number of bathrooms");
        renovate = new JLabel("renovation");
        stateofproperty = new JLabel("state of property");
        desc = new JLabel("Add a descritpion...");
        area = new JLabel("area");
        gardenchoice = new JLabel("garden");
        gardenarea = new JLabel("garden area");
        rentorsell = new JLabel("property to");
        adress = new JLabel("adress");
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
        logout = new JButton("LOG OUT");
        myprofile = new JButton("My profile");
        addpicture1 = new JButton("add picture 1");
        addpicture2 = new JButton("add picture 2");
        addpicture3 = new JButton("add picture 3");
        gardenyes = new JRadioButton("yes");
        gardenno = new JRadioButton("no");
        sell = new JRadioButton("sell");
        rent = new JRadioButton("rent");
        gardengroup = new ButtonGroup();
        rentorsellgroup = new ButtonGroup();
        gardengroup.add(gardenyes);
        gardengroup.add(gardenno);
        rentorsellgroup.add(sell);
        rentorsellgroup.add(rent);
        add.setFocusable(false);
        back.setFocusable(false);
        logout.setFocusable(false);
        myprofile.setFocusable(false);
        //creating texfields
        price = new JTextField();
        description = new JTextField();
        areachosen = new JTextField();
        gardenareachosen = new JTextField();
        adresschosen = new JTextField();
        //setting buttons to not focudable
        add.setFocusable(false);
        addpicture1.setFocusable(false);
        addpicture2.setFocusable(false);
        addpicture3.setFocusable(false);
        gardenyes.setFocusable(false);
        gardenno.setFocusable(false);
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
        addpicture1.setFont(font);
        addpicture2.setFont(font);
        addpicture3.setFont(font);
        area.setFont(font);
        areachosen.setFont(font);
        gardenyes.setFont(font);
        gardenno.setFont(font);
        gardenchoice.setFont(font);
        gardenareachosen.setFont(font);
        gardenarea.setFont(font);
        rentorsell.setFont(font);
        rent.setFont(font);
        sell.setFont(font);
        adress.setFont(font);
        adresschosen.setFont(font);
        //create scroller for middle panel
        SCROLLER = new JScrollPane(PANEL5);
        SCROLLER.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        SCROLLER.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //disable add button
        add.setEnabled(false);
        this.add(PANEL1, BorderLayout.NORTH);
        this.add(PANEL2, BorderLayout.SOUTH);
        this.add(PANEL3, BorderLayout.WEST);
        this.add(PANEL4, BorderLayout.EAST);
        this.add(SCROLLER, BorderLayout.CENTER);
        gardenpanel.add(gardenyes);
        gardenpanel.add(gardenno);
        rentorsellpanel.add(sell);
        rentorsellpanel.add(rent);
        PANEL2.add(back, BorderLayout.WEST);
        PANEL10.add(myprofile, BorderLayout.CENTER);
        PANEL10.add(logout, BorderLayout.NORTH);
        PANEL5.add(PANEL6);
        PANEL5.add(PANEL7);
        PANEL6.add(location);
        PANEL6.add(locate);
        PANEL6.add(adress);
        PANEL6.add(adresschosen);
        PANEL6.add(typeofproperty);
        PANEL6.add(typechosen);
        PANEL6.add(proximity);
        PANEL6.add(proximitychosen);
        PANEL6.add(pricerange);
        PANEL6.add(price);
        PANEL6.add(renovate);
        PANEL6.add(renovation);
        PANEL6.add(stateofproperty);
        PANEL6.add(state);
        PANEL7.add(nbrooms);
        PANEL7.add(nbroomschosen);
        PANEL7.add(nbbthrooms);
        PANEL7.add(nbbthroomschosen);
        PANEL7.add(area);
        PANEL7.add(areachosen);
        PANEL7.add(new JLabel());
        PANEL7.add(addpicture1);
        PANEL7.add(addpicture2);
        PANEL7.add(addpicture3);
        PANEL7.add(gardenchoice);
        PANEL7.add(gardenpanel);
        PANEL7.add(gardenarea);
        PANEL7.add(gardenareachosen);
        PANEL7.add(rentorsell);
        PANEL7.add(rentorsellpanel);
        PANEL7.add(desc);
        PANEL7.add(description);
        PANEL7.add(new JLabel());
        PANEL7.add(new JLabel());
        PANEL7.add(new JLabel());
        PANEL7.add(add);
        add.setEnabled(true);
        this.setVisible(true);

    }

    public void SellerAddProperty(ActionEvent ce) {
        if (ce.getSource() == gardenyes) {
            thisgardenchoice = "yes";
        } else if (ce.getSource() == gardenno) {
            thisgardenchoice = "no";
        }
        if (ce.getSource() == sell) {
            thisrent = "no";
        } else if (ce.getSource() == rent) {
            thisrent = "yes";
        }
        if (!areachosen.getText().equals("")) {
            this.thisarea = Integer.parseInt(areachosen.getText());
        }
        if (!price.getText().equals("")) {
            this.thisprice = Integer.parseInt(price.getText());
        }
        /////////////////////////////////////////////////////
        ///getting of all informations
        this.thislocation = (String) locate.getSelectedItem();
        this.thisproximity = (String) proximitychosen.getSelectedItem();
        this.thistype = (String) typechosen.getSelectedItem();
        this.thisadress = adresschosen.getText();
        this.thisrenovation = (String) renovation.getSelectedItem();
        this.thisstate = (String) state.getSelectedItem();
        if (!((String) nbroomschosen.getSelectedItem()).equals(" ")) {
            this.thisbedrooms = Integer.parseInt((String) nbroomschosen.getSelectedItem());
        }
        if (!((String) nbbthroomschosen.getSelectedItem()).equals(" ")) {
            this.thisbathrooms = Integer.parseInt((String) nbbthroomschosen.getSelectedItem());
        }
        //this.thisgardenchoice
        if (thisgardenchoice.equals("yes") && (!gardenareachosen.getText().equals(""))) {
            this.thisgardenarea = Integer.parseInt(gardenareachosen.getText());
        }
        this.thisdescription = description.getText();
        //photo1
        //photo2
        //photo3

        ////////////////////////////////////////////////////
        if ((!locate.getSelectedItem().equals(" "))
                && (!proximitychosen.getSelectedItem().equals(" "))
                && (!nbroomschosen.getSelectedItem().equals(" "))
                && (!nbbthroomschosen.getSelectedItem().equals(" "))
                && (!typechosen.getSelectedItem().equals(" "))
                && (!description.getText().equals(" "))
                && (!price.getText().equals(""))
                && (!description.getText().equals(""))
                && (!areachosen.getText().equals(""))
                && (!renovation.getSelectedItem().equals(" "))) {
            add.setEnabled(true);
        }
        if (ce.getSource() == addpicture1) {
            thispicturepath = getPicturePath();
        }
        if (ce.getSource() == addpicture2) {
            thispicturepath2 = getPicturePath();
        }
        if (ce.getSource() == addpicture3) {
            thispicturepath3 = getPicturePath();
        }
        if (ce.getSource() == add) {
            try {
                InputStream is = new FileInputStream(new File(thispicturepath));
                InputStream is2 = new FileInputStream(new File(thispicturepath2));
                InputStream is3 = new FileInputStream(new File(thispicturepath3));
                estatedao.addEstateToDataBase(this.thisadress,
                        this.thislocation,
                        this.thisprice,
                        this.thisdescription,
                        this.thisarea,
                        this.thistype,
                        this.thisrenovation,
                        this.thisproximity,
                        this.thisstate,
                        this.thisrent,
                        this.thisbedrooms,
                        this.thisbathrooms,
                        this.thisgardenarea,
                        this.thisgardenchoice,
                        is,
                        is2,
                        is3);
            } catch (SQLException | FileNotFoundException ex) {
                Logger.getLogger(SellerInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getPicturePath() {
        String path = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
        }
        return path;
    }
}
