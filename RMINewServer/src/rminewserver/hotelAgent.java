/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.rmi.RemoteException;

public class hotelAgent extends person{
    private int HotelAgentID;
    private hotel hotel;

    public hotelAgent(int HotelAgentID, hotel hotel, int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException {
        super(ID, Fname, Lname, gender, age, email, phone, address, username, password);
        this.HotelAgentID = HotelAgentID;
        this.hotel = hotel;
    }

    public void setHotelAgentID(int HotelAgentID) {
        this.HotelAgentID = HotelAgentID;
    }

    public void setHotel(hotel hotel) {
        this.hotel = hotel;
    }

    public int getHotelAgentID() {
        return HotelAgentID;
    }

    public hotel getHotel() {
        return hotel;
    }
    
}
