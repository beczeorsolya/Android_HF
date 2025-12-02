package com.example.hazi_4;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int[] flaglist = {R.drawable.jam, R.drawable.hu, R.drawable.ind, R.drawable.lit, R.drawable.latv};
    String[] currencies = {"JMD", "FT", "INR", "LTL", "LVL"};
    Double[] sell = {0.02700, 0.0132174, 0.0495109, 1.47241, 7.23382};
    Double[] buy = {36.6624, 75.658, 20.1976, 0.679172, 0.13824};

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
        ListView listv = findViewById(R.id.listview);
        PriceAdapter adapter = new PriceAdapter(this, flaglist,currencies,sell,buy);
        listv.setAdapter(adapter);

        listv.setOnItemClickListener((parent, view, position, id) -> {
            String information = currencies[position];
            Toast.makeText(MainActivity.this, information, Toast.LENGTH_SHORT).show();
        });
    }
}