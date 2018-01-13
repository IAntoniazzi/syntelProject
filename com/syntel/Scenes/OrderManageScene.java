package com.syntel.Scenes;

import com.syntel.Models.Order;
import com.syntel.Models.Orders;
import controller.OrderController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author syntel
 */
public class OrderManageScene extends Scene
{
    private OrderController control;
    public OrderManageScene()
    {
        control = new OrderController();
    }

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
        displayOrders( control.getOrdersBy( columnName ) );
    }
    
    public void displayOrdersByArea()
    {
        System.out.println( "Showing orders sorted by zip code" );
        //TODO: connect to controller to get orders,make sure query has order by clause
        //TODO: will need a join to get the addresses from address_id
        System.out.println( "Not yet implemented" );
    }
    
    public static void main( String[] args )
    {
        OrderManageScene scene = new OrderManageScene();
        while ( true )
        {
            scene.process();
            if ( scene.requestTransition )
            {
                System.out.println( "DONE" );
                break;
            }
        }
    }

    public void displayOrders(ArrayList<Orders> orderList ) 
    {
        System.out.println( "Order_Id\tDelivery Date\tPayment_Type\tPrice\tOrder_Date" );
        for ( Orders order : orderList )
        {
            System.out.print( order.getOrderId()+ "\t" );
            System.out.print( order.getDeliveryDate() + "\t" );
            System.out.print( order.getPaymentMethod() + "\t" );
            System.out.print( order.getPrice() + "\t" );
            System.out.print( order.getOrderDate() + "\t" );
            System.out.println();
        }
    }
}
