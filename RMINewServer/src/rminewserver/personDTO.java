/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rminewserver;
import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class personDTO implements Serializable{
    private String Phone;
    private String address;
    private String username;
    private String password;
    
    public personDTO (String Phone, String address, String username, String password){
        this.Phone = Phone;
        this.address = address;
        this.username = username;
        this.password = password;
}

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
