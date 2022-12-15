package rminewserver;

import java.util.ArrayList;

public class client extends person{

    private int client_card_number;
    private ArrayList <booking> booking_History = new ArrayList<booking>();
    private booking book;
    private ArrayList <complaint> complaint_history = new ArrayList <complaint>();
    private payment_method payement;
    private sysCarAgency sysCarAgencies;
    private sysHotel sysHotels;
    private sysAirline sysAirlines;

    public client() {
    }

    public client(int client_card_number, booking book, payment_method payement, sysCarAgency sysCarAgencies, sysHotel sysHotels, sysAirline sysAirlines) {
        this.client_card_number = client_card_number;
        this.book = book;
        this.payement = payement;
        this.sysCarAgencies = sysCarAgencies;
        this.sysHotels = sysHotels;
        this.sysAirlines = sysAirlines;
    }

    public int getClient_card_number() {
        return client_card_number;
    }

    public void setClient_card_number(int client_card_number) {
        this.client_card_number = client_card_number;
    }

    public ArrayList<booking> getBooking_History() {
        return booking_History;
    }

    public void setBooking_History(ArrayList<booking> booking_Hisotry) {
        this.booking_History = booking_Hisotry;
    }

    public booking getBook() {
        return book;
    }

    public void setBook(booking book) {
        this.book = book;
    }

    public ArrayList<complaint> getComplaint_history() {
        return complaint_history;
    }

    public void setComplaint_history(ArrayList<complaint> complaint_history) {
        this.complaint_history = complaint_history;
    }

    public payment_method getPayement() {
        return payement;
    }

    public void setPayement(payment_method payement) {
        this.payement = payement;
    }

    public sysCarAgency getSysCarAgencies() {
        return sysCarAgencies;
    }

    public void setSysCarAgencies(sysCarAgency sysCarAgencies) {
        this.sysCarAgencies = sysCarAgencies;
    }

    public sysHotel getSysHotels() {
        return sysHotels;
    }

    public void setSysHotels(sysHotel sysHotels) {
        this.sysHotels = sysHotels;
    }

    public sysAirline getSysAirlines() {
        return sysAirlines;
    }

    public void setSysAirlines(sysAirline sysAirlines) {
        this.sysAirlines = sysAirlines;
    }
    

    
    //functions
    public String manage_Account (client Client){
        
        return "x";
    }
    
    public boolean update(){
        
        return true;
    }
}
