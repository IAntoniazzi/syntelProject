/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.Scenes;

import com.syntel.DatabaseAction;
import static com.syntel.Scenes.Scene.matchInputWithChoice;
import com.syntel.models.Address;
import java.util.ArrayList;
import java.util.List;
import model.menuInfo;

/**
 *
 * @author syntel
 */
public class MenuChangeScene extends Scene {

    @Override
    public Scene transitionNext() {
        return new HomeScene();
    }

    @Override
    public void process() {
        // Create choices
        List<String> choices = new ArrayList<>();
        choices.add( "Display Menu Items" );
        choices.add( "Add Item" );
        choices.add( "Remove Item" );
        choices.add( "Change Menu Item" );
        choices.add( "Back" );
        
        do {
            // Display all choices
            for (int i = 0; i < choices.size(); i++)
                System.out.println("(" + i + ")" + " " + choices.get(i));

            // Match user input with choice
            selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

        } while (selectedChoice == null);
        
        switch ( selectedChoice )
        {
            case "Display Menu Items":
                displayMenuItems();
                break;
            case "Add Item":
                promptAddItem();
                break;
            case "Remove Item":
                promptRemoveItem();
                break;
            case "Change Menu Item":
                promptChangeMenuItem();
                break;
            case "Back":
                requestTransition = true;
                break;
            default:
                //TODO: throw exception because choice is invalid
                System.out.println( "Invalid choice: " + selectedChoice );
                break;
        }
    }

    public void displayMenuItems()
    {
        List<MenuController> menu;
        menu = MenuInfo.getMenuOptions();
        for ( int i = 0; i < menu.size(); i++ )
        {
            System.out.println( menu.get( i ).getName() );
        }  
    }
    
    public void promptRemoveItem()
    {
        System.out.print( "Enter the name of the food item you wish to remove: " );
        String item = scanner.nextLine();
        Connector.removeMenuItem(item);
    }
    
    public void promptAddMenuItem()
    {
        System.out.print( "Enter name of new item: " );
        String name = scanner.nextLine();
	System.out.print( "Enter a description for " + name + ": ");
        String desc = scanner.nextLine();
        System.out.print( "Enter the price for " + name + ": ");
        double price = scanner.nextLine();
	Sstem.out.print( "Enter the type for " + name + ": ");
        String type = scanner.nextLine();
	System.out.print( "Is " + name + "a vegetarian option? Enter Yes or No.");
        String veg = scanner.nextLine();
	Connector.addMenuItem(name, desc, price, type, veg);
	//needs functionality for adding an image and editing the availability
    }
    
    public void promptChangeMenuItem()
    {
        System.out.print( "Enter the name of the item you wish to change: " );
        String name = scanner.nextLine();
	MenuController item = Connector.getItem(name);
	int selection = 0;
	while(selection ==0){
		System.out.println("What aspect of this item would you like to change?");
		System.out.println("Enter 1 to change the name");
		System.out.println("Enter 2 to change the description");
		System.out.println("Enter 3 to change the price");
		System.out.println("Enter 4 to change the type");
		System.out.println("Enter 5 to change the vegetarian notation");
		int selection = scanner.nextLine();
		if(selection >5 || selection <1){
			System.out.println("That is not a valid entry.  Please try again");
			selection = 0;
		}
	} 
	switch ( selection )
        {
            case 1:
		System.out.println("Enter the new name: ");
		string nName = scanner.nextline();
                Connector.updateMenuItem(name, "name", nName);
                break;
            case 2:
                System.out.println("Enter the new description: ");
		string nDesc = scanner.nextline();
                Connector.updateMenuItem(name, "description", nDesc);
                break;
            case 3:
                System.out.println("Enter the new price: ");
		string nPrice = scanner.nextline();
                Connector.updateMenuItem(name, "price", nPrice);
                break;
            case 4:
                System.out.println("Enter the new type: ");
		string nType = scanner.nextline();
                Connector.updateMenuItem(name, "type", nType);
                break;
            case 5:
                System.out.println("Enter Yes if the item is vegetarian, No if it is not: ");
		string nVeg = scanner.nextline();
                Connector.updateMenuItem(name, "is_veg", nVeg);
                break;
            
        }
    }

}
