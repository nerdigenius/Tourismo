package com.example.drazzer.tourismo.ContactServices.ContactsListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

/**
 * Created by Ashiq on 12/30/2017.
 */

public class ContactListViewAdapter extends BaseAdapter {

    StringResource stringResource;
    Context context;
    String []name,number;

    public ContactListViewAdapter(StringResource stringResource, Context context) {
        this.stringResource = stringResource;
        this.context = context;
        this.name=stringResource.getName();
        this.number=stringResource.getNumber();
    }

    @Override
    public int getCount() {
        return name.length;
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
        convertView = inflater.inflate(R.layout.contactlist_custom_row,null);

        TextView  countryName=convertView.findViewById(R.id.CountryName);
        TextView currencyName=convertView.findViewById(R.id.CountryId);


        currencyName.setText(number[position]);
        countryName.setText(name[position]);





        return convertView;
    }
}
