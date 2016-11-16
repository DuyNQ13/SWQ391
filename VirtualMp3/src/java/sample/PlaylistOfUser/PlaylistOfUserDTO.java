/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.PlaylistOfUser;

import java.io.Serializable;

/**
 *
 * @author quocbao0412
 */
public class PlaylistOfUserDTO implements Serializable{
  private int ID;
  private int ID_User;
  private int ID_Playlist;

  public PlaylistOfUserDTO(int ID, int ID_User, int ID_Playlist) {
    this.ID = ID;
    this.ID_User = ID_User;
    this.ID_Playlist = ID_Playlist;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public int getID_User() {
    return ID_User;
  }

  public void setID_User(int ID_User) {
    this.ID_User = ID_User;
  }

  public int getID_Playlist() {
    return ID_Playlist;
  }

  public void setID_Playlist(int ID_Playlist) {
    this.ID_Playlist = ID_Playlist;
  }
  
  
}
