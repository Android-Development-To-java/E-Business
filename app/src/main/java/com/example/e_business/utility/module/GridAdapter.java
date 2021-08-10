package com.example.e_business.utility.module;import android.content.Context;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.BaseAdapter;import android.widget.ImageView;import android.widget.TextView;import com.example.e_business.R;public class GridAdapter  extends BaseAdapter {    Context context;    String[] itemName;    int[] image;    public GridAdapter(Context context, String[] itemName, int[] image) {        this.context = context;        this.itemName = itemName;        this.image = image;    }    @Override    public int getCount() {        return itemName.length;    }    @Override    public Object getItem(int position) {        return null;    }    @Override    public long getItemId(int position) {        return 0;    }    @Override    public View getView(int position, View convertView, ViewGroup parent) {        if (convertView != null)        {            LayoutInflater.from(context).inflate(R.layout.gird_items,parent,false);        }        ImageView imageView = convertView.findViewById(R.id.ImageView);        TextView textView = convertView.findViewById(R.id.pro_name);        TextView textView1=convertView.findViewById(R.id.pro_prc);        imageView.setImageResource(image[position]);        textView.setText(itemName[position]);        textView1.setText(itemName[position]);        return null;    }}