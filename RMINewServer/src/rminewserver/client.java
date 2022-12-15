package rminewserver;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class client extends person implements observer_interface{

    private int client_card_number;
    private ArrayList <booking> booking_History = new ArrayList<booking>();
    private booking book;
    private ArrayList <complaint> complaint_history = new ArrayList <complaint>();
    private payment_method payement;
    private sysCarAgency sysCarAgencies;
    private sysHotel sysHotels;
    private sysAirline sysAirlines;
    private DBAssem db = new DBAssem();

    @Override
    public void Update(String msg) {
        System.out.println(msg);
    }

    public client() throws RemoteException{
        super();
    }
    

    public client(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password, int client_card_number, booking book, payment_method payement, sysCarAgency sysCarAgencies, sysHotel sysHotels, sysAirline sysAirlines) throws RemoteException {
        super(ID, Fname, Lname, gender, age, email, phone, address, username, password);
        this.client_card_number = client_card_number;
        this.book = book;
        this.payement = payement;
        this.sysCarAgencies = sysCarAgencies;
        this.sysHotels = sysHotels;
        this.sysAirlines = sysAirlines;
    }

    public client(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException {
        super(ID, Fname, Lname, gender, age, email, phone, address, username, password);
        client tempclient = new client();
        tempclient = this;
        insertClientIntoDB(tempclient);
    }
    public void insertClientIntoDB(client c)
    {
        db.insertClient(c);
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
    public void Subscribe(client c)
    {
        
    }
    
    //functions
    public String manage_Account (client Client){
        
        return "x";
    }
    
    
}
