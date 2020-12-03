package edu.cnm.deepdive.smartcheff.controller.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.smartcheff.controller.MainViewModel;
import edu.cnm.deepdive.smartcheff.databinding.FragmentCurrentRecipeBinding;
import org.jetbrains.annotations.NotNull;
/**
 * This class holds the logic for the CurrentRecipe fragment.
 */
public class CurrentRecipeFragment extends Fragment {

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
    // Get reference to view model and set observers on live data.
  }

}
