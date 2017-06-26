package com.example.saurabh.daggerandroidsample;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by saurabh on 26/6/17.
 */

@Module(subcomponents = {
        MainActivityComponent.class,
        DetailActivityComponent.class
}
)
public class AppModule {

    private String baseUrl;

    public AppModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(){
        return new OkHttpClient.Builder()
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit  retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }
}
