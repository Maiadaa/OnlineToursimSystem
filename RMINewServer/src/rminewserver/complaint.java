/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

import java.rmi.RemoteException;
import org.bson.types.ObjectId;

/**
 *
 * @author PC
 */
public class complaint implements complaint_detector{
    private int ComplaintID;
    private String ComplaintType;   
    private String Description;
    private String ComplaintDate;
    private String ComplaintState;
    
    
    
    public void handleComplaint(){
        
    }

    public complaint() {
    }

    public complaint( String ComplaintType, String Description, String ComplaintDate, String ComplaintState) throws RemoteException {
        
        this.ComplaintType = ComplaintType;
        this.Description = Description;
        this.ComplaintDate = ComplaintDate;
        this.ComplaintState = ComplaintState;
    }

    public int getComplaintID() {
        return ComplaintID;
    }

//    public void setComplaintID(ObjectId ComplaintID) {
//        this.ComplaintID = ComplaintID;
//    }

    public String getComplaintType() {
        return ComplaintType;
    }

    public void setComplaintType(String ComplaintType) {
        this.ComplaintType = ComplaintType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getComplaintDate() {
        return ComplaintDate;
    }

    public void setComplaintDate(String ComplaintDate) {
        this.ComplaintDate = ComplaintDate;
    }

    public String getComplaintState() {
        return ComplaintState;
    }

    public void setComplaintState(String ComplaintState) {
        this.ComplaintState = ComplaintState;
    }

//    public complaint_detector getHandler() {
//        return handler;
//    }
//
//    public void setHandler(complaint_detector handler) {
//        this.handler = handler;
//    }
//    
//    
//    public void Set_POC() throws RemoteException{
//          handler = new admin();
//	}

    @Override
    public void Handle_complaint(complaint c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
