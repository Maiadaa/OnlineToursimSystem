/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.rmi.RemoteException;

/**
 *
 * @author LENOVO
 */
public class flightAgent extends person{
    private int flightAgentID;
    private airline agency;

    public flightAgent() throws RemoteException {
        super();
    }

    public flightAgent(int flightAgentID, airline agency) throws RemoteException {
        super();
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
