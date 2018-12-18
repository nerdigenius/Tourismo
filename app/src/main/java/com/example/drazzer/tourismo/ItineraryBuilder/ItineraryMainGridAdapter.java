package com.example.drazzer.tourismo.ItineraryBuilder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

/**
 * Created by Ashiq on 1/11/2018.
 */

public class ItineraryMainGridAdapter extends BaseAdapter {


    Context context;

    public ItineraryMainGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 10;
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
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.travel_plan_custom_grid,null);
        final TextView textDescription,textLocationNaem;
        Button seeMore;

        seeMore=(Button)view.findViewById(R.id.btnSeeMore);

       /* seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(context,TravelSelectionMenu.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });*/



        return view;
    }
}
