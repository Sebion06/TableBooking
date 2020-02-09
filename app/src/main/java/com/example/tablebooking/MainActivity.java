package com.example.tablebooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {       //prepare for spaghetti code <3

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doLaunchBookingScreen(View view){
        startActivity(new Intent(this,BookingActivity.class));      //for booking tables
    }

    public void doLaunchLayoutScreen(View view){
        startActivity(new Intent(this,LayoutActivity.class));       //for setting up tables
    }
}
