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
import rminewclient.viewAirline;
import rminewclient.viewHotel;
/**
 *
 * 
 */
public class viewAirlineController {
    
    // We have reference to both the GUI and the rmi registry
    viewAirline gui;
    Registry r;
    JTable table = new JTable();
    // The constructor takes the gui and the rmi registry as paramaters
    public viewAirlineController(viewAirline gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        
        try{
            sysAirline c = (sysAirline)this.r.lookup("airline");
//            System.out.println(c.getCarAgencies());
            System.out.println(c.getAirlines().size());
            table = gui.getjTable1();
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            Object rowData[] = new Object[1];
            for(int i = 0; i < c.getAirlines().size(); i++){
                rowData[0] = c.getAirlines().get(i);
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
