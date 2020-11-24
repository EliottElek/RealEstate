package GUI;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class Estate {

    Blob image1;
    Blob image2;
    Blob image3;
    Blob[] images;
    private String location;
    private String adress;
    private double price;
    private int area;
    private int factor;
    private String description;
    JPanel infos;
    JPanel imgs;
    JButton modify;
    JLabel[] imagefin = new JLabel[3];
    JScrollPane imagesScroller;

    public Estate(String location, String adress, double price, int area, String description, Blob image1, Blob image2, Blob image3, int factor) throws IOException {
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
        images[0] = this.image1;
        images[1] = this.image2;
        images[2] = this.image3;
        infos = new JPanel();
        imgs = new JPanel();
        modify = new JButton("modify");
        this.setInfos();
        modify.setFocusable(false);
        modify.setVisible(false);
    }

    public void setInfos() {
        infos.setLayout(new GridLayout(7, 1));
        Font font = new Font("Consolas", Font.PLAIN, 19 * this.factor);
        JLabel thislocation = new JLabel("Location : " + this.location);
        JLabel thisadress = new JLabel("adress : " + this.adress);
        JLabel thisprice = new JLabel("price : " + this.price + "$");
        JLabel thisarea = new JLabel("area : " + this.area + "m²");
        JTextArea thisdescription = new JTextArea("description : " + this.description);
        thisdescription.setLineWrap(true);
        thisdescription.setWrapStyleWord(true);
        modify.setFont(font);
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
        infos.add(modify);
    }

    public void addInfosOnPanel(JPanel panel) throws IOException {
        imgs.setLayout(new GridLayout(1,3));
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.area = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JButton getModify()
    {
        return this.modify;
    }
     public void setVisibleButton(boolean bool)
    {
        modify.setVisible(bool);
    }
}
