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

        Resources resources = getResources();
        final String[] colors = resources.getStringArray(R.array.colors);
        final String[] colors_in_english = resources.getStringArray(R.array.colors_in_english);

        linearLayout = findViewById(R.id.LinearLayout);
        basicSpinner = findViewById(R.id.ColorSpinner);

        ColorAdapter colorAdapter = new ColorAdapter(this, colors, colors_in_english);
        basicSpinner.setAdapter(colorAdapter);

        basicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (flag == true) {
                    intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("color", colors_in_english[position]);
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
