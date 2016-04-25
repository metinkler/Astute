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

// going to be the newsfeed page

public class MainActivity extends AppCompatActivity {

    ListView listView;

    // Search EditText
    EditText inputSearch;

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Defined Array values to show in ListView
        String[] values = new String[] { "CS 420 - Human-Computer Interaction",
                "CS 241 - Date Structures",
                "ENGL 212 - Intro to Creative Writing",
                "KINES 110 - Ballroom Dance 01",
                "MATH 211 - Calculus II",
                "ENGL 310 - Epic & Romance",
                "PSYCH 201 - Psych as a Social Science",
                "HIST 320 - History of Modern Japan"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

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
                String  itemValue    = (String) listView.getItemAtPosition(position);

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



