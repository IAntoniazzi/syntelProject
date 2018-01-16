/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.syntel.Models.OnlineUser;
import com.syntel.Models.Address;
import com.syntel.Models.Orders;
import controller.MenuController;
import java.nio.ByteBuffer;
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
    
    /*
        Returns the OnlineUser that corresponds to the id given.
    */
    public OnlineUser getUserById( byte[] userId )
    {
        try
        {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            PreparedStatement st = conn.prepareStatement( "SELECT * FROM online_user WHERE user_id=?" );
            //select the orders and order them by the column given
            st.setBytes(1, userId );
            //st.setShort( 1, addressId );
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                //OnlineUser(byte[] id, String fname, String lname, String isAdmin, String pword, String email, int addressId, String status){
                OnlineUser toReturn = new OnlineUser(
                        rs.getBytes( "user_id" ),
                        rs.getString( "first_name" ),
                        rs.getString( "last_name" ),
                        rs.getString( "is_admin" ),
                        rs.getString( "password" ),
                        rs.getString( "email" ),
                        rs.getBytes( "address_id" ),
                        rs.getString( "status" )
                );
                
                toReturn.setAddress( getAddressById( toReturn.getAddressId() ) );
                return toReturn;
            } 
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /*
        Returns the address that corresponds to the id given.
    */
    public Address getAddressById( byte[] addressId )
    {
        try
        {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            PreparedStatement st = conn.prepareStatement( "SELECT * FROM address WHERE address_id=?" );
            //select the orders and order them by the column given
            st.setBytes(1, addressId );
            ResultSet rs = st.executeQuery();
            if (rs.next())
            {
                Address toReturn = new Address();
                toReturn.setAddressId( addressId );
                toReturn.setCity( rs.getString( "city" ) );
                toReturn.setStreet1( rs.getString( "street" ) );
                toReturn.setZip( rs.getInt( "zip_code" ) + "" );
                toReturn.setState( rs.getString( "state" ) );
                return toReturn;
            } 
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<Orders> convertOrdersResultSet( ResultSet rs ) throws SQLException
    {
        ArrayList<Orders> ordersList = new ArrayList<>();
        while ( rs.next() )
        {
            //create an order object from database values object
             //public Orders(int orderId, int userId, int addressId, String payment, String oDate, float price, String dDate, String dTime)
             Orders order = new Orders(
                     //convert the order_id from bytes to an integer
                     rs.getBytes( "order_id" ),
                     rs.getBytes( "user_id" ),
                     rs.getBytes( "address_id" ),
                     rs.getString( "payment_type" ),
                     rs.getString( "order_date" ),
                     rs.getFloat( "price" ),
                     rs.getString( "delivery_date" ),
                     rs.getString( "delivery_time" )
             );
             order.setOrderAddress( getAddressById( order.getAddressId() ) );
             order.setUser( getUserById( order.getUserId() ) );
             //then add it to the orderlist
             ordersList.add( order );
        }
        
        return ordersList;
    }
    
    /*
        Returns list of all orders from database,they are ordered by the customer's columnName given
    */
    public ArrayList<Orders> selectOrdersSortCustomerColumn( String columnName )
    {
        try 
        {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            Statement st = conn.createStatement();
            //select the orders and order them by the column given
            ResultSet rs = st.executeQuery("SELECT orders.order_id,orders.user_id,orders.address_id,orders.payment_type,orders.order_date,orders.price,orders.delivery_date,orders.delivery_time FROM orders,online_user WHERE orders.user_id=online_user.user_id(+) ORDER BY online_user." + columnName );
            return convertOrdersResultSet( rs );
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
    
    /*
        Returns a list of all orders where they are ordered by the zip code
    */
    public ArrayList<Orders> selectOrdersSortAddressZip()
    {
        try 
        {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            Statement st = conn.createStatement();
            //select the orders and order them by the column given
            ResultSet rs = st.executeQuery("SELECT orders.order_id,orders.user_id,orders.address_id,orders.payment_type,orders.order_date,orders.price,orders.delivery_date,orders.delivery_time FROM orders,address WHERE orders.address_id=address.address_id(+) ORDER BY address.zip_code"  );
            return convertOrdersResultSet( rs );
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
       
    /*
        Returns list of all orders,ordered by the column name given
    */
    public ArrayList<Orders> selectOrdersSortColumn( String columnName )
    {
        try 
        {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            Statement st = conn.createStatement();
            //select the orders and order them by the column given
            ResultSet rs = st.executeQuery("SELECT * FROM orders ORDER BY " + columnName );
            return convertOrdersResultSet( rs );
                  
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        
        return new ArrayList<>();
    }
    
    public ArrayList<FoodItem> selectAllFoodItems()
    {
        ArrayList<FoodItem> items = new ArrayList<>();
        try
        {
            //PreparedStatement pstmt = conn.prepareStatement("Select Food_item, description, price from food_item");
            PreparedStatement st = conn.prepareStatement( "SELECT * FROM food_item" );
            //select the orders and order them by the column given
            ResultSet rs = st.executeQuery();
            while (rs.next())
            {
                //byte[] id, String name, String description, float price, String type, boolean veg, String image, int availability){
                FoodItem foodItem = new FoodItem( 
                        rs.getBytes( "food_item_id" ),
                        rs.getString( "name" ),
                        rs.getString( "description" ),
                        rs.getFloat( "price" ),
                        rs.getString( "type" ),
                        rs.getString( "is_veg" ).equalsIgnoreCase( "yes" ),
                        "",
                        -1
                );
                items.add( foodItem );
            } 
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return items;   
    }


}
