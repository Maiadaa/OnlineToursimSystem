/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

/**
 *
 * @author LENOVO
 */
public class flightAgent extends person{
    private int flightAgentID;
    private airline agency;

    public flightAgent() {
    }

    public flightAgent(int flightAgentID, airline agency) {
        this.flightAgentID = flightAgentID;
        this.agency = agency;
    }

    public int getFlightAgentID() {
        return flightAgentID;
    }

    public void setFlightAgentID(int flightAgentID) {
        this.flightAgentID = flightAgentID;
    }

    public airline getAgency() {
        return agency;
    }

    public void setAgency(airline agency) {
        this.agency = agency;
    }
    
    
    
}
