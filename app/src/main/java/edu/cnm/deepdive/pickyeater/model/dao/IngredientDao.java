package edu.cnm.deepdive.pickyeater.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.pickyeater.model.entity.Ingredient;
import edu.cnm.deepdive.pickyeater.model.entity.Ingredient;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface IngredientDao {

  @Insert
  Single<Long> insert(Ingredient ingredient);

  @Insert
  Single<List<Long>> insert(Ingredient... ingredients);


  @Insert
  Single<List<Long>> insert(Collection<? extends Ingredient> ingredients);

  @Update
  Single<Integer> update(Ingredient ingredient);

  @Update
  Single<Integer> update(Ingredient... ingredients);

  @Update
  Single<Integer> update(Collection<? extends Ingredient> ingredients);

  @Delete
  Single<Integer> delete(Ingredient ingredient);

  @Delete
  Single<Integer> delete(Ingredient... ingredients);

  @Delete
  Single<Integer> delete(Collection<? extends Ingredient> ingredients);

  // TODO
  //  - add Query method to retrieve a single ingredient based on its id.
  //  - add query method to select several ingredients based on cuisine
  //  - add query method to retrieve multiple recieps based on the user id


  @Query("SELECT * FROM Ingredient WHERE ingredient_id = :id")
  LiveData<Ingredient> select(long id);

  @Query("SELECT * FROM Ingredient WHERE name LIKE :name ORDER BY name ASC")
  LiveData<List<Ingredient>> searchByName(String name);

  @Query("SELECT * FROM Ingredient WHERE recipe_id = :id ORDER BY name ASC")
  LiveData<List<Ingredient>> selectByRecipeId(long id);

}

