package com.example.e_business.utility.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.e_business.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SlidingAdapter extends SliderViewAdapter<SlidingAdapter.HolderV> {

    int[] imagesAll;
    Context context;


    public SlidingAdapter(Context context) {
        this.context = context;
    }


    public SlidingAdapter(int[] image, Context context) {
        this.imagesAll = image;
        this.context = context;
    }


    @Override
    public HolderV onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_view_itrems, parent, false);

        return new HolderV(view);
    }

    @Override
    public void onBindViewHolder(HolderV viewHolder, int position) {

        if (viewHolder != null){
            viewHolder.imageView.setImageResource((imagesAll[position]));
        }else {
            Toast.makeText(context, "SomeThing Happened!!!", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public int getCount() {
        return imagesAll.length;
    }

    public class HolderV extends SliderViewAdapter.ViewHolder {


        ImageView imageView;

        public HolderV(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view_sliding);


        }
    }

}
