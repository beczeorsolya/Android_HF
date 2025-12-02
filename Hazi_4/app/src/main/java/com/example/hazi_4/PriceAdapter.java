package com.example.hazi_4;

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
    private int[] flags;
    private String[] currencies;
    private Double[] sell;
    private Double[] buy;
    private Context context;
    public PriceAdapter(Context context, int[] flags, String[] currencies, Double[] sell, Double[] buy) {
        super(context,R.layout.list_item1, currencies);
        this.flags = flags;
        this.currencies = currencies;
        this.sell = sell;
        this.buy = buy;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item1,parent, false);

        ImageView img = view.findViewById(R.id.imageView);
        TextView cur_name = view.findViewById(R.id.cur_bold);
        TextView cur_long = view.findViewById(R.id.cur_long);
        TextView selling = view.findViewById(R.id.sell);
        TextView buying = view.findViewById(R.id.buy);
        TextView bprice = view.findViewById(R.id.buy_price);
        TextView sprice = view.findViewById(R.id.sell_price);

        img.setImageResource(flags[position]);
        cur_name.setText(position);
        cur_long.setText(position);
        buying.setText("Cumpara");
        selling.setText("Vinde");
        sprice.setText(String.valueOf(sell[position]));
        bprice.setText(String.valueOf(buy[position]));

        return view;
    }
}
