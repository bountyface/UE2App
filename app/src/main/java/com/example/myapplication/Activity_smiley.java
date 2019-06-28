package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
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
        Log.d("mytag",""+view.getId());


        Intent intent = new Intent();
        intent.putExtra("color","#D81B60" );
        intent.putExtra("id", receivedIntent.getIntExtra("viewId",0));
        setResult(RESULT_OK, intent);

        finish();
        //ImageView imgView = (ImageView) findViewById(view.getId());
        //imgView.setBackgroundColor(Color.parseColor("#D81B60"));


        //view.getId();


    }
    public void onSmileyYellowClick(View view){

    }
    public void onSmileyRedClick(View view){

    }
}
