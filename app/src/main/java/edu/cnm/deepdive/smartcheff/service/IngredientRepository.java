package edu.cnm.deepdive.smartcheff.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.smartcheff.model.dao.IngredientDao;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import io.reactivex.Completable;
import java.util.List;

/**
 * This class is the logic behind the queries to the SmartCheff data base.
 */
public class IngredientRepository {

  private final Context context;

  private final IngredientDao ingredientDao;

  /**
   * This is the constructor for the IngredientRepository.
   * @param context is a reference to a Context object.
   */
  public IngredientRepository(Context context) {
    this.context = context;
    ingredientDao = SmartCheffDatabase.getInstance().getIngredientDao();
  }

  /**
   * This is the method to save an ingredient to the SmartCheff database
   * @param ingredient si an Ingredient object.
   * @return a saved ingredient.
   */
  public Completable save(Ingredient ingredient) {
    return (ingredient.getId() == 0)
        ? ingredientDao.insert(ingredient)
            .doAfterSuccess(ingredient::setId)
            .ignoreElement()
        : ingredientDao.update(ingredient)
            .ignoreElement();
  }

  /**
   * This is the method to delete a ingredient from the SmartCheff database.
   * @param ingredient is an ingredient object.
   * @return a deleted ingredient.
   */
  public Completable delete(Ingredient ingredient){
    return (ingredient.getId() == 0)
        ? Completable.complete()
        : ingredientDao.delete(ingredient)
            .ignoreElement();
  }

  /**
   * This is the method to get all the ingredients in the SmartCheff database.
   * @return all the ingredients in the SmartCheff database.
   */
  public LiveData<List<Ingredient>> getAll() {
    return ingredientDao.getAll();

  }

  /**
   * This is the method is used to get ingredients by name.
   * @param name is a String and is used as the name of an ingredient.
   * @return a list of ingredients.
   */
  public LiveData<List<Ingredient>> selectByName(String name){
    return ingredientDao.selectName(String.format("%%%s%%", name));
  }

  /**
   * This method is used to find an ingredient by its upc.
   * @param upc is the upc of a specific ingredient.
   * @return an ingredient.
   */
  public LiveData<Ingredient> selectByUpc(Ingredient upc){
    return ingredientDao.selectByUpc(upc.getUpc());
  }

  /**
   * This method is used to get an ingredient by the quanity of an ingredient on hand.
   * @param quantity is the amount of an ingredient on hand.
   * @return an ingredient.
   */
  public LiveData<List<Ingredient>> selectByQuantity(Ingredient quantity){
    return ingredientDao.selectByQuantity(quantity.getQuantityAvailable());
  }

}
