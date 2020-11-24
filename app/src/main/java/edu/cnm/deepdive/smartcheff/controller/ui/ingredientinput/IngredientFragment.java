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
import androidx.lifecycle.ViewModelProviders;
import androidx.viewbinding.ViewBinding;
import edu.cnm.deepdive.smartcheff.R;
import edu.cnm.deepdive.smartcheff.controller.ui.recipes.RecipesFragment;
import edu.cnm.deepdive.smartcheff.databinding.FragmentIngredientBinding;
import java.util.zip.Inflater;
import org.jetbrains.annotations.NotNull;

public class IngredientFragment extends Fragment {

  FragmentIngredientBinding binding;

  public static IngredientFragment createInstance(/* params to pass to fragment*/) {
    IngredientFragment fragment = new IngredientFragment();
    Bundle args = new Bundle();
    //Add param values to args, args.put???()
    fragment.setArguments(args);
    return fragment;

  }
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
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    // Get reference to view model and set observers on live data.
  }

private void findRecipes(Inflater inflater) {
    binding.recipeButton.setOnClickListener((v) -> {
    RecipesFragment.createInstance();
    });

}

//  public enum Variation {
//    AVAILABLE, CURRENT, CLOSED;
//  }


}