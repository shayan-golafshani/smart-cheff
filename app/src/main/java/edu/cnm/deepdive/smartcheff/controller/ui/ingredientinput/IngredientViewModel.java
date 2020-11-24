package edu.cnm.deepdive.smartcheff.controller.ui.ingredientinput;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IngredientViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public IngredientViewModel() {
    mText = new MutableLiveData<>();
  }

  public LiveData<String> getText() {
    return mText;
  }
}