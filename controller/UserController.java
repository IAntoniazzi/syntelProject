/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.UserInfo;

/**
 *
 * @author syntel
 */
public class UserController {
    private String email;
    UserInfo info;

    public String getEmail() {
        return email;
    }

    public void updateModelDisableUser(String email) {
        info = new UserInfo();
        info.adminDisableUser(email);
    }
    
    public void login(String email, String password){
        info.login(email, password);
        info.isAdminOrCustomer(email, password);
        
        if(info.isAdminOrCustomer(email, password).equals("Admin")){
            
        }
        
    }
    
}
