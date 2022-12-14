package rminewserver;

import java.util.ArrayList;

public class client extends person{

    private int client_card_number;
    private ArrayList <booking> booking_Hisotry = new ArrayList<booking>();
    private booking book;
    private ArrayList <complaint> complaint_history = new ArrayList <complaint>();
    private payment_method payement;
    private sysCarAgency sysCarAgencies;
    private sysHotel sysHotels;
    private sysAirline sysAirlines;

    public client(int client_card_number, booking book, payment_method payement, sysCarAgency sysCarAgencies, sysHotel sysHotels, sysAirline sysAirlines) {
        this.client_card_number = client_card_number;
        this.book = book;
        this.payement = payement;
        this.sysCarAgencies = sysCarAgencies;
        this.sysHotels = sysHotels;
        this.sysAirlines = sysAirlines;
    }
    
    
    
    //setters
    
    //getters
    
    //functions
    public String manage_Account (client Client){
        
        return "x";
    }
    
    public boolean update(){
        
        return true;
    }
}
