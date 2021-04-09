/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luongnd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import luongnd.db.MyConnection;
import luongnd.dto.ItemDTO;
import luongnd.dto.SuppliersDTO;


/**
 *
 * @author Dell
 */
public class ItemDAO {
     private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    void closeConnection() throws SQLException{
       if(rs!=null){
            rs.close();
        }
        
        if(ps!=null){
            ps.close();
        }
        if(cnn!=null){
            cnn.close();
        }
        
    }
    
    public ArrayList<ItemDTO> getItem() throws SQLException{
        ArrayList<ItemDTO> list= new ArrayList();
        boolean supplying;
        try{
            String url="SELECT tblItems.itemCode , tblItems.itemName ,tblItems.unit , tblItems.price , tblItems.supplying , tblItems.supCode , tblSuppliers.supName  from tblItems INNER JOIN tblSuppliers on tblItems.supCode = tblSuppliers.supCode";
            cnn=MyConnection.getConnection();
            ps=cnn.prepareStatement(url);
            rs=ps.executeQuery();
            ItemDTO dto;
            while(rs.next()){
                String id = rs.getString(1);
                    String name = rs.getString(2);
                    String unit = rs.getString(3);
                    float price = rs.getFloat(4);
                    
                    if(rs.getBoolean(5)){
                        supplying=true;
                       
                    } else supplying=false;
                    
                    String subCode = rs.getString(6) + "-" + rs.getString(7);
                    list.add(new ItemDTO(id, name, unit,price ,supplying , subCode));
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            closeConnection();
        }
        return list;
    }
     
//    public ArrayList<ItemDTO> getAllItems() throws Exception {
//        String sql = "Select itemCode, itemName, unit, price, supplying, supCode From tblItems";
//        List<ItemDTO> list = new Vector<>();
//        try {
//            cnn = MyConnection.getConnection();
//            ps = cnn.prepareStatement(sql);
//            rs = ps.executeQuery();
//            SupplierDAO supDao = new SupplierDAO();
//            while (rs.next()) {
//                if (supDao.getSuppliersById(rs.getString("supCode")).getSupCode().equals(rs.getString("supCode"))) {
//                   // ItemDTO item = new ItemDTO(rs.getString("itemCode"), rs.getString("itemName"), rs.getString("unit"), rs.getInt("price"), rs.getBoolean("supplying"),, rs.getString("supCode"));
//                    ItemDTO item1= new ItemDTO(rs.getString("itemcode"), rs.getString("itemName"), rs.getString("unit"), rs.getFloat("price"), rs.getBoolean("supplying"), rs.getString("supCode"));
//                    item1.setSupCode(supDao.getSuppliersById(rs.getString("supCode")).getSupCode()+ "-" + supDao.getSuppliersById(rs.getString("supCode")).getSupName());
//                    list.add(item1);
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            closeConnection();
//        }
//        return  (ArrayList)list;
//    }
    
    public  boolean checkDuplicate(ArrayList<ItemDTO> list, String code){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getSupCode().equals(code))
                return true;
        }
            return false;
        
    }
     public boolean CheckItems(String code) throws Exception{
        String sql = "Select * from tblItems Where supCode = ?";
        try {
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, code);
            rs = ps.executeQuery();
            while(rs.next()){
                if(rs.getString("supCode").equals(code)){
                    return true;
                }
            }
        } finally{
            closeConnection();
        }
        return false;
    }
     public boolean checkBlank(String s){
        if(s.length()==0) return true;
        return false;
    }
     public boolean checkPrice(String s){
        if(s.matches("^[-]\\d*[.]?\\d*")) return true;
         return false;
     } 
    
    public ItemDTO findbyprimarykey(String id) throws SQLException{
        ItemDTO dto=null;
        try{
            String url="Select itemCode, itemName, unit, price, supplying, supCode From tblItems Where itemCode=?";
            cnn=MyConnection.getConnection();
            ps=cnn.prepareStatement(url);
            ps.setString(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
              String Id=rs.getString("itemCode");
              String name=rs.getString("itemName");
              String unit=rs.getString("unit");
              float price=rs.getFloat("price");
              boolean supplying=rs.getBoolean("supplying");
              String supCode=rs.getString("supCode");
              dto= new ItemDTO(Id,name,unit, price, supplying, supCode);
            }
        } catch(Exception e){
            e.printStackTrace();
        } 
        return dto;
    }
    
   public boolean insert(ItemDTO dto) throws Exception{
       boolean check= false;
       try{
            String url="Insert Into tblItems values(?,?,?,?,?,?) ";
           cnn=MyConnection.getConnection();
           ps=cnn.prepareStatement(url);
           ps.setString(1, dto.getItemCode());
           ps.setString(2, dto.getItemName());
           ps.setString(3, dto.getUnit());
           ps.setFloat(4, dto.getPrice());
           ps.setBoolean(5, dto.isSupplying());
           ps.setString(6, dto.getSupCode());
           check= ps.executeUpdate()>0;
       } finally {
           closeConnection();
       }
       return check;
   }
   
   public boolean update(ItemDTO dto) throws SQLException{
       boolean check= false;
       try{
          String url="Update tblItems Set itemName=?, unit=?, price=?, supplying=?, supCode=? WHERE itemCode=?";
          cnn=MyConnection.getConnection();
          ps=cnn.prepareStatement(url);
          ps.setString(1, dto.getItemName());
          ps.setString(2, dto.getUnit());
          ps.setFloat(3, dto.getPrice());
          ps.setBoolean(4, dto.isSupplying());
          ps.setString(5, dto.getSupCode());
          ps.setString(6, dto.getItemCode());
          check= ps.executeUpdate()>0;
       } catch(Exception e){
           e.printStackTrace();
       } finally{
           closeConnection();
       }
       return check;
   }
   
   public boolean delete(String id) throws SQLException, ClassNotFoundException{
       boolean check= false;
       try{
           String url="Delete From tblItems WHERE itemCode=?";
           cnn=MyConnection.getConnection();
           ps=cnn.prepareStatement(url);
           ps.setString(1, id);
           check= ps.executeUpdate()>0 ;
       } finally{
           closeConnection();
       }
       return check;
   }
   
}
