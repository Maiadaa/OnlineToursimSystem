package rminewserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rmi.agencyDataMapperInterface;

public class agencyDataMapper extends UnicastRemoteObject implements agencyDataMapperInterface{
    
    private sysAgency sys;
    private DBHagrass dBHagrass = new DBHagrass();

    public agencyDataMapper() throws RemoteException{
    }

    @Override
    public boolean insertCarAgyncy() throws RemoteException{
        carAgency c = new carAgency();
        if(dBHagrass.insertCarAgency(c)){
            sys.addCarAgency(c);
            return true;
        }else return false;
    }
    
//    @Override
//    public boolean insertHotel(hotel Hotel){
//        if(dBHagrass.insertHotel(Hotel)){
//            sys.addHotel(Hotel);
//            return true;
//        }else return false;
//    }
//    
//    @Override
//    public boolean insertAirline(airline Airline){
//        if(dBHagrass.insertAirline(Airline)){
//            sys.addAirline(Airline);
//            return true;
//        }else return false;
//    }
//    
//    @Override
//    public boolean deleteCarAgency(carAgency CA){
//        return dBHagrass.deleteCarAgency(CA);
//    }
//
//    @Override
//    public boolean deleteHotel(hotel Hotel){
//        return dBHagrass.deleteHotel(Hotel);
//    }
//    
//    @Override
//    public boolean deleteAirline(airline Airline){
//        return dBHagrass.deleteAirline(Airline);
//    }
//    
//    @Override
//    public void modifyCarAgency(carAgency CA, String name){
//        dBHagrass.updateCarAgency(CA, name);
//    }
//    
//    @Override
//    public void modifyHotel(hotel H, String name){
//        dBHagrass.updateHotel(H, name);
//    }
//    
//    @Override
//    public void modifyAirline(airline A, String name){
//        dBHagrass.updateAurline(A, name);
//    }
}
