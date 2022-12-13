/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

/**
 *
 * @author LENOVO
 */
public class carAgent {
    private int carAgentID;
    private carAgency agency;

    public carAgent() {
    }

    public carAgent(int carAgentID, carAgency agency) {
        this.carAgentID = carAgentID;
        this.agency = agency;
    }

    public int getCarAgentID() {
        return carAgentID;
    }

    public void setCarAgentID(int carAgentID) {
        this.carAgentID = carAgentID;
    }

    public carAgency getAgency() {
        return agency;
    }

    public void setAgency(carAgency agency) {
        this.agency = agency;
    }
    
    
}
