package edu.cnm.deepdive.smartcheff.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.smartcheff.model.dao.IngredientDao;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import io.reactivex.Completable;
import java.util.List;

public class IngredientRepository {

  private final Context context;

  private final IngredientDao ingredientDao;

  public IngredientRepository(Context context) {
    this.context = context;
    ingredientDao = SmartCheffDatabase.getInstance().getIngredientDao();
  }

  public Completable save(Ingredient ingredient) {
    return (ingredient.getId() == 0)
        ? ingredientDao.insert(ingredient)
            .doAfterSuccess(ingredient::setId)
            .ignoreElement()
        : ingredientDao.update(ingredient)
            .ignoreElement();
  }

  public Completable delete(Ingredient ingredient){
    return (ingredient.getId() == 0)
        ? Completable.complete()
        : ingredientDao.delete(ingredient)
            .ignoreElement();
  }

  public LiveData<List<Ingredient>> getAll() {
    return ingredientDao.getAll();

  }

  public LiveData<List<Ingredient>> selectByName(String name){
    return ingredientDao.selectName(String.format("%%%s%%", name));
  }


  public LiveData<Ingredient> selectByUpc(Ingredient upc){
    return ingredientDao.selectByUpc(upc.getUpc());
  }


  public LiveData<List<Ingredient>> selectByQuantity(Ingredient quantity){
    return ingredientDao.selectByQuantity(quantity.getQuantityAvailable());
  }

}
