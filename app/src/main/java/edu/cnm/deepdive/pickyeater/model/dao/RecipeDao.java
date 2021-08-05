package edu.cnm.deepdive.pickyeater.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import edu.cnm.deepdive.pickyeater.model.pojo.RecipeWithIngredients;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RecipeDao {

  @Insert
  Single<Long> insert(Recipe recipe);

  @Insert
  Single<List<Long>> insert(Recipe... guesses);


  @Insert
  Single<List<Long>> insert(Collection<? extends Recipe> recipes);

  @Update
  Single<Integer> update(Recipe recipe);

  @Update
  Single<Integer> update(Recipe... recipes);

  @Update
  Single<Integer> update(Collection<? extends Recipe> recipes);

  @Delete
  Single<Integer> delete(Recipe recipe);

  @Delete
  Single<Integer> delete(Recipe... recipes);

  @Delete
  Single<Integer> delete(Collection<? extends Recipe> recipes);

  // TODO
  //  - add Query method to retrieve a single recipe based on its id.
  //  - add query method to select several recipes based on cuisine
  //  - add query method to retrieve multiple recipes based on the user id

  @Query("SELECT * FROM Recipe WHERE author LIKE :author ORDER BY name ASC")
  LiveData<List<RecipeWithIngredients>> searchByAuthor(String author);

  @Query("SELECT * FROM Recipe WHERE recipe_id = :id")
  LiveData<RecipeWithIngredients> select(long id);

  @Query("SELECT * FROM Recipe WHERE name LIKE :name ORDER BY name ASC")
  LiveData<List<RecipeWithIngredients>> searchByName(String name);

  @Query("SELECT r.* FROM Recipe AS r "
      + "INNER JOIN Ingredient AS i ON r.recipe_id = i.recipe_id "
      + "WHERE i.name LIKE :ingredientName "
      + "ORDER BY r.name ASC")
  LiveData<List<RecipeWithIngredients>> searchByIngredient(String ingredientName);
}

