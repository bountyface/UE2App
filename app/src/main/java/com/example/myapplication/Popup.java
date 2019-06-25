package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Popup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custompopup);
    }

    public void onCheckClick(View view){
        Intent testIntent = new Intent(getApplicationContext(), Activity_kitchen.class);
        startActivity(testIntent);
    }
    public void onCrossClick(View view){

    }
}
