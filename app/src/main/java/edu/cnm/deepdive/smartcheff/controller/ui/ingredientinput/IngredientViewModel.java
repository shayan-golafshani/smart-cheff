package edu.cnm.deepdive.smartcheff.controller.ui.ingredientinput;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import edu.cnm.deepdive.smartcheff.service.RecipeRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

/**
 * This class is the view model for the ingredient fragment.
 */
public class IngredientViewModel extends AndroidViewModel {

  /**
   * This field is creating a new mutable live data list of RecipeDto.
   */
  private final MutableLiveData<List<RecipeDto>> recipes;

  /**
   * This field is creating a new mutable live data Throwable.
   */
  private final MutableLiveData<Throwable> throwable;

  /**
   * This field is getting a reference to RecipeRepository
   */
  private final RecipeRepository recipeRepository;


  /**
   * This is the constructor for the IngredientViewModel class.
   * @param application is a reference to the application class.
   */
  public IngredientViewModel(
      @NonNull Application application) {
    super(application);
    throwable = new MutableLiveData<>();
    recipes = new MutableLiveData<>();
    recipeRepository = new RecipeRepository(application);
    // FIXME get rid of debug code that follows
//    recipeRepository.search(Arrays.stream(new String[]{"apple"}).collect(Collectors.toList()))
//        .flatMap((recipes) -> recipeRepository.retrieve(recipes.get(0).getId()))
//        .subscribe(
//            (recipe) -> Log.d(getClass().getSimpleName(), recipe.getSummary()),
//            (throwable) -> Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable)
//        );
  }

}