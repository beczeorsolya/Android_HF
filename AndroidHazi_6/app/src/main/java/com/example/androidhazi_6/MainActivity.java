package com.example.androidhazi_6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    public String FRAG1 = "fragment_portait";
    public String FRAG2 = "fragment_landscape";

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
        if(savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                fragmentTransaction.replace(R.id.fragment1, new Fragment1(), FRAG1);
            } else {
                fragmentTransaction.add(R.id.fragment1, new Fragment1(), FRAG1);
            }
            fragmentTransaction.commit();
        }
    }
    public void itemSelected(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction.replace(R.id.fragment1, Fragment2.newInstance(position), FRAG2);

        }
        else {
            fragmentTransaction.replace(R.id.fragment1, Fragment2.newInstance(position), FRAG2);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

}