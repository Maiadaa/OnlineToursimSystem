/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rminewserver;

/**
 *
 * @author mahmo
 */
public interface subject_interface 
{
    public void addObserver(client observer);
    public void removeObserver (client observer);
    public void notifyObservers();
}
