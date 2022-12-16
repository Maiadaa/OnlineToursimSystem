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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author meriam
 */
public class DBAssem {
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
   MongoCollection<Document> ComplainsCollection;

   
  
   public static Gson gson = new Gson();
    
   
   public DBAssem() 
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
        ComplainsCollection = database.getCollection("complain");
    }
   public void insertClient(client s) 
    {
        ClientCollection.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Client is inserted.");
    }
   public void subscribeClient(client c)
    {
        SubsCollection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Client subscribed to get information about added agencies");
    }
   public void removeSubscribtion(client c) throws RemoteException
   {
       String tempname = c.getFname();
       SubsCollection.deleteOne(Filters.eq("Fname",tempname));
       System.out.println("Client removed from subscribers list successfully");
   }
   public ArrayList<client> getAllClients() throws RemoteException
   {
       String json;
       client tempclient;
       ArrayList<client> tempclients =  new ArrayList<client>(); 
       ClientCollection = database.getCollection("client");
       MongoCursor cursor = ClientCollection.find().iterator();
       while(cursor.hasNext())
       {
           json = gson.toJson(cursor.next());
           tempclient = gson.fromJson(json, client.class);
           tempclients.add(tempclient);
           System.out.println(tempclient.getFname());
       }
       return tempclients;
   }
   public ArrayList<client> getAllSubscribers() throws RemoteException
   {
       String json;
       client tempclient;
       ArrayList<client> tempsubs =  new ArrayList<client>(); 
       SubsCollection = database.getCollection("subscriber");
       MongoCursor cursor = SubsCollection.find().iterator();
       while(cursor.hasNext())
       {
           json = gson.toJson(cursor.next());
           tempclient = gson.fromJson(json, client.class);
           tempsubs.add(tempclient);
           System.out.println(tempclient.getFname());
       }
       
       return tempsubs;
   }

    @Override
    public String toString() {
        return "DBAssem{" + "ClientCollection=" + ClientCollection + ", SubsCollection=" + SubsCollection + ", AdminsCollection=" + AdminsCollection + ", AgentsCollection=" + AgentsCollection + ", HotelsCollection=" + HotelsCollection + ", RoomsCollection=" + RoomsCollection + ", CarsCollection=" + CarsCollection + ", CarAgencyCollection=" + CarAgencyCollection + ", TicketsCollection=" + TicketsCollection + ", AirlinesCollection=" + AirlinesCollection + ", BookingsCollection=" + BookingsCollection + ", ComplainsCollection=" + ComplainsCollection + '}';
    }
   
    public void close() 
    {
        mongoClient.close();
    }
}
