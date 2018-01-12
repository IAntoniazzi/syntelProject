package model;

import java.sql.*;
public class OraDemoType4 {
public static void main(String args[]){
        try {
            //Step1 - Register Driver
            //    Driver dr  = new Driver();        //jdbc.driver.oracle.OracleDriver
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Type 4 Driver Pure Java Driver
             //System.out.println("Driver Registered");
             //Step2 - Create Connection
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
              //System.out.println("Connected to Sample DB");
              //Step3 - Create Statement
              Statement st = con.createStatement();
              //Step 4 - Generate Resultset
              ResultSet rs =   st.executeQuery("select * from online_users");
                
              System.out.println("User Id \t First Name");
        System.out.println("_____________________________________________________");
              while(rs.next())
                   System.out.println(rs.getString(1)+ "    "+ rs.getString(2));
        System.out.println("_____________________________________________________");
          st.close();
            con.close();
        } catch (Exception ex) {
             System.out.println(ex);
        }
  }
}