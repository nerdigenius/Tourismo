package com.example.drazzer.tourismo.SocialDinning;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.drazzer.tourismo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {

    ListView listView;
    Object object;
    Button TakeOrder;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        listView=view.findViewById(R.id.chefsItems);
        object= new Object();
        FoodAdapter foodAdapter=new FoodAdapter(object,getActivity());
        TakeOrder=view.findViewById(R.id.order);




        listView.setAdapter(foodAdapter);
        TakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Your Order Is Being Processed",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
