package com.example.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_kitchen extends AppCompatActivity {

    MediaPlayer mm_popup_kitchen;
    MediaPlayer sm_task;

    MediaPlayer smiley_feedback_green;
    MediaPlayer smiley_feedback_yellow;
    MediaPlayer smiley_feedback_red;

    ImageView assistant;
    public int color;

    boolean playAudio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
        Log.d("mytag", "kitchen onCreate");

        mm_popup_kitchen = MediaPlayer.create(this, R.raw.sm_state_kitchen_task);
        sm_task = MediaPlayer.create(this, R.raw.sm_task);
        smiley_feedback_green = MediaPlayer.create(this, R.raw.smiley_feedback_green);
        smiley_feedback_yellow = MediaPlayer.create(this, R.raw.smiley_feedback_yellow);
        smiley_feedback_red = MediaPlayer.create(this, R.raw.smiley_feedback_red);

        sm_task.seekTo(0);
        sm_task.start();


        animateAssistant();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("mytag", "kitchen start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("mytag", "kitchen destroy");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("mytag", "kitchen resume");


    }

    @Override
    protected void onPause() {
        super.onPause();
        /*
        Log.d("mytag", "kitchen pause");
        mm_popup_kitchen.stop();
        mm_popup_kitchen.release();
        sm_task.stop();
        sm_task.release();
        smiley_feedback_green.stop();
        smiley_feedback_green.release();
        smiley_feedback_yellow.stop();
        smiley_feedback_yellow.release();
        smiley_feedback_red.stop();
        smiley_feedback_red.release();
        */
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("mytag", "kitchen stop");

/*
        mm_popup_kitchen.stop();
        mm_popup_kitchen.release();
        sm_task.stop();
        sm_task.release();
        smiley_feedback_green.stop();
        smiley_feedback_green.release();
        smiley_feedback_yellow.stop();
        smiley_feedback_yellow.release();
        smiley_feedback_red.stop();
        smiley_feedback_red.release();
        */

    }


    public void onBackButtonClick(View view) {
        Intent testIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(testIntent);
    }

    public void onSubmenuTileClick(View view) {
        int x = 21;
        Log.d("mytag", "onSubmenuTile Clicked!!!!!!");

        Intent intent = new Intent(this, Activity_smiley.class);
        intent.putExtra("viewId", view.getId());
        startActivityForResult(intent, 1);
        //startActivity(testIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("mytag", "requestCode " + requestCode);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                color = data.getIntExtra("color", 0);
                ImageView imgView = (ImageView) findViewById(data.getIntExtra("id", 0));
                imgView.setBackgroundResource(color);


                String result = data.getStringExtra("result");
                switch (result) {
                    case "green":
                        smiley_feedback_green.seekTo(0);
                        smiley_feedback_green.start();

                        animateAssistant();
                        break;
                    case "yellow":
                        smiley_feedback_yellow.seekTo(0);
                        smiley_feedback_yellow.start();

                        animateAssistant();
                        break;
                    case "red":
                        smiley_feedback_red.seekTo(0);
                        smiley_feedback_red.start();

                        animateAssistant();
                        break;
                    default:
                        break;
                }
            }
            if (resultCode == RESULT_CANCELED) {
                Log.d("mytag", "RESULT_CANCELED");
            }
        }
    }

    public void onSupervisorClick(View view) {
        Intent intent = new Intent(this, Activity_skype.class);
        startActivityForResult(intent, 1);
    }

    /*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color_cleaning", color);
    }
*/

    public void onAssistantClick(View view) {
        animateAssistant();
        //if (!playAudio) return;


        mm_popup_kitchen.seekTo(0);
        mm_popup_kitchen.start();
        //playAudio = false;
/*

        mm_popup_kitchen.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                animateAssistant();
                mm_popup_kitchen.release();
                //playAudio = true;
                sm_task.seekTo(0);
                sm_task.start();
            }
        });

        sm_task.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sm_task.release();
            }
        });
        */
    }

    private void animateAssistant() {
        assistant = (ImageView) findViewById(R.id.assistant_ImageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake1);
        assistant.startAnimation(animation);
    }
}
