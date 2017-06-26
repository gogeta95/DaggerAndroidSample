package com.example.saurabh.daggerandroidsample;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by saurabh on 26/6/17.
 */

@Subcomponent(modules = DetailActivityModule.class)
public interface DetailActivityComponent extends AndroidInjector<DetailActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<DetailActivity>{}
}
