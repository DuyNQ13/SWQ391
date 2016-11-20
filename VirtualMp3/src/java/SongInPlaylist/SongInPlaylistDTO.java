/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.SongInPlaylist;

import java.io.Serializable;

/**
 *
 * @author quocbao0412
 */
public class SongInPlaylistDTO implements Serializable{
  private int ID;
  private int ID_Song;
  private int ID_Playlist;

  public SongInPlaylistDTO(int ID, int ID_Song, int ID_Playlist) {
    this.ID = ID;
    this.ID_Song = ID_Song;
    this.ID_Playlist = ID_Playlist;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getID_Song() {
    return ID_Song;
  }

  public void setID_Song(int ID_Song) {
    this.ID_Song = ID_Song;
  }

  public int getID_Playlist() {
    return ID_Playlist;
  }

  public void setID_Playlist(int ID_Playlist) {
    this.ID_Playlist = ID_Playlist;
  }
  
  
}
