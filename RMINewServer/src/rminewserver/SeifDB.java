/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.types.ObjectId;
import static rminewserver.DB.database;
import static rminewserver.DB.mongoClient;
import rmi.booking;
import rmi.client;

/**
 *
 * @author Seif
 */
public class SeifDB {
    public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> ClientCollection;
   MongoCollection<Document> SubsCollection;
   MongoCollection<Document> AdminsCollection;
   MongoCollection<Document> AgentsCollection;
   MongoCollection<Document> HotelsCollection;
   MongoCollection<Document> RoomsCollection;
   MongoCollection<Document> CarsCollection;
   MongoCollection<Document> CarAgencyCollection;
   MongoCollection<Document> TicketsCollection;
   MongoCollection<Document> AirlinesCollection;
   MongoCollection<Document> BookingsCollection;
   MongoCollection<Document> ComplaintsCollection;
  
   public static Gson gson = new Gson();
   
   public SeifDB()
    {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem"); 
        // Collection 
        ClientCollection = database.getCollection("client");
        AdminsCollection = database.getCollection("admin");
        SubsCollection = database.getCollection("subscriber");
        AgentsCollection = database.getCollection("agent");
        HotelsCollection = database.getCollection("hotel");
        RoomsCollection = database.getCollection("room");
        CarsCollection = database.getCollection("car");
        CarAgencyCollection = database.getCollection("carAgency");
        TicketsCollection = database.getCollection("ticket");
        AirlinesCollection = database.getCollection("airline");
        BookingsCollection = database.getCollection("booking");
        ComplaintsCollection = database.getCollection("complaint");
           
    }
   
   public boolean updateBooking(client c){
       BookingsCollection.updateOne(Filters.eq("clientID",c.getID()),Updates.set("PaymentMethod",c.getPayement()));
       return true;
   }
   
}
