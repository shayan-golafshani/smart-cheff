package edu.cnm.deepdive.smartcheff.controller;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import edu.cnm.deepdive.smartcheff.service.RecipeRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/**
 * This class is the is the Main view model for all the fragments.
 */
public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<List<RecipeDto>> searchResults;
  private final MutableLiveData<RecipeDto> searchDetail;
  private final MutableLiveData<Throwable> throwable;
  private final RecipeRepository recipeRepository;
  private final CompositeDisposable pending;

  /**
   * This is the constructor for the Main View Model.
   * @param application is a reference to the Application class.
   */
  public MainViewModel(
      @NonNull Application application) {
    super(application);
    searchResults = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    recipeRepository = new RecipeRepository(application);
    pending = new CompositeDisposable();
    searchDetail = new MutableLiveData<>();
  }

  /**
   * This is the getter for the live data list of RecipeDto
   */
  public LiveData<List<RecipeDto>> getSearchResults() {
    return searchResults;
  }

  /**
   * This is the getter for the live data Throwable
   * @return
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public LiveData<RecipeDto> getSearchDetail() {
    return searchDetail;
  }

  /**
   * This method searches Spoonaculer using the string array of ingredients.
   * @param ingredients is a String array inputted by the user.
   */
  public void search(String[] ingredients){
    pending.add(
        recipeRepository.search(Arrays.asList(ingredients))
            .subscribe(
                searchResults::postValue,
                throwable::postValue
            )
    );
  }

  public void getDetails(long id){
    pending.add(
        recipeRepository.retrieve(id)
            .subscribe(
                searchDetail::postValue,
                throwable::postValue
            )
    );
  }

  /**
   * This method clears the the Composite Disposable pending.
   */
  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending(){
    pending.clear();
  }


}
