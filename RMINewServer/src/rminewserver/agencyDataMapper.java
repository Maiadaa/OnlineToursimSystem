package rminewserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.agencyDataMapperInterface;

public class agencyDataMapper extends UnicastRemoteObject implements agencyDataMapperInterface{
    
    private sysAgency sys;
    private DB dBHagrass = new DB();

    public agencyDataMapper() throws RemoteException{
    }

    @Override
    public boolean insertCarAgyncy(String name) throws RemoteException{
        carAgency c = new carAgency();
        c.setAgencyName(name);
        if(dBHagrass.insertCarAgency(c)){
            sys.addCarAgency(c);
            return true;
        }else return false;
    }
    
    @Override
    public boolean insertHotel(String name) throws RemoteException{
        hotel h = new hotel();
        h.setHotelName(name);
        if(dBHagrass.insertHotel(h)){
            sys.addHotel(h);
            return true;
        }else return false;
    }
    
    @Override
    public boolean insertAirline(String name) throws RemoteException{
        airline a = new airline();
        a.setAirlineName(name);
        if(dBHagrass.insertAirline(a)){
            sys.addAirline(a);
            return true;
        }else return false;
    }
    
    @Override
    public boolean deleteCarAgency(String name) throws RemoteException{
        carAgency c = new carAgency();
        c.setAgencyName(name);
        return dBHagrass.deleteCarAgency(c);
    }

    @Override
    public boolean deleteHotel(String name) throws RemoteException{
        hotel h = new hotel();
        h.setHotelName(name);
        return dBHagrass.deleteHotel(h);
    }
    
    @Override
    public boolean deleteAirline(String name){
        airline a = new airline();
        a.setAirlineName(name);
        return dBHagrass.deleteAirline(a);
    }
    
    @Override
    public void modifyCarAgency(String oldname, String newname) throws RemoteException{
        carAgency c = new carAgency();
        c.setAgencyName(newname);
        dBHagrass.updateCarAgency(c, oldname);
    }
    
    @Override
    public void modifyHotel(String oldname, String newname) throws RemoteException{
        hotel h = new hotel();
        h.setHotelName(newname);
        dBHagrass.updateHotel(h, oldname);
    }
    
    @Override
    public void modifyAirline(String oldname, String newname){
        airline a = new airline();
        a.setAirlineName(newname);
        dBHagrass.updateAurline(a, oldname);
    }
}
