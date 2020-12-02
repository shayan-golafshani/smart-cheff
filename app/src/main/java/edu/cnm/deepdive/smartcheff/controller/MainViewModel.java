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

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<List<RecipeDto>> searchResults;
  private final MutableLiveData<Throwable> throwable;
  private final RecipeRepository recipeRepository;
  private final CompositeDisposable pending;

  public MainViewModel(
      @NonNull Application application) {
    super(application);
    searchResults = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    recipeRepository = new RecipeRepository(application);
    pending = new CompositeDisposable();
  }

  public LiveData<List<RecipeDto>> getSearchResults() {
    return searchResults;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void search(String[] ingredients){
    pending.add(
        recipeRepository.search(Arrays.asList(ingredients))
            .subscribe(
                searchResults::postValue,
                throwable::postValue
            )
    );
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending(){
    pending.clear();
  }


}
