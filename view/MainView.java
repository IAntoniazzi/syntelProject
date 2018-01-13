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

    public static void main(String[] args) {
        MealOptionsView mealOptions = new MealOptionsView();
        ManageUserView userView = new ManageUserView();
        Menu showMenu = new Menu();
        LoginView login = new LoginView();
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Mummy's Restaurant");
        System.out.println("---------------------------------------------");

        System.out.println("Enter 1 to view Restaurant Menu");
        // System.out.println("Enter 2 to Login");
        System.out.println("Enter 3 to Register");
        System.out.println("Enter 4 to Exit");

        int response = input.nextInt();
        //after login in and user has been verified as admin, then show admin options:
        //enclose in an if block like
        //if(user == "Admin") {
        System.out.println("Enter 5 to enable user");
        System.out.println("Enter 6 to disable user");
        System.out.println("Enter 7 to delete user");
        System.out.println("Enter 8 to change user password");

        if (response == 5) {
            System.out.println("Enter User Email to enable");
            String userEmail = input.next();
            userView.enableUser(userEmail);
        }

        if (response == 6) {
            System.out.println("Enter User Email to enable");
            String userEmail = input.next();
            userView.disableUser(userEmail);
        }

        if (response == 7) {
            System.out.println("Enter User Email to delete");
            String userEmail = input.next();
            userView.deleteUser(userEmail);
        }

        if (response == 8) {
            System.out.println("Enter User Email to change password");
            String userEmail = input.next();
            System.out.println("Enter new password");
            String newPassword = input.next();
            userView.changeUserPassword(userEmail, newPassword);
        }
        //}

        if (response == 1) {
            mealOptions.showMenuView();
        }

        if (response == 2) {
            //go to login
            System.out.println("Enter email below:");
            String email = input.next();
            System.out.println("Enter password below:");
            String password = input.next();
            login.login(email, password);  //this doesn't go anywhere yet
        }

        if (response == 3) {
            //go to register 
        }

        if (response == 4) {
            System.exit(1);
        }

    }

}
