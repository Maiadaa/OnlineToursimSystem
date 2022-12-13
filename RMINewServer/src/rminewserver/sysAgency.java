package rminewserver;

import java.util.ArrayList;

public class sysAgency implements sysHotel, sysAirline, sysCarAgency{
    
    private ArrayList <carAgency> carAgencies = new ArrayList <carAgency> ();
    private ArrayList <hotel> hotels = new ArrayList <hotel> ();
    private ArrayList <airline> airlines = new ArrayList <airline> ();
    private ArrayList <client> sysClients = new ArrayList <client>();
    
    //setters
    
    //getters
    
    //functions
    public void addCarAgency (carAgency CarAgency){
    
    }
    
    public void addHotel (hotel Hotel){
        
    }
    
    public void addAirline (airline Airline){
    
    }
    
    public boolean removeCarAgency(carAgency CarAgency){
        return true;
    }
    
    public boolean removeHotel(hotel Hotel){
        return true;
    }
    
    public boolean removeAirline(airLine Airline){
        return true;
    }
    
    public void addObserver(observer obs){
    
    }
    
    public void removeObserver(observer obs){
    
    }
    
    public void notifyObserver(){
    
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
    
}
