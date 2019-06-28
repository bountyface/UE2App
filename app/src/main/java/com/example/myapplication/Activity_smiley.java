package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Activity_smiley extends AppCompatActivity {
public Intent receivedIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smiley);

        //Intent intent = getIntent();
        receivedIntent = getIntent();
        int id = receivedIntent.getIntExtra("viewId",0);
        //int number1 = intent.getIntExtra("number1", 0);
    }

    public void onSmileyGreenClick(View view){
        Intent intent = new Intent();
        intent.putExtra("color", R.color.colorTaskPositive);
        intent.putExtra("id", receivedIntent.getIntExtra("viewId",0));
        setResult(RESULT_OK, intent);

        finish();

    }
    public void onSmileyYellowClick(View view){
        Intent intent = new Intent();
        intent.putExtra("color",R.color.colorTaskNeutral );
        intent.putExtra("id", receivedIntent.getIntExtra("viewId",0));
        setResult(RESULT_OK, intent);

        finish();

    }
    public void onSmileyRedClick(View view){
        Intent intent = new Intent();
        intent.putExtra("color",R.color.colorTaskNegative );
        intent.putExtra("id", receivedIntent.getIntExtra("viewId",0));
        setResult(RESULT_OK, intent);

        finish();
    }
}
