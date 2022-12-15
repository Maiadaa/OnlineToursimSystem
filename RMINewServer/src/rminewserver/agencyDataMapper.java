package rminewserver;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.util.JSON;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class agencyDataMapper {
    
   public static MongoClient mongoClient;
    
   public static MongoDatabase database;
    
   MongoCollection<Document> collection1;
  
   public static Gson gson = new Gson();
    
    private sysAgency sysAgencies;
    
//  function
    
    public boolean insertCarAgyncy(carAgency CarAgency){
        
        return true;
    }
    
    public boolean insertHotel(){
        return true;
    }
    
    public boolean insertAirline(){
        return true;
    }
    
    public boolean deleteCarAgency(){
        return true;
    }

    public boolean deleteHotel(){
        return true;
    }
    
    public boolean deleteAirline(){
        return true;
    }
    
    public boolean modifyCarAgency(){
        return true;
    }
    
    public boolean modifyHotel(){
        return true;
    }
    
    public boolean modifyAirline(){
        return true;
    }
}
