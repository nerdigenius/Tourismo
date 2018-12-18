package com.example.drazzer.tourismo.TimeConverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

import java.util.ArrayList;


/**
 * Created by Drazzer on 12/13/2017.
 */

class Time_Converter_Adapter extends BaseAdapter{

    ArrayList<GetZones> arrayLists=new ArrayList<>();
    Context context;

    public Time_Converter_Adapter(ArrayList<GetZones> arrayLists, Context context) {
        this.arrayLists = arrayLists;
        this.context = context;
    }

    public Time_Converter_Adapter() {
    }

    @Override
    public int getCount() {
        return arrayLists.size();
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
        convertView = inflater.inflate(R.layout.timezone_custom_row,null);
        GetZones getZones;
        getZones=arrayLists.get(position);
        TextView CountryName,CountryId;


        CountryName=convertView.findViewById(R.id.CountryName);
        CountryId=convertView.findViewById(R.id.CountryId);



        CountryName.setText(getZones.getCountryName());
        CountryId.setText(getZones.getCountryCode());

        return convertView;
    }
}
