/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Buyer;
import java.awt.List;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author eliot
 */
public class BuyerDAO {

    private Connection myConn;

    public BuyerDAO() throws Exception {
        /*
         // get db properties
         Properties props = new Properties();
         props.load(new FileInputStream("demo.properties"));
		
         String user = props.getProperty("user");
         String password = props.getProperty("password");
         String dburl = props.getProperty("dburl");
         */
        String user = "root";
        String password = "elektra1";
        String url = "jdbc:mysql://localhost:3306/realestatedatabase?useSSL=false";
        // connect to database
        myConn = DriverManager.getConnection(url, user, password);

        System.out.println("DB connection successful to: " + url);
    }

    public ArrayList<Buyer> getAllBuyers() throws Exception {
        ArrayList<Buyer> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * from buyers");

            while (myRs.next()) {
                Buyer temp = convertRowToBuyer(myRs);
                temp.showInfos();
                list.add(temp);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public ArrayList<Buyer> searchBuyers(String lastName) throws Exception {
        ArrayList<Buyer> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            lastName += "%";
            myStmt = myConn.prepareStatement("SELECT * from buyers where lastname like ?");

            myStmt.setString(1, lastName);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                Buyer temp = convertRowToBuyer(myRs);
                list.add(temp);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void addBuyerToDataBase(Buyer buyer) throws SQLException {
        Statement stmt = myConn.createStatement();
        String fstname = buyer.getFirstName();
        String lstname = buyer.getLastName();
        int d = buyer.getD();
        int m = buyer.getM();
        int y = buyer.getY();
        String adress = buyer.getAdress();
        String mail = buyer.getEmail();
        String pass = buyer.getPassword();
        String dbop = "INSERT INTO `buyers` (`identifier`,`firstname`, `lastname`, `birthdate`, `adress`, `mail`, `password`) VALUES (NULL, '" + fstname + "', '" + lstname + "', '" + y + "-" + m + "-" + d + "','" + adress + "','" + mail + "','" + pass + "');";
        stmt.execute(dbop);
        stmt.close();
    }

    public Buyer getBuyerAccount(String lastName, String password) throws Exception {
        Buyer buyer = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            lastName += "%";
            myStmt = myConn.prepareStatement("SELECT * FROM `buyers` WHERE `mail` like ? && `password` like ? ");

            myStmt.setString(1, lastName);
            myStmt.setString(2, password);
            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                buyer = convertRowToBuyer(myRs);
                buyer.showInfos();
            }
        } finally {
            close(myStmt, myRs);
        }
        return buyer;
    }

    public boolean mailCheck(String mail) throws SQLException {
        boolean mailok = false;
        try (Statement stmt = myConn.createStatement()) {
            String qry = "SELECT `mail` FROM `buyers` WHERE 1; ";
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                String thismail = rs.getString("mail");
                if (mail.equals(thismail)) {
                    JOptionPane.showMessageDialog(null, "This mail adress is already used. Please select another one.", "Already existing mail adress.", JOptionPane.WARNING_MESSAGE);
                    mailok = false;
                    break;
                } else {
                    mailok = true;
                }

            }
            stmt.close();
        }
        return mailok;
    }

    public boolean profileCheck(String mail, String password) {
        boolean checked = false;
        try {
            System.out.println(mail + password);
            Statement stmt = myConn.createStatement();
            String qry = "SELECT `mail`, `password` FROM `buyers` WHERE 1; ";
            ResultSet rs = stmt.executeQuery(qry);
            while (rs.next()) {
                String thismail = rs.getString("mail");
                String thispassord = rs.getString("password");
                if ((thismail.equals(mail)) && (thispassord.equals(password))) {
                    checked = true;
                    break;
                } else {
                    checked = false;
                }
            }
            if (!checked) {
                JOptionPane.showMessageDialog(null, "Cannot find account.", "fail", JOptionPane.WARNING_MESSAGE);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(BuyerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return checked;
    }

    public void modifyBuyerProfile(User newbuyer) throws SQLException {
        int id = newbuyer.getID();
        try (PreparedStatement myStmt = myConn.prepareStatement("UPDATE `buyers` SET `identifier`=?,`firstname`=?,`lastname`=?,`birthdate`=?,`adress`=?,`mail`=? WHERE `identifier` like ?")) {
            myStmt.setInt(1, id);
            myStmt.setString(2, newbuyer.getFirstName());
            myStmt.setString(3, newbuyer.getLastName());
            myStmt.setDate(4, newbuyer.getDate());
            myStmt.setString(5, newbuyer.getAdress());
            myStmt.setString(6, newbuyer.getEmail());
            myStmt.setInt(7, id);
            myStmt.execute();
            JOptionPane.showMessageDialog(null, "New infos have been saved.", "succes", JOptionPane.INFORMATION_MESSAGE);
            myStmt.close();
        }

    }

    private Buyer convertRowToBuyer(ResultSet myRs) throws SQLException {

        int id = myRs.getInt("identifier");
        String lastName = myRs.getString("lastname");
        String firstName = myRs.getString("firstname");
        String email = myRs.getString("mail");
        Date date = myRs.getDate("birthdate");
        String adress = myRs.getString("adress");

        Buyer temp = new Buyer(id, firstName, lastName, date, adress, email);

        return temp;
    }

    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {

        }

        if (myConn != null) {
            myConn.close();
        }
    }

    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

}
