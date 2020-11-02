package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import edu.cnm.deepdive.smartcheff.model.entity.RecipeIngredient;
import edu.cnm.deepdive.smartcheff.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RecipeIngredientDao {

  @Insert
  Single<Long> insert(RecipeIngredient recipeIngredient);

  @Insert
  Single<List<Long>> insert(RecipeIngredient...recipeIngredient);

  @Insert
  Single<List<Long>> insert(Collection<RecipeIngredient> recipeIngredient);

  @Delete
  Single<Integer> delete(RecipeIngredient recipeIngredient);

  @Delete
  Single<Integer> delete(RecipeIngredient...recipeIngredient);

  @Delete
  Single<Integer>delete(Collection<RecipeIngredient> recipeIngredient);

}
