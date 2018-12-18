package com.example.drazzer.tourismo.ItineraryBuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.drazzer.tourismo.R;

public class ItineraryMain extends AppCompatActivity {

    GridView gridView;
    ItineraryMainGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary_main);

        gridView=findViewById(R.id.travelGrid);
        adapter=new ItineraryMainGridAdapter(getApplicationContext());

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
