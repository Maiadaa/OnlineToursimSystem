/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.rmi.RemoteException;
import rmi.person;

/**
 *
 * @author PC
 */
public class admin extends person implements complaint_detector{

    public admin() throws RemoteException {
    }

    public admin(int ID, String Fname, String Lname, String gender, int age, String email, String phone, String address, String username, String password) throws RemoteException {
        super(ID, Fname, Lname, gender, age, email, phone, address, username, password);
    }

    public admin(String phone, String address, String username, String password) throws RemoteException {
        super(phone, address, username, password);
    }
    
    
    
    public void ViewComplaints(complaint c){
        
    }
    public void HandleComplaints(complaint c){
        
    }
    public void GenerateReport(){
        
    }
    
    public void setNextinchain(admin x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void handleComplaint(complaint c){
        if (c.getComplaintType().equals("Other")){
            c.setComplaintState("Your complaint has been acceppted by one of out admins");
        }
    }
    
    public void viewComplaints(complaint c){
        
    }
//    @Override
//    public void Handle_Feedback(Feedback f) {
//        if (f.getFeedback_Type().equals("rating")) {
//            f.setFeedback_State("Accepted from Restaurant Admin");
//            DB_Connection_Hagrass db = new DB_Connection_Hagrass();
//            db.EditFeedbackStatus(f);
//            if (f.getRate() <= 3) {
//                    db.editRestRating(Rest.getRest_Id(), (Rest.getRest_Rating() - 0.1));
//            }else if(f.getRate() > 3){
//                    db.editRestRating(Rest.getRest_Id(), (Rest.getRest_Rating() + 0.1));
//            }
//        }

    @Override
    public void Handle_complaint(complaint c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}
