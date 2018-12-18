package com.example.drazzer.tourismo.SocialDinning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.drazzer.tourismo.R;


/**
 * Created by Drazzer on 12/15/2017.
 */

class FoodAdapter extends BaseAdapter {


    Context context;

    public FoodAdapter(Object arrayList, Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.food_custom_list,null);




        return convertView;
    }
}
