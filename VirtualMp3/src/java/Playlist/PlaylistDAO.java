/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Playlist;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import song.SongDAO;
import song.SongDTO;
import utils.DBUtils;

/**
 *
 * @author quocbao0412
 */
public class PlaylistDAO implements Serializable{
  public boolean createPlaylist(PlaylistDTO dto) throws ClassNotFoundException, SQLException {
     Connection con = null;
     PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "INSERT INTO Playlist VALUES (?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setInt(2, dto.getNumOfLike());
                stm.setInt(3, dto.getNumOfListen());
                stm.setString(4, dto.getCover());
                stm.setInt(5, dto.getID_User());
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
  
  public boolean deletePlaylist(PlaylistDTO dto) throws SQLException, NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "DELETE FROM Playlist WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, dto.getID());
                
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
 
  
  public ArrayList<PlaylistDTO> listPlaylist;

  public ArrayList<PlaylistDTO> getListPlaylist() {
    return listPlaylist;
  }
 
  
  public void searchPlaylist(String playlistName) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Playlist Where Name LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, playlistName);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int ID = rs.getInt("ID");
                    String name = rs.getString("Name");
                    int numOfLike = rs.getInt("NumOfLike");
                    int numOfListen = rs.getInt("NumOfListen");
                    String cover = rs.getString("Cover");
                    int ID_User = rs.getInt("ID_User");
                    PlaylistDTO dto = new PlaylistDTO(ID, name, numOfLike, numOfListen, cover, ID_User);
                    if (listPlaylist.isEmpty()) {
                    listPlaylist = new ArrayList<>();
                    }
                    listPlaylist.add(dto);
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
        
        
    }
  
  
}
