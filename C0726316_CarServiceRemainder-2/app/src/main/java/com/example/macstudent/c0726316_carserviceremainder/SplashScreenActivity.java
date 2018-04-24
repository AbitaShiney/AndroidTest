package com.example.macstudent.c0726316_carserviceremainder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread thread = new Thread(){
            @Override
            public void run() {
try{
    sleep(3000);
    Intent intent = new Intent(SplashScreenActivity.this,MainActivity.class);
    startActivity(intent);
    finish();
}
catch (InterruptedException e){
    e.printStackTrace();
}
            }
        };
    thread.start();
    }

}
