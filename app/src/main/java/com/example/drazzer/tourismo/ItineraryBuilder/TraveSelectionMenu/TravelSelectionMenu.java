package com.example.drazzer.tourismo.ItineraryBuilder.TraveSelectionMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.drazzer.tourismo.ItineraryBuilder.TraveSelectionMenu.Transport.Transport_main;
import com.example.drazzer.tourismo.R;

public class TravelSelectionMenu extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageButton111,imageButton222,imageButton333,imageButton444;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_selection_menu);


        imageButton111=(ImageButton)findViewById(R.id.imageButton111);

        imageButton111.setOnClickListener(TravelSelectionMenu.this);
    }

    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId())
        {
            case R.id.imageButton111:
                intent=new Intent(TravelSelectionMenu.this, Transport_main.class);
                startActivity(intent);
                break;
        }


    }
}
