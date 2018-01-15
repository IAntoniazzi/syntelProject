/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import src.com.syntel.Models.AreaModel;

/**
 *
 * @author syntel
 */
public class AreaManagementController {
    private String name,zip;
    AreaModel am;
    
    public AreaManagementController(){
        
    }
    
    public AreaManagementController(String n,String z){
        this.name = n;
        this.zip = z;
    }
    
    public void editName(String n){
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void editZip(String z){
        this.zip = z;
    }
    
    public String getZip(){
        return this.zip;
    }
    
    public boolean addArea(String zip){
        return am.addArea(zip);
    }
    public boolean removeArea(String zip){
        return am.removeArea(zip);
    }
}
