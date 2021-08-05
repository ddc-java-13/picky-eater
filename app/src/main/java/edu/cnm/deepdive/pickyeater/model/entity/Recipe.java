package edu.cnm.deepdive.pickyeater.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Recipe {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_id")
  private long id;

  @NonNull
  private Date created = new Date();

  private Date updated;

  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  private String author;


  @NonNull
  private String name;

  @NonNull
  private String instructions;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  @NonNull
  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(@NonNull String instructions) {
    this.instructions = instructions;
  }
}
