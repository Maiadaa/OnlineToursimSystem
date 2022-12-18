/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class carAgency implements Serializable{
    private int carAgencyID;
    private ArrayList<car> cars;
    private String AgencyName;
    
    public carAgency() throws RemoteException{
        this.cars = new ArrayList<>();
    }

 
    public carAgency(int carAgencyID, ArrayList<car> cars, String AgencyName) throws RemoteException{
        this.carAgencyID = carAgencyID;
        this.cars = cars;
        this.AgencyName = AgencyName;
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

    @Override
    public String toString() {
        return AgencyName;
    }
    
    
    
}
