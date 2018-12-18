package com.example.drazzer.tourismo.CurrencyConverter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import java.math.BigDecimal;
import java.util.Currency;

import static com.example.drazzer.tourismo.CurrencyConverter.currencyList.countryName;
import static com.example.drazzer.tourismo.CurrencyConverter.currencyList.countryName2;
import static com.example.drazzer.tourismo.CurrencyConverter.currencyList.currencyID;
import static com.example.drazzer.tourismo.CurrencyConverter.currencyList.currencyID2;
import static com.example.drazzer.tourismo.CurrencyConverter.currencyList.currencyName;
import static com.example.drazzer.tourismo.CurrencyConverter.currencyList.currencyName2;

public class CurrencyConverter extends AppCompatActivity
{

    Button btnCurrency1,btnCurrency2,btnConvert;
    private double i,value,amount;
    TextView txtCurrencyName,txtValue;
    EditText edtAmount;
    LinearLayout linearLayout;
    private Animation fab_open;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        btnCurrency1=findViewById(R.id.btnCurrency1);
        btnCurrency2=findViewById(R.id.btnCurrency2);
        btnConvert=findViewById(R.id.btnConvert);
        txtCurrencyName=findViewById(R.id.txtCurrencyName);
        txtValue=findViewById(R.id.txtValue);
        edtAmount=findViewById(R.id.edtAmount);
        linearLayout=findViewById(R.id.linearLayout3);
        fab_open= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);

        fab_open.setAnimationListener(new Animation.AnimationListener() {
                                          @Override
                                          public void onAnimationStart(Animation animation) {

                                          }

                                          @Override
                                          public void onAnimationEnd(Animation animation) {

                                              linearLayout.clearAnimation();
                                              linearLayout.setVisibility(View.VISIBLE);

                                          }

                                          @Override
                                          public void onAnimationRepeat(Animation animation) {

                                          }
                                      });




        btnCurrency1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CurrencyConverter.this,currencyList.class);
                intent.putExtra("SELECTED_ITEM",1);
                startActivity(intent);
                finish();

            }
        });
        btnCurrency2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CurrencyConverter.this,currencyList.class);
                intent.putExtra("SELECTED_ITEM",2);
                startActivity(intent);
                finish();

            }
        });
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currencyID.equals("")||currencyID2.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Select Currencies",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Select Success!!!",Toast.LENGTH_SHORT).show();
                    if(edtAmount.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Enter A value to proceed",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Currency currency=Currency.getInstance(currencyID2);

                        amount=Double.parseDouble(String.valueOf(edtAmount.getText()));
                        onConvert(true);
                        value=i*amount;
                        String formattedValue = String.format("%.2f", value);
                        txtValue.setText(currency.getSymbol()+" "+formattedValue);
                        txtCurrencyName.setText(currencyName2);
                        linearLayout.startAnimation(fab_open);
                    }

                }

            }
        });


        btnCurrency1.setText(currencyName+" "+countryName);
        btnCurrency2.setText(currencyName2+" "+countryName2);
        onConvert(false);
    }


    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }




    private void onConvert(final boolean status)
    {
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest= new StringRequest(Request.Method.GET, "https://free.currencyconverterapi.com/api/v5/convert?q="+currencyID+"_"+currencyID2+"&compact=ultra", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject res=new JSONObject(response);
                    i= BigDecimal.valueOf(res.getDouble(currencyID+"_"+currencyID2)).floatValue();

                } catch (JSONException e) {
                    e.printStackTrace();
                    if(status!=false)
                    {
                        Toast.makeText(getApplicationContext(), "There Was A Fatal Error!!!!", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Context context=getApplicationContext();

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
