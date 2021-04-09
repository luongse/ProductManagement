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
public class UserDTO implements Serializable{
    public String userId;
    public String userName;
    public String userPassword;
    public boolean status;

    public UserDTO(String fullname, String password) {
        this.userId=fullname;
        this.userPassword= password;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    public Vector toVector(){
        Vector v= new Vector();
        v.add(userId);
        v.add(userName);
        v.add(status);
        return v;
    }
}