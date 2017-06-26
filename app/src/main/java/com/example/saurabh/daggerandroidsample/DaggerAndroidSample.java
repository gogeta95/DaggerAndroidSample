package com.example.saurabh.daggerandroidsample;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by saurabh on 26/6/17.
 */

public class DaggerAndroidSample extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .application(this)
                .appModule(new AppModule("https://api.github.com"))
                .build()
                .inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityAndroidInjector;
    }
}
