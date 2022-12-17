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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

import rmi.personDTO;

/**
 *
 * @author meriam
 */
public class DBSama {
    public static MongoClient mongoClient;
    public static MongoDatabase database;
    MongoCollection<Document> DTO;
    MongoCollection<Document> person;
    public static Gson gson = new Gson();

   public DBSama() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);
        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem"); 
        // Collection 
        DTO = database.getCollection("DTO");
        person = database.getCollection("Person");

    }

    public void setPerson (person c){
        person.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("person is inserted.");
    }

    public void setPersonDTO (personDTO d){
        DTO.insertOne(Document.parse(gson.toJson(d)));
        System.out.println("person is inserted.");
    }
    
    public person getPerson (person p){
        person.find(Filters.eq("email", p.getEmail()));
        person.find(Filters.eq("password", p.getPassword()));
        System.out.println("Successful " + p.getFname());
        return p;
    }
    public Document getPersonDTO (int ID){

        Document ids = (Document) DTO.find(Filters.all("ID", ID));
        if(ids != null){
            return ids;
        }else
            System.out.println("Nothing found");
        return null;
    }

    public void close() {
        mongoClient.close();
    }
}
