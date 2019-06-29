package com.example.myapplication;


import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;
    ImageView assistant;
    ImageView popupAssistant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        myDialog = new Dialog(this);

        // for testing purpose
        /*
        ImageView kitchenImageView = (ImageView) findViewById(R.id.MM_Kitchen_ImageView);
        kitchenImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                displayToast("Kitchen");
                Intent testIntent = new Intent(getApplicationContext(), test.class);
                startActivity(testIntent);
            }
        });
        */
    }

    public void ShowPopup(View v){
        ImageView imgCheck;
        ImageView imgClose;


        Log.d("mytag","Kitchen " +R.id.SM_Kitchen_ImageView +"_"+ v.getId());
        myDialog.setContentView(R.layout.custompopup);
        imgCheck = (ImageView) myDialog.findViewById(R.id.popup_check_ImageView);
        imgClose = (ImageView) myDialog.findViewById(R.id.popup_cross_ImageView);



        switch(v.getId()){
            case R.id.SM_Kitchen_ImageView:
                Log.d("mytag","switch1");
                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag","onclick1");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_kitchen.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.SM_Dining_ImageView:
                Log.d("mytag","switch2");
                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag","onclick2");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_dining.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.SM_Sleeping_ImageView:
                Log.d("mytag","switch3");
                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag","onclick3");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_sleeping.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.SM_Bathroom_ImageView:
                Log.d("mytag","switch4");
                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag","onclick4");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_bathroom.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.MM_Living_ImageView:
                Log.d("mytag","switch5");
                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag","onclick5");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_livingroom.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.MM_Basement_ImageView:
                Log.d("mytag","switch6");
                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag","onclick6");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_basement.class);
                        startActivity(testIntent);
                    }
                });
                break;

                default:
                    break;
        }
/*
        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Intent testIntent = new Intent(getApplicationContext(), Activity_kitchen.class);
                startActivity(testIntent);
            }
        });
        */

        imgClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        popupAssistant =(ImageView)myDialog.findViewById(R.id.popup_assistant_ImageView);
        popupAssistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mytag","popupAssistant click!");

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake1);
                popupAssistant.startAnimation(animation);

            }
        });
        
        myDialog.show();

    }

    public void onSupervisorClick(View view){
        Intent intent = new Intent(this, Activity_skype.class);
        startActivityForResult(intent,1);
}
public void onAssistantClick(View view) {
    animateAssistant();
}

private void animateAssistant(){
    assistant = (ImageView)findViewById(R.id.assistant_ImageView);
    Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake1);
    assistant.startAnimation(animation);
}

}
