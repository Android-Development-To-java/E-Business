package com.example.e_business;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.e_business.utility.ui.AccountFragment;
import com.example.e_business.utility.ui.FavoriteFragment;
import com.example.e_business.utility.ui.HomeFragment;
import com.example.e_business.utility.ui.SearchFragment;
import com.example.e_business.utility.ui.UploadItemsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Objects.requireNonNull(this.getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.frame_layout);

        mySetFragment(new HomeFragment());


        bottomNav();
    }


    private void bottomNav() {


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home_id_item:
                        mySetFragment(new HomeFragment());
                        break;
                    case R.id.favorite:
                        mySetFragment(new FavoriteFragment());
                        break;

                    case R.id.upload:
                        mySetFragment(new UploadItemsFragment());
                        break;

                    case R.id.search:
                        mySetFragment(new SearchFragment());
                        break;

                    case R.id.account:
                        mySetFragment(new AccountFragment());
                        break;


                }

                return false;
            }
        });
    }


    private void mySetFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();

    }


}