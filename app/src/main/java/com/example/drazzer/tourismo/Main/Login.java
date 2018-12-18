package com.example.drazzer.tourismo.Main;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.drazzer.tourismo.R;

import static com.example.drazzer.tourismo.Main.MainActivity.key;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    ImageButton Facebook,btnShowHide;
    Button btnLogIn;
    private boolean ImageType=true;




    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        Facebook=(ImageButton) view.findViewById(R.id.btnFacebook);
        btnLogIn=(Button)view.findViewById(R.id.btnLogIn);
        btnShowHide=(ImageButton)view.findViewById(R.id.btnShowHide);



        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isNetworkAvailable()==true)
                {
                    checkStatus();
                }
                else
                {
                    Toast.makeText(getActivity(),"Check Internet Connection",Toast.LENGTH_SHORT).show();
                }

            }
        });
        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                checkStatus();
            }
        }
        );

        btnShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ImageType==true)
                {
                    btnShowHide.setImageResource(R.drawable.hide);
                    ImageType=false;
                }
                else
                {
                    btnShowHide.setImageResource(R.drawable.show);
                    ImageType=true;
                }

            }
        });


        // Inflate the layout for this fragment
        return view;
    }



    private void checkStatus()
    {

        Toast.makeText(getActivity(),"Logging In",Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (key==17268)
                {
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    FeatureSelection f1 = new FeatureSelection();
                    fragmentTransaction.replace(android.R.id.content, f1);
                    Toast.makeText(getActivity(),key+"",Toast.LENGTH_SHORT);
                    fragmentTransaction.commit();
                    Toast.makeText(getActivity(),"Authorised",Toast.LENGTH_SHORT).show();

                }

                else
                {
                    Toast.makeText(getActivity(),"Unauthorised Usage Detected",Toast.LENGTH_SHORT).show();
                }
            }
        }, 2000);



    }




    private boolean isNetworkAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

}


