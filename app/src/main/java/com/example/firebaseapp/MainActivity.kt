package com.example.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count=0;
        val rb=findViewById<Button>(R.id.bt)
        val rr=findViewById<TextView>(R.id.tx)
        rb.setOnClickListener{
            count++;
            rr.text=count.toString();
    }
    }

}
