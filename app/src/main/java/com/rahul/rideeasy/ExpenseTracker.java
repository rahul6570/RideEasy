package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class ExpenseTracker extends AppCompatActivity {
    AppCompatButton btnenter,btnservice,btnfuel;
    EditText edtprice,edtdate,edttype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_tracker);
        btnenter=findViewById(R.id.btnenter);
        btnservice=findViewById(R.id.btnservice);
        btnfuel=findViewById(R.id.btnfuel);
        edtdate=findViewById(R.id.edtdate);
        edtprice=findViewById(R.id.edtprice);
        edttype=findViewById(R.id.edttype);
//        String price;
//        String date;
//        String type;
        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price,date,type;
                price=edtprice.getText().toString();
                date=edtdate.getText().toString();
                type=edttype.getText().toString().toLowerCase(Locale.ROOT);
                String f="fuel",s="service";
                if(type.equals(f)){
                    dbhelper dbh=new dbhelper(getApplicationContext());
                    dbh.addfuelcost(date,price);
                }
                else if(type.equals(s)){
                    dbhelper dbh=new dbhelper(getApplicationContext());
                    dbh.addservicecost(date,price);
                }
                else{
                    dbhelper dbh=new dbhelper(getApplicationContext());
                    Toast.makeText(ExpenseTracker.this, "Enter correct records", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnfuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExpenseTracker.this,displayfuel.class));
            }
        });
        btnservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ExpenseTracker.this,displayservice.class));
            }
        });


    }
}