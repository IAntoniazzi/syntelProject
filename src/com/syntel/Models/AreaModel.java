/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntel.Models;

/**
 *
 * @author syntel
 */
public class AreaModel {
    Connector conn;
    public boolean addArea(String zip){
        conn = new Connector();
        return conn.addZipToServiceArea(zip);
    }
    
    public boolean removeArea(String zip){
        conn = new Connector();
        return conn.removeZipFromServiceArea(zip);
    }
}
