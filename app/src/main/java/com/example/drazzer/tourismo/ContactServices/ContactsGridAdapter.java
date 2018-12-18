package com.example.drazzer.tourismo.ContactServices;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

/**
 * Created by Drazzer on 12/29/2017.
 */

public class ContactsGridAdapter extends BaseAdapter{

    Context context;

    public static   String buttonNames[]={"Airline","Emergency Services","Helpline","Bus Services","Hotel's","Live Chat"};
    public static   int buttonIcons[]={R.drawable.air,R.drawable.emergency,R.drawable.helpline,R.drawable.bus_icon,R.drawable.hotel,R.drawable.chat};



    public ContactsGridAdapter( Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return buttonNames.length;
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
        convertView = inflater.inflate(R.layout.contact_custom_grid,null);

        TextView textView=convertView.findViewById(R.id.textView27);
        ImageView imageButton=convertView.findViewById(R.id.imageView7);

        if(position>=buttonNames.length)
        {
            textView.setText("Error!!!");
            imageButton.setImageResource(R.drawable.error);
        }

        else
        {

            textView.setText(buttonNames[position]);
            imageButton.setImageResource(buttonIcons[position]);

        }

        return convertView;
    }
}
