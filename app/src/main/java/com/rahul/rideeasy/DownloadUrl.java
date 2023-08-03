package com.rahul.rideeasy;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrl {
    public String rURL(String url)throws IOException{
        String urldata="";
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        try{

            URL geturl=new URL(url);
            httpURLConnection=(HttpURLConnection)geturl.openConnection();
            httpURLConnection.connect();

            inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb=new StringBuffer();
            String line="";
            while((line=bufferedReader.readLine())!=null){
                sb.append(line);
            }
            urldata=sb.toString();
            bufferedReader.close();

        } catch (Exception e) {
            Log.d("Exception",e.toString());
        } finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }
        return url;
    }
}
