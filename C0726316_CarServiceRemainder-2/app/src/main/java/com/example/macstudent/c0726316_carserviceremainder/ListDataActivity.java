package com.example.macstudent.c0726316_carserviceremainder;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
private static final String TAG = "ListDataActivity";
DatabaseHelper databaseHelper;
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        listView = (ListView) findViewById(R.id.listView);
        databaseHelper = new DatabaseHelper(this);
        populateView();
    }
    private void  populateView(){
        Log.d(TAG,"Displaying data in ListView" );
        Cursor data = databaseHelper.addData();
        ArrayList<String > listData = new ArrayList<>();
        while (data.moveToNext()){
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listData);
        listView.setAdapter(adapter);
    }
}
