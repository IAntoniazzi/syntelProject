/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.syntel.Models.Orders;
import java.util.ArrayList;
import model.Connector;

/**
 *
 * @author syntel
 */
public class OrderController {
    public ArrayList<Orders> getOrdersBy( String columnName )
    {
        return new Connector().selectOrdersSortColumn( columnName );
    }
}
