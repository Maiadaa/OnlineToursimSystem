/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import rmi.person;


/**
 *
 * @author LENOVO
 */
public class flightAgent extends person{
    private int flightAgentID;
    private airline agency;

    public flightAgent(){
        super();
    }

    public flightAgent(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password,int flightAgentID, airline agency) {
        super(ID, Fname, Lname, gender, age, email, phone, address, username, password);
        this.flightAgentID = flightAgentID;
        this.agency = agency;
    }

    public int getFlightAgentID() {
        return flightAgentID;
    }

    public void setFlightAgentID(int flightAgentID) {
        this.flightAgentID = flightAgentID;
    }

    public airline getAgency() {
        return agency;
    }

    public void setAgency(airline agency) {
        this.agency = agency;
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getPassword() {
        return super.getPassword(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getUsername() {
        return super.getUsername(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getAddress() {
        return super.getAddress(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setPhone(String phone) {
        super.setPhone(phone); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getPhone() {
        return super.getPhone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getEmail() {
        return super.getEmail(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setAge(int age) {
        super.setAge(age); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getAge() {
        return super.getAge(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getGender() {
        return super.getGender(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setLname(String Lname) {
        super.setLname(Lname); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getLname() {
        return super.getLname(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setFname(String Fname) {
        super.setFname(Fname); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getFname() {
        return super.getFname(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setID(int ID) {
        super.setID(ID); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int getID() {
        return super.getID(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
}
