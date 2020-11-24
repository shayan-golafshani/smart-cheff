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

public class IngredientFragment extends Fragment {

  private IngredientViewModel ingredientViewModel;

  private ViewBinding binding;
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    ingredientViewModel =
        ViewModelProviders.of(this).get(IngredientViewModel.class);
    View root = inflater.inflate(R.layout.fragment_ingredient, container, false);
    final TextView textView = root.findViewById(R.id.navigation_ingredient);
    ingredientViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {

      @Override
      public void onChanged(String s) {

      }
    });
    return root;
  }
}