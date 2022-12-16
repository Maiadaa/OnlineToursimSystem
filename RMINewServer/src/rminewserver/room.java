/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.booking;
/**
 *
 * @author LENOVO
 */
public class room extends UnicastRemoteObject implements booking {
    private int roomNumber;
    private String roomType;
    private int floorNumber;
    private String roomView;
    private double price;
    
    maiadaDB db ;

    public room() throws RemoteException {
        this.roomNumber = 0;
        this.roomType = "";
        this.floorNumber = 0;
        this.roomView = "";
        this.price = 0.0;
    }

    public room(int roomNumber, String roomType, int floorNumber, String roomView, double price) throws RemoteException {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floorNumber = floorNumber;
        this.roomView = roomView;
        this.price = price;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomView() {
        return roomView;
    }

    public void setRoomView(String roomView) {
        this.roomView = roomView;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean book(client c) throws RemoteException {
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
    public String viewSummary(booking c){
        return c.toString();
    }

    @Override
    public String toString() {
        return "roomNumber=" + roomNumber  + ", floorNumber=" + floorNumber + ", roomType=" + roomType + ", roomView=" + roomView ;
    }


    
}
