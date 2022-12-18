package rminewserver;

import java.io.Serializable;
import java.util.ArrayList;

public class airline {
    private int airlineID;
    private String airlineName;
//    private ArrayList<flight> flights;

    public airline() {
    }

    public airline(int airlineID, String airlineName, ArrayList<flight> flights) {
        this.airlineID = airlineID;
        this.airlineName = airlineName;
//        this.flights = flights;
    }

    public int getAirlineID() {
        return airlineID;
    }

    public void setAirlineID(int airlineID) {
        this.airlineID = airlineID;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

//    public ArrayList<flight> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(ArrayList<flight> flights) {
//        this.flights = flights;
//    }

    @Override
    public String toString() {
        return airlineName;
    }
    
}