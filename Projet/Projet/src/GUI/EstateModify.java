package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JPanel;

public class EstateModify extends JPanel {

    Estate actualestate;
    EstateDAO estatedao;
    public EstateModify(Estate estate) throws IOException {

        this.setBackground(Color.green);
        this.setLayout(new GridLayout(1,1));
        this.actualestate = estate;
        this.actualestate.addInfosOnPanel(this,true);
        this.setVisible(true);

    }

}
