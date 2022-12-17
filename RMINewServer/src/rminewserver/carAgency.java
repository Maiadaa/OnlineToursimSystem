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
    private String AgencyName;
    
    public carAgency() {
    }

    
    public carAgency(int carAgencyID, ArrayList<car> cars, carAgent agent) {
        this.carAgencyID = carAgencyID;
        this.cars = cars;
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

    public void setAgencyName(String AgencyName) {
        this.AgencyName = AgencyName;
    }

    public String getAgencyName() {
        return AgencyName;
    }
    
    
    
}
