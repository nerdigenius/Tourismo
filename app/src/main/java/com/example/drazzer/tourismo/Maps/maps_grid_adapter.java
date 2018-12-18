package com.example.drazzer.tourismo.Maps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

/**
 * Created by Drazzer on 12/19/2017.
 */

class maps_grid_adapter extends BaseAdapter {

    Context context;

  public static   String buttonNames[]={"Restaurant","Hospital","Bank","Bus stop","Washroom","Police Station","Post Office"};
  public static   int buttonIcons[]={R.drawable.restaurant,R.drawable.hospital,R.drawable.bank,R.drawable.bus,R.drawable.washroom,R.drawable.police,R.drawable.post_office};
  public static   String typeName[]={"restaurant","hospital","bank","busstop","washroom","police","post_office"};



    public maps_grid_adapter( Context context) {
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
        convertView = inflater.inflate(R.layout.map_custom_grid,null);

        TextView textView=convertView.findViewById(R.id.txtGrid);
        ImageView imageButton=convertView.findViewById(R.id.btnGrid);




        textView.setText(buttonNames[position]);
        imageButton.setImageResource(buttonIcons[position]);

        return convertView;
    }
}
