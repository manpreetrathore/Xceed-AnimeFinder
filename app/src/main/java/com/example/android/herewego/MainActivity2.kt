package com.example.android.herewego

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var searchButton: Button
    lateinit var uriText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        searchButton = findViewById(R.id.searchBtn)
        uriText = findViewById(R.id.uri)

        searchButton.setOnClickListener {
            var txt:String = uriText.getText().toString()
            println(txt)
//            if(txt.trim().length>0) {
//                Toast.makeText(applicationContext,"Enter the image Link",Toast.LENGTH_SHORT).show()
//            }
//            else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("url", txt)
                startActivity(intent)
//            }
        }
    }
}