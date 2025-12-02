package com.example.android_5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] tomb;
    ArrayList<String> stringArrayList;
    ListView lista;

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
        tomb = getResources().getStringArray(R.array.programozasi_nyelvek);
        stringArrayList = new ArrayList<>(Arrays.asList(tomb));
        lista = findViewById(R.id.list_id);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringArrayList);
        lista.setAdapter(arrayAdapter);

        registerForContextMenu(lista);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context, menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = item.getItemId();
        TextView textView = lista.getChildAt(info.position).findViewById(android.R.id.text1);

        if (id == R.id.red) {
            textView.setTextColor(Color.RED);
        } else if (id == R.id.green) {
            textView.setTextColor(Color.GREEN);
        } else if (id == R.id.yellow) {
            textView.setTextColor(Color.YELLOW);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.sort) {
            Arrays.sort(tomb);
            stringArrayList.clear();
            stringArrayList.addAll(Arrays.asList(tomb));
        }
        else {
            stringArrayList.clear();
        }
        ((ArrayAdapter)lista.getAdapter()).notifyDataSetChanged();
        return true;
    }
}

