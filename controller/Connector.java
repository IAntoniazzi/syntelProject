/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel;

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
    
    
    
    public void createFoodQuery(FoodItem item) {    	
    
    	
    	try {
	    	//Insert into availability table first
    		//Need to add to availability so it has begin_time and end_time instead of just a time field
    		//Still need to figure out how to convert String date and time to timestamp and date types 
	    	PreparedStatement pstmt = conn.prepareStatement("Insert into Availability (zip_code,begin_time,end-time,begin_date,end_date) values (?,?,?,?,?)");
	    	pstmt.setString(1, Integer.toString(item.getZip()));
	    	pstmt.setString(2, item.getBeginTime());
	    	pstmt.setString(3, item.getEndTime());
	    	pstmt.setString(4, item.getStartDate());
	    	pstmt.setString(5, item.getEndDate());	    	
	    	pstmt.executeUpdate();
	    	
	    	//Insert into FoodItem table
	    	//Doesnt insert image yet	    
	    	
	    	pstmt = conn.prepareStatement("Insert into Food_item (name,description,price,type,is_veg,availability_id) values(?,?,?,?,?,?)");
	    	pstmt.setString(1, item.getName());
	    	pstmt.setString(2,item.getDescription());
	    	pstmt.setString(3, Float.toString(item.getPrice()));
	    	pstmt.setString(4, item.getType());
	    	pstmt.setString(5, item.getVeg());
	    	pstmt.setString(6, "Select Availability_id from Availability where zip_code="+item.getZip());
	    	pstmt.executeUpdate();
	    	
	    	
    	}catch(SQLException ex) {
    		Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
    	}    	
    	
    	
    	System.out.println("creating item: "+item);
    			
    	
    }
    
    public void getFoodQuery(FoodItem item) {       	
    	
    	try{
    		//retrieve info from food table first 
    		PreparedStatement pstmt = conn.prepareStatement("Select description, price, type, is_veg,availability_id from food_item where name=?");
    		pstmt.setString(1, item.getName());
            ResultSet rs = pstmt.executeQuery();
            
            item.setDescription(rs.getString(1));
            item.setPrice(rs.getDouble(2));
            item.setType(rs.getString(3));
            item.setVeg(rs.getString(4));
            
            //retrieve corresponding availability info using availability id next
            
            pstmt = conn.prepareStatement("Select zip_code,begin_time,end_time,begin_date,end_date from Availability where availability_id=?");
    		pstmt.setString(1, rs.getString(5));
            rs = pstmt.executeQuery();
            item.setZip(rs.getInt(1));
            item.setBeginTime(rs.getString(2));
            item.setEndTime(rs.getString(3));
            item.setStartDate(rs.getString(4));
            item.setEndDate(rs.getString(5));                   
                           
               		
    	}catch(SQLException ex) {
    		Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	
    	
    	
    }
    
   
    
    
    public void removeFoodQuery(String name) {   	
    	
    	
    	try {
	    	PreparedStatement pstmt = conn.prepareStatement("Delete from Food_item where name=?");
	    	pstmt.setString(1, name);
	    	pstmt.executeQuery();
	    	
    	}catch(SQLException ex) {
    		Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
    	}
    	
    
    	System.out.println("Removing: "+name);
    	
    	
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

}
