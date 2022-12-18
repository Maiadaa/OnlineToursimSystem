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
    
      
    public client(String Fname, String email, String username) throws RemoteException {
        this.Fname = Fname;
        this.email = email;
        this.username = username;
    }

    public int getClient_card_number() throws RemoteException{
        return client_card_number;
    }

    public void setClient_card_number(int client_card_number) throws RemoteException{
        this.client_card_number = client_card_number;
    }

    public ArrayList<booking> getBooking_History() {
        return booking_History;
    }

    public void setBooking_History(ArrayList<booking> booking_Hisotry) throws RemoteException{
        this.booking_History = booking_Hisotry;
    }

    public booking getBook() throws RemoteException{
        return book;
    }

    public void setBook(booking book) throws RemoteException{
        this.book = book;
    }

    public payment_method getPayement() throws RemoteException{
        return payement;
    }

    public void setPayement(payment_method payement)throws RemoteException {
        this.payement = payement;
    }

    public int getID() throws RemoteException{
        return ID;
    }

    public void setID(int ID) throws RemoteException{
        this.ID = ID;
    }

    public String getFname() throws RemoteException{
        return Fname;
    }

    public void setFname(String Fname) throws RemoteException{
        this.Fname = Fname;
    }

    public String getLname() throws RemoteException{
        return Lname;
    }

    public void setLname(String Lname)throws RemoteException {
        this.Lname = Lname;
    }

    public String getGender()throws RemoteException {
        return gender;
    }

    public void setGender(String gender) throws RemoteException{
        this.gender = gender;
    }

    public int getAge()throws RemoteException {
        return age;
    }

    public void setAge(int age) throws RemoteException{
        this.age = age;
    }

    public String getEmail() throws RemoteException{
        return email;
    }

    public void setEmail(String email)throws RemoteException {
        this.email = email;
    }

    public String getPhone() throws RemoteException{
        return phone;
    }

    public void setPhone(String phone) throws RemoteException{
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address)throws RemoteException {
        this.address = address;
    }

    public String getPassword() throws RemoteException{
        return password;
    }

    public void setPassword(String password)throws RemoteException {
        this.password = password;
    }

    
    //functions
    public String manage_Account (client Client)throws RemoteException{
        
        return "x";
    }
    
    public void Subscribe(client c)throws RemoteException
    {
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
    @Override
    public void Update(String msg)throws RemoteException {
        System.out.println(msg);
    }
    
    public ArrayList<String> getAirlines() throws RemoteException {
        return sysairline.getAirlines();
    }

    public ArrayList<String> getCarAgencies() throws RemoteException {
        return syscarAgency.getCarAgencies();
    }

    public ArrayList<String> getHotels() throws RemoteException {
        return syshotel.getHotels();
    }
    
    
}
