package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import rminewserver.carAgency;

public interface sysCarAgency extends Remote {

    ArrayList <carAgency> getCarAgencies() throws RemoteException;
    
}
