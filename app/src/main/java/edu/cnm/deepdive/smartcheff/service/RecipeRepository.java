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

/**
 * This class holds the logic for the queries to the SmartCheff database involving a recipe.
 */
public class RecipeRepository {

  private  final SpoonacularServiceProxy serviceProxy;
  private final Context context;

  private final RecipeDao recipeDao;

  /**
   * This is the constructor for the RecipeRepository.
   * @param context is reference to a Context object.
   */
  public RecipeRepository(Context context) {
    this.context = context;
    recipeDao = SmartCheffDatabase.getInstance().getRecipeDao();
    serviceProxy = SpoonacularServiceProxy.getInstance();
  }

  /**
   * This is the method used to save a recipe to the SmartCheff database.
   * @param recipe is a reference to a Recipe object.
   * @return a saved recipe.
   */
  public Completable save(Recipe recipe) {
    return (recipe.getId() == 0)
        ? recipeDao.insert(recipe)
        .doAfterSuccess(recipe::setId)
        .ignoreElement()
        : recipeDao.update(recipe)
            .ignoreElement();
  }

  /**
   * This is the method used to delete a recipe from the SmartCheff database.
   * @param recipe is a reference to a Recipe object.
   * @return a deleted recipe.
   */
  public Completable delete(Recipe recipe) {
    return (recipe.getId() == 0)
        ? Completable.complete()
        : recipeDao.delete(recipe)
            .ignoreElement();
  }

  /**
   * This method is used to get all the recipes in the SmartCheff database.
   * @return recipes.
   */
  public LiveData<List<Recipe>> getAll() {
    return recipeDao.getAll();
  }

  /**
   * This is the method used to find a recipe by name.
   * @param name is the name of a recipe.
   * @return a recipe.
   */
  public LiveData<Recipe> findByName(Recipe name) {
    return recipeDao.findByName(name.getName());
  }

  /**
   * This method is used to find a recipe the uses specific ingredients.
   * @param id is the primary key of a recipe.
   * @return a recipe.
   */
  public LiveData<List<Recipe>> findRecipeUsingIngredient(Recipe id) {
    return recipeDao.findRecipeUsingIngredient(id.getId());
  }

  /**
   * This method finds a recipe by id.
   * @param id is the primary key of a recipe.
   * @return a recipe.
   */
  public LiveData<List<Recipe>> findById(Recipe id) {
    return recipeDao.findById(id.getId());
  }

  /**
   * This method makes a request to the api service using ingredients to find recipes.
   * @param ingredients is the ingredients inputted by the user.
   * @return a collection of recipes
   */
  public Single<List<RecipeDto>> search(Collection<String> ingredients){

    return Single.fromCallable(() -> ingredients.stream()
        .map(String::trim)
        .collect(Collectors.joining(","))
    )
        .flatMap((joinedIngredients) -> serviceProxy.search(joinedIngredients, BuildConfig.API_KEY))
        .subscribeOn(Schedulers.io());
  }

  /**
   * This method makes a request to the api service using the recipes id to get all the details of the recipe.
   * @param id is the id of a recipe.
   * @return details of a recipe.
   */
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
