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
import org.bson.types.ObjectId;
import static rminewserver.DB.database;
import static rminewserver.DB.mongoClient;

/**
 *
 * @author Seif
 */
public class SeifDB {
    public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> ClientsCollection;
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
        ClientsCollection = database.getCollection("client");
        ComplaintsCollection = database.getCollection("complaint");
    }
   ArrayList <complaint> complaints = new ArrayList <complaint>(); 
   
    public ArrayList<complaint> getAllComplaints() throws RemoteException{
        String json;
        complaint Complaint = new complaint();
        MongoCollection<Document> collectionttemp = database.getCollection("complaint");
        //collectionttemp.insertOne(Document.parse(gson.toJson(Complaint)));
        MongoCursor cursor = collectionttemp.find().iterator();
        while (cursor.hasNext()){
            json = gson.toJson(cursor.next());
            Complaint = gson.fromJson(json, complaint.class);
            complaints.add(Complaint);
            System.out.println(Complaint.getComplaintID() + Complaint.getComplaintState() + Complaint.getComplaintType());
            }
        return complaints;
    }
   
//    public void viewComplaints(){
//       for (int i = 0; i <= complaints.size(); i++){
//           complaints.get(i);
//       }
//   }
   
   public void insertComplaint(complaint c){
       ComplaintsCollection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Complaint has been created.");
}
