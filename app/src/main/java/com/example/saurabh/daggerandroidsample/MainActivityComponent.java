package com.example.saurabh.daggerandroidsample;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by saurabh on 26/6/17.
 */

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
