package com.example.e_business.utility.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.e_business.R;
import com.example.e_business.utility.module.GridAdapter;
import com.example.e_business.utility.module.ItemsUpload;
import com.example.e_business.utility.module.SlidingAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {

    GridView gridViews;
    SliderView sliderViewS;

    List<ItemsUpload> uploadList;


    DatabaseReference databaseReference;

    public ImageButton imageButton1,imageButton2,imageButton3,imageButton4;

//     int [] imgS = getResources().getIntArray(R.array.imgAll);

    int[] img = {R.drawable.image2, R.drawable.image1, R.drawable.image2, R.drawable.image1};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View views = inflater.inflate(R.layout.fragment_home, container, false);

        sliderViewS = views.findViewById(R.id.image_slider);

        gridViews = views.findViewById(R.id.grid_view);

        SlidingAdapter mySliderAdapter = new SlidingAdapter( getContext(),img);

        sliderViewS.setSliderAdapter(mySliderAdapter);

        uploadList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference("Upload");




        fireBaseDataReceive();


//set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderViewS.setIndicatorAnimation(IndicatorAnimationType.SWAP);
        sliderViewS.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderViewS.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderViewS.setIndicatorSelectedColor(Color.WHITE);
        sliderViewS.setIndicatorUnselectedColor(Color.GRAY);
        sliderViewS.setScrollTimeInSec(2); //set scroll delay in seconds :
        sliderViewS.startAutoCycle();


        imageButton1 = views.findViewById(R.id.category_items);
        imageButton2 = views.findViewById(R.id.favorite_items);
        imageButton3 = views.findViewById(R.id.gift_items);
        imageButton4 = views.findViewById(R.id.top_selling_items);


        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);







        return views;
    }










    public void fireBaseDataReceive() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ItemsUpload itemsUploadData = dataSnapshot.getValue(ItemsUpload.class);
                    uploadList.add(itemsUploadData);
                }



                GridAdapter gridAdapter = new GridAdapter(getContext(),uploadList);
                gridViews.setAdapter(gridAdapter);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "SomeThing is wrong !!!" + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });




    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.category_items :
                loadingFT(new CategoryFragment());
                break;

            case R.id.favorite_items:
                loadingFT(new FavoriteFragment());
                break;

        }

    }

    public void loadingFT(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}