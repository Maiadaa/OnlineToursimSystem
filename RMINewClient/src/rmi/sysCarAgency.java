package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface sysCarAgency extends Remote{

    ArrayList <String> getCarAgencies() throws RemoteException;

}