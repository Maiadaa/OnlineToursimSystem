/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import org.bson.Document;
import rmi.booking;
import rmi.client;
import static rminewserver.maiadaDB.gson;

/**
 *
 * @author LENOVO
 */
public class packageOffer extends UnicastRemoteObject implements booking{
    private int packageId;
    private double price;
    private ArrayList<booking> pkgComponents;
    
    maiadaDB db;

    public packageOffer() throws RemoteException
    {
        this.packageId = 0;
        this.price = 0.0;
        this.pkgComponents = new ArrayList<>();
    }

    public packageOffer(int packageId, String description, double price, ArrayList<booking> pkgComponents) throws RemoteException {
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
    public boolean book(String uname, String agency, String identifier) {
        
//        String[] agencies = agency.split(" ");
//        String ticketAgency = agencies[0];
//        String roomAgency = agencies[1];
//        String carAgency = agencies[2];
//        
//        String[] identifiers = agency.split(" ");
//        String ticketId = identifiers[0];
//        String roomNum = identifiers[1];
//        String plateNum = identifiers[2];
//        
//        Document carDoc = db.ticketCollection.find(Filters.eq("_id", ticketAgency)).first(); 
//        carDoc = db.carAgencyCollection.find(Filters.eq("plateNum", identifier)).first();
//        car chosenCar =  db.gson.fromJson(carDoc.toJson(), car.class);
//        
//        Document carDoc = db.carAgencyCollection.find(Filters.eq("AgencyName", agency)).first(); 
//        carDoc = db.carAgencyCollection.find(Filters.eq("plateNum", identifier)).first();
//        car chosenCar =  db.gson.fromJson(carDoc.toJson(), car.class);
//        
//        Document carDoc = db.carAgencyCollection.find(Filters.eq("AgencyName", carAgency)).first(); 
//        carDoc = db.carAgencyCollection.find(Filters.eq("plateNum", plateNum)).first();
//        car chosenCar =  db.gson.fromJson(carDoc.toJson(), car.class);
//        
//        
//        
//        
//        
//        // get current booking index/loc to proceed to payment
//        int bookingIndex = c.getBooking_History().size();
//       c.getBooking_History().add(this);
//       
//       // add it to the database
//       if(db.addBooking(c, this)){
//           // proceed to payment
//           //c.pay(bookingIndex);
//           return true;
//       }
  
       return false;
    }
    
    public String viewSummary(packageOffer c) {
        return c.toString();
    }

    @Override
    public String toString() {
        return "packageId=" + packageId + ", pkgComponents=" + pkgComponents;
    }
    
    

    
    
    
    
    
    
}
