package edu.cnm.deepdive.smartcheff.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.smartcheff.model.dao.IngredientDao;
import edu.cnm.deepdive.smartcheff.model.dao.RecipeDao;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import io.reactivex.Completable;
import java.util.List;

public class RecipeRepository {

  private final Context context;

  private final RecipeDao recipeDao;

  public RecipeRepository(Context context) {
    this.context = context;
    recipeDao = SmartCheffDatabase.getInstance().getRecipeDao();
  }

  public Completable save(Recipe recipe) {
    return (recipe.getId() == 0)
        ? recipeDao.insert(recipe)
        .doAfterSuccess(recipe::setId)
        .ignoreElement()
        : recipeDao.update(recipe)
            .ignoreElement();
  }

  public Completable delete(Recipe recipe){
    return (recipe.getId() == 0)
        ? Completable.complete()
        : recipeDao.delete(recipe)
            .ignoreElement();
  }

  public LiveData<Recipe> findByName (Recipe name){
    return recipeDao.findByName(name.getName());
  }

  public LiveData<List<Recipe>> findRecipeUsingIngredient (Recipe id){
    return recipeDao.findRecipeUsingIngredient(id.getId());
  }

}
