package edu.cnm.deepdive.smartcheff.controller.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.cnm.deepdive.smartcheff.databinding.FragmentRecipesBinding;
import org.jetbrains.annotations.NotNull;

public class RecipesFragment extends Fragment {

  FragmentRecipesBinding binding;

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