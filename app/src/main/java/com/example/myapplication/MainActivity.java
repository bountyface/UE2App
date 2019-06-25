package com.example.myapplication;


import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        TextView txtclose;

        myDialog.setContentView(R.layout.custompopup);
        txtclose=(TextView) myDialog.findViewById(R.id.txtclose);

        txtclose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myDialog.dismiss();
            }
        });
        myDialog.show();

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void onKitchenImageViewClick(View view) {
        displayToast("Kitchen");
        Intent testIntent = new Intent(getApplicationContext(), Popup.class);
        startActivity(testIntent);
    }
}
