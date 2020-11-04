package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
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

  @Update
  Single<Integer> update(Recipe recipe);

  @Update
  Single<Integer> update(Recipe... recipes);

  @Update
  Single<Integer> update(Collection<Recipe> recipes);

  @Delete
  Single<Integer> delete(Recipe recipe);

  @Delete
  Single<Integer> delete(Recipe...recipes);

  @Delete
  Single<Integer>delete(Collection<Recipe> recipes);

  @Query("SELECT r.* FROM Recipe AS r INNER JOIN recipeingredient AS ri ON ri.recipe_id = r.recipe_id WHERE ri.ingredient_id = :ingredientId")
  LiveData<List<Recipe>> findRecipeUsingIngredient (long ingredientId);

  @Query("SELECT * FROM Recipe WHERE name = :name")
  LiveData<Recipe> findRecipeUsingName (String name);


}
