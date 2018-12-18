package com.example.drazzer.tourismo.CurrencyConverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

import java.util.ArrayList;


/**
 * Created by Drazzer on 12/15/2017.
 */

class currencyAdapter extends BaseAdapter {

    ArrayList <Getinfo> arrayLists=new ArrayList<>();
    Context context;

    public currencyAdapter(ArrayList<Getinfo> arrayList, Context context) {
        this.arrayLists = arrayList;
        this.context = context;
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
        convertView = inflater.inflate(R.layout.currency_custom_row,null);
        TextView getId=convertView.findViewById(R.id.id);
        TextView currencyName=convertView.findViewById(R.id.currencyName);
        TextView countryName=convertView.findViewById(R.id.countryName);






        Getinfo getinfo=arrayLists.get(position);
        getId.setText(getinfo.getGetId());
        currencyName.setText(getinfo.getCurrencyName());
        countryName.setText(getinfo.getCountryName());





        return convertView;
    }
}
