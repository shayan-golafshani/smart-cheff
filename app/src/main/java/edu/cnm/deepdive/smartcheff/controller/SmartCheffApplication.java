package edu.cnm.deepdive.smartcheff.controller;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class SmartCheffApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
