package edu.cnm.deepdive.smartcheff.controller.ui.ingredientinput;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;
import edu.cnm.deepdive.smartcheff.R;
import edu.cnm.deepdive.smartcheff.controller.MainViewModel;
import edu.cnm.deepdive.smartcheff.controller.ui.recipes.RecipesFragment;
import edu.cnm.deepdive.smartcheff.databinding.FragmentIngredientBinding;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.zip.Inflater;
import org.jetbrains.annotations.NotNull;

/**
 * This class holds the logic for the ingredient fragment.
 */
public class IngredientFragment extends Fragment {

  private static final Pattern LIST_SPLITTER = Pattern.compile("\\s*,\\s*");
  /**
   * This field is a reference to FragmentIngredientBinding.
   */
  private FragmentIngredientBinding binding;

  /**
   * This field is a reference to the Ingredient view model.
   */
  private MainViewModel viewModel;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = edu.cnm.deepdive.smartcheff.databinding.FragmentIngredientBinding.inflate(inflater);
    //noinspection ConstantConditions

    // THe stuff down bellow allows us to display multiple variations of a fragment.
//    Variation variation = MatchFragmentArgs.fromBundle(getArguments()).getVariation();
//    binding.placeholder.setText(variation.toString());
    // Access references in binding to set contents of view objects, as appropriate.
    binding.recipeButton.setOnClickListener((v) -> {
      //noinspection ConstantConditions
      String ingredientsEntry = binding.ingredientList.getText().toString().trim();
      String[] ingredients = LIST_SPLITTER.splitAsStream(ingredientsEntry)
          .map(String::toLowerCase)
          .filter((s) -> !s.isEmpty())
          .toArray(String[]::new);
      Navigation.findNavController(getView()).navigate(IngredientFragmentDirections.searchRecipes(ingredients));
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to view model and set observers on live data.
    viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    // TODO obserive live data as nedded
  }





//  public enum Variation {
//    AVAILABLE, CURRENT, CLOSED;
//  }


}