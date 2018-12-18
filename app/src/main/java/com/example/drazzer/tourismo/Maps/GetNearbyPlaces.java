package com.example.drazzer.tourismo.Maps;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GetNearbyPlaces extends AsyncTask<Object,String,String>
{

    GoogleMap mMap;
    String url;
    InputStream inputStream;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    String data;

    @Override
    protected String doInBackground(Object... objects) {
        mMap=(GoogleMap)objects[0];
        url=(String)objects[1];
        try
        {
            URL myUrl= new URL(url);
            HttpURLConnection httpURLConnection=(HttpURLConnection)myUrl.openConnection();
            httpURLConnection.connect();
            inputStream=httpURLConnection.getInputStream();
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream));

            String line="";
            stringBuilder=new StringBuilder();
            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line);
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



        data=stringBuilder.toString();



        return data;
    }

    private void showNearbyPlaces(List<HashMap<String,String>> nearbyPlaceList)
    {
        for (int i=0;i<nearbyPlaceList.size();i++)
        {
            MarkerOptions markerOptions=new MarkerOptions();
            HashMap<String,String> placeMap=nearbyPlaceList.get(i);
            String PlaceName=placeMap.get("place_name");
            String vicinity=placeMap.get("vicinity");
            double lat=Double.parseDouble(placeMap.get("lat"));
            double lng=Double.parseDouble(placeMap.get("lng"));

            LatLng latLng=new LatLng(lat,lng);
            markerOptions.position(latLng);
            markerOptions.title(PlaceName+" "+vicinity);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
            mMap.addMarker(markerOptions);
        }
    }

    @Override
    protected void onPostExecute(String s)
    {
        List<HashMap<String,String>> list;
        GetPlace getPlace=new GetPlace();
        try
        {
            list=getPlace.parse(s);
            showNearbyPlaces(list);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}

class GetPlace{
    private HashMap<String,String>getPlace(JSONObject googlePlaceJson)
    {
        HashMap<String,String> googlePlaceMap=new HashMap<>();
        String placeName="-NA-";
        String vicinity="-NA-";
        String  latitude="";
        String longitude="";
        String reference="";
        try
        {
            if(!googlePlaceJson.isNull("name"))
            {
                placeName=googlePlaceJson.getString("name");

            }
            if (!googlePlaceJson.isNull("vicinity"))
            {
                vicinity=googlePlaceJson.getString("vicinity");
            }
            latitude=googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude=googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");

            reference=googlePlaceJson.getString("reference");

            googlePlaceMap.put("place_name",placeName);
            googlePlaceMap.put("vicinity",vicinity);
            googlePlaceMap.put("lat",latitude);
            googlePlaceMap.put("lng",longitude);
            googlePlaceMap.put("reference",reference);


        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return googlePlaceMap;

    }

    List<HashMap<String,String>> getPlacesList(JSONArray jsonArray) throws JSONException {
        List<HashMap<String,String>> list=new ArrayList<>();
        HashMap<String,String> map;
        for(int i=0;i<jsonArray.length();i++)
        {
            map=getPlace((JSONObject) jsonArray.get(i));
            list.add(map);
        }

        return list;
    }

    public List<HashMap<String,String>> parse(String jsonData) throws JSONException {
        JSONArray jsonArray=null;
        JSONObject jsonObject;


        try
        {
            jsonObject=new JSONObject(jsonData);
            jsonArray=jsonObject.getJSONArray("results");
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return getPlacesList(jsonArray);
    }
}
