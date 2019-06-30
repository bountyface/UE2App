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

    boolean playAudio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dining);
        Log.d("mytag", "dining created");

        final MediaPlayer sm_task = MediaPlayer.create(this, R.raw.sm_task);
        sm_task.start();
        sm_task.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                sm_task.release();
            }
        });

        animateAssistant();

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

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                color = data.getIntExtra("color", 0);
                ImageView imgView = (ImageView) findViewById(data.getIntExtra("id", 0));
                imgView.setBackgroundResource(color);


                String result = data.getStringExtra("result");
                switch (result) {
                    case "green":
                        final MediaPlayer smiley_feedback_green = MediaPlayer.create(this, R.raw.smiley_feedback_green);
                        smiley_feedback_green.start();
                        smiley_feedback_green.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                smiley_feedback_green.release();
                            }
                        });

                        animateAssistant();
                        break;
                    case "yellow":
                        final MediaPlayer smiley_feedback_yellow = MediaPlayer.create(this, R.raw.smiley_feedback_yellow);
                        smiley_feedback_yellow.start();
                        smiley_feedback_yellow.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                smiley_feedback_yellow.release();
                            }
                        });

                        animateAssistant();
                        break;
                    case "red":
                        final MediaPlayer smiley_feedback_red = MediaPlayer.create(this, R.raw.smiley_feedback_red);
                        smiley_feedback_red.start();
                        smiley_feedback_red.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                smiley_feedback_red.release();
                            }
                        });


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
        final MediaPlayer mm_popup_dining = MediaPlayer.create(this, R.raw.sm_state_dining);
        final MediaPlayer sm_task = MediaPlayer.create(this, R.raw.sm_task);

        if (playAudio) {
            mm_popup_dining.start();
            playAudio = false;
        }

        mm_popup_dining.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                animateAssistant();
                mm_popup_dining.release();
                sm_task.start();

            }
        });

        sm_task.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                playAudio = true;
                sm_task.release();
            }
        });

        Log.d("mytag", "playAudio " + playAudio);
        animateAssistant();
    }

}
