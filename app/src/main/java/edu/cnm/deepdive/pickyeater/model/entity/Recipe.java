package edu.cnm.deepdive.pickyeater.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
   tableName = "recipe",
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = {"user_id"},
            parentColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE
        )
    }

    )
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recipe_id")
    private long id;

    @ColumnInfo(name = "date_created", index = true)
    private Date created;

    @ColumnInfo(index = true)
    private Date updated;

    @ColumnInfo(index = true)
    private String author;

    @ColumnInfo(name = "recipe_name", index = true)
    private String name;

    @ColumnInfo(index = true)
    private Cuisine cuisine;

    //TODO add a long indexed field for User ID; generate setter and getter; add Foreign key attribute to entity annotation.
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public enum Cuisine {
        CHICKEN , BEEF;
        // TODO add converter methods

    }
}