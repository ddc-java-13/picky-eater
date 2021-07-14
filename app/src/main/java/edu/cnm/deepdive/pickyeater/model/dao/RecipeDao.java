package edu.cnm.deepdive.pickyeater.model.dao;

import android.content.Context;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface RecipeDao {

  Single<Long> (Recipe);

  @Insert
  default Single<List<Long>> insert(Recipe... guesses) {
    return null;
  }


  @Insert
  default Single<List<Long>> insert(Collection<? extends Recipe> recipes) {
    return null;
  }

  @Update
  default Single<Integer> update(Recipe recipe) {
    return null;
  }

  @Update
  default Single<Integer> update(Recipe... recipes) {
    return null;
  }

  @Update
  default Single<Integer> update(Collection<? extends Recipe> recipes) {
    return null;
  }

  @Delete
  default Single<Integer> delete(Recipe recipe) {
    return null;
  }

  @Delete
  default Single<Integer> delete(Recipe... recipes) {
    return null;
  }

  @Delete
  default Single<Integer> delete(Collection<? extends Recipe> recipes) {
    return null;
  }


  @Override
  void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults((Context) this);
  }

}

}
