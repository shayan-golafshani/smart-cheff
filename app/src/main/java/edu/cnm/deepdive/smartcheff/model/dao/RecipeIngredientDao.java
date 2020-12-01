package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import edu.cnm.deepdive.smartcheff.model.entity.RecipeIngredient;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This is a joining table in the SmartCheff database between ingredient and recipe.
 * There is no queries implemented in this class.
 */
@Dao
public interface RecipeIngredientDao {

  @Insert
  Single<Long> insert(RecipeIngredient recipeIngredient);

  @Insert
  Single<List<Long>> insert(RecipeIngredient...recipeIngredient);

  @Insert
  Single<List<Long>> insert(Collection<RecipeIngredient> recipeIngredient);

  @Update
  Single<Integer> update(RecipeIngredient recipe);

  @Update
  Single<Integer> update(RecipeIngredient... recipeIngredients);

  @Update
  Single<Integer> update(Collection<RecipeIngredient> recipeIngredients);

  @Delete
  Single<Integer> delete(RecipeIngredient recipeIngredient);

  @Delete
  Single<Integer> delete(RecipeIngredient...recipeIngredient);

  @Delete
  Single<Integer>delete(Collection<RecipeIngredient> recipeIngredient);



}
