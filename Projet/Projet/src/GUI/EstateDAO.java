/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Buyer;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author eliot
 */
public class EstateDAO {

    private Connection myConn;

    public EstateDAO() throws Exception {
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

    public ArrayList<Estate> getAllEstates() throws Exception {
        ArrayList<Estate> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * from estate");

            while (myRs.next()) {
                Estate temp = convertRowToEstate(myRs);
                list.add(temp);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void modifyEstate(Estate newestate) throws SQLException {
        int id = newestate.getID();
        try (PreparedStatement myStmt = myConn.prepareStatement("UPDATE `estate` SET `identifier`=?,`location`=?,`adress`=?,`price`=?,`description`=?,`area`=? WHERE `identifier` like ?")) {
            myStmt.setInt(1, id);
            myStmt.setString(2, newestate.getLocation());
            myStmt.setString(3, newestate.getAdress());
            myStmt.setInt(4, newestate.getPrice());
            myStmt.setString(5, newestate.getDescription());
            myStmt.setInt(6, newestate.getArea());
            myStmt.setInt(7, id);
            myStmt.execute();
            JOptionPane.showMessageDialog(null, "New infos have been saved.", "succes", JOptionPane.INFORMATION_MESSAGE);
            myStmt.close();
        }
    }

    public ArrayList<Estate> searchEstate(String thislocate,
            String thistype,
            String thisrenovation,
            String thisrent,
            String thisproximity,
            int thisminroom,
            int thismaxroom,
            int thisminbthroom,
            int thismaxbthroom,
            int thisprice,
            int thisminarea,
            int thismaxarea,
            String thisgarden,
            int thisgardenarea) throws Exception {
        ArrayList<Estate> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            Statement stmt = myConn.createStatement();
            String qry = "SELECT `identifier`, `location`, `adress`, `price`, `area`, `type`, `renovation`, `stateofproperty`, `proximity`, `rent`, `bedrooms`, `bathrooms`, `garden`, `gardenarea`, `description`, `picture1`, `picture2`, `picture3` FROM `estate` WHERE `location`" + thislocate + " && `adress`IS NOT NULL && `price`<=" + thisprice + " && `area`>=" + thisminarea + "&&`area`<=" + thismaxarea + " && `type`" + thistype + " && `renovation`" + thisrenovation + " && `stateofproperty` IS NOT NULL && `proximity`" + thisproximity + " && `rent`" + thisrent + " && `bedrooms`>=" + thisminroom + "&& `bedrooms`<=" + thismaxroom + " && `bathrooms`>=" + thisminbthroom + "&& `bathrooms`<=" + thismaxbthroom + " && `garden`" + thisgarden + " && `gardenarea`>=" + thisgardenarea + " && `description` IS NOT NULL && `picture1` IS NOT NULL && `picture2` IS NOT NULL && `picture3` IS NOT NULL;";
            myRs = stmt.executeQuery(qry);

            while (myRs.next()) {
                Estate temp = convertRowToEstate(myRs);
                list.add(temp);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    public void addEstateToDataBase(String thisadress,
            String thislocation,
            int thisprice,
            String thisdescription,
            int thisarea,
            String thistype,
            String thisrenovation,
            String thisproximity,
            String thisstate,
            String thisrent,
            int thisbedrooms,
            int thisbathrooms,
            int thisgardenarea,
            String thisgardenchoice,
            InputStream is,
            InputStream is2,
            InputStream is3) throws SQLException {
        PreparedStatement ps = myConn.prepareStatement("INSERT INTO `estate`(`identifier`,`location`, `adress`, `price`, `area`, `type`, `renovation`,`stateofproperty`, `proximity`, `rent`, `bedrooms`, `bathrooms`, `garden`, `gardenarea`, `description`, `picture1`, `picture2`, `picture3`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, thislocation);
        ps.setString(2, thisadress);
        ps.setInt(3, thisprice);
        ps.setInt(4, thisarea);
        ps.setString(5, thistype);
        ps.setString(6, thisrenovation);
        ps.setString(7, thisstate);
        ps.setString(8, thisproximity);
        ps.setString(9, thisrent);//
        ps.setInt(10, thisbedrooms);
        ps.setInt(11, thisbathrooms);
        ps.setString(12, thisgardenchoice);//
        ps.setInt(13, thisgardenarea);
        ps.setString(14, thisdescription);
        ps.setBlob(15, is);
        ps.setBlob(16, is2);
        ps.setBlob(17, is3);
        ps.execute();
        JOptionPane.showMessageDialog(null, "Your request has been saved. Waiting for an employee to accept it.", "Request saved.", JOptionPane.INFORMATION_MESSAGE);
        ps.close();
    }

    public void removeEstate(Estate estate) throws SQLException {
        int reponse = JOptionPane.showConfirmDialog(null,
                "Do you really want to delete this property ?",
                "Delete property",
                JOptionPane.YES_NO_CANCEL_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            int id = estate.getID();
            PreparedStatement ps = myConn.prepareStatement("DELETE FROM `estate` WHERE `identifier` like  ? ;");
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        }
    }

    private Estate convertRowToEstate(ResultSet rs) throws SQLException, IOException {

        Estate temp = new RealEstate(rs.getInt("identifier"), rs.getString("location"), rs.getString("adress"), rs.getInt("price"), rs.getInt("area"), rs.getString("description"), rs.getBlob("picture1"), rs.getBlob("picture2"), rs.getBlob("picture3"), 1);

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
