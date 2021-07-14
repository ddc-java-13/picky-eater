package edu.cnm.deepdive.pickyeater.model.entity;

import android.content.Context;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import com.facebook.stetho.Stetho;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public class Recipe extends Context {

  Single<Long> (Recipe); {
    return null;
  }

  {

  }

  @Insert
  Single<List<Long>> insert(Recipe... guesses) {
    return null;
  }

  @Insert
  Single<List<Long>> insert(Collection<? extends Recipe> recipes) {
    return null;
  }

  @Update
  Single<Integer> update(Recipe recipe) {
    return null;
  }

  @Update
  Single<Integer> update(Recipe... recipes) {
    return null;
  }

  @Update
  Single<Integer> update(Collection<? extends Recipe> recipes) {
    return null;
  }

  @Delete
  Single<Integer> delete(Recipe recipe) {
    return null;
  }

  @Delete
  Single<Integer> delete(Recipe... recipes) {
    return null;
  }

  @Delete
  Single<Integer> delete(Collection<? extends Recipe> recipes)
  }


  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }

}


}
