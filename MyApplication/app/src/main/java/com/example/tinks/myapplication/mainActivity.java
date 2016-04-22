package com.example.tinks.myapplication;

import android.os.Bundle;
import android.view.View;


/**
 * Created by tinks on 4/21/16.
 */
public class mainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ​
        // get our folding cell
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
        ​
        // attach click listener to folding cell
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });
    }

}


