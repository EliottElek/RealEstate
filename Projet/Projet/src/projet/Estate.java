package projet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class Estate {

    BufferedImage[] images;
    JLabel[] ImagesToShow;
    int imageindex;
    private String location;
    private String adress;
    private double price;
    private int area;
    private int factor;
    private String description;
    JButton right;
    JButton left;
    JPanel infos;
    JPanel imgs;
    JScrollPane imagesScroller;

    public Estate(String location, String adress, double price, int area, String description, String[] imagesnames, int factor) throws IOException {
        this.location = location;
        this.adress = adress;
        this.price = price;
        this.area = area;
        this.factor = factor;
        this.description = description;
        this.images = new BufferedImage[imagesnames.length];
        this.ImagesToShow = new JLabel[imagesnames.length];
        for (int i = 0; i < imagesnames.length; i++) {
            this.images[i] = ImageIO.read(this.getClass().getResource(imagesnames[i]));
            ImagesToShow[i] = new JLabel(new ImageIcon(this.images[i]));
        }

        infos = new JPanel();
        imgs = new JPanel();
        this.setInfos();
    }

    public void setInfos() {
        infos.setLayout(new GridLayout(6, 1));
        Font font = new Font("Consolas", Font.PLAIN, 24 * this.factor);
        JLabel location = new JLabel("Location : " + this.location);
        JLabel adress = new JLabel("adress : " + this.adress);
        JLabel price = new JLabel("price : " + this.price + "$");
        JLabel area = new JLabel("area : " + this.area + "m²");
        JLabel description = new JLabel("description : " + this.description);
        this.right = new JButton("view next image");
        this.left = new JButton("view previous image");
        this.right.setFont(font);
        this.left.setFont(font);
        location.setFont(font);
        adress.setFont(font);
        price.setFont(font);
        area.setFont(font);
        description.setFont(font);
        infos.add(location);
        infos.add(adress);
        infos.add(price);
        infos.add(area);
        infos.add(description);


    }

    public void addInfosOnPanel(JPanel panel) {
        imgs.setLayout(new GridLayout(1,ImagesToShow.length));

        for (int i = 0; i < ImagesToShow.length; i++) {
            System.out.println(i);
            imgs.add(ImagesToShow[i]);
        }

        imagesScroller = new JScrollPane(imgs);
        imagesScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        imagesScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panel.add(imagesScroller);
        panel.add(infos);

    }
    public void removeInfos(JPanel panel)
    {
        panel.remove(imagesScroller);
        panel.remove(infos);
    }

    public void changeImage(JPanel panel) {
        panel.remove(infos);
        addInfosOnPanel(panel);

    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.area = area;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
