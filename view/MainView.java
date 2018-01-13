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
public class MainView {
    public static void main(String[] args){
        MealOptionsView mealOptions = new  MealOptionsView();
        Menu showMenu = new Menu();
        LoginView login = new LoginView();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Mummy's Restaurant");
        System.out.println("---------------------------------------------");
        
        System.out.println("Enter 1 to view Restaurant Menu");
        System.out.println("Enter 2 to Login");
        System.out.println("Enter 3 to Register");
        System.out.println("Enter 4 to Exit");
         
        int response = input.nextInt();
        if(response == 1){
            mealOptions.showMenuView();
        }
        
        if(response == 2){
            //go to login
            System.out.println("Enter email below:");
            String email = input.next();
             System.out.println("Enter password below:");
            String password = input.next();
            login.login(email, password);
        }
        
        if(response == 3){
            //go to register 
        }
        
         if(response == 4){
            System.exit(1); 
        }
        
        
    }
    
}
