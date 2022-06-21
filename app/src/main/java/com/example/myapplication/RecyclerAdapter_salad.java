package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.time.chrono.HijrahChronology;

public class RecyclerAdapter_salad extends RecyclerView.Adapter<RecyclerAdapter_salad.ViewHolder> {


 String data[];
 Context context;
 int pic[];
 String arraymsg[];
  String prices[];
  HomeScreen homeScreen;
    public RecyclerAdapter_salad(Context context, String[] data, String[] arraymsg, int[] pic,String[] prices){
        this.data=data;
        this.context=context;
        this.pic=pic;
        this.arraymsg=arraymsg;
        this.prices=prices;
    }

    public RecyclerAdapter_salad(Context context, String[] pizza_name, String[] description, int[] pic, String[] prices, HomeScreen homeScreen) {
        this.data=data;
        this.context=context;
        this.pic=pic;
        this.arraymsg=arraymsg;
        this.prices=prices;
        this.homeScreen=homeScreen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.category_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.imageView.setImageResource(pic[position]);
        holder.textView.setText(data[position]);
        holder.txtmsg.setText(arraymsg[position]);
         holder.txtprice.setText(prices[position]);
         holder.parentLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Bundle bundle=new Bundle();
                 int picsd=(pic[position]);
                 bundle.putString("image",""+picsd);
                 bundle.putString("name",data[position]);
                 bundle.putString("description",arraymsg[position]);
                 bundle.putString("price",prices[position]);
//                 bundle.
                 HomeScreen homeScreen = (HomeScreen) context;
                 homeScreen.setPizzaDetailsFragment(bundle);
             }
         });
    }



    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,txtmsg,txtprice,txtfont;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview_id);
            imageView=itemView.findViewById(R.id.imageView);
            txtmsg=itemView.findViewById(R.id.textmsg_id);
            txtprice=itemView.findViewById(R.id.id_price);
            txtfont=itemView.findViewById(R.id.fontawesome_x);
            parentLayout=itemView.findViewById(R.id.parent_layout);
        }
    }

}
