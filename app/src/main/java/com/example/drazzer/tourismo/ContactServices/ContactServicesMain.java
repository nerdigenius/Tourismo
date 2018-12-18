package com.example.drazzer.tourismo.ContactServices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.drazzer.tourismo.ContactServices.ChatServices.ChatMain;
import com.example.drazzer.tourismo.ContactServices.ContactsListView.ContactListViewMain;
import com.example.drazzer.tourismo.R;

public class ContactServicesMain extends AppCompatActivity {

    GridView gridView;
    ContactsGridAdapter contactsGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_services_main);

        gridView=(GridView)findViewById(R.id.contactGrid);
        contactsGridAdapter=new ContactsGridAdapter(getApplicationContext());



        gridView.setAdapter(contactsGridAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(i<5)
                {
                    Intent intent=new Intent(getApplicationContext(), ContactListViewMain.class);
                    intent.putExtra("selection",i);
                    startActivity(intent);
                }
                else if(i==5)
                {
                    Intent intent=new Intent(getApplicationContext(), ChatMain.class);
                    startActivity(intent);
                }

            }
        });
    }
}
