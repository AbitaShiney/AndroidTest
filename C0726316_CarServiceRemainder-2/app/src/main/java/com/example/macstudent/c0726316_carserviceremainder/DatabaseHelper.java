package com.example.macstudent.c0726316_carserviceremainder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by macstudent on 2018-04-13.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "Servicetable";
    private static final String COL1 = "ID";
    private static final String COL2 = "Odometer";

    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 +" TEXT)";
             db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
    }
    public boolean addData(String item){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item);
        Log.d(TAG, "Adding " + item + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }


    public Cursor addData() {

        return null;
    }
}
