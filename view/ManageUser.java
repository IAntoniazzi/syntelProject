/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserController;

/**
 *
 * @author syntel
 */
public class ManageUser {
    private String email;

    
    public void disableUser(String email){
       UserController manageModel = new UserController();
       manageModel.updateModelDisableUser(email);   
    }
    
   public void enableUser(String email){
       UserController manageModel = new UserController();
       manageModel.updateModelDisableUser(email);   
    }
   
   public void changeUserPassword(String email){
       
   }
    
}
