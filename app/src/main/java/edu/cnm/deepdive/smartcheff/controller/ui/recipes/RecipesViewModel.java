package edu.cnm.deepdive.smartcheff.controller.ui.recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * This class is the viewModel for the recipe fragment.
 */
public class RecipesViewModel extends ViewModel {



  private MutableLiveData<String> Text;

  public RecipesViewModel() {
    Text = new MutableLiveData<>();
  }

  public LiveData<String> getText() {
    return Text;
  }
}