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

        Resources resources1 = getResources();
        final String[] colors_in_english = resources1.getStringArray(R.array.colors);

        Resources resources2 = getResources();
        final String[] colors_in_spanish = resources2.getStringArray(R.array.colors);

        linearLayout = findViewById(R.id.LinearLayout);
        basicSpinner = findViewById(R.id.ColorSpinner);

        ColorAdapter colorEnglishAdapter = new ColorAdapter(this, colors_in_english);
        basicSpinner.setAdapter(colorEnglishAdapter);

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
