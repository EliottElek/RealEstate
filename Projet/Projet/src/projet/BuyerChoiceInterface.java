package projet;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BuyerChoiceInterface extends JPanel {

    Estate[] properties;
    int factor;

    BuyerChoiceInterface(Estate[] properties, int factor) {
        
        this.factor = factor;
        this.setSize(1000*factor,600*factor);
        this.setLayout(new GroupLayout(this));
        this.properties = new Estate[properties.length];
        this.properties = properties;
        Font font = new Font("Consolas", Font.PLAIN, 18 * factor);
        this.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        showAllPropertiesImage(this, g);
    }

    void showAllPropertiesImage(JPanel panel, Graphics g) {
        int horizoffset = 0;
        int vertoffset = 0;
        for (int i = 0; i < properties.length; i++) {
            properties[i].x = properties[i].x + horizoffset;
            properties[i].y = properties[i].y + vertoffset;
            showOnePropertyImage(this, g, 0, i);
            if (properties[i].x*factor + properties[i].w*factor + horizoffset*factor+270*factor > 1000*factor) {
                horizoffset = 0;
                vertoffset = vertoffset + properties[i].h + 40*factor;
            } else {
                horizoffset = horizoffset + properties[i].w + 270;
            }
            this.add(properties[i].left);
            this.add(properties[i].right);
        }
    }

    void showOnePropertyImage(JPanel panel, Graphics g, int imageindex, int propertyindex) {
        properties[propertyindex].showImage(this, g, imageindex, factor);
    }

}
