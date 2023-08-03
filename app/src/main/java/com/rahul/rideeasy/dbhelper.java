package com.rahul.rideeasy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Expense";
    private static final String TABLE_FUEL="fuel";
    private static final String TABLE_SERVICE="fuel";
    private static final int DATABASE_VERSION=1;
    private static final String KEY_ID="id";
    private static final String KEY_DATE="data";
    private static final String KEY_PRICE="price";
    public dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE "+TABLE_FUEL+ "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_DATE+" TEXT,"+KEY_PRICE+" TEXT"+")");
        db.execSQL("CREATE TABLE "+TABLE_SERVICE+ "("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_DATE+" TEXT,"+KEY_PRICE+" TEXT"+")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FUEL);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SERVICE);
        onCreate(db);
    }
    public void addfuelcost(String fdate,String fprice){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_DATE,fdate);
        cv.put(KEY_PRICE,fprice);
        db.insert(TABLE_FUEL,null,cv);

    }
    public void addservicecost(String sdate,String sprice){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_DATE,sdate);
        cv.put(KEY_PRICE,sprice);
        db.insert(TABLE_SERVICE,null,cv);

    }
    public ArrayList<recordmodel> getfuelrecord(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur= db.rawQuery("SELECT * FROM "+TABLE_FUEL,null);
        ArrayList<recordmodel> arrfuellist=new ArrayList<>();
        while (cur.moveToNext()){
            recordmodel cm=new recordmodel();
            cm.id=cur.getInt(0);
            cm.date=cur.getString(1);
            cm.price=cur.getString(2);
            arrfuellist.add(cm);
        }
        return  arrfuellist;
    }
    public ArrayList<recordmodel> getservicerecord(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cur= db.rawQuery("SELECT * FROM "+TABLE_SERVICE,null);
        ArrayList<recordmodel> arrservicelist=new ArrayList<>();
        while (cur.moveToNext()){
            recordmodel cm=new recordmodel();
            cm.id=cur.getInt(0);
            cm.date=cur.getString(1);
            cm.price=cur.getString(2);
            arrservicelist.add(cm);
        }
        return  arrservicelist;
    }
}
