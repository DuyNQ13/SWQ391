/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Playlist;

import java.io.Serializable;
import java.util.ArrayList;
import song.SongDTO;

/**
 *
 * @author quocbao0412
 */
public class PlaylistDTO implements Serializable{
  private int ID;
  private String Name;
  private int numOfLike;
  private int numOfListen;
  private String Cover;
  private int ID_User;
  private ArrayList<SongDTO> listSong;

  public ArrayList<SongDTO> getListSong() {
    return listSong;
  }

  public void addListSong(SongDTO songDTO) {
    this.listSong.add(songDTO);
  }

  public PlaylistDTO(int ID, String Name, int numOfLike, int numOfListen, String Cover, int ID_User) {
    this.ID = ID;
    this.Name = Name;
    this.numOfLike = numOfLike;
    this.numOfListen = numOfListen;
    this.Cover = Cover;
    this.ID_User = ID_User;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public int getNumOfLike() {
    return numOfLike;
  }

  public void setNumOfLike(int numOfLike) {
    this.numOfLike = numOfLike;
  }

  public int getNumOfListen() {
    return numOfListen;
  }

  public void setNumOfListen(int numOfListen) {
    this.numOfListen = numOfListen;
  }

  public String getCover() {
    return Cover;
  }

  public void setCover(String Cover) {
    this.Cover = Cover;
  }

  public int getID_User() {
    return ID_User;
  }

  public void setID_User(int ID_User) {
    this.ID_User = ID_User;
  }
  
  
}
