package com.example.e_business.utility.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.e_business.R;


public class UploadItemsFragment extends Fragment {

    private ImageView imageViewProduct;

    private TextView prd_name, prd_price, prd_details;

    private Button pro_save_btn;

    private View viewU;

    public UploadItemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewU = inflater.inflate(R.layout.fragment_upload_items, container, false);

        allFinding();

        return viewU;
    }

    private void allFinding() {
        imageViewProduct = viewU.findViewById(R.id.product_img);
        prd_name = viewU.findViewById(R.id.product_name);
        prd_price = viewU.findViewById(R.id.product_price);
        prd_details = viewU.findViewById(R.id.product_details);

        pro_save_btn = viewU.findViewById(R.id.save_product_btn);
    }

}