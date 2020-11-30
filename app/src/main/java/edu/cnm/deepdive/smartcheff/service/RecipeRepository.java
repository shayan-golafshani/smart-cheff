package edu.cnm.deepdive.smartcheff.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.smartcheff.BuildConfig;
import edu.cnm.deepdive.smartcheff.model.dao.IngredientDao;
import edu.cnm.deepdive.smartcheff.model.dao.RecipeDao;
import edu.cnm.deepdive.smartcheff.model.dto.AnalyzedInstructionDto;
import edu.cnm.deepdive.smartcheff.model.dto.ExtendedIngredientDto;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import edu.cnm.deepdive.smartcheff.model.dto.StepDto;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeRepository {

  private  final SpoonacularServiceProxy serviceProxy;
  private final Context context;

  private final RecipeDao recipeDao;

  public RecipeRepository(Context context) {
    this.context = context;
    recipeDao = SmartCheffDatabase.getInstance().getRecipeDao();
    serviceProxy = SpoonacularServiceProxy.getInstance();
  }

  public Completable save(Recipe recipe) {
    return (recipe.getId() == 0)
        ? recipeDao.insert(recipe)
        .doAfterSuccess(recipe::setId)
        .ignoreElement()
        : recipeDao.update(recipe)
            .ignoreElement();
  }

  public Completable delete(Recipe recipe) {
    return (recipe.getId() == 0)
        ? Completable.complete()
        : recipeDao.delete(recipe)
            .ignoreElement();
  }
  public LiveData<List<Recipe>> getAll() {
    return recipeDao.getAll();

  }
  public LiveData<Recipe> findByName(Recipe name) {
    return recipeDao.findByName(name.getName());
  }

  public LiveData<List<Recipe>> findRecipeUsingIngredient(Recipe id) {
    return recipeDao.findRecipeUsingIngredient(id.getId());
  }

  public LiveData<List<Recipe>> findById(Recipe id) {
    return recipeDao.findById(id.getId());
  }

  public Single<List<RecipeDto>> search(Collection<String> ingredients){

    return Single.fromCallable(() -> ingredients.stream()
        .map(String::trim)
        .collect(Collectors.joining(","))
    )
        .flatMap((joinedIngredients) -> serviceProxy.search(joinedIngredients, BuildConfig.API_KEY))
        .subscribeOn(Schedulers.io());
  }

  public Single<RecipeDto> retrieve(long id){

    return serviceProxy.get(id,BuildConfig.API_KEY)
        .map((recipe) -> {
          for(ExtendedIngredientDto ingredient : recipe.getExtendedIngredients()){
            List<ExtendedIngredientDto> ingredients = recipe.getIngredients().getOrDefault(ingredient.getId(), new LinkedList<>());
            ingredients.add(ingredient);
            recipe.getIngredients().putIfAbsent(ingredient.getId(), ingredients);
          }
          for (AnalyzedInstructionDto instruction : recipe.getAnalyzedInstructions()){
            for (StepDto step : instruction.getSteps()){
              step.setIngredients(
                  step.getIngredients().stream()
                      .flatMap((ingredient) -> recipe.getIngredients().getOrDefault(ingredient.getId(),new LinkedList<>()).stream())
                      .collect(Collectors.toList())
              );
            }
          }
          return recipe;
        })
        .subscribeOn(Schedulers.io());
  }
}
