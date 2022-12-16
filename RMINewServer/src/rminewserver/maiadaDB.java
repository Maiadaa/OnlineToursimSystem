/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.booking;
import rmi.client;



/**
 *
 * @author meriam
 */
public class maiadaDB {
    public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> carCollection;
  
   public static Gson gson = new Gson();
    
   
   public void DB() 
    {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem"); 
        // Collection 
        
   
    }
   public boolean addBooking(client c, booking b) 
    {
        // get document of the car being booked from db to insert in bookings array in client
        MongoCollection<Document> bookingCol = database.getCollection("booking");
        if(b instanceof  car){
           car cc = (car) b;
          Document newBooking = new Document ("clientID", c.getID()).append("bookingType", "car").append("totalPrice",(cc.getRentalPrice() + "")).append("description", cc.viewSummary(cc));
          bookingCol.insertOne(newBooking);  
          return true;
        }
        else if(b instanceof ticket){
          ticket tt = (ticket) b;
          Document newBooking = new Document ("clientID", c.getID()).append("bookingType", "ticket").append("totalPrice",(tt.getPrice()+ "")).append("description", tt.viewSummary(tt));
          bookingCol.insertOne(newBooking);  
          return true;
        }
        else if (b instanceof room){
          room rr = (room) b;
          Document newBooking = new Document ("clientID", c.getID()).append("bookingType", "room").append("totalPrice",(rr.getPrice()+ "")).append("description", rr.viewSummary(rr));
          bookingCol.insertOne(newBooking);
          return true;
        } 
        else if (b instanceof packageOffer){
          packageOffer pp = (packageOffer) b;
          Document newBooking = new Document ("clientID", c.getID()).append("bookingType", "package").append("totalPrice",(pp.getPrice()+ "")).append("description", pp.viewSummary(pp));
          bookingCol.insertOne(newBooking);  
          return true;
        }
        
        return false;
    }
       
   
    public void close() 
    {
        mongoClient.close();
    }
}
