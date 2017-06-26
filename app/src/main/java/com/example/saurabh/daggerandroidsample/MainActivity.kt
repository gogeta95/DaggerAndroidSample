package com.example.saurabh.daggerandroidsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import dagger.android.AndroidInjection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button  = findViewById(R.id.btn ) as Button
        btn.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java))
        }

        val textView: TextView = findViewById(R.id.textView) as TextView

        AndroidInjection.inject(this)

        apiService.items.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {

                val body = response?.body()
                Toast.makeText(this@MainActivity,body, Toast.LENGTH_SHORT).show()
                textView.text = body
            }

        })
    }
}
