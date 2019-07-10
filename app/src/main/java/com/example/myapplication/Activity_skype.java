package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity_skype extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skype);
    }

    public void onPhoneClick(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent);

        finish();
    }
}
