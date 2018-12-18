package com.example.drazzer.tourismo.SocialDinning;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.drazzer.tourismo.R;

public class SocialDinningMain extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        FragmentManager manager=getFragmentManager();

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dashboard:
                    Discover discover =new Discover();
                    manager.beginTransaction().replace(R.id.contentLayout,discover).commit();
                    return true;
                case R.id.navigation_notifications:
                    FoodFeed foodFeed =new FoodFeed();
                    manager.beginTransaction().replace(R.id.contentLayout,foodFeed).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_dinning_main);
        FragmentManager manager=getFragmentManager();
        Discover discover=new Discover();
        manager.beginTransaction().replace(R.id.contentLayout,discover).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
