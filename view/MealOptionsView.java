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
public class MealOptionsView {
     public static void main(String [] args){
        Menu showMenu = new Menu();
        Scanner input = new Scanner(System.in);
        
       /* System.out.println("Enter 1 to see menu");
        int menuResponse =  input.nextInt();
         if(menuResponse == 1){
            //View.showMenu();
         }*/
        
        System.out.println("Enter 1 to see menu");
        int menuResponse =  input.nextInt();
        if(menuResponse == 1){   
           showMenu.displayMenu();
        }
     }
}
