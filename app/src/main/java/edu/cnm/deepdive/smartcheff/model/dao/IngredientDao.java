package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This is an interface that handles all the queries involving ingredients.
 */
@Dao
public interface IngredientDao {

  /**
   * This method is used to insert one ingredient into the SmartCheff data base.
   * @param ingredient is a reference to the Ingredient object.
   * @return Ingredient.
   */
  @Insert
  Single<Long> insert(Ingredient ingredient);

  /**
   * This method is used to insert more then one ingredient into the SmartCheff database.
   * @param ingredients is a reference to more then one Ingredient object.
   * @return Ingredients
   */
  @Insert
  Single<List<Long>> insert(Ingredient... ingredients);

  /**
   * This method is used insert a collection ingredient into the SmartCheff database.
   * @param ingredients is a reference to a collection Ingredient object.
   * @return Ingredients.
   */
  @Insert
  Single<List<Long>> insert(Collection<Ingredient> ingredients);

  /**
   * This method is used to update an ingredient in the SmartCeff database.
   * @param ingredient is a reference to the Ingredient object.
   * @return Ingredient.
   */
  @Update
  Single<Integer> update(Ingredient ingredient);

  /**
   * This method is used to update more then one ingredients in the SmartCeff database.
   * @param ingredients is a reference to more then one Ingredient object.
   * @return ingredients.
   */
  @Update
  Single<Integer> update(Ingredient... ingredients);

  /**
   * This method is used to update a collection of ingredients in the SmartCeff database.
   * @param ingredients  is a reference to a collection of Ingredient objects.
   * @return ingredients.
   */
  @Update
  Single<Integer> update(Collection<Ingredient> ingredients);

  /**
   * This method is used to delete an ingredient from the SmartCeff database.
   * @param ingredients is a reference to a Ingredient object.
   * @return ingredient.
   */
  @Delete
  Single<Integer> delete(Ingredient ingredients);

  /**
   * This method is used to delete more the one ingredient from the SmartCeff database.
   * @param ingredients is a reference to more then one Ingredient object.
   * @return ingredients.
   */
  @Delete
  Single<Integer> delete(Ingredient... ingredients);

  /**
   * This method is used to delete a collection of ingredients from the SmartCeff database.
   * @param ingredients is a reference to a collection of Ingredient objects
   * @return ingredients.
   */
  @Delete
  Single<Integer>delete(Collection<Ingredient> ingredients);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find an ingredient by upc.
   * @param upc is a reference to an ingredient upc
   * @return ingredient.
   */
  @Query("SELECT * FROM Ingredient WHERE upc = :upc")
  LiveData<Ingredient> selectByUpc(String upc);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find ingredients by name.
   * @param name is a reference to an ingredient name.
   * @return ingredients.
   */
  @Query("SELECT * FROM Ingredient WHERE name LIKE :name")
  LiveData <List<Ingredient>> selectName(String name);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find an ingredients by the quantity available.
   * @param quantityAvailable reference to an ingredients quanity available.
   * @return ingredients.
   */
  @Query("SELECT * FROM Ingredient WHERE quantity_available >= :quantityAvailable")
  LiveData<List<Ingredient>> selectByQuantity(int quantityAvailable);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find all the ingredients in the SmartCheff database.
   * @return ingredients.
   */
  @Query("SELECT * FROM Ingredient")
  LiveData <List<Ingredient>> getAll();
}
