/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luongnd.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import luongnd.db.MyConnection;
import luongnd.dto.UserDTO;

/**
 *
 * @author Dell
 */
public class UserDAO implements Serializable{
   private List<UserDTO> listAccount;

    public UserDAO() throws ClassNotFoundException {
        try {
            loadData();
             
        } catch (SQLException e) {
            System.out.println("Error Connection");
        }catch(NamingException ex){
            System.out.println("Error Connection");
        }
    }
    public void loadData() throws SQLException,NamingException, ClassNotFoundException{
        Connection con=null;
        PreparedStatement prestm= null;
        ResultSet rs= null;
        if(this.listAccount==null){
            this.listAccount= new ArrayList<>();
            
        }
        try {
            con=MyConnection.getConnection();
                                ;
            if(con!=null){
                String sql="select userID,password From tblUsers";
                prestm=con.prepareStatement(sql);
                rs=prestm.executeQuery();
                while(rs.next()){
                    String id= rs.getString("userID");
                    String password=rs.getString("password");
                    UserDTO dto= new UserDTO (id, password);
                    this.listAccount.add(dto);
                }
                
            }
            
        } finally {
            if(rs!=null) rs.close();
            if(prestm!=null) prestm.close();
            if(con!=null) con.close();
        }
        
    }
    public boolean checkLogin(String userName, String password){
        for(int i=0;i<listAccount.size();i++){
            if(listAccount.get(i).getUserId().equals(userName) && listAccount.get(i).getUserPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean checkBlank(String s){
        if(s.length()==0) return true;
        return false;
    }
}
