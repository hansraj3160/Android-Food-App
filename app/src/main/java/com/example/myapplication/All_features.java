package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class All_features extends Fragment {
     View view;
      RecyclerView recyclerView;
    RecyclerAdapter adapter;
    String[] pizza_name={"Chicken Fajita","Chicken Tikka","Cheesy Pizza","Veggie Pizza","Fajita Sicilian","BBQ Pizza",
            "Malai Boti"};
    int[] pic={R.drawable.a0,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.img_4,R.drawable.a5,
            R.drawable.a7};
    String[] prices={"$30","$10","$20","$22","$30","$14","$22"};
    String[] description={"Classis mozzarella cheese & tomato","Spicy Pakistani Tikka chunks Oninons",
            "Signature Creamy Sauce, Spicy chicken Chunks, Oninons & Green Preper topped with our SignatureSauce",
            "Tomatoes,Onions & Green Pepper","Signature Fajita Chicken Chinks, Onions & Green Prepper",
            "Signature Fajita Chicken Chunks,onions","Classis mozzarella cheese & tomato","Spicy Pakistani Tikka chunks Oninons",
                };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       view=  inflater.inflate(R.layout.fragment_all_features, container, false);
        recyclerView=view.findViewById(R.id.recycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new RecyclerAdapter(getContext(),pizza_name,description,pic,prices);
        recyclerView.setAdapter(adapter);
        return view;
    }
}