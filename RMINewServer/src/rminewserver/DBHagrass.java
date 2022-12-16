/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.util.JSON;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.client;
/**
 *
 * @author meriam
 */
public class DBHagrass {
    public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> collection1;
  
   public static Gson gson = new Gson();
    
   
   public DBHagrass() 
    {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        mongoClient = new MongoClient();
        // Database name
        database = mongoClient.getDatabase("OnlineTourismSystem"); 
        // Collection 
        collection1 = database.getCollection("flightAgent");
   
    }
   public void insertStudent(client s) 
    {
        collection1.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Student is inserted.");
    }
   
   
   //read only
   public ArrayList<hotel> getAllHotels (){
       String json;
       ArrayList<hotel> hotels = new ArrayList<hotel>();
       hotel Hotel = new hotel();
       collection1 = database.getCollection("hotel");
//       collection1.insertOne(Document.parse(gson.toJson(Hotel)));
       MongoCursor cursor = collection1.find().iterator();
       while(cursor.hasNext()){
           json = gson.toJson(cursor.next());
           Hotel = gson.fromJson(json, hotel.class);
           hotels.add(Hotel);
       }
       return hotels;
   }
   
public ArrayList<airline> getAllAirlines (){
       String json;
       ArrayList<airline> airlines = new ArrayList<airline>();
       airline Airline = new airline();
       collection1 = database.getCollection("airline");
       collection1.insertOne(Document.parse(gson.toJson(Airline)));
       MongoCursor cursor = collection1.find().iterator();
       while(cursor.hasNext()){
           json = gson.toJson(cursor.next());
           Airline = gson.fromJson(json, airline.class);
           airlines.add(Airline);
       }
       return airlines;
   }

public ArrayList<carAgency> getAllCarAgencies (){
       String json;
       ArrayList<carAgency> carAgencies = new ArrayList<carAgency>();
       carAgency CarAgency = new carAgency();
       collection1 = database.getCollection("carAgency");
       collection1.insertOne(Document.parse(gson.toJson(CarAgency)));
       MongoCursor cursor = collection1.find().iterator();
       while(cursor.hasNext()){
           json = gson.toJson(cursor.next());
           CarAgency = gson.fromJson(json, carAgency.class);
           carAgencies.add(CarAgency);
       }
       return carAgencies;
   }

public boolean clientSignUp(client c) throws RemoteException{
    try{
        collection1 = database.getCollection("client");
        if(collection1.find(Filters.all("username", c.getUsername())).first() == null){
            if(collection1.find(Filters.all("password", c.getPassword())).first() == null){
                collection1.insertOne(Document.parse(gson.toJson(c)));
                if(collection1.find(Filters.all("password", c.getPassword())).first() != null){
                    return true;
                }
            }
        }
        return false;
    }catch(MongoException ex){
        throw new MongoException(500, "can not sign up");
    }
}

public boolean carAgentSignUp(carAgent cA){
    try{
        collection1 = database.getCollection("carAgent");
        if(collection1.find(Filters.all("username", cA.getUsername())).first() == null){
            if(collection1.find(Filters.all("password", cA.getPassword())).first() == null){
                collection1.insertOne(Document.parse(gson.toJson(cA)));
                if(collection1.find(Filters.all("password", cA.getPassword())).first() != null){
                    return true;
                }
            }
        }
        return false;
    }catch(MongoException ex){
        throw new MongoException(500, "can not sign up");
    }
}

public boolean hotelAgentSignUp(hotelAgent HA){
    try{
        collection1 = database.getCollection("hotelAgent");
        if(collection1.find(Filters.all("username", HA.getUsername())).first() == null){
            if(collection1.find(Filters.all("password", HA.getPassword())).first() == null){
                collection1.insertOne(Document.parse(gson.toJson(HA)));
                if(collection1.find(Filters.all("password", HA.getPassword())).first() != null){
                    return true;
                }
            }
        }
        return false;
    }catch(MongoException ex){
        throw new MongoException(500, "can not sign up");
    }
}

public boolean flightAgentSignUp(flightAgent FA){
    try{
        if(collection1.find(Filters.all("username", FA.getUsername())).first() == null){
            if(collection1.find(Filters.all("password", FA.getPassword())).first()== null){
                collection1.insertOne(Document.parse(gson.toJson(FA)));
                if(collection1.find(Filters.all("password", FA.getPassword())).first() != null){
                    return true;
                }
            }
        }
        return false;
    }catch(MongoException ex){
        throw new MongoException(500, "can not sign up");
    }
}

public Object clientLogin(String type,String password, String username){
    if("client".equals(type)){
        collection1 = database.getCollection("client");
        client Client;
        String json;
        if(collection1.find(Filters.all("password", password)).first() != null){
            if(collection1.find(Filters.all("username", username)).first() != null){
                Client = gson.fromJson(gson.toJson(collection1.find(Filters.all("password", password))), client.class);
                return Client;
            }
        }
    }else if("hotelAgent".equals(type)){
        collection1 = database.getCollection("hotelAgent");
        hotelAgent HotelAgent;
        String json;
        if(collection1.find(Filters.all("password", password)).first() != null){
            if(collection1.find(Filters.all("username", username)).first() != null){
                HotelAgent = gson.fromJson(gson.toJson(collection1.find(Filters.all("password", password))), hotelAgent.class);
                return HotelAgent;
            }
        }
    }else if("carAgent".equals(type)){
        collection1 = database.getCollection("carAgent");
        carAgent CarAgent;
        String json;
        if(collection1.find(Filters.all("password", password)).first() != null){
            if(collection1.find(Filters.all("username", username)).first() != null){
                CarAgent = gson.fromJson(gson.toJson(collection1.find(Filters.all("password", password))), carAgent.class);
                return CarAgent;
            }
        }
    }else if("flightAgent".equals(type)){
        collection1 = database.getCollection("flightAgent");
        flightAgent FlightAgent;
        String json;
        if(collection1.find(Filters.all("password", password)).first() != null){
            if(collection1.find(Filters.all("username", username)).first() != null){
                FlightAgent = gson.fromJson(gson.toJson(collection1.find(Filters.all("password", password))), flightAgent.class);
                return FlightAgent;
            }
        }
    }
    return null;
}

