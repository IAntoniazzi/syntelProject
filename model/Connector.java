/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.MenuController;
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
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

/**
 *
 * @author syntel
 */
public class Connector {

    //JdbcRowSet jRS;
    Connection conn;
    MenuController meals;
    List<MenuController> mealsList = new ArrayList<>();

    public Connector() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn
                    = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void disableUserQuery(String cmd) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("Update Online_user set status = 'Disabled' where email=?");
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println("User" + cmd + ": status changed to disabled!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enableUserQuery(String cmd) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("Update Online_user set status = 'Enabled' where email=?");
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println("User" + cmd + ": status changed to enabled!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List showMenuQuery() {
        try {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            Statement st = conn.createStatement();
            ResultSet rs =   st.executeQuery("Select name, description, price, type, is_veg from food_item");
           while(rs.next()){
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
    
    public void deleteUserQuery(String cmd){
                try {
            PreparedStatement pstmt = conn.prepareStatement("Delete from Online_user where email=?");
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println("User " + cmd + " has been deleted!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
