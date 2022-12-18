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
public class flight {
    private int flightID;
    private ArrayList<ticket> tickets;
    private String destination;
    private String departure;
    private String takOffTime;
    private String arrivalTime;

    public flight() {
        this.tickets = new ArrayList<>();
    }

    public flight(int flightID, ArrayList<ticket> tickets, String destination, String departure, String takOffTime, String arrivalTime) {
        this.flightID = flightID;
        this.tickets = tickets;
        this.destination = destination;
        this.departure = departure;
        this.takOffTime = takOffTime;
        this.arrivalTime = arrivalTime;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public ArrayList<ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<ticket> tickets) {
        this.tickets = tickets;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getTakOffTime() {
        return takOffTime;
    }

    public void setTakOffTime(String takOffTime) {
        this.takOffTime = takOffTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "flight{" + "flightID=" + flightID + ", tickets=" + tickets + ", destination=" + destination + ", departure=" + departure + ", takOffTime=" + takOffTime + ", arrivalTime=" + arrivalTime + '}';
    }
    
    
}
