package com.example.e_business.utility.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.e_business.R;
import com.example.e_business.utility.module.ListViewItems;


public class AccountFragment extends Fragment {



    String [] allList;
    public ListView listView;


    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View viewS = inflater.inflate(R.layout.fragment_account, container, false);

        listView = viewS.findViewById(R.id.list_view);

        allList = getResources().getStringArray(R.array.all_setting);

        ListViewItems listViewItems = new ListViewItems(allList,getContext());
        listView.setHasTransientState(true);
        listView.setAdapter(listViewItems);



        return viewS;
    }
}