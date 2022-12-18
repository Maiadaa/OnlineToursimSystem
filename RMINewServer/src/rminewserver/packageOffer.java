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
    public boolean book(String uname, String agency, String identifier) throws RemoteException{
        
        String[] agencies = agency.split(" ");
        String ticketAgency = agencies[0];
        String roomAgency = agencies[1];
        String carAgency = agencies[2];
        
        String[] identifiers = agency.split(" ");
        String ticketId = identifiers[0];
        String roomNum = identifiers[1];
        String plateNum = identifiers[2];
        
        Document clientDoc = db.clientCollection.find(Filters.eq("email", uname)).first();
        client c = db.gson.fromJson(clientDoc.toJson(), client.class);
        System.out.println(c.toString());


        Document carDoc = db.carAgencyCollection.find(Filters.eq("AgencyName", carAgency)).first();
        carAgency car = db.gson.fromJson(carDoc.toJson(), carAgency.class);
        System.out.println(car);
        car chosenCar = new car();
        for(car carr : car.getCars()){
            if(carr.getPlateNum() == identifier){
                chosenCar = carr;
            }   
        }
        
        Document airlineDoc = db.AirlinesCollection.find(Filters.eq("AgencyName", ticketAgency)).first();
        airline air = db.gson.fromJson(airlineDoc.toJson(), airline.class);
        System.out.println(air);
        ticket t = new ticket();
        for(flight fl : air.getFlights()){
            for(ticket ti : fl.getTickets()){
                if(ti.getSeatNumber()== Integer.parseInt(identifier)){
                    t = ti;
                }
            }
        }
        
        Document hotelDoc = db.HotelsCollection.find(Filters.eq("HotelName", roomAgency)).first();
        hotel h = db.gson.fromJson(hotelDoc.toJson(), hotel.class);
        System.out.println(h.toString());
        room r = new room();
        for(room room: h.getRooms()){
            if(room.getRoomNumber() == Integer.parseInt(identifier)){
                r = room;
            }
        }
        
        packageOffer p = new packageOffer();
        p.addBooking(chosenCar);
        p.addBooking(t);
        p.addBooking(r);

        // add it to the database
        if (db.addBooking(c,p)) {
            c.getBooking_History().add(p);
            return true;
        }
  
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
