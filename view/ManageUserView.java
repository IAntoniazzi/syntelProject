/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserController;
import java.util.Scanner;

/**
 *
 * @author syntel
 */
public class ManageUserView {
    
    public static void main(String [] args){
        UserController userController = new UserController();
        Scanner input = new Scanner(System.in);
        
       /* System.out.println("Enter 1 to see menu");
        int menuResponse =  input.nextInt();
         if(menuResponse == 1){
            //View.showMenu();
         }*/
        
        System.out.println("Enter 1 to enable user");
        System.out.println("Enter 2 to disable user");
        System.out.println("Enter 3 to delete user");
        
        int response = input.nextInt();
        if(response == 1){
            System.out.println("Enter User Email to enable");
            String userEmail = input.next();
            userController.updateModelEnableUser(userEmail);
        }
        
        if(response == 2){
            System.out.println("Enter User Email to disable");
            String userEmail = input.next();
            userController.updateModelDisableUser(userEmail);
        }
        
          if(response == 3){
            System.out.println("Enter User Email to delete");
            String userEmail = input.next();
            userController.updateModelDeleteUser(userEmail);
        }
        
         //System.out.println("Enter 3 to delete password");
        
        input.close();
    }
    

    
}
