package edu.cnm.deepdive.smartcheff;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.smartcheff.service.GoogleSignInService;
import edu.cnm.deepdive.smartcheff.service.SmartCheffDatabase;
import io.reactivex.schedulers.Schedulers;

public class SmartCheffApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    GoogleSignInService.setContext(this);
    SmartCheffDatabase.setContext(this);
    SmartCheffDatabase.getInstance().getIngredientDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}