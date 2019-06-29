package com.example.myapplication;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class Startup extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Log.d("mytag", "only onStartup");


    }


}
