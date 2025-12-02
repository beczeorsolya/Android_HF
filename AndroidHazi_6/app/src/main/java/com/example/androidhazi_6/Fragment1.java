package com.example.androidhazi_6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    int[] flaglist = {R.drawable.jam, R.drawable.hu, R.drawable.ind, R.drawable.lit, R.drawable.latv};
    String[] currencies = {"JMD", "FT", "INR", "LTL", "LVL"};
    Double[] sell = {0.02700, 0.0132174, 0.0495109, 1.47241, 7.23382};
    Double[] buy = {36.6624, 75.658, 20.1976, 0.679172, 0.13824};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Fragment1() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // TODO: Rename and change types of parameters
            String mParam1 = getArguments().getString(ARG_PARAM1);
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        ListView listv = view.findViewById(R.id.frag_list);
        PriceAdapter adapter = new PriceAdapter(requireContext(), flaglist,currencies,sell,buy);
        listv.setAdapter(adapter);

        listv.setOnItemClickListener((parent, v, position, id) -> {

            if(getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).itemSelected(position);
            }
        });
        return view;
    }
}