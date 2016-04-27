package com.tinks.astute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.text.TextWatcher;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// going to be the newsfeed page

public class MainActivity extends AppCompatActivity {

    ListView listView;

    // Search EditText
    EditText inputSearch;

    //ArrayAdapter<String> adapter;

    CustomListAdapter adapter;

    Integer[] imgid={
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    Integer[] members = {
            1,
            3,
            4,
            2,
            8,
            1,
            5,
            2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Defined Array values to show in ListView
        ArrayList<String> values = new ArrayList<String>();
        values.add("CS 420 - Human-Computer Interaction");
        values.add("CS 241 - Data Structures");
        values.add("ENGL 212 - Intro to Creative Writing");
        values.add("KINES 110 - Ballroom Dance 01");
        values.add("MATH 211 - Calculus II");
        values.add("ENGL 310 - Epic & Romance");
        values.add("PSYCH 201 - Psych as a Social Science");
        values.add("HIST 320 - History of Modern Japan");


        // Define a new Adapter
        this.adapter = new CustomListAdapter(this, values, imgid, members);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition   = position;

                // ListView Clicked item value
                String  itemValue    = listView.getItemAtPosition(position).toString();

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }

        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                System.out.println(MainActivity.this.adapter);
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }

}



