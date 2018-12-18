package com.example.drazzer.tourismo.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.drazzer.tourismo.R;

public class Splash extends AppCompatActivity {

    private static int SplashTimeout=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(Splash.this,MainActivity.class);

                startActivity(intent);

                finish();

            }
        },SplashTimeout);
    }

}
