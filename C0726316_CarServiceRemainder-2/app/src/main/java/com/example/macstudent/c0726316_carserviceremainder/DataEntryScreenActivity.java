package com.example.macstudent.c0726316_carserviceremainder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DataEntryScreenActivity extends AppCompatActivity {
private Button buttonAdd;
DatabaseHelper databaseHelper;
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry_screen);
        editText = (EditText) findViewById(R.id.editText);
        buttonAdd = (Button) findViewById(R.id.btnOK);
        databaseHelper = new DatabaseHelper(this);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String newEntry = editText.getText().toString();
                Intent intent = new Intent(DataEntryScreenActivity.this,ListDataActivity.class);
                startActivity(intent);
            }
        });

    }
    public void addData(String newEntry){
        boolean insertData = databaseHelper.addData(newEntry);
        if(insertData){
            Toast.makeText(DataEntryScreenActivity.this, "Data added successfully", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(DataEntryScreenActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
        }
    }
}
