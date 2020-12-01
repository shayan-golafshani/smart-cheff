package edu.cnm.deepdive.smartcheff.controller.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.cnm.deepdive.smartcheff.databinding.FragmentRecipesBinding;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;


/**
 * This class holds the logic for the ingredient fragment.
 */
public class RecipesFragment extends Fragment {

  /**
   * This field is creating a new list of RecipeDto that is an array list.
   */
  List<RecipeDto> recipeItems = new ArrayList<RecipeDto>();

  /**
   * This field is a reference to FragmentRecipeBinding
   */
  FragmentRecipesBinding binding;


  /**
   * This is the constructor for the RecipeFragment class.
   * @return the recipe fragment.
   */
  public static RecipesFragment createInstance(/* params to pass to fragment*/) {
   RecipesFragment fragment = new RecipesFragment();
    Bundle args = new Bundle();
    //Add param values to args, args.put???()
    fragment.setArguments(args);
    return fragment;

  }


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentRecipesBinding.inflate(inflater);
    //noinspection ConstantConditions

    // THe stuff down bellow allows us to display multiple variations of a fragment.
//    Variation variation = MatchFragmentArgs.fromBundle(getArguments()).getVariation();
//    binding.placeholder.setText(variation.toString());
    // Access references in binding to set contents of view objects, as appropriate.
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to view model and set observers on live data.
  }



//  public enum Variation {
//    AVAILABLE, CURRENT, CLOSED;
//  }


}