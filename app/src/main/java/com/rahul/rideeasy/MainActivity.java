package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView cardsearchvehicle,cardcomplain,cardfindnearest,cardrentvehicle,cardbuyservice;
    CardView cardresale,cardexpenselog,cardfuelprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardsearchvehicle=findViewById(R.id.cardsearchvehicle);
        cardcomplain=findViewById(R.id.cardcomplain);
        cardfindnearest=findViewById(R.id.cardfindnearest);
        cardbuyservice=findViewById(R.id.cardbuyservice);
        cardrentvehicle=findViewById(R.id.cardrentvehicle);
        cardfuelprice=findViewById(R.id.cardfuelprice);
        cardresale=findViewById(R.id.cardresale);
        cardexpenselog=findViewById(R.id.cardexpenselog);

        cardfindnearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RideEasyMap.class));
            }
        });
        cardsearchvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });
        cardcomplain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Complain.class));
            }
        });
        cardexpenselog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ExpenseTracker.class));
            }
        });
        cardrentvehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RentingActivity.class));
            }
        });
    }
}