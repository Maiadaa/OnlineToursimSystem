package rminewserver;

import rmi.sysAirline;
import rmi.sysCarAgency;
import rmi.sysHotel;
import rmi.subject_interface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import rmi.client;

public class sysAgency extends UnicastRemoteObject implements sysHotel, sysAirline, sysCarAgency{
    
    private ArrayList <carAgency> carAgencies = new ArrayList <carAgency> ();
    private ArrayList <hotel> hotels = new ArrayList <hotel> ();
    private ArrayList <airline> airlines = new ArrayList <airline> ();
    private ArrayList <client> sysClients = new ArrayList <client>();
    private DBAssem db = new DBAssem();
    
    
    //functions
    public sysAgency()  throws RemoteException{
        this.carAgencies = null;
        this.hotels=null;
        this.airlines=null;
        this.sysClients=null;
    }
    
    public void addCarAgency (carAgency CarAgency)throws RemoteException{
//    notifyObservers(CarAgency.getAgencyName());
    }
    
    public void addHotel (hotel Hotel) throws RemoteException{
//    notifyObservers(Hotel.getHotelName());    
    }
    
    public void addAirline (airline Airline) throws RemoteException{
//    notifyObservers(Airline.getAirlineName());
    }
    
    public boolean removeCarAgency(carAgency CarAgency)throws RemoteException{
        return true;
    }
    
    public boolean removeHotel(hotel Hotel)throws RemoteException{
        return true;
    }
    
    public boolean removeAirline(airline Airline)throws RemoteException{
        return true;
    }
//    @Override
//    public void addObserver(client obs)throws RemoteException{
//        db.subscribeClient(obs);
//    }
//    @Override
//    public void removeObserver(client obs) throws RemoteException{
//        try {
//            db.removeSubscribtion(obs);
//        } catch (RemoteException ex) {
//            Logger.getLogger(sysAgency.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("Error occured removing the subscribtion");
//        }
//    }  
//    @Override
//    public void notifyObservers(String agencyName) throws RemoteException{
//        try {
//            this.sysClients = db.getAllSubscribers();
//        } catch (RemoteException ex) {
//            Logger.getLogger(sysAgency.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String msg = "NEW AGENCY ADDED: -> " + agencyName + "Was successfully added to the system";
//        for(int i = 0; i<sysClients.size();i++)
//        {
//          sysClients.get(i).Update(msg);
//        }
//    }

    @Override
    public ArrayList<String> getHotels() throws RemoteException{
        DBHagrass dbhagrass = new DBHagrass();
        return dbhagrass.getAllHotels();
    }

    @Override
    public ArrayList<String> getAirlines() throws RemoteException{
        DBHagrass dbhagrass = new DBHagrass();
        return dbhagrass.getAllAirlines();
    }

    @Override
    public ArrayList <String> getCarAgencies() throws RemoteException{
        DBHagrass dbhagrass = new DBHagrass();
        return dbhagrass.getAllCarAgencies();
    }

    @Override
    public ArrayList<String> getAllRooms(String name) throws RemoteException {
        DBHagrass dBHagrass = new DBHagrass();
//        return dBHagrass.getAllRoom();
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getAllFlights(String name) throws RemoteException {
        DBHagrass dBHagrass = new DBHagrass();
//        return dBHagrass.getAllFlights();
        return new ArrayList<>();
    }

    @Override
    public ArrayList<String> getAllCars(String name) throws RemoteException {
        DB dBHagrass = new DB();
        return dBHagrass.getAllCar(name);
    }

    public void setCarAgencies(ArrayList<carAgency> carAgencies) throws RemoteException{
        this.carAgencies = carAgencies;
    }

    public void setHotels(ArrayList<hotel> hotels) throws RemoteException{
        this.hotels = hotels;
    }

    public void setAirlines(ArrayList<airline> airlines) throws RemoteException{
        this.airlines = airlines;
    }

    public void setSysClients() throws RemoteException {
        this.sysClients = db.getAllClients();
    }
    
}
