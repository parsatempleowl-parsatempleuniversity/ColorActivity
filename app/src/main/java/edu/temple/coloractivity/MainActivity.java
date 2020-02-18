package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    View linearLayout;

    Spinner basicSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        String[] colors = {"red", "blue", "green", "black", "white", "gray", "cyan",
                            "magenta", "yellow", "lightgray", "darkgray", "grey",
                            "lightgrey", "darkgrey", "aqua", "fuchsia", "lime", "maroon",
                            "navy", "olive", "purple", "silver", "teal"};

        linearLayout = findViewById(R.id.LinearLayout);
        basicSpinner = findViewById(R.id.ColorSpinner);

        ColorAdapter colorAdapter = new ColorAdapter(this, colors);

        basicSpinner.setAdapter(colorAdapter);

        basicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                linearLayout.setBackgroundColor(Color.parseColor(parent.getItemAtPosition(position).toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}