    /*Data mapper*/
    
    public boolean insertCarAgency(carAgency CarAgency){
        collection1 = database.getCollection("carAgency");
        collection1.insertOne(Document.parse(gson.toJson(CarAgency)));
        if(collection1.find(Filters.all("AgencyName", CarAgency.getAgencyName())).first() != null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insertHotel(hotel Hotel){
        collection1 = database.getCollection("hotel");
        collection1.insertOne(Document.parse(gson.toJson(Hotel)));
        if(collection1.find(Filters.all("HotelName", Hotel.getHotelName())).first() != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean insertAirline(airline Airline){
        collection1 = database.getCollection("airline");
        collection1.insertOne(Document.parse(gson.toJson(Airline)));
        if(collection1.find(Filters.all("airlineName", Airline.getAirlineName())).first() != null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteCarAgency(carAgency CA){
        collection1 = database.getCollection("carAgency");
        if(collection1.deleteOne(Filters.eq("AgencyName", CA.getAgencyName())) != null){
            return true;
        }else{
            return false;
        }
        
    }
    
    public boolean deleteHotel(hotel Hotel){
        collection1 = database.getCollection("hotel");
        if(collection1.deleteOne(Filters.eq("HotelName", Hotel.getHotelName())) != null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteAirline(airline Airline){
        collection1 = database.getCollection("airline");
        if(collection1.deleteOne(Filters.all("airlineName", Airline.getAirlineName())) != null){
            return true;
        }else{
            return false;
        }
    }
    
    public void updateCarAgency(carAgency CA, String name){
        collection1 = database.getCollection("carAgency");
        collection1.updateOne(Filters.eq("AgencyName", name), Updates.set("carAgent", CA.getCarAgent()));
        collection1.updateOne(Filters.eq("AgencyName", name), Updates.set("cars", CA.getCars()));
        collection1.updateOne(Filters.eq("AgencyName", name), Updates.set("AgencyName", CA.getAgencyName()));
    }
    
    public void updateHotel(hotel H, String name){
        collection1 = database.getCollection("hotel");
        collection1.updateOne(Filters.eq("HotelName", name), Updates.set("Rooms", H.getRooms()));
        collection1.updateOne(Filters.eq("HotelName", name), Updates.set("HotelName", H.getHotelName()));
    }  

    public void updateAurline(airline A, String name){
        collection1 = database.getCollection("hotel");
        collection1.updateOne(Filters.eq("airlineName", name), Updates.set("flights", A.getFlights()));
        collection1.updateOne(Filters.eq("airlineName", name), Updates.set("agent", A.getAgent()));
        collection1.updateOne(Filters.eq("airlineName", name), Updates.set("airlineName", A.getAirlineName()));
    }  

   /*/////////////////////////////////////////////////////////////////////////*/
   public void close() 
    {
        mongoClient.close();
    }
}
