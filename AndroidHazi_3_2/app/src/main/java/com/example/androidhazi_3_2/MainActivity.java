package com.example.androidhazi_3_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> termek_lista = new ArrayList<>();
    String termekek_egybefuzve = "";

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
        TextView code = findViewById(R.id.code_text);
        TextView name = findViewById(R.id.name_text);
        TextView price = findViewById(R.id.pprice);
        TextView termekek_view = findViewById(R.id.termekek_text);


        Button add_button = findViewById(R.id.add_prod);
        Button cancel_button = findViewById(R.id.cancel_b);
        Button show_button = findViewById(R.id.show_p_button);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameP = name.getText().toString();
                String codeP = code.getText().toString();
                String priceP = price.getText().toString();

                if (nameP.isEmpty() || codeP.isEmpty() || priceP.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Töltsd ki az összes mezőt!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Product product = new Product(nameP, priceP, codeP);
                termek_lista.add(product);
            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code.setText("");
                price.setText("");
                name.setText("");
            }
        });

        show_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(Product product : termek_lista) {
                    termekek_egybefuzve += product.toString() + " ";
                }
                termekek_view.setText(termekek_egybefuzve);
            }

        });
    }

}