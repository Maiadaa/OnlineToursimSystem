/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;

/**
 *
 * @author PC
 */
public class customerSupport {
    public int custSupportID;
    
    public void handleComplaint(complaint c){
        if (c.getComplaintType().equals("Technical")){
            c.setComplaintState("Your complaint has been acceppted by out customer support team");
        }
    }
    
    
    
}
