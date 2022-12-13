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

/**
 *
 * @author meriam
 */
public class DB {
    public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> collection1;
  
   public static Gson gson = new Gson();
    
   
   public DB() 
    {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem"); 
        // Collection 
//        database.createCollection("car");
        database.createCollection("airline");
        database.createCollection("hotel");
        database.createCollection("hotelAgent");
        database.createCollection("carAgent");
        database.createCollection("flightAgent");
        database.createCollection("carAgency");
        database.createCollection("ticket");
        database.createCollection("room");
        database.createCollection("admin");
        Document doc1 = new Document("ID", 1).append("Fname", "Abdelrahman").append("Lname", "Hagrass").append("gender", "male").append("age", 21).append("email", "hagrass@gmail.com").append("phone", "01013700990").append("address", "cairo").append("username", "hagrass").append("password", "hagrass");
        collection1 = database.getCollection("client");
        collection1.insertOne(doc1);
   
    }
   
         public void insertStudent(Student s) 
    {
        collection1.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Student is inserted.");
    }
         
         
         public void close() 
    {
        mongoClient.close();
    }
}
