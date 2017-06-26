package com.example.saurabh.daggerandroidsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        AndroidInjection.inject(this)
        AndroidInjection.inject(this)

        apiService.items.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Toast.makeText(this@DetailActivity,response?.body(), Toast.LENGTH_SHORT).show()
            }

        })
    }
}
