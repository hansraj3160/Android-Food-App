package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Pizza_fragment extends Fragment {
     View view;
      RecyclerView recyclerView;
    RecyclerAdapter_salad adapter;
    String[] pizza_name={"Chicken Fajita","Chicken Tikka","Cheesy Pizza","Veggie Pizza","Fajita Sicilian","BBQ Pizza",
            "Malai Boti","Chicken Supreme","Hot & Spicy","Afghani Tikka","Pepperoni","Peri-peri","Chicken Suppreme","Behari Chicken","Seekh Kebab"};
    int[] pic={R.drawable.a0,R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.img_4,R.drawable.a5,
            R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.pizza_1,R.drawable.pizza_2,
            R.drawable.pizza_4,R.drawable.pizza_5,R.drawable.pizza_6,R.drawable.a2};
    String[] prices={"$30","$10","$20","$22","$30","$14","$22","$40","$21","$13","$22","$43","$25","$26","$33"};
    String[] description={"Classis mozzarella cheese & tomato","Spicy Pakistani Tikka chunks Oninons",
            "Signature Creamy Sauce, Spicy chicken Chunks, Oninons & Green Preper topped with our SignatureSauce",
            "Tomatoes,Onions & Green Pepper","Signature Fajita Chicken Chinks, Onions & Green Prepper",
            "Signature Fajita Chicken Chunks,onions","Classis mozzarella cheese & tomato","Spicy Pakistani Tikka chunks Oninons",
             "Tomatoes,Onions & Green Pepper","Signature Fajita Chicken Chinks, Onions & Green Prepper",
            "Simplicity Valued and Taken to the next level by adding more flavor","Pizza with a desi twist","Good Pizza","Love qone","Very Chickeny"};

    HomeScreen homeScreen;

    public Pizza_fragment(HomeScreen homeScreen) {
        this.homeScreen=homeScreen;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_pizza, container, false);
        recyclerView = view.findViewById(R.id.recycleView_pizza);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new RecyclerAdapter_salad(getContext(), pizza_name, description, pic, prices);
        recyclerView.setAdapter(adapter);
        return view;
    }
}