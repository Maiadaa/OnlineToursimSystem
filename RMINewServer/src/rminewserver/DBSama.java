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
public class DBSama {
    public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> collection1;
  
   public static Gson gson = new Gson();
    
   
   public DBSama() 
    {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem"); 
        // Collection 
        collection1 = database.getCollection("client");
   
    }
   public void insertStudent(client s) 
    {
        collection1.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Student is inserted.");
    }
   
   
    public void close() 
    {
        mongoClient.close();
    }
    
    public void setPerson (person p){
        
    }
    public personDTO editPerson(personDTO p){
        return p;
    }
    
    public person getPerson(person p){
        return p;
    }
    public void setPersonDTO (personDTO d){
        
    }
}
