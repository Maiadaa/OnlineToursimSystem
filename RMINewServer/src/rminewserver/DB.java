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
import rmi.booking;

import rmi.client;

public class DB {

    public static MongoClient mongoClient;

    public static MongoDatabase database;

    MongoCollection<Document> collection1;
    MongoCollection<Document> carAgencyCollection;
    MongoCollection<Document> bookingCollection;
    MongoCollection<Document> HotelsCollection;
    MongoCollection<Document> AirlinesCollection;
    MongoCollection<Document> clientCollection;

    public static Gson gson = new Gson();

    public DB() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();

        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem");

        // Collection 
        this.clientCollection = database.getCollection("client");

        this.bookingCollection = database.getCollection("booking");
        
        this.carAgencyCollection = database.getCollection("carAgency");
        this.HotelsCollection = database.getCollection("hotel");
        this.AirlinesCollection = database.getCollection("airline");

    }

    public ArrayList<String> getAllAirlines() {
        String json;
        ArrayList<String> airlines = new ArrayList<String>();
        airline Airline = new airline();
        collection1 = database.getCollection("airline");
        MongoCursor cursor = collection1.find().iterator();
        while (cursor.hasNext()) {
            json = gson.toJson(cursor.next());
            Airline = gson.fromJson(json, airline.class);
            airlines.add(Airline.getAirlineName());
        }
        return airlines;
    }

    public ArrayList<String> getAllCarAgencies() throws RemoteException {
        String json;
        ArrayList<String> carAgencies = new ArrayList<String>();
        carAgency CarAgency = new carAgency();
        collection1 = database.getCollection("carAgency");
        MongoCursor cursor = collection1.find().iterator();
        while (cursor.hasNext()) {
            json = gson.toJson(cursor.next());
            CarAgency = gson.fromJson(json, carAgency.class);
            carAgencies.add(CarAgency.toString());
        }
        return carAgencies;
    }

    public ArrayList<String> getAllHotels() throws RemoteException {
        String json;
        ArrayList<String> hotels = new ArrayList<String>();
        hotel Hotel = new hotel();
        collection1 = database.getCollection("hotel");
        MongoCursor cursor = collection1.find().iterator();
        while (cursor.hasNext()) {
            json = gson.toJson(cursor.next());
            Hotel = gson.fromJson(json, hotel.class);
            hotels.add(Hotel.getHotelName());
        }
        return hotels;
    }

    public ArrayList<String> getAllCar(String AgencyName) throws RemoteException {
        String json;
        ArrayList<String> cars = new ArrayList<String>();
        car Car = new car();
        collection1 = database.getCollection("carAgency");
        carAgency agency = new carAgency();
        json = gson.toJson(collection1.find(Filters.eq("AgencyName", AgencyName)).first());
        agency = gson.fromJson(json, carAgency.class);
        for (int i = 0; i < agency.getCars().size(); i++) {
            cars.add(agency.getCars().get(i).toString());
        }
        return cars;
    }

    public ArrayList<String> getAllRoom(String AgencyName) throws RemoteException {
        String json;
        ArrayList<String> rooms = new ArrayList<String>();
        room Room = new room();
        collection1 = database.getCollection("hotel");
        hotel Hotel = new hotel();
        json = gson.toJson(collection1.find(Filters.eq("HotelName", AgencyName)).first());
        Hotel = gson.fromJson(json, hotel.class);
        for (int i = 0; i < Hotel.getRooms().size(); i++) {
            rooms.add(Hotel.getRooms().get(i).toString());
        }
        return rooms;
    }

    public ArrayList<String> getAllFlights(String AgencyName) throws RemoteException {
        String json;
        ArrayList<String> flights = new ArrayList<String>();
        flight Flight = new flight();
        collection1 = database.getCollection("airline");
        airline Airline = new airline();
        json = gson.toJson(collection1.find(Filters.eq("airlineName", AgencyName)).first());
        Airline = gson.fromJson(json, airline.class);
        for (int i = 0; i < Airline.getFlights().size(); i++) {
            flights.add(Airline.getFlights().get(i).toString());
        }
        return flights;
    }

    /*Data mapper*/

    public boolean insertCarAgency(carAgency CarAgency) {
        collection1 = database.getCollection("carAgency");
        collection1.insertOne(Document.parse(gson.toJson(CarAgency)));
        if (collection1.find(Filters.all("AgencyName", CarAgency.getAgencyName())).first() != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertHotel(hotel Hotel) throws RemoteException {
        collection1 = database.getCollection("hotel");
        collection1.insertOne(Document.parse(gson.toJson(Hotel)));
        if (collection1.find(Filters.all("HotelName", Hotel.getHotelName())).first() != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertAirline(airline Airline) {
        collection1 = database.getCollection("airline");
        collection1.insertOne(Document.parse(gson.toJson(Airline)));
        if (collection1.find(Filters.all("airlineName", Airline.getAirlineName())).first() != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteCarAgency(carAgency CA) {
        collection1 = database.getCollection("carAgency");
        if (collection1.deleteOne(Filters.eq("AgencyName", CA.getAgencyName())) != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean deleteHotel(hotel Hotel) throws RemoteException {
        collection1 = database.getCollection("hotel");
        if (collection1.deleteOne(Filters.eq("HotelName", Hotel.getHotelName())) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAirline(airline Airline) {
        collection1 = database.getCollection("airline");
        if (collection1.deleteOne(Filters.all("airlineName", Airline.getAirlineName())) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void updateCarAgency(carAgency CA, String name) {
        collection1 = database.getCollection("carAgency");
        collection1.updateOne(Filters.eq("AgencyName", name), Updates.set("AgencyName", CA.getAgencyName()));
    }

    public void updateHotel(hotel H, String name) throws RemoteException {
        collection1 = database.getCollection("hotel");
        collection1.updateOne(Filters.eq("HotelName", name), Updates.set("HotelName", H.getHotelName()));
    }

    public void updateAurline(airline A, String name) {
        collection1 = database.getCollection("hotel");
        collection1.updateOne(Filters.eq("airlineName", name), Updates.set("airlineName", A.getAirlineName()));
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

    public boolean addBooking(client c, booking b) throws RemoteException {
        if (b instanceof car) {
            car cc = (car) b;
            Document newBooking = new Document("client", c.getEmail()).append("bookingType", "car").append("totalPrice", (cc.getRentalPrice() + "")).append("description", cc.viewSummary(cc)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        } else if (b instanceof ticket) {
            ticket tt = (ticket) b;
            Document newBooking = new Document("client",  c.getEmail()).append("bookingType", "ticket").append("totalPrice", (tt.getPrice() + "")).append("description", tt.viewSummary(tt)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        } else if (b instanceof room) {
            room rr = (room) b;
            Document newBooking = new Document("client",  c.getEmail()).append("bookingType", "room").append("totalPrice", (rr.getPrice() + "")).append("description", rr.viewSummary(rr)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        } else if (b instanceof packageOffer) {
            packageOffer pp = (packageOffer) b;
            Document newBooking = new Document("client",  c.getEmail()).append("bookingType", "package").append("totalPrice", (pp.getPrice() + "")).append("description", pp.viewSummary(pp)).append("status", "pending");
            bookingCollection.insertOne(newBooking);
            return true;
        }

        return false;
    }

    public void close() {
        mongoClient.close();
    }
}
