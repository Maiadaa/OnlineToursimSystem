/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
    
    private maiadaDB db;

    public car()throws RemoteException {
        this.CarID = 0;
        this.Model = "";
        this.RentalPrice = 0.0;
        this.Manufacturer = "";
        this.CarType = "";
        this.Seats = 0;
        this.plateNum = "";
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

    @Override
    public boolean book(client c, String agency, String identifier) throws RemoteException {
        car chosenCar = new car();
        chosenCar = db.getCarByPlateNumber(agency, identifier);
        System.out.println(chosenCar);
        
       // add it to the database
       if(db.addBooking(c, chosenCar)){
           c.getBooking_History().add(chosenCar);
           return true;
       }
  
       return false;
    }

    public String viewSummary(booking c) {
        return c.toString();
    }

    @Override
    public String toString() {
        return "carId=" + plateNum + ", CarType=" + CarType + ", Manufacturer=" + Manufacturer + ", Model=" + Model + ", Seats=" + Seats ;
    }
    
    
    
    
    
}
