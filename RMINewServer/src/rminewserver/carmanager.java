/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import org.bson.Document;
import rmi.booking;
import rmi.client;
/**
 *
 * @author LENOVO
 */
public class carmanager extends UnicastRemoteObject implements booking{
    
    maiadaDB db = new maiadaDB();

    public carmanager() throws RemoteException{
    }
    
    
    
    @Override
    public boolean book(String uname, String agency, String identifier) throws RemoteException {
        System.out.println(uname);
        Document clientDoc = db.clientCollection.find(Filters.all("Fname", uname)).first();
        client c = db.gson.fromJson(clientDoc.toJson(), client.class);
        System.out.println(c);

        Document carDoc = db.carAgencyCollection.find(Filters.eq("AgencyName", agency)).first();
        carDoc = db.carAgencyCollection.find(Filters.eq("plateNum", identifier)).first();
        car chosenCar = db.gson.fromJson(carDoc.toJson(), car.class);

        // add it to the database
        if (db.addBooking(c, (booking) chosenCar)) {
            c.getBooking_History().add((booking) chosenCar);
            return true;
        }

        return false;
    }
    
}
