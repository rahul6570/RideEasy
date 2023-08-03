package com.rahul.rideeasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class searchresult extends AppCompatActivity {
//    TextView txtres;
    AppCompatButton btnregcomplain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchresult);
        btnregcomplain=findViewById(R.id.btnregcomplain);
        Intent fromact=getIntent();
        String vnum=fromact.getStringExtra("vhno");



        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
//       RequestBody body = RequestBody.create(mediaType, "{\n  \"vehicleno\": \"+vnum+"\"\n}");
        RequestBody body = RequestBody.create(mediaType, "{\"vehicleno\": \"" + vnum + "\"}");

//        RequestBody body = RequestBody.create(mediaType, "{\"vehicleno\": \"mh02fb2727\"}");

        Request request = new Request.Builder()
                .url("https://rto-vehicle-details.p.rapidapi.com/")
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("Content-Type", "application/json")
                .addHeader("X-RapidAPI-Key", "9c776d6b59mshdda6aee4acdd75ap166889jsncb92eb8ba1a6")
                .addHeader("X-RapidAPI-Host", "rto-vehicle-details.p.rapidapi.com")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if(response.isSuccessful()) {
                        final String responseBody = response.body().string();
                        searchresult.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(searchresult.this, "Search successful", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            }
        });

        btnregcomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String vno=edtvehicleno.getText().toString();
                Intent inext;
                inext=new Intent(searchresult.this,RegisterComplain.class);
//                inext.putExtra("vhno",vno);
                startActivity(inext);
            }
        });


    }
}
//package com.rahul.rideeasy;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//
//import com.androidnetworking.AndroidNetworking;
//import com.androidnetworking.common.Priority;
//import com.androidnetworking.error.ANError;
//import com.androidnetworking.interfaces.JSONObjectRequestListener;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class searchresult extends AppCompatActivity {
//    TextView txtres;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_searchresult);
//
//        Intent fromact=getIntent();
////        String vnum=fromact.getStringExtra("vhno");
//        String vnum = "mh02fb2727";
//        txtres=findViewById(R.id.txtres);
////        txtres.setText(vnum);
//        AndroidNetworking.initialize(this);
//        // Request URL and body
//        String url = "https://rto-vehicle-details.p.rapidapi.com/";
////        String requestBody = "{\"vehicleno\": \"" + vnum + "\"}";
//        JSONObject requestBody = new JSONObject();
//        try {
//            requestBody.put("vehicleno", vnum);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        // Set up the POST request
//        AndroidNetworking.post(url)
//                .addHeaders("content-type", "application/json")
//                .addBodyParameter(requestBody)
//                .addHeaders("X-RapidAPI-Key", "9c776d6b59mshdda6aee4acdd75ap166889jsncb92eb8ba1a6")
//                .addHeaders("X-RapidAPI-Host", "rto-vehicle-details.p.rapidapi.com")
//                .addHeaders("Content-Type", "application/json")
//                .setContentType("application/json")
//                .setTag("POST_REQUEST_TAG")
//                .setPriority(Priority.MEDIUM)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("RES",response.toString());
//
//                        String ow = "Salman ";
//
//                        try {
//                            // Check if the response contains the "brand_name" field
//                            if (response.has("owner_name")) {
//                                // Extract the brand name from the response
//                                ow = response.getString("owner_name");
//
//                                // Set the brand name on the TextView
//                                txtres.setText(ow);
//                            }
//                        } catch (JSONException e) {
//                            throw new RuntimeException(e);
//                        }
////                        try {
////                            String on = response.getString("owner_name");
////                        } catch (JSONException e) {
////                            throw new RuntimeException(e);
////                        }
//                        // Set the brand name on the TextView
////                        txtres.setText(bn);
//                    }
//
//                    @Override
//                    public void onError(ANError anError) {
//                        anError.printStackTrace();
//                        Log.d("ERROR",anError.toString());
//                    }
//                });
//
//
//    }
//}