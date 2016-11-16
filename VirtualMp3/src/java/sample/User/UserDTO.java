/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.User;

import java.io.Serializable;

/**
 *
 * @author quocbao0412
 */
public class UserDTO implements Serializable{
  private int ID;
  private String username;
  private String avatar;
  private String password;

  public UserDTO(int ID, String username, String avatar, String password) {
    this.ID = ID;
    this.username = username;
    this.avatar = avatar;
    this.password = password;
  }

  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
