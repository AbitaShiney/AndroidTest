package com.example.macstudent.c0726316_carserviceremainder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText email;
EditText password;
CheckBox chkRemeberMe;
Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences myPref = getSharedPreferences("mypref", MODE_PRIVATE);

        email = (EditText) findViewById(R.id.editText1);

        password = (EditText) findViewById(R.id.editText2);
        chkRemeberMe = (CheckBox)findViewById(R.id.checkbox1);



        String userid = myPref.getString("email",null);
        final String pwd = myPref.getString("password",null);


        if(userid != null && pwd != null) {
            email.setText(userid);
            password.setText(pwd);
            chkRemeberMe.setChecked(true);
        }else
        {
            chkRemeberMe.setChecked(false);
        }

        b1 = (Button)findViewById(R.id.button);


        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(TextUtils.isEmpty(email.getText()) || email.getText().toString().length() == 0)
                {
                    email.setError("Please Enter User Name");
                }
                else {

                    if (email.getText().toString().equals("user1@carservice.com") && password.getText().toString().equals("s3cr3t")) {
                        Toast.makeText(MainActivity.this, "User Successfully logged in ", Toast.LENGTH_LONG).show();


                        SharedPreferences.Editor editor = myPref.edit();
                        if(chkRemeberMe.isChecked())
                        {

                            editor.putString("email", email.getText().toString());
                            editor.putString("password", password.getText().toString());
                        }
                        else
                        {

                            editor.remove("email");
                            editor.remove("password");
                        }

                        editor.apply();

                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "UserID/passwords invalid", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });


    }
}
