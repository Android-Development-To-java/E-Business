package com.example.e_business.utility.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.e_business.R;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class SlidingAdapter extends SliderViewAdapter<SlidingAdapter.HolderV> {


    Context contexts;

    int [] images;


    public SlidingAdapter(Context context) {
        this.contexts = context;
    }


    public SlidingAdapter(Context context, int [] imageAll) {

        this.contexts = context;
        this.images = imageAll;

    }


    @Override
    public HolderV onCreateViewHolder(ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_view_itrems, parent, false);

        return new HolderV(view);
    }

    @Override
    public void onBindViewHolder(HolderV viewHolder, int position) {

       Picasso.get()
               .load(images[position])
               .fit()
               .centerCrop()
               .into(viewHolder.imageView);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    public class HolderV extends SliderViewAdapter.ViewHolder {


        ImageView imageView;

        public HolderV(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view_sliding);


        }
    }

}
