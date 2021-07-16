package edu.cnm.deepdive.pickyeater.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import java.util.Date;

public class PickyEaterDatabase {

  @Database(
      entities = {Recipe.class, Recipe.class},
      version = 2,
      exportSchema = true
  )

  //@TypeConverters((Converters.class))

  public abstract static class PickyeaterDatabase<GuessDao, GameDao> extends RoomDatabase {

    private static final String DB_NAME = "pickyeater-db";

    private static Application context;

    public static PickyeaterDatabase getInstance() {
      return InstanceHolder.INSTANCE;
    }


    private static class InstanceHolder {

      private static final PickyeaterDatabase INSTANCE =
          Room.databaseBuilder(context, PickyeaterDatabase.class, DB_NAME)
              .build();
    }

    public abstract GameDao getgetGameDao();

    public abstract GuessDao getGuessDao();

    public static class Converters {

      @TypeConverter
      public static Long dateToLong(Date value) {
        return (value != null) ? value.getTime() : null;
      }

      @TypeConverter
      public static Date longToDate(Long value) {
        return (value != null) ? new Date(value) : null;
      }

    }

  }
}
// @TypeConverter
  //public static Long toLong(Date value) {
  //  return (value != null) ? value.getTime() : null;
// }

//@TypeConverter
// public static Date toDtae(Long value) {
//   reyrn (value != null) ? new Date (value)
// }



//de