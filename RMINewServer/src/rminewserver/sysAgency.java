package rminewserver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sysAgency implements sysHotel, sysAirline, sysCarAgency, subject_interface{
    
    private ArrayList <carAgency> carAgencies = new ArrayList <carAgency> ();
    private ArrayList <hotel> hotels = new ArrayList <hotel> ();
    private ArrayList <airline> airlines = new ArrayList <airline> ();
    private ArrayList <client> sysClients = new ArrayList <client>();
    private DBAssem db;
    //setters
    
    //getters
    
    //functions
    public sysAgency() {
        this.carAgencies = null;
        this.hotels=null;
        this.airlines=null;
        this.sysClients=null;
    }
 
    
    
    
    public void addCarAgency (carAgency CarAgency){
    notifyObservers(CarAgency.getAgencyName());
    }
    
    public void addHotel (hotel Hotel){
    notifyObservers(Hotel.getHotelName());    
    }
    
    public void addAirline (airline Airline){
    notifyObservers(Airline.getAirlineName());
    }
    
    public boolean removeCarAgency(carAgency CarAgency){
        return true;
    }
    
    public boolean removeHotel(hotel Hotel){
        return true;
    }
    
    public boolean removeAirline(airline Airline){
        return true;
    }
    @Override
    public void addObserver(client obs){
        db.subscribeClient(obs);
    }
    @Override
    public void removeObserver(client obs){
        try {
            db.removeSubscribtion(obs);
        } catch (RemoteException ex) {
            Logger.getLogger(sysAgency.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error occured removing the subscribtion");
        }
    }  
    @Override
    public void notifyObservers(String agencyName){
        try {
            this.sysClients = db.getAllClients();
        } catch (RemoteException ex) {
            Logger.getLogger(sysAgency.class.getName()).log(Level.SEVERE, null, ex);
        }
        String msg = "NEW AGENCY ADDED: -> " + agencyName + "Was successfully added to the system";
        for(int i = 0; i<sysClients.size();i++)
        {
          sysClients.get(i).Update(msg);
        }
    }

    @Override
    public ArrayList<hotel> getHotels() {
        DBHagrass dbhagrass = new DBHagrass();
        return dbhagrass.getAllHotels();
    }

    @Override
    public ArrayList<airline> getAirlines() {
        DBHagrass dbhagrass = new DBHagrass();
        return dbhagrass.getAllAirlines();
    }

    @Override
    public ArrayList<carAgency> getCarAgencies() {
        DBHagrass dbhagrass = new DBHagrass();
        return dbhagrass.getAllCarAgencies();
    }


    public void setCarAgencies(ArrayList<carAgency> carAgencies) {
        this.carAgencies = carAgencies;
    }

    public void setHotels(ArrayList<hotel> hotels) {
        this.hotels = hotels;
    }

    public void setAirlines(ArrayList<airline> airlines) {
        this.airlines = airlines;
    }

    public void setSysClients() throws RemoteException {
        this.sysClients = db.getAllClients();
    }

    
    
    
}
