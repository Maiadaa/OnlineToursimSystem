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
import rmi.client;
/**
 *
 * 
 */
public class viewCarAgenciesController {
    
    // We have reference to both the GUI and the rmi registry
    viewCarAgencies gui;
    Registry r;
    JTable table = new JTable();
    client c = new client();
    // The constructor takes the gui and the rmi registry as paramaters
    public viewCarAgenciesController(viewCarAgencies gui, Registry r)
    {
        this.gui = gui;
        this.r = r;
        
        try{
            
            c = (client) r.lookup("client");
            
        } catch (RemoteException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table = gui.getjTable1();
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        Object rowData[] = new Object[1];
        for(int i = 0; i < c.){}
        rowData[0] = "1";
        model.addRow(rowData);
        rowData[0] = "2";
        model.addRow(rowData);
        
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
