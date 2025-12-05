package com.example.android7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int[] flaglist = {R.drawable.jam, R.drawable.hu, R.drawable.ind, R.drawable.lit, R.drawable.latv};
    String[] currencies = {"JMD", "FT", "INR", "LTL", "LVL"};
    String[] cur_long = {"Jam. Dollar", "Hu. Forint", "Ind. Rupee", "Lit. Litas", "Latv. Lati"};
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



        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Prices> list = new ArrayList<>();

        for (int i = 0; i < currencies.length; i++) {
            list.add(new Prices(flaglist[i], currencies[i], cur_long[i], buy[i], sell[i]));
        }
        CardViewAdapter adapter = new CardViewAdapter(this, list);
        recyclerView.setAdapter(adapter);
    }

}