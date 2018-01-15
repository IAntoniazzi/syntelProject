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
    
    public boolean addZipToServiceArea(String zip){
        try{
            PreparedStatement pstmt = conn.prepareStatement("insert into service_areas (zip_code) values (?)");
            pstmt.setString(1,zip);
            int count = pstmt.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch(SQLException ex){
            return false;
        }
        return false;
    }
    
    public boolean removeZipFromServiceArea(String zip){
        try{
            PreparedStatement pstmt = conn.prepareStatement("Delete from service_areas where zip_code = ?");
            pstmt.setInt(1,Integer.parseInt(zip));
            int count = pstmt.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch(SQLException ex){
            return false;
        }
        return false;
    }

    public List getAreas(){
        List<String> allAreas = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT zip_code from service_areas");
            while(rs.next()){
                allAreas.add(rs.getString(1));
            }
        }catch(SQLException ex){
            System.out.println("Unable to fetch areas from database.");
        }
        return allAreas;
    }
    
    public List getFoodItemsInArea(String zip){
        List<String> foodInArea = new ArrayList();
        try{
            PreparedStatement pstmt = conn.prepareStatement("select name || ' - ' || description as Food_Item from food_item fi join availability a on fi.availability_id = a.availability_id join service_areas se on a.zip_code = se.zip_code where se.zip_code = ?");
            pstmt.setInt(1, Integer.parseInt(zip));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                foodInArea.add(rs.getString(1));
            }
        }catch(SQLException ex){
            System.out.println("Unable to get food in "+zip);
        }
        return foodInArea;
    }
}
