package edu.cnm.deepdive.pickyeater.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

  //Todo
  // - add entity anootation
  // - add uder field as the Primary Key
  // - add display name field
  // - add oauth field as a unique key
  // - generte setters and getters


  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;


}
