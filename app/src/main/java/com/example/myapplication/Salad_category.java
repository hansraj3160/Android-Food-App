package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class Salad_category extends Fragment {
    View view;
    RecyclerView recyclerView;
    RecyclerAdapter_salad adapter;
    String[] salad_name ={"Caesar Salad","Leafy Green Salad","Greek Salad","Fattoush","Niçoise Salad","Composed Salad",
            "Cobb Salad","Wedge Salad","Insalata Caprese","Bound Salad","Chicken Salad","Ambrosia","Waldorf Salad","Greek Salad","Fattoush"};
    int[] pic={R.drawable.salad1,R.drawable.salad2,R.drawable.salad3,R.drawable.salad4,R.drawable.salad5,R.drawable.img_1,R.drawable.img_3,R.drawable.img_2
                ,R.drawable.img,R.drawable.salad1,R.drawable.img_5,R.drawable.img_6,R.drawable.salad4,R.drawable.salad3,R.drawable.salad5};
    String[] salad_description;
    String[] prices={"$30","$10","$20","$22","$30","$14","$22","$40","$21","$13","$22","$43","$25","$26","$33"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        salad_description =getResources().getStringArray(R.array.salad_dis);
        view= inflater.inflate(R.layout.salad_category, container, false);
         recyclerView=view.findViewById(R.id.recycleView_salad);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter=new RecyclerAdapter_salad(getContext(), salad_name, salad_description,pic,prices);
        recyclerView.setAdapter(adapter);
        return view;
    }
}