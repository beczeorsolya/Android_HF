package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView first_number = findViewById(R.id.editTextText2);
        TextView second_number = findViewById(R.id.editTextText3);

        Button btn_plus = findViewById(R.id.button_plus);
        Button btn_minus = findViewById(R.id.button_minus);
        Button btn_mult = findViewById(R.id.button_multiply);
        Button btn_dvd = findViewById(R.id.button_divide);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fn = Integer.parseInt(first_number.getText().toString());
                int sn = Integer.parseInt(second_number.getText().toString());
                int sum = fn + sn;
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fn = Integer.parseInt(first_number.getText().toString());
                int sn = Integer.parseInt(second_number.getText().toString());
                int sum = fn - sn;
            }
        });
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fn = Integer.parseInt(first_number.getText().toString());
                int sn = Integer.parseInt(second_number.getText().toString());
                int sum = fn * sn;
            }
        });
        btn_dvd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int fn = Integer.parseInt(first_number.getText().toString());
                int sn = Integer.parseInt(second_number.getText().toString());
                int sum = fn / sn;
            }
        });
        Button calculate = findViewById(R.id.button5);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate.setText(sum);
            }
        });
    }
}