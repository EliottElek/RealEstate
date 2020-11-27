package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class Estate implements SellerConstInterface {

    Blob image1;
    Blob image2;
    Blob image3;
    Blob[] images;
    private String location;
    private String adress;
    private int price;
    private int area;
    private int factor;
    private String description;
    private int id;
    private ArrayList<Booking> bookings;
    JPanel infos;
    JPanel imgs;
    JButton modify;
    JButton save;
    JButton delete;
    JButton booking;
    JLabel[] imagefin = new JLabel[3];
    JScrollPane imagesScroller;
    JComboBox newlocation;
    JTextField newarea;
    JTextField newdescription;
    JTextField newprice;
    JTextField newadress;
    JLabel thislocation;
    JLabel thisadress;
    JLabel thisprice;
    JLabel thisarea;
    JLabel thisdescription;

    ;

    public Estate(int id, String location, String adress, int price, int area, String description, Blob image1, Blob image2, Blob image3, int factor) throws IOException {
        this.id = id;
        this.location = location;
        this.adress = adress;
        this.price = price;
        this.area = area;
        this.factor = factor;
        this.description = description;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        images = new Blob[3];
        bookings = new ArrayList();
        images[0] = this.image1;
        images[1] = this.image2;
        images[2] = this.image3;
        infos = new JPanel();
        imgs = new JPanel();
        modify = new JButton("modify");
        save = new JButton("save");
        delete = new JButton("delete");
        booking = new JButton("BOOK");
        delete.setBackground(new Color(240,60,60));
        booking.setVisible(false);
        //this.setInfos();
        modify.setFocusable(false);
        booking.setFocusable(false);
        delete.setFocusable(false);
        save.setFocusable(false);
        modify.setVisible(false);
        delete.setVisible(false);
    }

    public void updateInfos() {

    }

    public void setInfos() {
        delete.setBackground(Color.red);
        infos.removeAll();
        infos.setLayout(new GridLayout(8, 1));
        Font font = new Font("Times New Roman", Font.PLAIN, 19 * this.factor);
        JLabel thislocation = new JLabel("Location : " + this.location);
        JLabel thisadress = new JLabel("adress : " + this.adress);
        JLabel thisprice = new JLabel("price : " + this.price + "$");
        JLabel thisarea = new JLabel("area : " + this.area + "m²");
        JTextArea thisdescription = new JTextArea("description : " + this.description);
        thisdescription.setLineWrap(true);
        thisdescription.setWrapStyleWord(true);
        modify.setFont(font);
        delete.setFont(font);
        thislocation.setFont(font);
        thisadress.setFont(font);
        thisprice.setFont(font);
        thisarea.setFont(font);
        thisdescription.setFont(font);
        infos.add(thislocation);
        infos.add(thisadress);
        infos.add(thisprice);
        infos.add(thisarea);
        infos.add(thisdescription);
        infos.add(booking);
        infos.add(delete);
        infos.add(modify);
    }

    public void setModifyingInfos() {
        infos.removeAll();
        newadress = new JTextField(this.adress);
        newarea = new JTextField(Integer.toString(this.area));
        newdescription = new JTextField(this.description);
        newprice = new JTextField(Integer.toString(this.price));
        newlocation = new JComboBox(typesoflocations);
        newlocation.setSelectedItem(this.location);
        infos.setLayout(new GridLayout(8, 2));
        Font font = new Font("Times New Roman", Font.PLAIN, 19 * this.factor);
        thislocation = new JLabel("Location : ");
        thisadress = new JLabel("adress : ");
        thisprice = new JLabel("price : ");
        thisarea = new JLabel("area : ");
        thisdescription = new JLabel("description : ");
        modify.setFont(font);
        save.setFont(font);
        newadress.setFont(font);
        newarea.setFont(font);
        newdescription.setFont(font);
        newprice.setFont(font);
        newlocation.setFont(font);
        thislocation.setFont(font);
        thisadress.setFont(font);
        thisprice.setFont(font);
        thisarea.setFont(font);
        thisdescription.setFont(font);
        infos.add(thislocation);
        infos.add(newlocation);
        infos.add(thisadress);
        infos.add(newadress);
        infos.add(thisprice);
        infos.add(newprice);
        infos.add(thisarea);
        infos.add(newarea);
        infos.add(thisdescription);
        infos.add(newdescription);
        infos.add(booking);
        infos.add(delete);
        infos.add(save);
    }

    public void addInfosOnPanel(JPanel panel, boolean modif) throws IOException {
        if (!modif) {
            this.setInfos();
        } else if (modif) {
            this.setModifyingInfos();
        }
        imgs.setLayout(new GridLayout(1, 3));
        for (int i = 0; i < 3; i++) {
            byte[] imagebytes = null;
            try {
                imagebytes = images[i].getBytes(1, (int) images[i].length());
            } catch (SQLException ex) {
                Logger.getLogger(Estate.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedImage theImage = ImageIO.read(new ByteArrayInputStream(imagebytes));
            imagefin[i] = new JLabel(new ImageIcon(theImage));
            imgs.add(imagefin[i]);
        }
        imagesScroller = new JScrollPane(imgs);
        imagesScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        imagesScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panel.add(imagesScroller);
        panel.add(infos);

    }

    public void removeInfos(JPanel panel) {
        
        panel.remove(imagesScroller);
        panel.remove(imgs);
        panel.remove(infos);
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getID() {
        return this.id;
    }

    public String getAdress() {
        return this.adress;
    }

    public String getLocation() {
        return this.location;
    }

    public int getArea() {
        return this.area;
    }

    public int getPrice() {
        return this.price;
    }

    String getDescription() {
        return this.description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.area = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public JButton getModify() {
        return this.modify;
    }

    public void setVisibleButton(boolean bool) {
        modify.setVisible(bool);
    }
    
    public void addBooking(Booking booking)
    {
        this.bookings.add(booking);
    }
    
    public void removeBooking(Booking booking)
    {
        this.bookings.remove(booking);
    }
    
    public ArrayList<Booking> getAllBookings()
    {
        return this.bookings;
    }
}
