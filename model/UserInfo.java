/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;

/**
 *
 * @author syntel
 */
public class UserInfo {
     Connector disableUser;
     
    //admin disable user
    public void adminDisableUser(String userEmail){
       disableUser = new Connector();
        disableUser.disableQuery(userEmail);
    }
    
    public void adminEnableUser(String userEmail){
       disableUser = new Connector();
        disableUser.enableQuery(userEmail);
    }
    
    
    public boolean login(String email, String password){
        
        //
        return true;
    }

    public String isAdminOrCustomer(String email, String password){
        //if user is admin
        return "Admin";
    }
    
}
