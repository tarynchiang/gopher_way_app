package com.example.gopherway.ui.Weather;

// Uses code from: https://www.androdocs.com/java/creating-an-android-weather-app-using-java.html

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.NetworkOnMainThreadException;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.gopherway.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.net.*;
import java.util.Scanner;

import static java.lang.Math.pow;

public class WeatherFragment extends Fragment {

    private WeatherViewModel toolsViewModel;

    TextView addressTxt, updated_atTxt, statusTxt, tempTxt, temp_lowTxt, temp_highTxt, sunriseTxt,
            sunsetTxt, windTxt, pressureTxt, humidityTxtm, windchillTxt, frostTxt;

    ImageView statusImg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(WeatherViewModel.class);
        View root = inflater.inflate(R.layout.fragment_weather, container, false);
        final TextView textView = root.findViewById(R.id.text_weather);
        /*
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/


        return root;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        //addressTxt = (TextView)getView().findViewById(R.id.address);
        //updated_atTxt = (TextView)getView().findViewById(R.id.updated_at);
        statusTxt = (TextView) getView().findViewById(R.id.status);
        tempTxt = (TextView) getView().findViewById(R.id.temp);
        temp_lowTxt = (TextView)getView().findViewById(R.id.lowtemp);
        temp_highTxt = (TextView)getView().findViewById(R.id.hightemp);
        //sunriseTxt = (TextView)getView().findViewById(R.id.sunrise);
        //sunsetTxt = (TextView)getView().findViewById(R.id.sunset);
        windTxt = (TextView)getView().findViewById(R.id.wind);
        windchillTxt = (TextView)getView().findViewById(R.id.windchill);
        frostTxt = (TextView)getView().findViewById(R.id.frost);
        statusImg = (ImageView)getView().findViewById(R.id.statusImage);
        //pressureTxt = (TextView)getView().findViewById(R.id.pressure);
        //humidityTxt = (TextView)getView().findViewById(R.id.humidity);

        new weatherTask().execute();
    }

    class weatherTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /* Showing the ProgressBar, Making the main design GONE */
            //(TextView)getView().findViewById(R.id.loader).setVisibility(View.VISIBLE);
            //(TextView)getView().findViewById(R.id.mainContainer).setVisibility(View.GONE);
            //(TextView)getView().findViewById(R.id.errorText).setVisibility(View.GONE);
        }

        @Override
        protected String doInBackground(String... args) {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=minneapolis&units=imperial&appid=1d5e7f3088bcb556635eef3781da03a2";
            URL url = null;
            HttpURLConnection connection = null;
            String err = "oops";
            try {
                url = new URL(urlString);
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream is;
                int status = connection.getResponseCode();
                if (status != HttpURLConnection.HTTP_OK) {
                    is = connection.getErrorStream();
                    err = "Response code";
                }
                else
                    is = connection.getInputStream();

                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String line;
                StringBuffer response = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    response.append(line);
                    response.append('\r');
                }
                rd.close();
                return response.toString();

            } catch (Exception e) {
                e.printStackTrace();
                return err;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                JSONObject jsonObj = new JSONObject(result);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONObject sys = jsonObj.getJSONObject("sys");
                JSONObject wind = jsonObj.getJSONObject("wind");
                JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

                int fbrisk = 0;

                Long updatedAt = jsonObj.getLong("dt");
                String updatedAtText = "Updated at: " + new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
                int t = main.getInt("temp");
                int t_low = main.getInt("temp_min");
                int t_high = main.getInt("temp_max");
                int w = wind.getInt("speed");
                int id = weather.getInt("id");
                double wchill = 70;

                if(t <= -28){
                    fbrisk = 2;
                } else if (t <= -12){
                    fbrisk = 1;
                }

                if(t<=50 && w>=5) {
                    wchill = 35.74 + 0.6215 * t - 35.658 * (pow(w, 0.16)) + 0.4275 * t * (pow(w, 0.16));
                    int wchillint = (int)wchill;
                    String wct = new Integer(wchillint).toString();
                    windchillTxt.setText("Wind chill: " + wct + "°F");
                    if(wchill <= -72){
                        fbrisk = 3;
                    } else if(wchill <= -28){
                        fbrisk = 2;
                    }
                } else {
                    windchillTxt.setText("Wind chill: Not applicable");
                }

                String temp = new Integer(t).toString();
                String temp_low = new Integer(t_low).toString();
                String temp_high = new Integer(t_high).toString();
                String weatherDescription = weather.getString("description");
                String windt = new Integer(w).toString() + " mph";

                String address = jsonObj.getString("name") + ", " + sys.getString("country");
                String fbwarn0 = "No frostbite warning";
                String fbwarn1 = "No frostbite warning, but very cold";
                String fbwarn2 = "Warning: Risk of frostbite!";
                String fbwarn3 = "Warning: Extreme danger of frostbite!";

                if(fbrisk == 0){
                    frostTxt.setText(fbwarn0);
                } else if(fbrisk == 1) {
                    frostTxt.setText(fbwarn1);
                } else if(fbrisk == 2) {
                    frostTxt.setText(fbwarn2);
                } else if(fbrisk == 3) {
                    frostTxt.setText(fbwarn3);
                }

                if(id <= 200 && id < 300){
                    statusImg.setImageResource(R.drawable.w_thunder);
                } else if(id <= 300 && id < 400){
                    statusImg.setImageResource(R.drawable.w_rain);
                }else if(id <= 500 && id < 600){
                    statusImg.setImageResource(R.drawable.w_rain);
                }else if(id <= 600 && id < 700){
                    statusImg.setImageResource(R.drawable.w_snow);
                }else if(id == 800) {
                    statusImg.setImageResource(R.drawable.w_sun);
                }else{
                    statusImg.setImageResource(R.drawable.w_clouds);
                }

                tempTxt.setText(temp);
                temp_highTxt.setText(temp_high+"°F");
                temp_lowTxt.setText(temp_low+"°F");
                statusTxt.setText(weatherDescription);
                windTxt.setText(windt);


            } catch (JSONException e) {
                statusTxt.setText("oops");
                tempTxt.setText("oops");
                //findViewById(R.id.loader).setVisibility(View.GONE);
                //findViewById(R.id.errorText).setVisibility(View.VISIBLE);
            }

        }
    }
}