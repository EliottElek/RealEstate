/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mysql.jdbc.Connection;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author eliot
 */
public class Projet {

    public static void main(String[] args) throws Exception {
        SellerDAO seldao = new SellerDAO();
        System.out.println("/////////////////SELLERS////////////////////");
        seldao.getAllSellers();
        BuyerDAO buyerdao = new BuyerDAO();
        System.out.println("/////////////////BUYERS////////////////////");
        buyerdao.getAllBuyers();
        EmployeeDAO employeedao = new EmployeeDAO();
        System.out.println("/////////////////EMPLOYEES////////////////////");
        employeedao.getAllEmployees();
        new CreateInterface();
        //Projet projet = new Projet();
    }

}
