package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_smiley extends AppCompatActivity {

    ImageView assistant;
    boolean playAudio = true;

    MediaPlayer smiley_info;

    public Intent receivedIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smiley);

        //Intent intent = getIntent();
        receivedIntent = getIntent();
        int id = receivedIntent.getIntExtra("viewId", 0);
        //int number1 = intent.getIntExtra("number1", 0);

        smiley_info = MediaPlayer.create(this, R.raw.smiley_info);

        smiley_info.seekTo(0);
        smiley_info.start();

        animateAssistant();
    }

    public void onSmileyGreenClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("result", "green");
        intent.putExtra("color", R.color.colorTaskPositive);
        intent.putExtra("id", receivedIntent.getIntExtra("viewId", 0));
        setResult(RESULT_OK, intent);

        finish();

    }

    public void onSmileyYellowClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("result", "yellow");
        intent.putExtra("color", R.color.colorTaskNeutral);
        intent.putExtra("id", receivedIntent.getIntExtra("viewId", 0));
        setResult(RESULT_OK, intent);

        finish();

    }

    public void onSmileyRedClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("result", "red");
        intent.putExtra("color", R.color.colorTaskNegative);
        intent.putExtra("id", receivedIntent.getIntExtra("viewId", 0));
        setResult(RESULT_OK, intent);

        finish();
    }

    public void onSupervisorClick(View view) {
        Intent intent = new Intent(this, Activity_skype.class);
        startActivityForResult(intent, 1);
    }

    public void onAssistantClick(View view) {
        animateAssistant();


        smiley_info.seekTo(0);
        smiley_info.start();
/*
        playAudio = false;
        smiley_info.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                //animateAssistant();
                playAudio = true;
            }
        });*/
    }

    private void animateAssistant() {
        assistant = (ImageView) findViewById(R.id.assistant_ImageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake1);
        assistant.startAnimation(animation);
    }
}
