package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

 String data[];
 Context context;
 int pic[];
 String arraymsg[];
 String prices[];
    public RecyclerAdapter(Context context, String[] data, String[] arraymsg, int[] pic,String[] price){
        this.data=data;
        this.context=context;
        this.pic=pic;
        this.arraymsg=arraymsg;
        this.prices=price;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.custome_design,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.imageView.setImageResource(pic[position]);
        holder.textView.setText(data[position]);
        holder.txtmsg.setText(arraymsg[position]);
        holder.txtprice.setText(prices[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked "+data[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView,txtmsg,txtprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview_id);
            imageView=itemView.findViewById(R.id.imageView);
            txtmsg=itemView.findViewById(R.id.textmsg_id);
            txtprice=itemView.findViewById(R.id.id_priceP);
        }
    }
}
