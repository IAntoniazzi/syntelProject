/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MenuController;
import controller.UserController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author syntel
 */
public class Connector {

    Connection conn;
    MenuController meals;
    List<MenuController> mealsList = new ArrayList<>();
    UserController response = new UserController();

    public Connector() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void disableUserQuery(String cmd) {
        try (PreparedStatement pstmt = conn.prepareStatement("Update Online_user set status = 'Disabled' where email=?")) {
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                response.userSuccessfullyUpdated(0);
            }
        } catch (SQLException ex) {
            ex.getMessage();
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enableUserQuery(String cmd) {
        try (PreparedStatement pstmt = conn.prepareStatement("Update Online_user set status = 'Enabled' where email=?")) {
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                 response.userSuccessfullyUpdated(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List showMenuQuery() {
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("Select name, description, price, type, is_veg from food_item");
            while (rs.next()) {
                String name = rs.getString(1);
                String desc = rs.getString(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);
                String veg = rs.getString(5);
                meals = new MenuController(name, desc, price, type, veg);
                mealsList.add(meals);
            }

            //meals.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mealsList;
    }

    public void deleteUserQuery(String cmd) {
        try (PreparedStatement pstmt = conn.prepareStatement("Delete from Online_user where email=?")) {
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                 response.userSuccessfullyUpdated(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void changePasswordQuery(String cmd, String password) {
        try (PreparedStatement pstmt = conn.prepareStatement("Update Online_user set password = ? where email=?")) {
            pstmt.setString(1, password);
            pstmt.setString(2, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                 response.userSuccessfullyUpdated(3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String loginQuery(String cmd, String password) {
        String result = " ";
        String pw = "";
        String admin = "";
        String status = "";
        String fname = " ";
        try (PreparedStatement pstmt = conn.prepareStatement("Select password, is_admin, status, first_name from online_user where email=?")) {
            pstmt.setString(1, cmd);
            pstmt.executeQuery();
            ResultSet rs = pstmt.getResultSet();
            while (rs.next()) {
                pw = rs.getString(1);
                admin = rs.getString(2);
                status = rs.getString(3);
                fname = rs.getString(4);
            }
            if (pw.equals(password) && status.equals("Enabled")) {
                result = fname;
                if (admin.equals("Yes")) 
                    result = "admin";       
            }

        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public void registerNewUserQuery(String fname, String lname, String email, String passWrd,
            String strAddress, String city, String state, int zipCode) {
        try {
            PreparedStatement pstmt2 = conn.prepareStatement("Select first_name from online_user where email=? ");
            pstmt2.setString(1, email);
            ResultSet rs = pstmt2.executeQuery();
            if (rs.next()) {
                 response.userSuccessfullyUpdated(4);
                 return;
            }

            PreparedStatement pstmt = conn.prepareStatement("Insert into ADDRESS (street, city, zip_code, state) values (?,?,?,?)");
            pstmt.setString(1, strAddress);
            pstmt.setString(2, city);
            pstmt.setInt(3, zipCode);
            pstmt.setString(4, state);
            int count = pstmt.executeUpdate();

            if (count == 1) {
                String admin = "No";
                String status = "Enabled";
                PreparedStatement pstmt1 = conn.prepareStatement
                  ("Insert into ONLINE_USER (first_name, last_name, is_admin, password, email, address_id, status ) "
                          + "values (?,?,?,?,?,(Select address_id from address where street=? and zip_code=?),?)"); //password will be encrypted in web app
                pstmt1.setString(1, fname);
                pstmt1.setString(2, lname);
                pstmt1.setString(3, admin);
                pstmt1.setString(4, passWrd);
                pstmt1.setString(5, email);                
                pstmt1.setString(6, strAddress);
                pstmt1.setInt(7, zipCode);
                pstmt1.setString(8, status);
  
                count = pstmt1.executeUpdate();
                if (count == 1) 
                     response.userSuccessfullyUpdated(5);
                

            }
        } catch (SQLException ex) {
            ex.getMessage();
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
