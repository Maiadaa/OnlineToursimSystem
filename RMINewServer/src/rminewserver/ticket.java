/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import rmi.booking;
/**
 *
 * @author LENOVO
 */
public class ticket implements booking{
    private int ticketID;
    private int seatNumber;
    private double price;
    private String ticketType;
    
    maiadaDB db;

    public ticket() {
        this.ticketID = 0;
        this.seatNumber = 0;
        this.price = 0.0;
        this.ticketType = "";
    }

    public ticket(int ticketID, int seatNumber, double price, String ticketType) {
        this.ticketID = ticketID;
        this.seatNumber = seatNumber;
        this.price = price;
        this.ticketType = ticketType;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
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
    
    public void manageTicket(){
        
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
        return "ticketID=" + ticketID + ", ticketType=" + ticketType + ", seatNumber=" + seatNumber ;
    }
    
    
    
    
}
