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
public class ItemDTO extends SuppliersDTO {
    public String itemCode;
    public String itemName;
    public String unit;
    public float price;
    public boolean supplying;
    public String supCode;

    public ItemDTO(String itemCode, String itemName, String unit, float price, boolean supplying, String supCode) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.price = price;
        this.supplying = supplying;
        this.supCode = supCode;
    }
    
    public ItemDTO(){
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSupplying() {
        return supplying;
    }

    public void setSupplying(boolean supplying) {
        this.supplying = supplying;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }
    
    public Vector toVector(){
        Vector v= new Vector();
        v.add(itemCode);
        v.add(itemName);
        v.add(unit);
        v.add(price);
        v.add(supplying);
        v.add(supCode);
        return v;
    }
}
