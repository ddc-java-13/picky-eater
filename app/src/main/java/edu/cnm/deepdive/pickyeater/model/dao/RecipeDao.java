package edu.cnm.deepdive.pickyeater.model.dao;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RecipeDao<PickyEater> {

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
  //  - add query method to retrieve multiple recieps based on the user id

  @Query("SELECT * FROM recipe [WHERE recipe_id = :recipeId")
  LiveData<PickyEater> select(long recipeId);

  @Query("SELECT * FROM Ingredient WHERE ingredient_id = :ingredientId")
  LiveData<ingredient> select(long guessId);

  @Query("SELECT * FROM cuisine WHERE cuisine_id = :guessId")
  LiveData<cuisine> select(long guessId);

}

