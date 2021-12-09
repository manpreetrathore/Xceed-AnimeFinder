package com.example.android.herewego

import android.os.Bundle
import android.util.Log.d
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.trace.moe/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler=findViewById(R.id.recyclerview_list)
        recycler?.setHasFixedSize(true)
        linearLayoutManager=LinearLayoutManager(this)
        recycler.layoutManager = linearLayoutManager
        val url = intent.getStringExtra("url")

        getMyData(url!!)
    }
lateinit var mainRes: TextView
    private fun getMyData(url:String) {
//        val gson = GsonBuilder()
//            .setLenient()
//            .create()

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData(url)
        println(url+"in Main 2")
        retrofitData.enqueue(object : Callback<MyData> {
            override fun onResponse(
                call: Call<MyData>,
                response: Response<MyData>
            ) {
//                println("Inside response")
////                val responseBody
//                if(response.isSuccessful()){}
//                else{
//                    try {
//                        val jObjError = JSONObject(response.errorBody()!!.string())
//                        println(jObjError)
////                        Toast.makeText(
////                            getContext(),
////                            jObjError.getJSONObject("error").getString("message"),
////                            Toast.LENGTH_LONG
////                        ).show()
//                    } catch (e: Exception) {
////                        Toast.makeText(getContext(), e.message, Toast.LENGTH_LONG).show()
//                        println("Exception $e")
//                    }
//                    val m = response.errorBody()
//                    println("Error body $m")}
//                val responseBody = response.body()
//                println("Repsonse ----------- $responseBody")
//                val myStringBuilder = StringBuilder()
//                for(data in responseBody!!.result) {
////                    myStringBuilder.append(responseBody.toString())
//                    myStringBuilder.append(data.anilist)
//                    myStringBuilder.append("\n")
//                }
//                println("String Builder $myStringBuilder")
//                mainRes = findViewById(R.id.txtID)
//                mainRes.text = myStringBuilder


                val responseBody = response.body()!!
                val array: MutableList<Result> = ArrayList()
                for(data in responseBody.result) {
                    array.add(data)
                }
                for(data in array)
                {
                    d("array",data.filename)
                }

                myAdapter = MyAdapter(baseContext,array)
                myAdapter.notifyDataSetChanged()
                recycler.adapter = myAdapter
            }


            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Toast.makeText(applicationContext, t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
}