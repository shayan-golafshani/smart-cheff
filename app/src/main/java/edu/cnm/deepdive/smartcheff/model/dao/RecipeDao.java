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

/**
 * This is an interface that handles all the queries involving recipes.
 */
@Dao
public interface RecipeDao {

  /**
   * This method is used to insert one recipe into the SmartCheff data base.
   * @param recipe is a reference to the Recipe object.
   * @return recipe.
   */
  @Insert
  Single<Long> insert(Recipe recipe);


  /**
   * This method is used to insert more then one recipe into the SmartCheff database.
   * @param recipes is a reference to more then one Recipe object.
   * @return recipe.
   */
  @Insert
  Single<List<Long>> insert(Recipe...recipes);

  /**
   * This method is used insert a collection recipes into the SmartCheff database.
   * @param recipes is a reference to a collection recipes object.
   * @return recipes.
   */
  @Insert
  Single<List<Long>> insert(Collection<Recipe> recipes);

  /**
   * This method is used to update a recipe in the SmartCeff database.
   * @param recipe is a reference to the recipe object.
   * @return recipes.
   */
  @Update
  Single<Integer> update(Recipe recipe);

  /**
   * This method is used to update more then one recipes in the SmartCeff database.
   * @param recipes is a reference to more then one recipes object.
   * @return recipes.
   */
  @Update
  Single<Integer> update(Recipe... recipes);

  /**
   * This method is used to update a collection of recipes in the SmartCeff database.
   * @param recipes  is a reference to a collection of recipes objects.
   * @return recipes.
   */
  @Update
  Single<Integer> update(Collection<Recipe> recipes);

  /**
   * This method is used to delete a recipes from the SmartCeff database.
   * @param recipe is a reference to a recipes object.
   * @return recipes.
   */
  @Delete
  Single<Integer> delete(Recipe recipe);

  /**
   * This method is used to delete more the one recipes from the SmartCeff database.
   * @param recipes is a reference to more then one recipe object.
   * @return recipes.
   */
  @Delete
  Single<Integer> delete(Recipe...recipes);

  /**
   * This method is used to delete a collection of recipes from the SmartCeff database.
   * @param recipes is a reference to a collection of recipes objects.
   * @return recipes.
   */
  @Delete
  Single<Integer>delete(Collection<Recipe> recipes);


  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find a recipe using the ingredient id.
   * @param ingredientId is a reference to an ingredient id.
   * @return recipe.
   */
  @Query("SELECT r.* FROM Recipe AS r INNER JOIN recipeingredient AS ri ON ri.recipe_id = r.recipe_id WHERE ri.ingredient_id = :ingredientId")
  LiveData<List<Recipe>> findRecipeUsingIngredient (long ingredientId);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find a recipe using the recipes' name.
   * @param name is a reference to a recipes' name.
   * @return
   */
  @Query("SELECT * FROM Recipe WHERE name = :name")
  LiveData<Recipe> findByName (String name);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find a recipe using the recipes' id.
   * @param recipeId is a reference to a recipes' id.
   * @return
   */
  @Query("SELECT * FROM Recipe WHERE recipe_id = :recipeId")
  LiveData<List<Recipe>> findById (long recipeId);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find all the recipes in the SmartCheff database.
   */
  @Query("SELECT * FROM Recipe")
  LiveData<List<Recipe>> getAll ();
}
