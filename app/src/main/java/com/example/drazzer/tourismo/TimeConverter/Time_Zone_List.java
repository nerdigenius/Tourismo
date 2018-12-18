package com.example.drazzer.tourismo.TimeConverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Time_Zone_List extends AppCompatActivity {


    private ArrayList<GetZones> arrayList;
    private ListView listView;
    public static String zoneName,showTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time__zone__list);




        arrayList=new ArrayList<GetZones>();
        listView=findViewById(R.id.timeZoneList);
        getCountryList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GetZones getZones;
                getZones=arrayList.get(position);
                long batch_date = getZones.getTimestamp();
                DateFormat formatter = new SimpleDateFormat("hh:mm aa");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis((batch_date * 1000l)-21600000);
                showTime =formatter.format(calendar.getTime());
                zoneName=getZones.getCountryName();
                intent();

            }
        });


    }

    private void intent()
    {
        Intent intent=new Intent(getApplicationContext(),TimeMain.class);
        startActivity(intent);
        finish();
    }







    public void getCountryList()
    {

        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://api.timezonedb.com/v2/list-time-zone?key=Z35J0I51CRWE&format=json", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject res = new JSONObject(response);
                    JSONArray jsonArray=res.getJSONArray("zones");
                    for(int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        String countryName=jsonObject.getString("countryName");
                        long timestamp=jsonObject.getInt("timestamp");
                        long gmtOffset=jsonObject.getInt("gmtOffset");
                        String countryCode=jsonObject.getString("countryCode");
                        GetZones getZones=new GetZones(countryName,countryCode,timestamp,gmtOffset);
                        arrayList.add(getZones);


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "There Was A Fatal Error!!!!", Toast.LENGTH_SHORT).show();
                }
                ListAdapter listAdapter=new Time_Converter_Adapter(arrayList,getApplicationContext());

                listView.setAdapter(listAdapter);

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
class GetZones
{
    private String countryName,countryCode;
    private long timestamp;

    public long getGmtOffset() {
        return gmtOffset;
    }

    private long gmtOffset;

    public String getCountryName() {
        return countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public GetZones(String countryName, String countryCode, long timestamp,long gmtOffset) {

        this.countryName = countryName;
        this.countryCode = countryCode;
        this.timestamp = timestamp;
        this.gmtOffset=gmtOffset;
    }

    public GetZones() {
    }
}
