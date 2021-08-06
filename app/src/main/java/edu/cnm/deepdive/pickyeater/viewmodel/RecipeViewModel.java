package edu.cnm.deepdive.pickyeater.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.pickyeater.model.entity.Ingredient;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import edu.cnm.deepdive.pickyeater.model.entity.User;
import edu.cnm.deepdive.pickyeater.service.RecipeRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

  private final RecipeRepository repository;

  private final MutableLiveData<Long> recipeId;
  private final LiveData<Recipe> recipe;
  private final MutableLiveData<Integer> codeLength;
  private final MutableLiveData<Integer> poolSize;
  private final MutableLiveData<Boolean> sortedByTime;

  //private final LiveData<List<Recipe>> history;
  //private final LiveData<List<Ingredient>> history;
  //private final LiveData<List<User>> history;

  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final SharedPreferences preferences;
  private final String basePool;

  public RecipeViewModel(@NonNull Application application,
      MutableLiveData<Long> recipeId,
      LiveData<Recipe> recipe, MutableLiveData<Integer> codeLength,
      MutableLiveData<Integer> poolSize,
      MutableLiveData<Boolean> sortedByTime,
      LiveData<List<Recipe>> history,
      MutableLiveData<Throwable> throwable, CompositeDisposable pending,
      SharedPreferences preferences, String basePool) {
    super(application);
    repository = new RecipeRepository(application);
    this.recipeId = recipeId;
    this.recipe = recipe;
    this.codeLength = codeLength;
    this.poolSize = poolSize;
    this.sortedByTime = sortedByTime;
    // this.history = history;
    this.throwable = throwable;
    this.pending = pending;
    this.preferences = preferences;
    this.basePool = basePool;
  }

  public RecipeRepository getRepository() {
    return repository;
  }

  public MutableLiveData<Long> getRecipeId() {
    return recipeId;
  }

  public LiveData<Recipe> getRecipe() {
    return recipe;
  }

  public LiveData<List<Ingredient>> getHistory() {
    //return history;
  }
}
