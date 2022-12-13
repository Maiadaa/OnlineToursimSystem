package rminewserver;

import java.util.ArrayList;

public class sysAgency implements sysHotel, sysAirline, sysCarAgency{
    
    private ArrayList <carAgency> carAgencies = new ArrayList <carAgency> ();
    private ArrayList <hotel> hotels = new ArrayList <hotel> ();
    private ArrayList <airLine> airLines = new ArrayList <airLines> ();
    private ArrayList <client> sysClients = new ArrayList <client>();
    
    //setters
    
    //getters
    
    //functions
    public void addCarAgency (carAgency){
    
    }
    
    public void addHotel (hotel){
        
    }
    
    public void addAirline (airLine){
    
    }
    
    public boolean removeCarAgency(carAgency){
        return true;
    }
    
    public boolean removeHotel(hotel){
        return true;
    }
    
    public boolean removeAirline(airLine){
        return true;
    }
    
    public void addObserver(observer obs){
    
    }
    
    public void removeObserver(observer obs){
    
    }
    
    public void notifyObserver(){
    
    }

    @Override
    public ArrayList<Object> getHotels() {
        return hotels;
    }

    @Override
    public ArrayList<Object> getAirlines() {
        return airLines;
    }

    @Override
    public ArrayList<Object> getCarAgencies() {
        return carAgencies;
    }
    
}
