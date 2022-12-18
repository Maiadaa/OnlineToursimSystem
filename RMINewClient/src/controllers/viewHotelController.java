package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.GradeInterface;
import rminewclient.viewCarAgencies;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rmi.*;
import rminewclient.viewHotel;
/**
 *
 * 
 */
public class viewHotelController {
    
    // We have reference to both the GUI and the rmi registry
    viewHotel gui;
    Registry r;
    JTable table = new JTable();
    // The constructor takes the gui and the rmi registry as paramaters
    public viewHotelController(viewHotel gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        
        try{
            sysHotel c = (sysHotel)this.r.lookup("hotel");
//            System.out.println(c.getCarAgencies());
System.out.println(c.getHotels().size());
            table = gui.getjTable1();
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            Object rowData[] = new Object[1];
            for(int i = 0; i < c.getHotels().size(); i++){
                rowData[0] = c.getHotels().get(i);
                model.addRow(rowData);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        gui.setjTable1(table);
    }
    
    
    // This class is responsible for handling the button click
    class GetGradeBtnAction implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    
}