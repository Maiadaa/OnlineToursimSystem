/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class packageOffer implements booking{
    private int packageId;
    private String description;
    private double price;
    private ArrayList<booking> pkgComponents;

    public packageOffer() {
    }

    public packageOffer(int packageId, String description, double price, ArrayList<booking> pkgComponents) {
        this.packageId = packageId;
        this.description = description;
        this.price = price;
        this.pkgComponents = pkgComponents;
    }
    
    
    public void addBooking(booking component){
        
    }
    
    public void removeBooking(booking component){
        
    }
    
    public ArrayList<booking> getChildren (){
        return null;
    }

    @Override
    public void book() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewSummary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
    
    
    
    
    
}
