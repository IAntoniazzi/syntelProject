/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;
import java.sql.*;
/**
 *
 * @author syntel
 */
public class DbConnection {

    public static void main(String[] args) {
        try{
            System.out.println("Connected to Database");
            String sql = "SELECT * FROM customers order by customer_id";
            ResultSet rs = getQueryResults(sql);
            System.out.println("Executed Query");
            int c1;
            while (rs.next()){
                c1 = rs.getInt(1);
                System.out.println(Integer.toString(c1)+" | "+rs.getString(2));
            }
        }catch(SQLException e){
            System.out.print(e);
        }
    }
    
    public static Connection connect(){
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch(ClassNotFoundException cnfe){
            System.out.print(cnfe);
        }
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url,"hr","hr");
            return conn;
        }catch(SQLException sqle){
            System.out.print(sqle);
        }
        return conn;
    }
    
        public static ResultSet getQueryResults(String query){
            ResultSet rs = null;
            Connection conn = connect();
            try{
                String sql = query;
                Statement stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                return rs;
            }catch(SQLException sqle){
                System.out.print(sqle);
            }
            return rs;
        }
        
        public static boolean updateTable(String query,Connection conn){
            try{
                String sql = query;
                Statement stmt = conn.createStatement();
                if (stmt.executeUpdate(sql) == 1){
                    return true;
                }
            }catch(SQLException sqle){
                System.out.print(sqle);
            }
            return false;
        }
    
}
