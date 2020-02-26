package edu.temple.coloractivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    TextView textView;
    View linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        String color = intent.getStringExtra("color");

        linearLayout = findViewById(R.id.LinearLayout);
        textView = findViewById(R.id.colorTextView);

        linearLayout.setBackgroundColor(Color.parseColor(color));
        textView.setText(color);

    }
}
