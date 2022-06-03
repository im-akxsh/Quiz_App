package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name : EditText = findViewById(R.id.name)
        val btnstart : Button = findViewById(R.id.btn_start)
        btnstart.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"Name is Empty",Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this,QuizQuiestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }

        }


    }
}