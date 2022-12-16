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
import static rminewserver.DBAssem.database;
import static rminewserver.DBAssem.mongoClient;
import static rminewserver.DBHagrass.gson;


/**
 *
 * @author Seif
 * 
 * 
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
   
   ArrayList <complaint> complaints = new ArrayList <complaint>(); 
   
    public ArrayList<complaint> getAllComplaints(){
        String json;
        complaint Complaint;
        ComplaintsCollection = database.getCollection("complaint");
        //collectionttemp.insertOne(Document.parse(gson.toJson(Complaint)));
        MongoCursor cursor = ComplaintsCollection.find().iterator();
        while (cursor.hasNext()){
            json = gson.toJson(cursor.next());
            Complaint = gson.fromJson(json, complaint.class);
            complaints.add(Complaint);
            System.out.println(Complaint.getComplaintState() + Complaint.getComplaintType());
            }
        return complaints;
    }
   
//    public void viewComplaints(){
//       for (int i = 0; i <= complaints.size(); i++){
//           complaints.get(i);
//       }
//   }
   
   public void insertComplain(complaint c){
       ComplaintsCollection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Complaint inserted successfuly.");
   }
}
