package com.example.e_business.utility.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.e_business.R;
import com.example.e_business.utility.module.GridAdapter;
import com.example.e_business.utility.module.SlidingAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

    GridView gridView;
     SliderView sliderViewS;

//     int [] imgS = getResources().getIntArray(R.array.imgAll);


     int [] img =  {R.drawable.image2,R.drawable.image1,R.drawable.image2,R.drawable.image1};






    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View views = inflater.inflate(R.layout.fragment_home, container, false);

        sliderViewS = views.findViewById(R.id.image_slider);

        gridView = views.findViewById(R.id.gridView);

        SlidingAdapter mySliderAdapter = new SlidingAdapter(img,getContext());

        sliderViewS.setSliderAdapter(mySliderAdapter);

        sliderViewS.setIndicatorAnimation(IndicatorAnimationType.SWAP); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderViewS.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderViewS.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderViewS.setIndicatorSelectedColor(Color.WHITE);
        sliderViewS.setIndicatorUnselectedColor(Color.GRAY);
        sliderViewS.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderViewS.startAutoCycle();

      //  GridAdapter gridAdapter = new GridAdapter();







        return views;
    }



}