package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Cold_drink_fragment extends Fragment {
  View view;
    RecyclerView recyclerView;
    RecyclerAdapter_salad adapter;
    String[] cold_drinkname ={"Wine","Coffee","Lemonade","Iced tea","Hot chocolate","Juice","Milkshake","Water",
            "Milk","Beer","Soda","Tomato juice","Smoothie","Milkshake","Coconut milk"};
    int[] pic={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,R.drawable.d1,R.drawable.d2,R.drawable.d3
                ,R.drawable.d2,R.drawable.d4,R.drawable.d2,R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d5};
             String[] cold_drink;
             String[] prices={"$30","$10","$20","$22","$30","$14","$22","$40","$21","$13","$22","$43","$25","$26","$33"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        cold_drink =getResources().getStringArray(R.array.drink_desc);

        view= inflater.inflate(R.layout.cold_drink_fragment, container, false);
         recyclerView=view.findViewById(R.id.recycleView_cold_drink);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter=new RecyclerAdapter_salad(getContext(), cold_drinkname, cold_drink,pic,prices);
        recyclerView.setAdapter(adapter);
        return view;
    }
}