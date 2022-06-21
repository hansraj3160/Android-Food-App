package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class full_details_Fragment extends Fragment {
    View view;
    TextView textView,textView1,textView2;
    ImageView imageView;
    String imgPosition;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_full_details, container, false);
        textView = view.findViewById(R.id.idText);
        imageView = view.findViewById(R.id.id_imagedetail);
        textView1 = view.findViewById(R.id.textview_id);
        Bundle bundle = this.getArguments();
        imgPosition = bundle.getString("image");
        int ids = getResources().getIdentifier(imgPosition, "drawable", getContext().getPackageName());
        imageView.setImageResource(ids);
        textView1.setText(bundle.getString("name"));
        textView.setText(bundle.getString("description"));
        return view;
    }

}