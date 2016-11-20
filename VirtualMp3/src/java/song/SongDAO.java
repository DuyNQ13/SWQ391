/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package song;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author quocbao0412
 */
public class SongDAO implements Serializable{
  public boolean insertSong(SongDTO song) throws SQLException, NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "INSERT INTO Song VALUES (?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, song.getSong());
                stm.setString(2, song.getSinger());
                stm.setInt(3, song.getNumOfLike());
                stm.setInt(4, song.getNumOfListen());
                stm.setString(5, song.getCover());
                stm.setString(6, song.getLink());
                
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
  
  public boolean deleteSong(SongDTO song) throws SQLException, NamingException, ClassNotFoundException{
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "DELETE FROM Song WHERE ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, song.getID());
                
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
  
  private List<SongDTO> listOfSong;
    public List<SongDTO> getCategory() {
        return listOfSong;
    }
    
    
  public void searchListOfSong(String name) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Song Where Song LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int ID = rs.getInt("ID");
                    String song = rs.getString("Song");
                    String singer = rs.getString("Singer");
                    int numOfLike = rs.getInt("NumOfLike");
                    int numOfListen = rs.getInt("NumOfListen");
                    String cover = rs.getString("Cover");
                    String link = rs.getString("Link");
                    int ID_User = rs.getInt("ID_User");
                    SongDTO dto = new SongDTO(ID, song, singer, numOfLike, numOfListen, cover, link, ID_User);
                    if (listOfSong.isEmpty()) {
                      listOfSong = new ArrayList<>();
                      
                    }
                    listOfSong.add(dto);
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
  
  public SongDTO loadSong(int ID_Song) throws SQLException, NamingException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Song Where ID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID_Song);
                rs = stm.executeQuery();
                if (rs.next()) {
                    int ID = rs.getInt("ID");
                    String song = rs.getString("Song");
                    String singer = rs.getString("Singer");
                    int numOfLike = rs.getInt("NumOfLike");
                    int numOfListen = rs.getInt("NumOfListen");
                    String cover = rs.getString("Cover");
                    String link = rs.getString("Link");
                    int ID_User = rs.getInt("ID_User");
                    SongDTO dto = new SongDTO(ID, song, singer, numOfLike, numOfListen, cover, link, ID_User);
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
  
  public boolean like(int ID_Song) throws SQLException, ClassNotFoundException, NamingException{
    Connection con = null;
    PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "UPDATE Song\n" +
                              "SET NumOfLike = ?\n" +
                              "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                SongDTO dto = loadSong(ID_Song);
                stm.setInt(1, dto.getNumOfLike() + 1);
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
  
  public boolean listen(int ID_Song) throws SQLException, ClassNotFoundException, NamingException{
    Connection con = null;
    PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "UPDATE Song\n" +
                              "SET NumOfListen = ?\n" +
                              "WHERE ID = ?";
                stm = con.prepareStatement(sql);
                SongDTO dto = loadSong(ID_Song);
                stm.setInt(1, dto.getNumOfListen() + 1);
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
}
