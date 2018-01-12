/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author syntel
 */
public class ManageUserView {
    
    public static void main(String [] args){
        ManageUser manage = new ManageUser();
        Scanner input = new Scanner(System.in);
        
       /* System.out.println("Enter 1 to see menu");
        int menuResponse =  input.nextInt();
         if(menuResponse == 1){
            //View.showMenu();
         }*/
        
        System.out.println("Enter 1 to enable user or 2 to disable user");       
        int disableResponse = input.nextInt();
        if(disableResponse == 1){
            System.out.println("Enter User Email to disable");
            String userEmail = input.next();
            manage.enableUser(userEmail);
        }
        if(disableResponse == 2){
            System.out.println("Enter User Email to disable");
            String userEmail = input.next();
            manage.disableUser(userEmail);
        }
        
         //System.out.println("Enter 3 to delete password");
        
        input.close();
    }
    

    
}
