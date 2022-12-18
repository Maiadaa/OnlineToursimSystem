/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;
import org.bson.types.ObjectId;
import rmi.booking;

import rmi.client;

public class ticket extends UnicastRemoteObject implements booking {

    private ObjectId _id;
    private int seatNumber;
    private double price;
    private String ticketType;

    maiadaDB db;

    public ticket() throws RemoteException {
        this._id = new ObjectId();
        this.seatNumber = 0;
        this.price = 0.0;
        this.ticketType = "";
        this.db = new maiadaDB();
    }

    public ticket(ObjectId ticketID, int seatNumber, double price, String ticketType) throws RemoteException {
        this._id = ticketID;
        this.seatNumber = seatNumber;
        this.price = price;
        this.ticketType = ticketType;
    }

    public ObjectId getTicketID() {
        return _id;
    }

    public void setTicketID(ObjectId ticketID) {
        this._id = ticketID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void manageTicket() {

    }

    @Override
    public boolean book(String uname, String agency, String identifier) throws RemoteException {
        System.out.println(uname);
        Document clientDoc = db.clientCollection.find(Filters.eq("Email", uname)).first();
        client c = db.gson.fromJson(clientDoc.toJson(), client.class);
        System.out.println(c.toString());

        Document airlineDoc = db.AirlinesCollection.find(Filters.eq("AgencyName", agency)).first();
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
        
        if(db.addBooking(c, t)){
            c.getBooking_History().add(t);
            return true;
        }
        return false;
        
    }

    public String viewSummary(ticket c) {
        return c.toString();
    }

    @Override
    public String toString() {
        return "ticketID=" + _id + ", ticketType=" + ticketType + ", seatNumber=" + seatNumber;
    }

}
