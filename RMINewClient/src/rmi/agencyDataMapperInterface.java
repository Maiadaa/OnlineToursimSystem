
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface agencyDataMapperInterface extends Remote {

    // add parameters 
    public boolean insertCarAgyncy(String name) throws RemoteException;
    public boolean insertHotel(String name) throws RemoteException;
    public boolean insertAirline(String name) throws RemoteException;
    public boolean deleteCarAgency(String name) throws RemoteException;
    public boolean deleteHotel(String name) throws RemoteException;
    public boolean deleteAirline(String name) throws RemoteException;
    public void modifyCarAgency(String oldname, String newname) throws RemoteException;
    public void modifyHotel(String oldname, String newname) throws RemoteException;
    public void modifyAirline(String oldname, String newname) throws RemoteException;
}
