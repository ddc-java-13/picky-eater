package edu.cnm.deepdive.pickyeater.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface HistoryDao {

  @Dao
  public interface RecipesDao {

    @Insert
    Single<Long> insert (Recipe);

    @Insert
    Single<List<Long>> insert(Recipe recipe);

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


  }
}
