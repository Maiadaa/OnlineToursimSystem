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
public class complaint {
    private ObjectId ComplaintID;
    private String ComplaintType;   
    private String Description;
    private String ComplaintDate;
    private String ComplaintState;
    private complaint_detector handler;
    
    
    public void handleComplaint(){
        
    }

    public complaint() {
    }

    public complaint(ObjectId ComplaintID, String ComplaintType, String Description, String ComplaintDate, String ComplaintState, complaint_detector handler) throws RemoteException {
        this.ComplaintID = ComplaintID;
        this.ComplaintType = ComplaintType;
        this.Description = Description;
        this.ComplaintDate = ComplaintDate;
        this.ComplaintState = ComplaintState;
        this.handler = handler;
        Set_POC();
    }

    public ObjectId getComplaintID() {
        return ComplaintID;
    }

    public void setComplaintID(ObjectId ComplaintID) {
        this.ComplaintID = ComplaintID;
    }

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

    public complaint_detector getHandler() {
        return handler;
    }

    public void setHandler(complaint_detector handler) {
        this.handler = handler;
    }
    
    
    public void Set_POC() throws RemoteException{
          handler = new admin();
	}
}
