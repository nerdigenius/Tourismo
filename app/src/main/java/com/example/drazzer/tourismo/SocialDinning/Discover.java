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
public class Discover extends Fragment {

    ListView chefList;


    public Discover() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_discover, container, false);

        chefList=view.findViewById(R.id.chefList);
        Object object=new Object();
        ChefAdapter chefAdapter=new ChefAdapter(object,getActivity());

        chefList.setAdapter(chefAdapter);
        chefList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),ProfileOrChefList.class);
                intent.putExtra("message",2);
                startActivity(intent);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
