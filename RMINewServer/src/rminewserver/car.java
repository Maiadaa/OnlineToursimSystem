/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
public class car implements booking
{
    private int CarID;
    private String Model;
    private double RentalPrice;
    private String Manufacturer;
    private String CarType;
    private int Seats;
    private String plateNum;

    public car() {
    }

    public car(int CarID, String Model, double RentalPrice, String Manufacturer, String CarType, int Seats, String plateNum) {
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
    public void book(client c) {
        c.getBooking_Hisotry()
    }

    @Override
    public void viewSummary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
