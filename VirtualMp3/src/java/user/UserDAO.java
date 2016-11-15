/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author quocbao0412
 */
public class UserDAO implements Serializable{
   public UserDTO checkLogin(String username, String password) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From User Where Username = ? and Password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
 
                if (rs.next()) {
                    int ID = rs.getInt("ID");
                    String un = rs.getString("Username");
                    String avatar = rs.getString("avatar");
                    String pass = rs.getString("Password");
                    UserDTO dto = new UserDTO(ID, un, avatar, pass);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
           
        }
        return null;
    }
   
   
   public boolean checkUsername(String username) throws NamingException, SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From User Where Username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                
                rs = stm.executeQuery();
 
                if (rs.next()) {
                    return true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
           
        }
        return false;
    }
   
    public boolean insertUser(UserDTO user) throws SQLException, NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "INSERT INTO User VALUES (?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, user.getUsername());
                stm.setString(2, user.getAvatar());
                stm.setString(3, user.getPassword());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }              
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
     public boolean changePassword(UserDTO user) throws SQLException, NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "UPDATE User\n" +
                              "SET Password = ?\n" +
                              "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(2, user.getPassword());
                stm.setInt(3, user.getID());
                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }              
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
