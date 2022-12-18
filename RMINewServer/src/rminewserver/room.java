/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;
import rmi.booking;
import rmi.client;

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

    DB db;

    public room() throws RemoteException {
        this.roomNumber = 0;
        this.roomType = "";
        this.floorNumber = 0;
        this.roomView = "";
        this.price = 0.0;
        this.db = new DB();
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
    public boolean book(String uname, String agency, String identifier) throws RemoteException {
        System.out.println(uname);
        Document clientDoc = db.clientCollection.find(Filters.eq("email", uname)).first();
        client c = db.gson.fromJson(clientDoc.toJson(), client.class);
        System.out.println(c.toString());
        
        Document hotelDoc = db.HotelsCollection.find(Filters.eq("HotelName", agency)).first();
        hotel h = db.gson.fromJson(hotelDoc.toJson(), hotel.class);

        room r = new room();
        int roomNum = Integer.parseInt(identifier);
        for(room roomm: h.getRooms()){
            if(roomm.getRoomNumber() == roomNum){
                r = roomm;
            }
        }
        
        if(db.addBooking(c, r)){
            c.getBooking_History().add(r);
            return true;
        }
        return false;
    }


    public String viewSummary(room c) {
        return c.toString();
    }

    @Override
    public String toString() {
        return "roomNumber=" + roomNumber + ", floorNumber=" + floorNumber + ", roomType=" + roomType + ", roomView=" + roomView;
    }

}
