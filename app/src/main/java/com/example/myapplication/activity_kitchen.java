package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class Activity_kitchen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

    }
    public void onBackButtonClick(View view){
        Intent testIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(testIntent);
    }

    public void onSubmenuTileClick(){
        Log.d("mytag","onSubmenuTile Clicked!!!!!!");
        Intent testIntent = new Intent(this, Activity_smiley.class);
        startActivity(testIntent);

    }
}
