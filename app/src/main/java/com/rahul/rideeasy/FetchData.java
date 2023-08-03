package com.rahul.rideeasy;

import android.os.AsyncTask;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class FetchData extends AsyncTask<Object,String,String> {
    String googlenearby;
    String url;
    GoogleMap gmap;

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //on revecig data from url in json it is need to be parsed
        try {
            JSONObject jsonObject=new JSONObject(s);
            JSONArray jsonArray=jsonObject.getJSONArray("results");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                JSONObject getLocation=jsonObject1.getJSONObject("geometry")
                        .getJSONObject("location");

                String lat=getLocation.getString("lat");
                String lon=getLocation.getString("lon");

                JSONObject getName=jsonArray.getJSONObject(i);
                String name= getName.getString("name");
                LatLng latLng=new LatLng(Double.parseDouble(lat),Double.parseDouble(lon));
                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.title(name);
                markerOptions.position(latLng);
                gmap.addMarker(markerOptions);
                gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String doInBackground(Object... objects) {
        try {
            gmap=(GoogleMap) objects[0];
            url=(String) objects[1];
            //with help of download url with retrive data from url
            DownloadUrl downloadUrl=new DownloadUrl();
            googlenearby=downloadUrl.rURL(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return googlenearby;
    }
}
