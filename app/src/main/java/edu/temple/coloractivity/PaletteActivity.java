package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;



public class PaletteActivity extends AppCompatActivity {

    View linearLayout;
    Spinner basicSpinner;
    Intent intent;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        final String[] colors = res.getStringArray(R.array.colors);

        /* final String[] colors = {"red", "blue", "green", "black", "white", "gray", "cyan",
                            "magenta", "yellow", "lightgray", "darkgray", "grey",
                            "lightgrey", "darkgrey", "aqua", "fuchsia", "lime", "maroon",
                            "navy", "olive", "purple", "silver", "teal"}; */

        linearLayout = findViewById(R.id.LinearLayout);
        basicSpinner = findViewById(R.id.ColorSpinner);

        ColorAdapter colorAdapter = new ColorAdapter(this, colors);

        basicSpinner.setAdapter(colorAdapter);



        basicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (flag == true) {
                    intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("color", colors[position]);
                    startActivity(intent);
                }

                flag = true;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}
