package com.example.e_business.utility.module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_business.R;

public class RecyclerAdapterCategory extends RecyclerView.Adapter <RecyclerAdapterCategory.MyViewHolder> {

    String [] allCategoryText;

    Context contexts;

    public RecyclerAdapterCategory(){

    }

    public RecyclerAdapterCategory(String [] allText,Context context){
        this.allCategoryText = allText;
        this.contexts = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) contexts.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View views = inflater.inflate(R.layout.catergory_sample_view,parent,false);

        return new MyViewHolder(views);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.textView.setText(allCategoryText[position]);

    }

    @Override
    public int getItemCount() {
        return allCategoryText.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{


        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_category_sample);
        }
    }
}
