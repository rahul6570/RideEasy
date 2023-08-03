package com.rahul.rideeasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Complain extends AppCompatActivity {
    WebView webvw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complain);
        webvw=findViewById(R.id.webvw);
        webvw.loadUrl("https://mumbaipolice.gov.in/OnlineComplaints?ps_id=0");
        webvw.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(webvw.canGoBack()){
            webvw.goBack();
        }else{
            super.onBackPressed();
        }
    }
}