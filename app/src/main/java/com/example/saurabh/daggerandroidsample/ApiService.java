package com.example.saurabh.daggerandroidsample;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by saurabh on 26/6/17.
 */

public interface ApiService {
    @GET("/users/gogeta95/repos")
    Call<String> getItems();
}
