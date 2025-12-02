package com.example.androidhazi_6;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PriceAdapter extends ArrayAdapter<String> {
    private final int[] flags;
    private final Double[] sell;
    private final Double[] buy;
    public Context context;

    public PriceAdapter(Context context, int[] flags, String[] currencies, Double[] sell, Double[] buy) {
        super(context, R.layout.item, currencies);
        this.flags = flags;
        this.sell = sell;
        this.buy = buy;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }

        ImageView img = convertView.findViewById(R.id.imageView);
        TextView cur_name = convertView.findViewById(R.id.cur_bold);
        TextView cur_long = convertView.findViewById(R.id.cur_long);
//        TextView selling = convertView.findViewById(R.id.sell);
//        TextView buying = convertView.findViewById(R.id.buy);
       // TextView bprice = convertView.findViewById(R.id.buy_price);
        //TextView sprice = convertView.findViewById(R.id.sell_price);

        img.setImageResource(flags[position]);
        cur_name.setText(getItem(position));
        cur_long.setText(getItem(position));
        //selling.setText("Vinde");
        //buying.setText("Cumpara");
        //sprice.setText(String.valueOf(sell[position]));
        //bprice.setText(String.valueOf(buy[position]));

        return convertView;
    }
}
