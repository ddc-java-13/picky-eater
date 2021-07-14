package edu.cnm.deepdive.pickyeater;

import android.app.Application;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class AppStarterApplication extends Application {}
