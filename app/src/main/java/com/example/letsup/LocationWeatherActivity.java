package com.example.letsup;

//https://www.youtube.com/watch?v=f2oSRBwN2HY
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RequiresApi(api = Build.VERSION_CODES.N)
public class LocationWeatherActivity extends AppCompatActivity {
    EditText cityET;
    TextView resultTV;
    private final String url = "http://api.openweathermap.org/data/2.5/weather";
    private final String apiKey = "98247b4992ab33699feb08f9a13b7ea6";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_weather);
        cityET = findViewById(R.id.cityET);
        resultTV = findViewById(R.id.resultTV);
    }

    public void getWeather(View view) {
        String tempURL = "";
        String city = cityET.getText().toString().trim();
        if(city.equals("")) {
            resultTV.setText("Pole nie może być puste");
        } else {
            tempURL = url + "?q=" + city + "&lang=pl&units=metric&appid=" + apiKey;

            StringRequest stringRequest = new StringRequest(Request.Method.POST, tempURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    //Log.d("response", response);
                    String output ="";
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
                        resultTV.setTextColor(Color.BLACK);
                        output += "Aktualnie pogoda wygląda następująco: "
                                + "\n Temperatura: " + df.format(temp) + "°C"
                                + "\n Odczuwalna: " + df.format(feelslike) + "°C"
                                + "\n Wilgotność: " + humidity + "%"
                                + "\n Szczegóły: " + description
                                + "\n Prędkość wiatru: " + wind + "m/s"
                                + "\n Zachmurzenie: " + clouds + "%"
                                + "\n Ciśnienie: " + pressure + "hPa";
                        resultTV.setText(output);

                    } catch (JSONException e) {;
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
    }
}