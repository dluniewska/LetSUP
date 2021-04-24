package com.example.letsup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoiceActivity extends AppCompatActivity {

    Button bLiveStream;
    Button bWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        bLiveStream = (Button) findViewById(R.id.bStreams);
        bWeather = findViewById(R.id.bWeather);

        bLiveStream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(ChoiceActivity.this, LiveStreamActivity.class);
                startActivity(i);
            }
        });
        bWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(ChoiceActivity.this, LocationWeatherActivity.class);
                startActivity(i);
            }
        });
    }
}