package com.example.myapplication;


import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;

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
        Log.d("mytag","Kitchen Clicked!!!!!!");
        myDialog.setContentView(R.layout.custompopup);
        imgCheck = (ImageView) myDialog.findViewById(R.id.popup_check_ImageView);
        imgClose = (ImageView) myDialog.findViewById(R.id.popup_cross_ImageView);

        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
                Intent testIntent = new Intent(getApplicationContext(), Activity_kitchen.class);
                startActivity(testIntent);
                //myDialog.setContentView(R.layout.activity_kitchen_2);
            }
        });

        imgClose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });

        myDialog.show();

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onKitchenImageViewClick(View view) {
        Log.d("mytag","onKitchenImageViewClick Clicked!!!!!!");
        displayToast("Kitchen");
        Intent testIntent = new Intent(getApplicationContext(), Popup_obsolete.class);
        startActivity(testIntent);
    }


}
