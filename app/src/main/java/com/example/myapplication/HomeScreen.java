package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
    int itemCount=1,total_price=0;
    int price=0;

    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    TextView textView,textView1,ItemCount,item_price;
    ImageView imageView;
    String imgPosition;
    ArrayList<AddCart> addCarts;
     MenuItem menuItem;
    // badge text view
    TextView badgeCounter;
    // change the number to see badge in action
    int pendingNotifications = 1;

     public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addCarts=new ArrayList<>();

       drawerLayout = findViewById(R.id.drawerContainer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

         replaceFragment(new All_features());
    }


     @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
         int id_=item.getItemId();
         switch (id_){
             case R.id.item_logout:
                 Intent intent=new Intent(this,Login.class);
                 startActivity(intent);
                 finish();

         }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.top_menu,menu);
        menuItem = menu.findItem(R.id.id_cart);
        // check if any pending notification
        if (pendingNotifications == 0) {
            // if no pending notification remove badge
            menuItem.setActionView(null);
        } else {

            // if notification than set the badge icon layout
            menuItem.setActionView(R.layout.notification_badge);
            // get the view from the nav item
            View view = menuItem.getActionView();
            // get the text view of the action view for the nav item
            badgeCounter = view.findViewById(R.id.badge_counter);
            // set the pending notifications value
            badgeCounter.setText(String.valueOf(pendingNotifications));
        }
        return true;
    }

    public void showDetails(View view) {
    }
    public void allCategory(View view){
     replaceFragment(new All_features());
    }
     public void pizzaCategory(View view){
     replaceFragment(new Pizza_fragment(this));
    }
    public void saladCategory(View view){
        replaceFragment(new Salad_category());
    }
    public void drinkCategory(View view){
        replaceFragment(new Cold_drink_fragment());
    }
     public void burgerCategory(View view){
        replaceFragment(new BurgerFragment());
    }

    private void replaceFragment(Fragment fragment){
          FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
                      fragmentTransaction.replace(R.id.frameLayout,fragment).commit();

    }
     public void onIncrease(View view){

//         Toast.makeText(this, "item count"+itemCount, Toast.LENGTH_SHORT).show();
         setPizzaDetailsFragment(null);


    }
    public void setPizzaDetailsFragment(Bundle bundle){

         dialogBuilder=new AlertDialog.Builder(this);
         View contactPopupView=getLayoutInflater().inflate(R.layout.fragment_full_details,null);
         Button btn=contactPopupView.findViewById(R.id.btn_add);
          Button btn_dec=contactPopupView.findViewById(R.id.id_btn_remove);
          Button btn_addcart=contactPopupView.findViewById(R.id.id_btn_addcart);

         ItemCount=contactPopupView.findViewById(R.id.id_item_count);
         textView = contactPopupView.findViewById(R.id.idText);
        imageView = contactPopupView.findViewById(R.id.id_imagedetail);
        textView1 = contactPopupView.findViewById(R.id.textview_id);
        item_price=contactPopupView.findViewById(R.id.id_price);
        price=Integer.parseInt((bundle.getString("price")).substring(1,(bundle.getString("price")).length()));
         total_price=price;
        item_price.setText("$"+total_price+"");
        btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                  itemCount++;
                  ItemCount.setText(itemCount+"");
                  total_price+=price;
                   item_price.setText("$"+total_price+"");
             }
         });
           btn_dec.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (itemCount>1) {
                     itemCount--;
                     ItemCount.setText(itemCount + "");
                      total_price -=price;
                      item_price.setText("$"+total_price+"");
                 }
             }
         });
        btn_addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              pendingNotifications++;

                    badgeCounter.setText(String.valueOf(pendingNotifications));

            }
        });

        imgPosition = bundle.getString("image");
        int ids = getResources().getIdentifier(imgPosition, "drawable", getPackageName());
        imageView.setImageResource(ids);
        textView1.setText(bundle.getString("name"));
        textView.setText(bundle.getString("description"));
         dialogBuilder.setView(contactPopupView);
         dialog=dialogBuilder.create();
         dialog.show();
    }

}