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
    private double price;
    private ArrayList<booking> pkgComponents;
    
    maiadaDB db;

    public packageOffer() {
        this.packageId = 0;
        this.price = 0.0;
        this.pkgComponents = new ArrayList<>();
    }

    public packageOffer(int packageId, String description, double price, ArrayList<booking> pkgComponents) {
        this.packageId = packageId;
        this.price = price;
        this.pkgComponents = pkgComponents;
    }
    
    
    public void addBooking(booking component){
        pkgComponents.add(component);
    }
    
    public void removeBooking(booking component){
        for(booking b: this.pkgComponents){
            if(component.equals(b)){
                this.pkgComponents.remove(b);
            }
        }
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setChildren(ArrayList<booking> pkgComponents) {
        this.pkgComponents = pkgComponents;
    }
    
    public ArrayList<booking> getChildren (){
        return null;
    }

    @Override
    public boolean book(client c) {
        // get current booking index/loc to proceed to payment
        int bookingIndex = c.getBooking_History().size();
       c.getBooking_History().add(this);
       
       // add it to the database
       if(db.addBooking(c, this)){
           // proceed to payment
           //c.pay(bookingIndex);
           return true;
       }
  
       return false;
    }

    @Override
    public String viewSummary(booking c) {
        return c.toString();
    }

    @Override
    public String toString() {
        return "packageId=" + packageId + ", pkgComponents=" + pkgComponents;
    }
    
    

    
    
    
    
    
    
}
