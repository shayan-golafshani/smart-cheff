package edu.cnm.deepdive.smartcheff.controller.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.smartcheff.adapter.RecipeAdapter;
import edu.cnm.deepdive.smartcheff.controller.MainViewModel;
import edu.cnm.deepdive.smartcheff.databinding.FragmentRecipesBinding;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import edu.cnm.deepdive.smartcheff.service.RecipeRepository;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;


/**
 * This class holds the logic for the ingredient fragment.
 */
public class RecipesFragment extends Fragment {

  private FragmentRecipesBinding binding;
  private MainViewModel viewModel;
  private RecipeRepository recipeRepository;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentRecipesBinding.inflate(inflater);
    // THe stuff down bellow allows us to display multiple variations of a fragment.
//    Variation variation = MatchFragmentArgs.fromBundle(getArguments()).getVariation();
//    binding.placeholder.setText(variation.toString());
    // Access references in binding to set contents of view objects, as appropriate.
    binding.recipeList.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        RecipeDto recipe = (RecipeDto) parent.getItemAtPosition(position);
        Navigation.findNavController(getView()).navigate(
            RecipesFragmentDirections.showDetails(recipe.getId())
        );
        // TODO get recipe details

      }
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to view model and set observers on live data.
    //noinspection ConstantConditions
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getSearchResults().observe(getViewLifecycleOwner(), (recipes) -> {
      RecipeAdapter adapter = new RecipeAdapter(getContext(), recipes);
      binding.recipeList.setAdapter(adapter);
    });
    //noinspection ConstantConditions
    String[] ingredients = RecipesFragmentArgs.fromBundle(getArguments()).getIngredientsList();
    if (ingredients != null && ingredients.length > 0){
      viewModel.search(ingredients);
    }
  }



}