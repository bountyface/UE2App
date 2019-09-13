package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Activity_dining extends AppCompatActivity {

    ImageView assistant;
    public int color;
    MediaPlayer mm_popup_dining;
    MediaPlayer sm_task;

    MediaPlayer smiley_feedback_green;
    MediaPlayer smiley_feedback_yellow;
    MediaPlayer smiley_feedback_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);

        mm_popup_dining = MediaPlayer.create(this, R.raw.sm_state_dining_task);
        sm_task = MediaPlayer.create(this, R.raw.sm_task);
        smiley_feedback_green = MediaPlayer.create(this, R.raw.smiley_feedback_green);
        smiley_feedback_yellow = MediaPlayer.create(this, R.raw.smiley_feedback_yellow);
        smiley_feedback_red = MediaPlayer.create(this, R.raw.smiley_feedback_red);

        sm_task.seekTo(0);
        sm_task.start();

        animateAssistant();
    }

    public void onBackButtonClick(View view) {
        Intent testIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(testIntent);
    }

    public void onSubmenuTileClick(View view) {
        Intent intent = new Intent(this, Activity_smiley.class);
        intent.putExtra("viewId", view.getId());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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

                Log.d("mytag", "RESULT_OK: " + color);
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

    private void animateAssistant() {
        assistant = (ImageView) findViewById(R.id.assistant_ImageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake1);
        assistant.startAnimation(animation);
    }

    public void onAssistantClick(View view) {
        animateAssistant();
        mm_popup_dining.seekTo(0);
        mm_popup_dining.start();
    }

}
