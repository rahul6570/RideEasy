package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class searchactivitytext extends AppCompatActivity {
    EditText edtvehicleno;
    AppCompatButton btnsearchtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchactivitytext);
        edtvehicleno=findViewById(R.id.edtvehicleno);
        btnsearchtxt=findViewById(R.id.btnsearchtxt);

        btnsearchtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vno=edtvehicleno.getText().toString();
                Intent inext;
                inext=new Intent(searchactivitytext.this,searchresult.class);
                inext.putExtra("vhno",vno);
                startActivity(inext);
            }
        });
    }
}