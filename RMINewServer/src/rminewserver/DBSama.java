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
    
   MongoCollection<Document> personDTO;
    
   MongoCollection<Document> person;
  
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
        personDTO = database.getCollection("DTO");
        person = database.getCollection("p");
   
    }
   public void insertStudent(client s) 
    {
        personDTO.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("DTO is inserted.");
    }
   
    public personDTO editPerson(personDTO p){
        return p;
    }
    
    public person getPerson(person p){
        return p;
    }
    
    public void setPerson (person c){
        person.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("person is inserted.");
    }
    public void setPersonDTO (personDTO d){
        personDTO.insertOne(Document.parse(gson.toJson(d)));
        System.out.println("person is inserted.");
    }
    
    public void editPersonDTO(int ID, personDTO dto){
        personDTO.updateOne(Document.parse(gson.toJson(ID)), Document.parse(gson.toJson(dto)));
        System.out.println("updated.");
    }
   
    public void close() 
    {
        mongoClient.close();
    }
}
