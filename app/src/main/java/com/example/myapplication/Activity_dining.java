package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class Activity_dining extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
        Log.d("mytag","dining created");

    }
    public void onBackButtonClick(View view){
        Intent testIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(testIntent);
    }

    public void onSubmenuTileClick(View view){
        int x = 21;
        Log.d("mytag","onSubmenuTile Clicked!!!!!!");

        Intent intent = new Intent(this, Activity_smiley.class);
        intent.putExtra("viewId",view.getId());
        startActivityForResult(intent,1);
        //startActivity(testIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode==RESULT_OK){
                int color = data.getIntExtra("color",0);
                ImageView imgView = (ImageView) findViewById(data.getIntExtra("id",0));
                imgView.setBackgroundResource(color);
                Log.d("mytag","RESULT_OK: "+color);
            }
            if(resultCode==RESULT_CANCELED){
                Log.d("mytag","RESULT_CANCELED");
            }
        }
    }
    public void onSupervisorClick(View view){
        Intent intent = new Intent(this, Activity_skype.class);
        startActivityForResult(intent,1);
    }
}
