package com.example.drazzer.tourismo.SocialDinning;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.drazzer.tourismo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFeed extends Fragment {

    ListView listView;


    public FoodFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_food_feed, container, false);
        listView=view.findViewById(R.id.foodList);
        Object object=new Object();
        FoodAdapter adapter=new FoodAdapter(object,getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),ProfileOrChefList.class);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
