package edu.cnm.deepdive.smartcheff.controller.ui.recipes;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.smartcheff.adapter.CurrentRecipeAdapter;
import edu.cnm.deepdive.smartcheff.controller.MainViewModel;
import edu.cnm.deepdive.smartcheff.databinding.FragmentCurrentRecipeBinding;
import edu.cnm.deepdive.smartcheff.model.dto.AnalyzedInstructionDto;
import edu.cnm.deepdive.smartcheff.model.dto.ExtendedIngredientDto;
import org.jetbrains.annotations.NotNull;
/**
 * This class holds the logic for the CurrentRecipe fragment.
 */
public class CurrentRecipeFragment extends Fragment {

  private ExtendedIngredientDto ingredients;
  private CurrentRecipeAdapter adapter;
  private FragmentCurrentRecipeBinding binding;
  private MainViewModel viewModel;




  @Nullable
  @Override
  public View onCreateView( LayoutInflater inflater,
      @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    binding = FragmentCurrentRecipeBinding.inflate(inflater);
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
    viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    viewModel.getSearchDetail().observe(getViewLifecycleOwner(), (recipe) -> {
      binding.title.setText(recipe.getTitle());
      binding.summary.setText(Html.fromHtml(recipe.getSummary(),Html.FROM_HTML_MODE_LEGACY));
      binding.prepTime.setText(String.valueOf(recipe.getPrepTime()));
      binding.servings.setText(String.valueOf(recipe.getServings()));
      if (recipe.getImage() != null && !recipe.getImage().trim().isEmpty()){
        Picasso.get().load(recipe.getImage().trim()).into(binding.image);
      }else{
        binding.image.setVisibility(View.GONE);

      }
      binding.sourceUrl.setText(recipe.getSourceUrl());
      binding.instructions.setText(recipe.getInstructions());
//      binding.instructions.setAdapter(adapter);

    });
    long id = CurrentRecipeFragmentArgs.fromBundle(getArguments()).getExternalId();
    if (id != 0){
      viewModel.getDetails(id);
    }
    // Get reference to view model and set observers on live data.
  }

}
