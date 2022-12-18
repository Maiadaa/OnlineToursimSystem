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
import java.util.ArrayList;
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

    MongoCollection<Document> carAgencyCollection;
    MongoCollection<Document> bookingCollection;
    MongoCollection<Document> HotelsCollection;
    MongoCollection<Document> AirlinesCollection;
    MongoCollection<Document> clientCollection;

    public static Gson gson = new Gson();

    public maiadaDB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        this.mongoClient = new MongoClient("localhost", 27017);

        // Database name
        this.database = mongoClient.getDatabase("OnlineTourismSystem");

        // Collection 
        this.bookingCollection = database.getCollection("booking");
        this.carAgencyCollection = database.getCollection("carAgency");
        this.clientCollection = database.getCollection("client");
        this.HotelsCollection = database.getCollection("hotel");
        this.AirlinesCollection = database.getCollection("airline");
    }

//    public car getCarByPlateNumber(String agencyName, String plateNum) throws RemoteException {
//        String json;
//        
//        Document agency = carAgencyCollection.find(Filters.eq("AgencyName", agencyName)).first();
//        carAgency carAgency = new carAgency();
//        json = gson.toJson(agency);
//        carAgency = gson.fromJson(json, carAgency.class);
//        
//        for(car c: carAgency.getCars()){
//            if(c.getPlateNum() == plateNum){
//                return c;
//            }
//        }
//        
//        return null;
//    }
//
//    public ticket getTicketById(String ticketId) throws RemoteException {
//        String json;
//        Document chosenTicket = ticketCollection.find(Filters.eq("_id", ticketId)).first();
//        ticket t = new ticket();
//        json = gson.toJson(chosenTicket);
//        t = gson.fromJson(json, ticket.class);
//        return t;
//    }
//
//    public room getRoomById(String roomId) throws RemoteException {
//        String json;
//        Document chosenTicket = ticketCollection.find(Filters.eq("_id", roomId)).first();
//        room r = new room();
//        json = gson.toJson(chosenTicket);
//        r = gson.fromJson(json, room.class);
//        return r;
//    }

    public boolean addBooking(client c, booking b) {
        if (b instanceof car) {
            car cc = (car) b;
            Document newBooking = new Document("client", c.getEmail()).append("bookingType", "car").append("totalPrice", (cc.getRentalPrice() + "")).append("description", cc.viewSummary(cc)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        } else if (b instanceof ticket) {
            ticket tt = (ticket) b;
            Document newBooking = new Document("client", c.getEmail()).append("bookingType", "ticket").append("totalPrice", (tt.getPrice() + "")).append("description", tt.viewSummary(tt)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        } else if (b instanceof room) {
            room rr = (room) b;
            Document newBooking = new Document("client", c.getEmail()).append("bookingType", "room").append("totalPrice", (rr.getPrice() + "")).append("description", rr.viewSummary(rr)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        } else if (b instanceof packageOffer) {
            packageOffer pp = (packageOffer) b;
            Document newBooking = new Document("client", c.getEmail()).append("bookingType", "package").append("totalPrice", (pp.getPrice() + "")).append("description", pp.viewSummary(pp)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        }

        return false;
    }
    
    public ArrayList<String> getAllCar (String AgencyName){
       String json;
       ArrayList<String> cars = new ArrayList<String>();
       carAgency agency = new carAgency();
//       collection1.insertOne(Document.parse(gson.toJson(agency)));
       json = gson.toJson(carAgencyCollection.find(Filters.eq("AgencyName", AgencyName)).first());
       agency = gson.fromJson(json, carAgency.class);
       for(int i = 0; i < agency.getCars().size(); i++){
           cars.add(agency.getCars().get(i).specialToString());
       }
       return cars;
   }

    public void close() {
        mongoClient.close();
    }
}
