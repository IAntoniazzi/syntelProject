/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.ArrayList;

/**
 *
 * @author syntel
 */
public class Combo {
    private static int ComboId;
    private static String Name;
    private static String Description;
    private static float Price;
    private static String Image;
    private static ArrayList<FoodItem> Items;

    public static int getComboId() {
        return ComboId;
    }

    public static void setComboId(int ComboId) {
        Combo.ComboId = ComboId;
    }

    public static String getName() {
        return Name;
    }

    public static void setName(String Name) {
        Combo.Name = Name;
    }

    public static String getDescription() {
        return Description;
    }

    public static void setDescription(String Description) {
        Combo.Description = Description;
    }

    public static float getPrice() {
        return Price;
    }

    public static void setPrice(float Price) {
        Combo.Price = Price;
    }

    public static String getImage() {
        return Image;
    }

    public static void setImage(String Image) {
        Combo.Image = Image;
    }

    public static ArrayList<FoodItem> getItems() {
        return Items;
    }

    public static void setItems(ArrayList<FoodItem> Items) {
        Combo.Items = Items;
    }
 
    public static void addItem(int ItemId){
        Combo.setItems(Combo.getItems().add(getFoodItem(ItemId))) //requires a global method getFoodItem() to get a food item object from an id#
                
    }
    
    public static void removeItem(int ItemId){
        Combo.setItems(Combo.getItems().remove(getFoodItem(ItemId))); ////requires a global method getFoodItem() to get a food item object from an id#
    }
}
