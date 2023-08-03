package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class displayfuel extends AppCompatActivity {
    RecyclerView recyclervwfuel;
    TextView txtfueltotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayfuel);
        recyclervwfuel=findViewById(R.id.recylervwfuel);
        txtfueltotal=findViewById(R.id.txtfueltotal);
        recyclervwfuel.setLayoutManager(new LinearLayoutManager(this));
        dbhelper dbh=new dbhelper(getApplicationContext());
        ArrayList<recordmodel> arrayfuellist =dbh.getfuelrecord();
        int totalsum=0;
        for (recordmodel data : arrayfuellist) {
            // Step 2: Convert the price to a numeric data type (double)
            int price = Integer.parseInt(data.price);
            totalsum += price;
        }

        // Step 3: Convert the sum back to a string
        String totalPrice = String.valueOf(totalsum);
        recyclerfueladapter adp=new recyclerfueladapter(this,arrayfuellist);
        recyclervwfuel.setAdapter(adp);
        txtfueltotal.setText(totalPrice);

    }
}