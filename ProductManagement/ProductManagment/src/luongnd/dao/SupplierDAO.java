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
import luongnd.db.MyConnection;
import luongnd.dto.SuppliersDTO;

/**
 *
 * @author Dell
 */
public class SupplierDAO implements Serializable {

    private Connection cnn;
    private PreparedStatement ps;
    private ResultSet rs;

    void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }

        if (ps != null) {
            ps.close();
        }
        if (cnn != null) {
            cnn.close();
        }
    }

    public ArrayList<SuppliersDTO> getSupplier() throws SQLException {
        ArrayList<SuppliersDTO> list = new ArrayList();
        try {
            String url = "Select supCode, supName, address, collaborating From tblSuppliers";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(url);
            rs = ps.executeQuery();
            SuppliersDTO dto;
            while (rs.next()) {
                dto = new SuppliersDTO(rs.getString("supCode"), rs.getString("supName"), rs.getString("address"), rs.getBoolean("collaborating"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public boolean checkDuplicate(ArrayList<SuppliersDTO> list, String code) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSupCode().equals(code)) {
                return true;
            }
        }
        return false;

    }
     public SuppliersDTO getSuppliersById(String id) throws Exception {
        String sql = "Select * From tblSuppliers Where supCode Like ? ";
        try {
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(sql);
            ps.setString(1, "%" + id + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SuppliersDTO sup = new SuppliersDTO(rs.getString("supCode"), rs.getString("supName"), rs.getString("address"), rs.getBoolean("collaborating"));
                return sup;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean checkBlank(String s) {
        if (s.length() == 0) {
            return true;
        }
        return false;
    }

    public SuppliersDTO findbyprimarykey(String id) throws SQLException {
        SuppliersDTO dto = null;
        try {
            String url = "Select supCode, supName, address, collaborating From tblSuppliers Where supCode=?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(url);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String Id = rs.getString("supCode");
                String name = rs.getString("supName");
                String address = rs.getString("address");
                boolean collaborating = rs.getBoolean("collaborating");
                dto = new SuppliersDTO(Id, name, address, collaborating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dto;
    }

    public boolean insert(SuppliersDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String url = "Insert Into tblSuppliers(supCode, supName, address, collaborating)" + "values(?,?,?,?)";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(url);
            ps.setString(1, dto.getSupCode());
            ps.setString(2, dto.getSupName());
            ps.setString(3, dto.getAddress());
            ps.setBoolean(4, dto.isCollaborating());
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String url = "Delete From tblSuppliers Where supCode=?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(url);
            ps.setString(1, id);
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(SuppliersDTO dto) {
        boolean check = false;
        try {
            String url = "Update tblSuppliers Set supName=?, address=?, collaborating=? WHERE supCode=?";
            cnn = MyConnection.getConnection();
            ps = cnn.prepareStatement(url);
            ps.setString(1, dto.getSupName());
            ps.setString(2, dto.getAddress());
            ps.setBoolean(3, dto.isCollaborating());
            ps.setString(4, dto.getSupCode());
            check = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

}
