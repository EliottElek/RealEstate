/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author eliot
 */
public class BookingDAO {

    private Connection myConn;

    public BookingDAO() throws Exception {
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

    public ArrayList<Booking> getAllBookings() throws Exception {
        ArrayList<Booking> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * from bookings");

            while (myRs.next()) {
                Booking temp = convertRowToBooking(myRs);
                list.add(temp);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    private Booking convertRowToBooking(ResultSet myRs) throws SQLException {

        int id = myRs.getInt("identifier");
        String lastname = myRs.getString("lastname");
        String adress = myRs.getString("adress");
        int buyerID = myRs.getInt("buyerID");
        int estateID = myRs.getInt("estateID");
        Date date = myRs.getDate("date");

        Booking temp = new Booking(date, buyerID, estateID, adress, lastname);

        return temp;
    }

    void addBooking(Estate estate, User buyer, Date date) throws SQLException {
        String dbop = "INSERT INTO `booking` (`identifier`,`estateID`, `userID`, `date`, `lastname`, `adress`) VALUES (NULL,?,?,?,?,?);";
        PreparedStatement stmt = myConn.prepareStatement(dbop);
        int buyerID = buyer.getID();
        int estateID = estate.getID();
        String adress = estate.getAdress();
        String lastname = buyer.getLastName();
        stmt.setInt(1,estateID);
        stmt.setInt(2,buyerID);
        stmt.setDate(3,date);
        stmt.setString(4,lastname);
        stmt.setString(5,adress);
        stmt.execute(dbop);
        stmt.close();
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
