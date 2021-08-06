package edu.cnm.deepdive.pickyeater.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.pickyeater.model.dao.IngredientDao;
import edu.cnm.deepdive.pickyeater.model.dao.RecipeDao;
import edu.cnm.deepdive.pickyeater.model.dao.UserDao;
import edu.cnm.deepdive.pickyeater.model.entity.Ingredient;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import edu.cnm.deepdive.pickyeater.model.pojo.RecipeWithIngredients;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Observer;
import org.jetbrains.annotations.NotNull;


public class RecipeRepository {

  private final Context context;
  private final RecipeDao recipeDao;
  private final IngredientDao ingredientDao;
  private final Object UserDao;

  public RecipeRepository(Context context) {
    this.context = context;

    PickyEaterDatabase database = PickyEaterDatabase.getInstance();
    recipeDao = database.getRecipeDao();
    ingredientDao = database.getIngredientDao();
    UserDao = database.getUserDao();
  }


  public Single<RecipeWithIngredients> save(RecipeWithIngredients recipe) {
    return (
        (recipe.getId() != 0)
            ? recipeDao
                .update(recipe)
                .map((count) -> recipe)
            : recipeDao
                .insert(recipe)
                .map((id) -> {
                  recipe.setId(id);
                  return recipe;
                })
    )
        .flatMap(this::saveIngredients)
        .subscribeOn(Schedulers.io());
  }

  public LiveData<List<RecipeWithIngredients>> searchByIngredient(String nameFragment){
    return recipeDao.searchByIngredient('%' + nameFragment + '%');
  }

  public LiveData<List<>

  private Single<RecipeWithIngredients> saveIngredients(
      RecipeWithIngredients updatedRecipe) {
    List<Ingredient> ingredientsToUpdate = new LinkedList<>();
    List<Ingredient> ingredientsToInsert = new LinkedList<>();
    for (Ingredient ingredient : updatedRecipe.getIngredients()) {
      ingredient.setRecipeId(updatedRecipe.getId());
      if (ingredient.getId() == 0) {
        ingredientsToInsert.add(ingredient);
      } else {
        ingredientsToUpdate.add(ingredient);
      }
    }
    return ingredientDao
        .update(ingredientsToUpdate)
        .flatMap((ignored) -> ingredientDao.insert(ingredientsToInsert))
        .map((ids) -> {
          Iterator<Ingredient> ingredientIterator = ingredientsToInsert.iterator();
          Iterator<Long> idIterator = ids.iterator();
          while (ingredientIterator.hasNext() && idIterator.hasNext()) {
            Ingredient ingredient = ingredientIterator.next();
            long id = idIterator.next();
            ingredient.setId(id);
          }
          return updatedRecipe;
        });
  }

}
