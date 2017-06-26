package com.example.saurabh.daggerandroidsample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import okhttp3.OkHttpClient;

/**
 * Created by saurabh on 26/6/17.
 */


@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance Builder application(Application application);

        Builder appModule(AppModule appModule);

        AppComponent build();
    }

    void inject(DaggerAndroidSample app);
}
