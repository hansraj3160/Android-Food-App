package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivty2 extends AppCompatActivity {
    TextView textView,textView1,textView2;
    ImageView imageView;
    String imgPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activty2);

        textView=findViewById(R.id.idText);
        imageView=findViewById(R.id.id_imagedetail);
        textView1=findViewById(R.id.textview_id);
        Intent intent=getIntent();
      imgPosition=intent.getStringExtra("image");
      int ids = getResources().getIdentifier(imgPosition, "drawable", getPackageName());
      imageView.setImageResource(ids);
      textView1.setText(intent.getStringExtra("name"));
     textView.setText(intent.getStringExtra("description"));
    }
}