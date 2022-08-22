package com.multic.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.multic.R

class Res : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)
        val attemp=findViewById<TextView>(R.id.attemp)
        val start=findViewById<Button>(R.id.button2)
        attemp.text=getIntent().getStringExtra("att")
        start.setOnClickListener {
            val intent1= Intent(this@Res, Game::class.java)
            startActivity(intent1)
        }
    }
}