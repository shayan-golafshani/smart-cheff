package edu.cnm.deepdive.smartcheff.controller.ui.camera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import edu.cnm.deepdive.smartcheff.controller.ui.ingredientinput.IngredientFragment;
import edu.cnm.deepdive.smartcheff.databinding.FragmentCameraBinding;
import edu.cnm.deepdive.smartcheff.databinding.FragmentIngredientBinding;
import org.jetbrains.annotations.NotNull;

/**
 * This class is unimplemented.
 */
public class CameraFragment extends Fragment {

    FragmentCameraBinding binding;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Bundle args = getArguments();
    //Do whatever is necessary with args
  }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
        @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      binding = edu.cnm.deepdive.smartcheff.databinding.FragmentCameraBinding.inflate(inflater);
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

