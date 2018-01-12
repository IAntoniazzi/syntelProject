/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.MenuInfo;

/**
 *
 * @author syntel
 */
public class MenuController {
    MenuInfo info;
    //private String foodItemId;
    private String Name;
    private String desc;
    private double price;
    private String type;
    private String veg;
    
    public MenuController(){
        
    }

    public MenuController(String Name, String desc, double price, String type, String veg) {
        this.Name = Name;
        this.desc = desc;
        this.price = price;
        this.type = type;
        this.veg = veg;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVeg() {
        return veg;
    }

    public void setVeg(String veg) {
        this.veg = veg;
    }
    
     public void showMenu() {
        info = new MenuInfo();
        List<MenuController> disp = info.getMenuOptions();
        displayOptions(disp);
    }
     
     private void displayOptions(List items){
         for(Object mealItem : items){
             System.out.println(mealItem.toString());
         }
     }

    @Override
    public String toString() {
        return "MenuController{" + "Name=" + Name + ", desc=" + desc + ", price=" + price + ", type=" + type + ", veg=" + veg + '}';
    }
     
     
}
