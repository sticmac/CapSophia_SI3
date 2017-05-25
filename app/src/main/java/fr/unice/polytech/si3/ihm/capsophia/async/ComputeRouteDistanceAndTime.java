package fr.unice.polytech.si3.ihm.capsophia.async;

import android.os.AsyncTask;
import android.util.Pair;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ComputeRouteDistanceAndTime extends AsyncTask<LatLng, Void, Pair<String, String>> {
    private TextView distance;
    private TextView duration;

    public ComputeRouteDistanceAndTime(TextView distance, TextView duration) {
        this.distance = distance;
        this.duration = duration;
    }

    @Override
    protected Pair<String, String> doInBackground(LatLng... params) {
        Pair<String, String> res = new Pair<>("0 km", "0 heures 0 minutes");
        if (params.length >= 2) {
            LatLng start = params[0];
            LatLng end = params[1];

            final String str = "http://maps.googleapis.com/maps/api/directions/json?"
                            + "origin=" + start.latitude + "," + start.longitude
                            + "&destination=" + end.latitude + "," + end.longitude
                            + "&sensor=false&units=metric&mode=" + "car"
                            + "&alternatives=true";

            try {
                URL url = new URL(str);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                InputStreamReader in = new InputStreamReader(conn.getInputStream());

                StringBuilder jsonResults = new StringBuilder();
                int read;
                char[] buff = new char[1024];
                while ((read = in.read(buff)) != -1) {
                    jsonResults.append(buff, 0, read);
                }

                JSONObject jsonObj = new JSONObject(jsonResults.toString());
                JSONArray parentArray = jsonObj.getJSONArray("routes");
                final JSONArray legArray = parentArray.getJSONObject(0).getJSONArray("legs");

                //Distance
                JSONObject distanceObj = legArray.getJSONObject(0).getJSONObject("distance");
                String distance = distanceObj.getString("text"); //String that contains the distance value formated

                //Time
                JSONObject timeObj = legArray.getJSONObject(0).getJSONObject("duration");
                //String duration = timeObj.getString("text");
                int duration = timeObj.getInt("value");
                int hours = duration/3600;
                int minutes = (duration - hours*3600)/60;
                String durationString = hours+":"+minutes;

                res = Pair.create(distance, durationString);
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public void onPostExecute(Pair<String, String> pair) {
        distance.setText(pair.first);
        duration.setText(pair.second);
    }
}
