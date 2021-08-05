package edu.cnm.deepdive.pickyeater.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.pickyeater.model.entity.Ingredient;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import java.util.List;

public class RecipeWithIngredients extends Recipe {

  @NonNull
  @Relation(
      entity = Ingredient.class,
      parentColumn = "recipe_id",
      entityColumn = "recipe_id"
  )
  private List<Ingredient> ingredients;

  @NonNull
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(
      @NonNull List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }
}
