package com.example.letsup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


@RequiresApi(api = Build.VERSION_CODES.N)
public class GetStartedActivity extends AppCompatActivity {

    Button bGetStarted;
    String cityName;
    TextView descriptionVal;
    TextView tempVal;
    TextView feelslikeVal;
    TextView humidityVal;
    TextView windVal;
    ConstraintLayout getStartedCL;
    FusedLocationProviderClient fusedLocationProviderClient;
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    private final String apiKey = "98247b4992ab33699feb08f9a13b7ea6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
        descriptionVal = findViewById(R.id.descriptionVal);
        tempVal = findViewById(R.id.tempVal);
        feelslikeVal = findViewById(R.id.feelslikeVal);
        humidityVal = findViewById(R.id.humidityVal);
        windVal = findViewById(R.id.windVal);
        getStartedCL = findViewById(R.id.getStartedCL);


        checkLocationIsEnabled();
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(GetStartedActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else
            ActivityCompat.requestPermissions(GetStartedActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44
            );


        bGetStarted = findViewById(R.id.bGetStarted);

        bGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(GetStartedActivity.this, ChoiceActivity.class);
                startActivity(i);
            }
        });

        String tempURL = "";
        tempURL = url + "?q=" + "Gdansk" + "&lang=pl&units=metric&appid=" + apiKey;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, tempURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d("response", response);
                String output = "";
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                    JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);
                    String weather = jsonObjectWeather.getString("main");
                    String description = jsonObjectWeather.getString("description");
                    JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                    double temp = jsonObjectMain.getDouble("temp");
                    double feelslike = jsonObjectMain.getDouble("feels_like");
                    float pressure = jsonObjectMain.getInt("pressure");
                    int humidity = jsonObjectMain.getInt("humidity");
                    JSONObject jsonObjectWind = jsonResponse.getJSONObject("wind");
                    String wind = jsonObjectWind.getString("speed");
                    JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                    String clouds = jsonObjectClouds.getString("all");
                    JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                    String cityName = jsonResponse.getString("name");
                    descriptionVal.setText(description);
                    tempVal.setText(temp + "°C");
                    feelslikeVal.setText(feelslike + "°C");
                    humidityVal.setText(humidity + "%");
                    windVal.setText(wind + "m/s");
                    Log.i("pupa", description);

                    switch (weather) {
                        case "Clear":
                            getStartedCL.setBackground(getDrawable(R.drawable.sun));
                            break;
                        case "Clouds":
                            getStartedCL.setBackground(getDrawable(R.drawable.clouds));
                            break;
                        case "Drizzle":
                            getStartedCL.setBackground(getDrawable(R.drawable.rain));
                            break;
                        case "Thunderstorm":
                            getStartedCL.setBackground(getDrawable(R.drawable.thunder));
                            break;
                        case "Snow":
                            getStartedCL.setBackground(getDrawable(R.drawable.snow));
                            break;
                        case "Mist":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Smoke":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Haze":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Squall":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Fog":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Sand":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Dust":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Ash":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        case "Tornado":
                            getStartedCL.setBackground(getDrawable(R.drawable.fog));
                            break;
                        default:
                            getStartedCL.setBackground(getDrawable(R.drawable.flower));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }


    private void getLocation() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            }
        }

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(GetStartedActivity.this, Locale.getDefault());
                        List<Address> addressList = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        cityName = addressList.get(0).getLocality();
                        Log.i("To jest miasto", "miasto:"+ cityName);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.i("fupa", "dipa");
                }
            }
        });
    }

    private void checkLocationIsEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        boolean gpsEnabled = false;
        boolean networkEnabled = false;

        try {
            gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            networkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!gpsEnabled && !networkEnabled) {
            new AlertDialog.Builder(GetStartedActivity.this).setTitle("Enable GPS Service").setCancelable(false).setPositiveButton("Enable", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                }
            }).setNegativeButton("Cancel", null).show();
        }
    }
}




