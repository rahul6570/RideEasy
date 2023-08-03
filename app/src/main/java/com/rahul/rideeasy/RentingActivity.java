package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RentingActivity extends AppCompatActivity {
    CardView cardpost,cardrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renting);
        cardpost=findViewById(R.id.cardpost);
        cardrent=findViewById(R.id.cardrent);
        cardrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RentingActivity.this,RentingDisplay.class));
            }
        });
    }
}