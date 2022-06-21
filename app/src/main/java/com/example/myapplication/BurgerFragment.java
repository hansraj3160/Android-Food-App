package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BurgerFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    RecyclerAdapter_salad adapter;
    String[] burgers_name;
    int[] pic={R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6,R.drawable.b2,R.drawable.b3
                ,R.drawable.b2,R.drawable.b4,R.drawable.b2,R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b5};
             String[] burger_description;
             String[] prices={"$30","$10","$20","$22","$30","$14","$22","$40","$21","$13","$22","$43","$25","$26","$33"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         burger_description =getResources().getStringArray(R.array.burger_des);
         burgers_name =getResources().getStringArray(R.array.burger_name);
        view= inflater.inflate(R.layout.fragment_burger, container, false);
       recyclerView=view.findViewById(R.id.recycleView_burger);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter=new RecyclerAdapter_salad(getContext(), burgers_name, burger_description,pic,prices);
        recyclerView.setAdapter(adapter);
        return view;
    }
}