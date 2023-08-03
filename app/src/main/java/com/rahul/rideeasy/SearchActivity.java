package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SearchActivity extends AppCompatActivity {
    CardView cardsearchvehiclebyimage,cardsearchvehiclebytext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        cardsearchvehiclebytext=findViewById(R.id.cardsearchvehiclebytext);
        cardsearchvehiclebyimage=findViewById(R.id.cardsearchvehiclebyimage);

        cardsearchvehiclebytext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SearchActivity.this,searchactivitytext.class));
            }
        });
    }
}