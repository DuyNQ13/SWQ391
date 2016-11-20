/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package songInPlaylist;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Playlist.PlaylistDTO;
import song.SongDTO;
import utils.DBUtils;

/**
 *
 * @author quocbao0412
 */
public class SongInPlaylistDAO implements Serializable {

    public boolean addToPlaylist(int ID_Song, int ID_Playlist) throws ClassNotFoundException, SQLException {
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

    public boolean deleteFromPlaylist(int ID_Song, int ID_Playlist) throws ClassNotFoundException, SQLException {
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

    public ArrayList<SongDTO> listOfSong;

    public ArrayList<SongDTO> getListOfSong() {
        return listOfSong;
    }

    public void loadSongFromPlaylist(int ID_Playlist) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From SongInPlaylist a, Song s Where a.ID_Playlist = ? and s.ID = a.ID_Song";
                stm = con.prepareStatement(sql);
                stm.setInt(1, ID_Playlist);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int ID_Song = rs.getInt("ID_Song");
                    String song = rs.getString("Song");
                    String singer = rs.getString("Singer");
                    int numOfLike = rs.getInt("NumOfLike");
                    int numOfListen = rs.getInt("NumOfListen");
                    String cover = rs.getString("Cover");
                    String link = rs.getString("Link");
                    int ID_User = rs.getInt("ID_User");
                    SongDTO dto = new SongDTO(ID_Song, song, singer, numOfLike, numOfListen, cover, link, ID_User);
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
}
