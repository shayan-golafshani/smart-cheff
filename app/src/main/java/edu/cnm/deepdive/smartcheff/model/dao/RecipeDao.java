package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import edu.cnm.deepdive.smartcheff.model.entity.RecipeIngredient;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RecipeDao {
  @Insert
  Single<Long> insert(Recipe recipe);

  @Insert
  Single<List<Long>> insert(Recipe...recipes);

  @Insert
  Single<List<Long>> insert(Collection<Recipe> recipes);

  @Delete
  Single<Integer> delete(Recipe recipe);

  @Delete
  Single<Integer> delete(Recipe...recipes);

  @Delete
  Single<Integer>delete(Collection<Recipe> recipes);
}
