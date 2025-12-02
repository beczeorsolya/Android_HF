package com.example.androidhazi_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    int[] flaglist = {R.drawable.jam, R.drawable.hu, R.drawable.ind, R.drawable.lit, R.drawable.latv};
    String[] currencies = {"JMD", "FT", "INR", "LTL", "LVL"};
    Double[] sell = {0.02700, 0.0132174, 0.0495109, 1.47241, 7.23382};
    Double[] buy = {36.6624, 75.658, 20.1976, 0.679172, 0.13824};
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment2() {
        // Required empty public constructor
        }

    public static Fragment2 newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);

        Fragment2 fragment2 = new Fragment2();
        fragment2.setArguments(bundle);
        return fragment2;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        int pos = getArguments().getInt("pos");

        TextView selling = view.findViewById(R.id.sell2);
        TextView buying = view.findViewById(R.id.buy2);
        TextView bprice = view.findViewById(R.id.buy_price2);
        TextView sprice = view.findViewById(R.id.sell_price2);

        buying.setText("Cumpara");
        selling.setText("Vinde");
        sprice.setText(String.valueOf(sell[pos]));
        bprice.setText(String.valueOf(buy[pos]));

        return view;
    }
}