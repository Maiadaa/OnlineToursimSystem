/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.mongodb.client.model.Filters;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;
import java.rmi.RemoteException;
import rmi.booking;
import rmi.client;

public class car extends UnicastRemoteObject implements booking
{
    private int CarID;
    private String Model;
    private double RentalPrice;
    private String Manufacturer;
    private String CarType;
    private int Seats;
    private String plateNum;
    
    private DB db;

    public car()throws RemoteException {
        this.CarID = 0;
        this.Model = "";
        this.RentalPrice = 0.0;
        this.Manufacturer = "";
        this.CarType = "";
        this.Seats = 0;
        this.plateNum = "";
        this.db = new DB();
    }
    
    public car(int CarID, String Model, double RentalPrice, String Manufacturer, String CarType, int Seats, String plateNum) throws RemoteException{
        this.CarID = CarID;
        this.Model = Model;
        this.RentalPrice = RentalPrice;
        this.Manufacturer = Manufacturer;
        this.CarType = CarType;
        this.Seats = Seats;
        this.plateNum = plateNum;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setRentalPrice(double RentalPrice) {
        this.RentalPrice = RentalPrice;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public void setCarType(String CarType) {
        this.CarType = CarType;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public int getCarID() {
        return CarID;
    }

    public String getModel() {
        return Model;
    }

    public double getRentalPrice() {
        return RentalPrice;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public String getCarType() {
        return CarType;
    }

    public int getSeats() {
        return Seats;
    }

    public String getPlateNum() {
        return plateNum;
    }

//    @Override
//    public boolean book(client c) throws RemoteException {
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
//  
//       return false;
//    }

    public String viewSummary(car c) {
        return c.toString();
    }

    @Override
    public String toString() {
        return "car{" + "Model=" + Model + ", RentalPrice=" + RentalPrice + ", Manufacturer=" + Manufacturer + ", CarType=" + CarType + ", Seats=" + Seats + ", plateNum=" + plateNum + '}';
    }
    
    public String specialToString(){
        return plateNum + " " + CarType + " " + Manufacturer + " " + Model + " " + Seats ;
    }
    
        
    @Override
    public boolean book(String uname, String agency, String identifier) throws RemoteException {
        System.out.println(uname);
        Document clientDoc = db.clientCollection.find(Filters.eq("email", uname)).first();
        client c = db.gson.fromJson(clientDoc.toJson(), client.class);
        System.out.println(c.toString());

        Document carDoc = db.carAgencyCollection.find(Filters.eq("AgencyName", agency)).first();
        carAgency car = db.gson.fromJson(carDoc.toJson(), carAgency.class);
        
        car chosenCar = new car();
        for(car carr : car.getCars()){
            
            if(carr.getPlateNum().equals(identifier)){
                chosenCar = carr;
            }   
        }
        
        // add it to the database
        if (db.addBooking(c, chosenCar)) {
            c.getBooking_History().add(chosenCar);
            return true;
        }

        return false;
    }
    
    
    
    
}
