package edu.cnm.deepdive.pickyeater.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.pickyeater.model.dao.RecipeDao;
import edu.cnm.deepdive.pickyeater.model.dao.UserDao;
import edu.cnm.deepdive.pickyeater.model.entity.Recipe;
import edu.cnm.deepdive.pickyeater.model.entity.User;
import edu.cnm.deepdive.pickyeater.service.PickyEaterDatabase.Converters;
import java.util.Date;


  @Database(
      entities = {Recipe.class},
      version = 1,
      exportSchema = true
  )
  @TypeConverters(value = {Converters.class})

  public abstract class PickyEaterDatabase extends RoomDatabase {

    private static final String DB_NAME = "pickyeater_db";

    private static Application context;

    public static PickyEaterDatabase getInstance() {
      return InstanceHolder.INSTANCE;
    }


    private static class InstanceHolder {


      private static final PickyEaterDatabase INSTANCE =
          Room.databaseBuilder(context, PickyEaterDatabase.class, DB_NAME)
              .build();
    }

    public abstract UserDao getUserDao();

    public abstract RecipeDao getRecipeDao();

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

