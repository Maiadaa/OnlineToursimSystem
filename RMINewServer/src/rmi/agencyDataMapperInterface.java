
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface agencyDataMapperInterface extends Remote {

    // add parameters 
    public boolean insertCarAgyncy() throws RemoteException;
//    public boolean insertHotel() throws RemoteException;
//    public boolean insertAirline() throws RemoteException;
//    public boolean deleteCarAgency() throws RemoteException;
//    public boolean deleteHotel() throws RemoteException;
//    public boolean deleteAirline() throws RemoteException;
//    public void modifyCarAgency() throws RemoteException;
//    public void modifyHotel() throws RemoteException;
//    public void modifyAirline() throws RemoteException;
}
