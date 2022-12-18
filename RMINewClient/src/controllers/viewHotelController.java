package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rmi.*;
import rminewclient.bookRoomWindow;
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
    client c = new client();
    // The constructor takes the gui and the rmi registry as paramaters
    public viewHotelController(viewHotel gui, Registry r, client C)throws RemoteException, NotBoundException
    {
        this.c = C;
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
            Logger.getLogger(viewHotelController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(viewHotelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
        gui.setjTable1(table);
        gui.getBack().addActionListener(new backbtn());
                gui.getBack().addActionListener(new showbtn());

    }
    
    class showbtn implements ActionListener {

        // Whatever written inside this function will execute when the button is clicked
        @Override
        public void actionPerformed(ActionEvent ae) {
            //call menu assem
            bookRoomWindow gui2 = new bookRoomWindow();
            bookRoomWindowController book = new bookRoomWindowController(gui2, r, "m", gui.getAgencyTextBox().getText());
            gui.dispose();
        }

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
