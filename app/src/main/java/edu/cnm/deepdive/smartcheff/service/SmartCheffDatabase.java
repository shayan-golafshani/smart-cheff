package edu.cnm.deepdive.smartcheff.service;


import androidx.room.Database;
import androidx.room.Room;
import android.app.Application;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.smartcheff.model.dao.IngredientDao;
import edu.cnm.deepdive.smartcheff.model.dao.RecipeDao;
import edu.cnm.deepdive.smartcheff.model.dao.RecipeIngredientDao;
import edu.cnm.deepdive.smartcheff.model.dao.UserDao;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import edu.cnm.deepdive.smartcheff.model.entity.RecipeIngredient;
import edu.cnm.deepdive.smartcheff.model.entity.User;

/**
 * This class is what creates the Smartcheff database.
 */
@Database(entities = {Recipe.class, Ingredient.class, User.class, RecipeIngredient.class}, version = 1, exportSchema = true)

public abstract class SmartCheffDatabase extends RoomDatabase {

  private static final String DB_NAME = "SmartCheff_db";

  private static Application context;

  public static void setContext(Application context) {
    SmartCheffDatabase.context = context;
  }

  public static SmartCheffDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract UserDao getUserDao();

  public abstract RecipeDao getRecipeDao();

  public abstract IngredientDao getIngredientDao();

  public abstract RecipeIngredientDao getRecipeIngredientDao();


  private static class InstanceHolder {

    private static final SmartCheffDatabase INSTANCE =
        Room.databaseBuilder(context, SmartCheffDatabase.class, DB_NAME)
            .build();

  }
}

