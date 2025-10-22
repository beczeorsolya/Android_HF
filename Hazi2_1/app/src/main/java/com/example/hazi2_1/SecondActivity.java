package com.example.hazi2_1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status: ", "com.example.hazi2_1.SecondActivity:onDestroy");
    }
}