package com.example.user.CURIFY;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by FELIX on 12/18/2016.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "curify.db";
    private static final String TABLE_NAME = "login_table";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "name";
    private static final String COL_EMAIL = "email";
    private static final String COL_PASS = "password";
    private static final String COL_ADDR = "address";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table login_table (id integer primary key not null , " + "uname text not null , " + "email text not null , " + "pw text not null , " + "addr text not null);";

    public DbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertContact(DbContact c){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from login_table";
        Cursor cursor = db.rawQuery(query, null);
        int count  = cursor.getCount();

        values.put(COL_ID, count);
        values.put(COL_NAME, c.getUname());
        values.put(COL_EMAIL, c.getEmail());
        values.put(COL_PASS, c.getPw());
        values.put(COL_ADDR, c.getAddr());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String name){
        db = this.getReadableDatabase();
        String query = "select name, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                if(a.equals(name)){
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
