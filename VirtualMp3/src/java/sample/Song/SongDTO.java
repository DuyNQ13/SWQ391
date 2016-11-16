/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Song;

import java.io.Serializable;

/**
 *
 * @author quocbao0412
 */
public class SongDTO implements Serializable{
  private int ID;
  private String Song;
  private String Singer;
  private int numOfLike;
  private int numOfListen;
  private String Cover;
  private String Link;
  private int ID_User;
  
  public SongDTO(int ID, String Song, String Singer, int numOfLike, int numOfListen, String Cover, String Link, int ID_User) {
    this.ID = ID;
    this.Song = Song;
    this.Singer = Singer;
    this.numOfLike = numOfLike;
    this.numOfListen = numOfListen;
    this.Cover = Cover;
    this.Link = Link;
    this.ID_User = ID_User;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getSong() {
    return Song;
  }

  public void setSong(String Song) {
    this.Song = Song;
  }

  public String getSinger() {
    return Singer;
  }

  public void setSinger(String Singer) {
    this.Singer = Singer;
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

  public String getLink() {
    return Link;
  }

  public void setLink(String Link) {
    this.Link = Link;
  }

  public int getID_User() {
    return ID_User;
  }

  public void setID_User(int ID_User) {
    this.ID_User = ID_User;
  }
  
  
}
