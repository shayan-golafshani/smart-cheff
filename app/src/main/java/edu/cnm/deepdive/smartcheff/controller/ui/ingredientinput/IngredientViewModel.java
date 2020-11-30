package edu.cnm.deepdive.smartcheff.controller.ui.ingredientinput;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import edu.cnm.deepdive.smartcheff.service.RecipeRepository;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class IngredientViewModel extends AndroidViewModel {


private final RecipeRepository recipeRepository;



  public IngredientViewModel(
      @NonNull Application application) {
    super(application);
    recipeRepository = new RecipeRepository(application);
    // FIXME get rid of debug code that follows
    recipeRepository.search(Arrays.stream(new String[]{"apple"}).collect(Collectors.toList()))
        .flatMap((recipes) -> recipeRepository.retrieve(recipes.get(0).getId()))
        .subscribe(
            (recipe) -> Log.d(getClass().getSimpleName(), recipe.getSummary()),
            (throwable) -> Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable)
        );
  }
}