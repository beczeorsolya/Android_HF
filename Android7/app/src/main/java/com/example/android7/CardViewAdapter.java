package com.example.android7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.ViewHolder> {
    private Context context;
    private List<Prices> items;

    public CardViewAdapter(Context context, List<Prices> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CardViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewAdapter.ViewHolder holder, int position) {
        Prices price = items.get(position);

        holder.img.setImageResource(price.getFlags());
        holder.cur_name.setText(price.getCurrencies());
        holder.cur_long.setText(price.getCur_long());
        holder.buying.setText("Cumpara");
        holder.selling.setText("Vinde");
        holder.sprice.setText(String.valueOf(price.getSell()));
        holder.bprice.setText(String.valueOf(price.getBuy()));


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView cur_name;
        TextView cur_long;
        TextView selling;
        TextView buying;
        TextView bprice;
        TextView sprice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageView);
            cur_name = itemView.findViewById(R.id.cur_bold);
             cur_long = itemView.findViewById(R.id.cur_long);
             selling = itemView.findViewById(R.id.sell);
             buying = itemView.findViewById(R.id.buy);
             bprice = itemView.findViewById(R.id.buy_price);
             sprice = itemView.findViewById(R.id.sell_price);

        }
    }
}
