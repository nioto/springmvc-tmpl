package eu.tmi.model;

public enum Role {

  ADMIN(1), USER(10);
  
  int roleId;
  private Role(int i){
    this.roleId = i;
  }
}
