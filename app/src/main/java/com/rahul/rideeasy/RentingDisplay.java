package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RentingDisplay extends AppCompatActivity {
    RecyclerView rcyrentdisplay;
    rentadapter adpr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renting_display);
        rcyrentdisplay=(RecyclerView) findViewById(R.id.rcyrentdisplay);
        rcyrentdisplay.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<RentModel> options =
                new FirebaseRecyclerOptions.Builder<RentModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("rentals"), RentModel.class)
                        .build();
        adpr=new rentadapter(options);
        rcyrentdisplay.setAdapter(adpr);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adpr.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adpr.stopListening();
    }
}