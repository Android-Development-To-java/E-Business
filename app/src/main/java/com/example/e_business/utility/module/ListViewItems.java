package com.example.e_business.utility.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.e_business.R;

public class ListViewItems extends BaseAdapter {

    String [] allSet;
    Context contextL;

    public ListViewItems (){

    }

    public ListViewItems(String [] allSets, Context context){
        this.allSet = allSets;
        this.contextL = context;

    }


    @Override
    public int getCount() {
        return allSet.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) contextL.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.catergory_sample_view, viewGroup, false);
        }

        TextView textViewList = view.findViewById(R.id.txt_category_sample);
        textViewList.setText(allSet[i]);

        return view;
    }
}
