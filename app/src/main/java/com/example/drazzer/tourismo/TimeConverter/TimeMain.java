package com.example.drazzer.tourismo.TimeConverter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.drazzer.tourismo.TimeConverter.Time_Zone_List.showTime;
import static com.example.drazzer.tourismo.TimeConverter.Time_Zone_List.zoneName;

public class TimeMain extends AppCompatActivity {

    public  TextView cityName,timeShown,currentTime;
    ArrayList arrayList = new ArrayList<GetZones>();
    Button timeZoneButton;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_main);
        cityName = findViewById(R.id.cityName);
        timeZoneButton=findViewById(R.id.timeZoneButton);
        timeShown=findViewById(R.id.timeShown);
        currentTime=findViewById(R.id.textView19);



        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                DateFormat formatter = new SimpleDateFormat("hh:mm aa");
                                Date calendar = Calendar.getInstance().getTime();
                                currentTime.setText(formatter.format(calendar.getTime()).toString());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();




        timeZoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeMain.this,Time_Zone_List.class);
                startActivity(intent);
                finish();
            }
        });
        cityName.setText(zoneName);
        timeShown.setText(showTime);


    }
}











