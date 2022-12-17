package rmi;

import rminewclient.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import rmi.booking;

public class client extends UnicastRemoteObject implements observer_interface{
    private int ID;
    private String Fname;
    private String Lname;
    private String gender;
    private int age;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String password;
    private sysCarAgency syscarAgency;
    private sysHotel syshotel;
    private sysAirline sysairline;
    
    private int client_card_number;
    private ArrayList <booking> booking_History = new ArrayList<booking>();
    
    private booking book;
    private payment_method payement;


    public client() throws RemoteException{
    }

    public client(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password, int client_card_number, booking book, payment_method payement) throws RemoteException {
        this.ID = ID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.client_card_number = client_card_number;
        this.book = book;
        this.payement = payement;
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

    public payment_method getPayement() {
        return payement;
    }

    public void setPayement(payment_method payement) {
        this.payement = payement;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    //functions
    public String manage_Account (client Client){
        
        return "x";
    }
    
    public void Subscribe(client c)
    {
        
    }
    
    @Override
    public void Update(String msg) {
        System.out.println(msg);
    }
    
    public ArrayList<Object> getAirlines() throws RemoteException {
        return sysairline.getAirlines();
    }

    public ArrayList<Object> getCarAgencies() throws RemoteException {
        return syscarAgency.getCarAgencies();
    }

    public ArrayList<Object> getHotels() throws RemoteException {
        return syshotel.getHotels();
    }
    
    
}
