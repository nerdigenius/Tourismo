package com.example.drazzer.tourismo.SocialDinning;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.drazzer.tourismo.R;

public class ProfileOrChefList extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_or_chef_list);

        Intent mintent=getIntent();
        int message=mintent.getIntExtra("message",1);
        checkString(message);







    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void checkString(int message)
    {

        if(message==1)
        {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            Discover discover=new Discover();
            fragmentTransaction.replace(android.R.id.content, discover);
            fragmentTransaction.commit();


        }

        else if (message==2)
        {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            Profile profile=new Profile();
            fragmentTransaction.replace(android.R.id.content, profile);
            fragmentTransaction.commit();


        }
    }
}
