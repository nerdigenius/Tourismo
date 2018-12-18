package com.example.drazzer.tourismo.Main;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.drazzer.tourismo.ContactServices.ContactServicesMain;
import com.example.drazzer.tourismo.CurrencyConverter.CurrencyConverter;
import com.example.drazzer.tourismo.ItineraryBuilder.ItineraryMain;
import com.example.drazzer.tourismo.Maps.MapsActivityMain;
import com.example.drazzer.tourismo.R;
import com.example.drazzer.tourismo.SocialDinning.SocialDinningMain;
import com.example.drazzer.tourismo.TimeConverter.TimeMain;
import com.example.drazzer.tourismo.Translator.Translator_main;
import com.example.drazzer.tourismo.UploadImageVideo.UploadingImageMain;
import com.example.drazzer.tourismo.Weather.Weather_Activity_Main;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeatureSelection extends Fragment implements View.OnClickListener{

    LinearLayout TimeConverter;
    ImageButton imageButton11,imageButton22,imageButton33,imageButton44,imageButton55,imageButton66,imageButton77,imageButton88,imageButton99;


    public FeatureSelection() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_feature_selection, container, false);
        TimeConverter= (LinearLayout) view.findViewById(R.id.timeConverter);
        imageButton11=(ImageButton)view.findViewById(R.id.imageButton11);
        imageButton22=(ImageButton)view.findViewById(R.id.imageButton22);
        imageButton33=(ImageButton)view.findViewById(R.id.imageButton33);
        imageButton44=(ImageButton)view.findViewById(R.id.imageButton44);
        imageButton55=(ImageButton)view.findViewById(R.id.imageButton55);
        imageButton66=(ImageButton)view.findViewById(R.id.imageButton66);
        imageButton77=(ImageButton)view.findViewById(R.id.imageButton77);
        imageButton88=(ImageButton)view.findViewById(R.id.imageButton88);
        imageButton99=(ImageButton)view.findViewById(R.id.imageButton99);





        imageButton11.setOnClickListener(FeatureSelection.this);
        imageButton22.setOnClickListener(FeatureSelection.this);
        imageButton33.setOnClickListener(FeatureSelection.this);
        imageButton44.setOnClickListener(FeatureSelection.this);
        imageButton55.setOnClickListener(FeatureSelection.this);
        imageButton66.setOnClickListener(FeatureSelection.this);
        imageButton77.setOnClickListener(FeatureSelection.this);
        imageButton88.setOnClickListener(FeatureSelection.this);
        imageButton99.setOnClickListener(FeatureSelection.this);




        return view;
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId())
        {
            case R.id.imageButton11:
               intent =new Intent(getActivity(),TimeMain.class);
                startActivity(intent);
                break;
            case R.id.imageButton22:
                intent =new Intent(getActivity(),MapsActivityMain.class);
                startActivity(intent);
                break;
            case R.id.imageButton33:
                intent =new Intent(getActivity(),CurrencyConverter.class);
                startActivity(intent);
                break;
            case R.id.imageButton44:
                intent =new Intent(getActivity(),ItineraryMain.class);
                startActivity(intent);
                break;
            case R.id.imageButton55:
                intent =new Intent(getActivity(),ContactServicesMain.class);
                startActivity(intent);
                break;
            case R.id.imageButton66:
                intent =new Intent(getActivity(),Weather_Activity_Main.class);
                startActivity(intent);
                break;
            case R.id.imageButton77:
                intent =new Intent(getActivity(),Translator_main.class);
                startActivity(intent);
                break;
            case R.id.imageButton88:
                intent =new Intent(getActivity(),SocialDinningMain.class);
                startActivity(intent);
                break;
            case R.id.imageButton99:
                intent =new Intent(getActivity(),UploadingImageMain.class);
                startActivity(intent);
                break;
        }

    }

}
