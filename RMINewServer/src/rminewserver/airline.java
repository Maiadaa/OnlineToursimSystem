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
public class airline implements booking{
    private int airlineID;
    private String airlineName;
    private ArrayList<flight> flights;
    private flightAgent agent;

    public airline() {
    }

    public airline(int airlineID, String airlineName, ArrayList<flight> flights, flightAgent agent) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
        this.flights = flights;
        this.agent = agent;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public ArrayList<flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<flight> flights) {
        this.flights = flights;
    }

    public flightAgent getAgent() {
        return agent;
    }

    public void setAgent(flightAgent agent) {
        this.agent = agent;
    }

    @Override
    public void book() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void viewSummary() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
