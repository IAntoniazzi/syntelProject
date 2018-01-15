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

/**
 *
 * @author syntel
 */
public class Connector {
    
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

    public void changePasswordQuery(String cmd, String password) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("Update Online_user set password = ? where email=?");
            pstmt.setString(1, password);
            pstmt.setString(2, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println("User " + cmd + " password has been updated!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   public void deleteMenuItem(String cmd) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("Delete from Food_item where name=?");
            pstmt.setString(1, cmd);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println(cmd + " has been deleted!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addMenuItem(String name, String desc, double price, String type, String Veg){
	try{
		PreparedStatement pstmt = conn.prepareStatement("Insert into food_item (name, description, price, type, is_veg) values (?,?,?,?,?);
		pstmt.setString(1, name);
		pstmt.setString(2, desc);
		pstmt.setNumber(3, price);
		pstmt.setString(4, type);
		pstmt.setString(5, veg);
		int count == 1){
			System.out.println(name + "has been added to the menu.");
	}catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MenuController getItem(String qname) {
        try {
	    Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select description, price, type, is_veg from food_item where name = qname");
            while (rs.next()) {
                String desc = rs.getString(1);
                double price = rs.getDouble(2);
                String type = rs.getString(3);
                String veg = rs.getString(4);
                return new MenuController(qname, desc, price, type, veg);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mealsList;
    }
	 

}

    public void changeMenuItem(String qname, String column, String newValue){
	try{
	    PreparedStatement pstmt = conn.prepareStatement("Update Food_item set " + column +" = ? where name=?");
            if(column == "price"){
		pstmt.setDouble(1, Double.parseDouble(newValue));
		}
	    else{
		pstmt.setString(1, newValue);
		}
            pstmt.setString(2, qname);
            int count = pstmt.executeUpdate();
            if (count == 1) {
                System.out.println("This item has been updated!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }