package edu.cnm.deepdive.pickyeater.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.preference.PreferenceManager;
import edu.cnm.deepdive.pickyeater.model.pojo.RecipeWithIngredients;
import edu.cnm.deepdive.pickyeater.service.RecipeRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class RecipeViewModel extends AndroidViewModel {

  private final RecipeRepository repository;

  private final MutableLiveData<Long> recipeId;
  private final LiveData<RecipeWithIngredients> recipe;
  private final MutableLiveData<String> ingredientName;
  private final LiveData<List<RecipeWithIngredients>> searchResults;

  //private final LiveData<List<Recipe>> history;
  //private final LiveData<List<Ingredient>> history;
  //private final LiveData<List<User>> history;

  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final SharedPreferences preferences;


  public RecipeViewModel(@NonNull Application application) {
    super(application);
    repository = new RecipeRepository(application);
    recipeId = new MutableLiveData<>();
    recipe = Transformations.switchMap(recipeId, repository::get);
    ingredientName = new MutableLiveData<>();
    searchResults = Transformations.switchMap(ingredientName, repository::searchByIngredient);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    preferences = PreferenceManager.getDefaultSharedPreferences(application);
  }

  public void setRecipeId(long id) {
    recipeId.setValue(id);
  }

  public LiveData<RecipeWithIngredients> getRecipe() {
    return recipe;
  }

  public void setIngredientName(String ingredientName) {
    this.ingredientName.setValue(ingredientName);
  }

  public LiveData<List<RecipeWithIngredients>> getSearchResults() {
    return searchResults;
  }

  public MutableLiveData<Throwable> getThrowable() {
    return throwable;
  }
}
