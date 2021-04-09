/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luongnd.dto;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Dell
 */
public class SuppliersDTO implements Serializable {
    public String supCode;
    public String supName;
    public String address;
    public boolean collaborating;

    public SuppliersDTO(String supCode, String supName, String address, boolean collaborating) {
        this.supCode = supCode;
        this.supName = supName;
        this.address = address;
        this.collaborating = collaborating;
    }

    public SuppliersDTO() {
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCollaborating() {
        return collaborating;
    }

    public void setCollaborating(boolean collaborating) {
        this.collaborating = collaborating;
    }
    
    public Vector toVector(){
        Vector v= new Vector();
        v.add(supCode);
        v.add(supName);
        v.add(address);
        v.add(collaborating);
        return v;
    } 
}
