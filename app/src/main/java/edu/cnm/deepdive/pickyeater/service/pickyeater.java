package edu.cnm.deepdive.pickyeater.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.pickyeater.entity.UserDao.GuessDao;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class RecipeRepository {

}



import android.content.Context;
    import androidx.lifecycle.LiveData;
    import edu.cnm.deepdive.pickyeater.model.dao.RecipeDao;
    import edu.cnm.deepdive.pickyeater.model.dao.RecipeDao;
    import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
    import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
    import io.reactivex.Completable;
    import io.reactivex.Single;
    import io.reactivex.schedulers.Schedulers;
    import java.util.List;

public class PickyEater {

  private final PickyEaterServiceProxy proxy;
  private final Context context;
  private final RecipeDao recipeDao;
  private final RecipeDao recipeDao;

  public RecipeRepository(Context context) {
    this.context = context;
    proxy = PickyEaterServiceProxy.getInstance();
    PickyEaterDatabase database = PickyEaterDatabase.getInstance();
    RecipeDao = database.getRecipeDao();
    UserDao = database.getRecipeDao();
  }

  //public Single<Recipe> save(Recipe game) {
    //return (
      //  (recipe.getId() == 0)
        //    ? proxy
          //  .startRecipe(recipe)
            //.flatMap((receivedRecipe) -> {
              //receivedRecipe.setPoolSize((int) receivedRecipe.getPool().codePoints().count());
              //return gameDao
                //  .insert(receivedGame)
                  //.map((id) -> {
                    //receivedGame.setId(id);
                    //return receivedGame;
                  });
            })
            //: gameDao
             //   .update(game)
              //  .map((count) -> game)
    )
      //  .subscribeOn(Schedulers.io());
  }

  public LiveData<GameWithGuesses> get(long id) {
    return recipeDao.select(id);
  }

  public Completable remove(Recipe recipe) {
    return (
        (recipe.getId() == 0)
            ? Completable.complete()
            : recipeDao
                .delete(recipe)
                .ignoreElement()
    )
        .subscribeOn(Schedulers.io());
  }

  public Single<Recipe> save(Recipe recipe, Recipe recipe) {
    return (
        (recipe.getId() == 0)
            ? proxy
            .submitRecipe(recipe.getServiceKey(), recipe)
            .map((receivedRecipe) -> {
              receivedRecipe.setRecipeId(Recipe.getId());
              return receivedRecipe;
            })
            .flatMap((receivedRecipe) -> {
              Single<Recipe> task;
              if (receivedRecipe.isSolution()) {
                recipe.setSolved(true);
                task = recipeDao
                    .update(recipe)
                    .map((count) -> receivedRecipe);
              } else {
                task = Single.just(receivedRecipe);
              }
              return task;
            })
            .flatMap(userDao::insert)
            .map((id) -> recipe)
            : userDao
                .update(recipe)
                .map((count) -> user)
    )
        .subscribeOn(Schedulers.io());
  }

 // public LiveData<List<GameWithGuesses>> getScoreboardAttempts(int codeLength, int poolSize) {
    //return gameDao.selectTopScoresByAttempts(codeLength, poolSize);
  }

  //public LiveData<List<GameWithGuesses>> getScoreboardTime(int codeLength, int poolSize) {
    //return gameDao.selectTopScoresByTime(codeLength, poolSize);
  }

}
