package com.example.e_business.utility.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.e_business.R;
import com.example.e_business.utility.module.RecyclerAdapterCategory;

public class CategoryFragment extends Fragment {


    public  String [] allCategory;
    public RecyclerView recyclerView;


    public CategoryFragment() {
        // Required empty public constructor
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


       View view =  inflater.inflate(R.layout.fragment_category, container, false);

       allCategory = getResources().getStringArray(R.array.categories_name);


       recyclerView =  view.findViewById(R.id.recycler_category);

       someThing();




       return view;
    }

    public void someThing(){

        RecyclerAdapterCategory adapterCategory = new RecyclerAdapterCategory(allCategory,getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterCategory);

    }
}