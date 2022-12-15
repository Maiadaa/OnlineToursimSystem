package rminewserver;

import java.util.ArrayList;

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
        db.removeSubscribtion(obs);
    }  
    @Override
    public void notifyObservers(String agencyName){
        this.sysClients = db.getAllClients();
        String msg = "NEW AGENCY ADDED: -> " + agencyName + "Was successfully added to the system";
        for(int i = 0; i<sysClients.size();i++)
        {
          sysClients.get(i).Update(msg);
        }
    }

    @Override
    public ArrayList<hotel> getHotels() {
        return hotels;
    }

    @Override
    public ArrayList<airline> getAirlines() {
        return airlines;
    }

    @Override
    public ArrayList<carAgency> getCarAgencies() {
        return carAgencies;
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

    public void setSysClients() {
        this.sysClients = db.getAllClients();
    }

    
    
    
}
