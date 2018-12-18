package com.example.drazzer.tourismo.CurrencyConverter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.drazzer.tourismo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class currencyList extends AppCompatActivity {

   private ArrayList<Getinfo> arrayList;
   public static String currencyName="Select";
   public static String countryName="currency";
   public static String currencyName2="Select";
   public static String countryName2="currency";
   public static String currencyID="";
   public static String currencyID2="";
   ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_currency_list);
        listView=(ListView)findViewById(R.id.currencylist);
        arrayList=new ArrayList<Getinfo>();
        GetCurrencyNames();
        final Intent intent=getIntent(),intent1=new Intent(getApplicationContext(),CurrencyConverter.class);
       final int i=intent.getIntExtra("SELECTED_ITEM",0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Getinfo getinfo=new Getinfo();
                getinfo=arrayList.get(position);
                if (i==1)
                {
                    currencyName=getinfo.getCurrencyName();
                    countryName=getinfo.getCountryName();
                    currencyID=getinfo.getGetId();
                    finish();
                    startActivity(intent1);
                }
                else
                {
                    currencyName2=getinfo.getCurrencyName();
                    countryName2=getinfo.getCountryName();
                    currencyID2=getinfo.getGetId();
                    finish();
                    startActivity(intent1);
                }

            }
        });




    }

    public void GetCurrencyNames()
    {

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://free.currencyconverterapi.com/api/v5/countries", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject res = new JSONObject(response);
                    JSONObject object=res.getJSONObject("results");
                    Iterator<String>keys=object.keys();
                    while (keys.hasNext())
                    {
                        String key=keys.next();
                        JSONObject innerObject=object.getJSONObject(key);
                        Getinfo getinfo=new Getinfo(innerObject.getString("currencyId"),innerObject.getString("currencyName"),innerObject.getString("name"));
                        arrayList.add(getinfo);
                    }

                    Collections.sort(arrayList);

                    ListAdapter listAdapter=new currencyAdapter(arrayList,getApplicationContext());
                    ListView timeListView=(ListView)findViewById(R.id.currencylist);
                    timeListView.setAdapter(listAdapter);
                    Toast.makeText(getApplicationContext(), "Success!!!!", Toast.LENGTH_SHORT).show();


                } catch (JSONException e) {
                    e.printStackTrace();
                     Toast.makeText(getApplicationContext(), "There Was A Fatal Error!!!!", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context = getApplicationContext();

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(context,
                            "Connection Timed Out",
                            Toast.LENGTH_LONG).show();
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        });
        requestQueue.add(stringRequest);
    }
}

class Getinfo implements Comparable<Getinfo> {
    String getId, currencyName, countryName;

    public Getinfo() {
    }

    public Getinfo(String getId, String currencyName, String countryName) {

        this.getId = getId;
        this.currencyName = currencyName;
        this.countryName = countryName;
    }

    public String getGetId() {
        return getId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCountryName() {
        return countryName;
    }


    @Override
    public int compareTo(@NonNull Getinfo o) {
        return this.countryName.compareTo(o.getCountryName());
    }
}
