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
public class carAgency {
    private int carAgencyID;
    private ArrayList<car> cars;
    private carAgent agent;

    public carAgency() {
    }

    public carAgency(int carAgencyID, ArrayList<car> cars, carAgent agent) {
        this.carAgencyID = carAgencyID;
        this.cars = cars;
        this.agent = agent;
    }

    public int getCarAgencyID() {
        return carAgencyID;
    }

    public void setCarAgencyID(int carAgencyID) {
        this.carAgencyID = carAgencyID;
    }

    public ArrayList<car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<car> cars) {
        this.cars = cars;
    }

    public carAgent getCarAgent() {
        return agent;
    }

    public void setCarAgent(carAgent agent) {
        this.agent = agent;
    }
    
    
    
}
