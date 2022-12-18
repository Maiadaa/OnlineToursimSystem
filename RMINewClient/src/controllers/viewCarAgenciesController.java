package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.GradeInterface;
import rminewclient.viewCarAgencies;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rmi.*;
/**
 *
 * 
 */
public class viewCarAgenciesController {
    
    // We have reference to both the GUI and the rmi registry
    viewCarAgencies gui;
    Registry r;
    JTable table = new JTable();
    client c;
    // The constructor takes the gui and the rmi registry as paramaters
    public viewCarAgenciesController(viewCarAgencies gui, Registry r, client C) throws RemoteException, NotBoundException
    {
        this.c = C;
        this.gui = gui;
        this.r = r;
        
        try{
            sysCarAgency c = (sysCarAgency) r.lookup("carAgency");
            System.out.println(Arrays.toString(r.list()));
//            System.out.println(c.getCarAgencies());
            table = gui.getjTable1();
            DefaultTableModel model;
            model = (DefaultTableModel) table.getModel();
            Object rowData[] = new Object[1];
            for(int i = 0; i < c.getCarAgencies().size(); i++){
                rowData[0] = c.getCarAgencies().get(i);
                model.addRow(rowData);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        gui.setjTable1(table);
        gui.getBack().addActionListener(new backbtn());
    }
    
    // This class is responsible for handling the button click
    class backbtn implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            //call menu assem
            gui.dispose();
        }
        
    }
    
}
