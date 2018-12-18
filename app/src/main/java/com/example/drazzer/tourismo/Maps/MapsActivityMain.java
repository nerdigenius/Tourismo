package com.example.drazzer.tourismo.Maps;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drazzer.tourismo.R;
    import com.google.android.gms.common.ConnectionResult;
    import com.google.android.gms.common.api.GoogleApiClient;
    import com.google.android.gms.location.LocationListener;
    import com.google.android.gms.location.LocationRequest;
    import com.google.android.gms.location.LocationServices;
    import com.google.android.gms.maps.CameraUpdateFactory;
    import com.google.android.gms.maps.GoogleMap;
    import com.google.android.gms.maps.OnMapReadyCallback;
    import com.google.android.gms.maps.SupportMapFragment;
    import com.google.android.gms.maps.model.BitmapDescriptorFactory;
    import com.google.android.gms.maps.model.LatLng;
    import com.google.android.gms.maps.model.Marker;
    import com.google.android.gms.maps.model.MarkerOptions;

    import static com.example.drazzer.tourismo.Maps.maps_grid_adapter.buttonIcons;
    import static com.example.drazzer.tourismo.Maps.maps_grid_adapter.buttonNames;
import static com.example.drazzer.tourismo.Maps.maps_grid_adapter.typeName;

public class MapsActivityMain extends FragmentActivity implements OnMapReadyCallback
        , GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener
        , LocationListener {

    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastLoocation;
    private Marker currentLocationMarker;
    public static final int PERMISSION_REQUEST_LOCATION_CODE=99;
    private FloatingActionButton btn_float_main,btn_float_hospital,btn_float_restaurant,btn_float_bank;
    private Animation fab_open,fab_close,fab_clockwise,fab_anticlockwise;
    private boolean isOpen=false;
    private GridView gridView;
    private maps_grid_adapter adapter=new maps_grid_adapter(this);
    private ImageButton btnFilter;
    private LinearLayout layout;
    private TextView textView;
    private LatLng latLng;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_main);


        gridView=findViewById(R.id.grids);
        btnFilter=findViewById(R.id.button4);
        layout=findViewById(R.id.filter);
        textView=findViewById(R.id.textView6);

        fab_open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fab_close= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fab_clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fab_anticlockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);

        gridView.setAdapter(adapter);
        gridView.setVisibility(View.GONE);

        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gridView.startAnimation(fab_open);
                layout.startAnimation(fab_close);
                fab_open.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        gridView.clearAnimation();
                        gridView.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                textView.setText(buttonNames[position]);
                textView.setCompoundDrawablesWithIntrinsicBounds(buttonIcons[position],0,0,0);
                gridView.startAnimation(fab_close);
                layout.startAnimation(fab_open);
                fab_close.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        gridView.clearAnimation();
                        gridView.setVisibility(View.GONE);

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


                mMap.clear();

                MarkerOptions markerOptions=new MarkerOptions();
                if(latLng!=null)
                {
                    markerOptions.position(latLng);
                    markerOptions.title("Current Location");
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

                    currentLocationMarker=mMap.addMarker(markerOptions);


                    String coordinates=lastLoocation.getLatitude()+","+lastLoocation.getLongitude();
                    Object data[]=new Object[2];
                    data[0]=mMap;
                    data[1]=urlBuilder(typeName[position],coordinates);
                    GetNearbyPlaces getNearbyPlaces=new GetNearbyPlaces();
                    getNearbyPlaces.execute(data);
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"Connection Error!",Toast.LENGTH_SHORT).show();
                }

            }
        });








        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            checkLocationPermission();
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }





    protected synchronized void buildGoogleApiClient() {
        client = new GoogleApiClient.Builder(this).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        client.connect();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(false);
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }

    }

    @Override
    public void onLocationChanged(Location location) {

        lastLoocation=location;

        if(currentLocationMarker!=null)
        {
            currentLocationMarker.remove();
            mMap.clear();
        }

        latLng=new LatLng(location.getLatitude(),location.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE));

        currentLocationMarker=mMap.addMarker(markerOptions);










        if(client!=null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(client,this);
        }

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();

        locationRequest.setInterval(100000);
        locationRequest.setFastestInterval(100000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }

    }


    public boolean checkLocationPermission()
    {
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_LOCATION_CODE);
            }
            else
            {
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_LOCATION_CODE);
            }
            return false;
        }
        else
        {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case PERMISSION_REQUEST_LOCATION_CODE:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
                    {
                        if (client==null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }
                    else
                    {
                        Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Toast.makeText(getApplicationContext(),"Connection Failed!",Toast.LENGTH_LONG).show();
    }

    private String urlBuilder(String type,String coordinates)
    {
        StringBuilder stringBuilder=new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=");
        stringBuilder.append(coordinates+"&radius=1000&type="+type+"&key=AIzaSyACGSENkjkYD1Jz4FBp5ksqrRpoGdn_fi0");
        return stringBuilder.toString();
    }
}
