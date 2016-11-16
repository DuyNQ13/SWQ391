/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.SofU;

import java.io.Serializable;

/**
 *
 * @author quocbao0412
 */
public class SofUDTO implements Serializable{
  private int ID;
  private int ID_User;
  private int ID_Song;

  public SofUDTO(int ID, int ID_User, int ID_Song) {
    this.ID = ID;
    this.ID_User = ID_User;
    this.ID_Song = ID_Song;
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

  public int getID_Song() {
    return ID_Song;
  }

  public void setID_Song(int ID_Song) {
    this.ID_Song = ID_Song;
  }
  
  
}
