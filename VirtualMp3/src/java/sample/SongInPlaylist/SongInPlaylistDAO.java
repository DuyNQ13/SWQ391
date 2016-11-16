/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.SongInPlaylist;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.utils.DBUtils;

/**
 *
 * @author quocbao0412
 */
public class SongInPlaylistDAO implements Serializable{
  public boolean addToPlaylist(int ID_Song, int ID_Playlist) throws ClassNotFoundException, SQLException{
    Connection con = null;
    PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "INSERT INTO SongInPlaylist VALUES (?,?)";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID_Song);
                stm.setInt(2, ID_Playlist);
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
  
  public boolean deleteFromPlaylist(int ID_Song, int ID_Playlist) throws ClassNotFoundException, SQLException{
    Connection con = null;
    PreparedStatement stm = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String sql = "Delete from SongInPlaylist where ID_Song = ? and ID_Playlist = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID_Song);
                stm.setInt(2, ID_Playlist);
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
