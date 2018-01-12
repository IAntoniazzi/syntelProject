package com.syntel.Scenes;

import static com.syntel.Scenes.Scene.matchInputWithChoice;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author syntel
 */
public class OrderManageScene extends Scene
{

    @Override
    public Scene transitionNext() {
        return new HomeScene();
    }

    @Override
    public void process() {
        // Create choices
        System.out.println( "View orders by?" );
        List<String> choices = new ArrayList<>();
        choices.add( "Mode of payment" );
        choices.add( "Date" );
        choices.add( "Area" );
        choices.add( "Price" );
        choices.add( "OrderID" );
        choices.add( "Back" );
        
        do {
            // Display all choices
            for (int i = 0; i < choices.size(); i++)
                System.out.println("(" + i + ")" + " " + choices.get(i));

            // Match user input with choice
            selectedChoice = matchInputWithChoice(scanner.nextLine(), choices);

        } while (selectedChoice == null);
        
        //TODO: customer name,customer email
        switch ( selectedChoice )
        {
            case "Mode of payment":
                displayOrdersByColumn( "payment_type" , "payment type" );
                break;
            case "Date":
                displayOrdersByColumn( "delivery_date" , "delivery date" );
                break;
            case "Price":
                displayOrdersByColumn( "price" , "price" );
                break;
            case "Area":
                displayOrdersByArea();
                break;
            case "OrderID":
                displayOrdersByColumn( "order_id" , "order id" );
                break;
            case "Back":
                requestTransition = true;
                break;
            default:
                //TODO: throw exception since choice is invalid
                System.out.println( "Unknown choice: " + selectedChoice );
                break;
        }
    }
    
    public void displayOrdersByColumn( String columnName, String description )
    {
        System.out.println( "Showing orders sorted by " + description );
        //TODO: connect to controller to get orders,make sure query has order by clause
        System.out.println( columnName );
        System.out.println( "Not yet implemented" );
    }
    
    public void displayOrdersByArea()
    {
        System.out.println( "Showing orders sorted by zip code" );
        //TODO: connect to controller to get orders,make sure query has order by clause
        //TODO: will need a join to get the addresses from address_id
        System.out.println( "Not yet implemented" );
    }
}
