package edu.cnm.deepdive.pickyeater;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.pickyeater.service.PickyEaterDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class PickyEaterApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    PickyEaterDatabase.setContext(this);
    PickyEaterDatabase
        .getInstance()
        .getRecipeDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
