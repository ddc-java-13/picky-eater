package edu.cnm.deepdive.pickyeater.model.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Recipe.class,
            parentColumns = "recipe_id",
            childColumns = "recipe_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Ingredient {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ingredient_id")
  private long id;

  @NonNull
  @ColumnInfo(index = true, collate = ColumnInfo.NOCASE)
  private String name;

  private String quantity;

  @ColumnInfo(name= "recipe_id", index = true)
  private long recipeId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }
}
