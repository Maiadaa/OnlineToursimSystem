/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.util.ArrayList;

public class hotel 
{
    private int HotelID;
    private ArrayList<room> Rooms;
    private String HotelName;

    public hotel() {
    }

    public hotel(int HotelID, ArrayList<room> Rooms, String HotelName) {
        this.HotelID = HotelID;
        this.Rooms = Rooms;
        this.HotelName = HotelName;
    }

    public hotel(int HotelID, String HotelName) {
        this.HotelID = HotelID;
        this.HotelName = HotelName;
    }

    
    
    public void setHotelID(int HotelID) {
        this.HotelID = HotelID;
    }

    public void setRooms(ArrayList<room> Rooms) {
        this.Rooms = Rooms;
    }

    public void setHotelName(String HotelName) {
        this.HotelName = HotelName;
    }

    public int getHotelID() {
        return HotelID;
    }

    public ArrayList<room> getRooms() {
        return Rooms;
    }

    public String getHotelName() {
        return HotelName;
    }
    
    
    
}
