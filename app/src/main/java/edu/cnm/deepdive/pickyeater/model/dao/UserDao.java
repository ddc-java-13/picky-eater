package edu.cnm.deepdive.pickyeater.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface UserDao {

  public abstract @interface Dao
      implements Recipes



  @androidx.room.Dao
  public interface GuessDao {

    @Insert
    Single<Long> insert(Recipe recipes);

    @Insert
    Single<List<Long>> insert(Recipe... recipes);

    @Insert
    Single<List<Long>> insert(Collection<? extends Recipe> recipes);

    @Update
    Single<Integer> update(Recipe recipes);

    @Update
    Single<Integer> update(Recipe... recipes);

    @Update
    Single<Integer> update(Collection<? extends Recipe> recipes);

    @Delete
    Single<Integer> delete(Recipe recipes);

    @Delete
    Single<Integer> delete(Recipe... recipes);

    @Delete
    Single<Integer> delete(Collection<? extends Recipe> recipes);

    @Query("SELECT * FROM recipe WHERE recipe_id = :recipeId")
    LiveData<Recipe> select(long recipeId);

    @Query("SELECT * FROM recipe WHERE recipe_id = : recipeId ORDER BY created ASC")
    LiveData<List<Recipe>> selectForRecipe(long recipeId);
  }


  // TODO
  //  - add dao annotation
  //  - add 3 insert methods
  //  - add 3 update methods
  //  - add 3 delete methods
  //  = add 1-2 query methods
}
