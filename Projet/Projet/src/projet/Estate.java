package projet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Estate {

    BufferedImage[] images;
    JLabel[] ImagesToShow;
    int imageindex;
    int x = 20;
    int y = 20;
    int w = 200;
    int h = 200;
    private String location;
    private String adress;
    private double price;
    private int area;
    private int factor;
    private String description;
    JButton right;
    JButton left;

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
        right = new JButton("next");
        left = new JButton("prev");
    }

    public void addImageOnPanel(JPanel panel, int i) {
        panel.add(this.ImagesToShow[i]);
    }

    public void showImage(JPanel panel, Graphics g, int i, int factor) {
        Font font = new Font("Consolas", Font.ITALIC, 14 * factor);
        right = new JButton("next");
        left = new JButton("prev");
        //right.setBounds((this.x*factor + this.w*factor) / 2, (this.y + this.h) * factor, 90*factor, 50*factor);
        left.setBounds((this.x + this.w - 100) / 2 * this.factor, (this.y + this.h) * factor, 90*factor, 50*factor);
        g.drawImage(this.images[i], this.x * factor, this.y * factor, this.w * factor, this.h * factor, panel);
        g.setFont(font);
        g.drawString("location : " + this.location, this.x * factor + this.w * factor + 10, (this.y + 20) * factor);
        g.drawString("adress : " + this.adress, this.x * factor + this.w * factor + 10, (this.y + 40) * factor);
        g.drawString("price : " + this.price + "$", this.x * factor + this.w * factor + 10, (this.y + 60) * factor);
        g.drawString("area : " + this.area + "m²", this.x * factor + this.w * factor + 10, (this.y + 80) * factor);
        g.drawString("descritpion : " + this.description, this.x * factor + this.w * factor + 10, (this.y + 100) * factor);
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
