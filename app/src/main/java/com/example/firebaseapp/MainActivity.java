package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        var count=0;
        val rb=findViewById<Button>(R.id.bt)
                val rr=findViewById<TextView>(R.id.tx)
                rb.setOnClickListener{
            count++;
            rr.text=count.toString();
        }
    }
}
