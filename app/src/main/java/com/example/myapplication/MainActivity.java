package com.example.myapplication;


import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mm_popup_kitchen;
    MediaPlayer mm_popup_dining;
    MediaPlayer mm_popup_sleeping;
    MediaPlayer mm_popup_bathroom;
    MediaPlayer mm_popup_living;
    MediaPlayer mm_popup_basement;

    Dialog myDialog;
    ImageView assistant;
    ImageView popupAssistant;

    boolean firstTime = true;
    boolean playAudio = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDialog = new Dialog(this);

        mm_popup_kitchen = MediaPlayer.create(this, R.raw.mm_popup_kitchen);
        mm_popup_dining = MediaPlayer.create(this, R.raw.mm_popup_dining);
        mm_popup_sleeping = MediaPlayer.create(this, R.raw.mm_popup_sleeping);
        mm_popup_bathroom = MediaPlayer.create(this, R.raw.mm_popup_bathroom);
        mm_popup_living = MediaPlayer.create(this, R.raw.mm_popup_living);
        mm_popup_basement = MediaPlayer.create(this, R.raw.mm_popup_basement);
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

    public void ShowPopup(View v) {
        ImageView imgCheck;
        ImageView imgClose;


        Log.d("mytag", "Kitchen " + R.id.SM_Kitchen_ImageView + "_" + v.getId());
        myDialog.setContentView(R.layout.custompopup);
        imgCheck = (ImageView) myDialog.findViewById(R.id.popup_check_ImageView);
        imgClose = (ImageView) myDialog.findViewById(R.id.popup_cross_ImageView);


        popupAssistant = (ImageView) myDialog.findViewById(R.id.popup_assistant_ImageView);

        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake1);
        // Popup Assistant Animation onStart
        popupAssistant.startAnimation(animation);
        // Popup Assistant Animation onClick
        popupAssistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mytag", "popupAssistant click!");

                popupAssistant.startAnimation(animation);

            }
        });


        switch (v.getId()) {
            case R.id.SM_Kitchen_ImageView:
                Log.d("mytag", "switch1");

                mm_popup_kitchen.start();


                mm_popup_kitchen.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mm_popup_kitchen.release();
                    }
                });

                // set onclick of the assistant with the corresponding soundfile
                popupAssistant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "popupAssistant click!");

                        popupAssistant.startAnimation(animation);
                        mm_popup_kitchen.seekTo(0);
                        mm_popup_kitchen.start();


                        mm_popup_kitchen.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mm_popup_kitchen.release();
                            }
                        });
                    }
                });

                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "onclick1");

                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_kitchen.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.SM_Dining_ImageView:
                Log.d("mytag", "switch2");
                mm_popup_dining.start();

                mm_popup_dining.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mm_popup_dining.release();
                    }
                });

                // set onclick of the assistant with the corresponding soundfile
                popupAssistant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "popupAssistant click!");

                        popupAssistant.startAnimation(animation);
                        mm_popup_dining.seekTo(0);
                        mm_popup_dining.start();
                        mm_popup_dining.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mm_popup_dining.release();
                            }
                        });

                    }
                });

                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "onclick2");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_dining.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.SM_Sleeping_ImageView:
                Log.d("mytag", "switch3");
                mm_popup_sleeping.start();

                mm_popup_sleeping.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mm_popup_sleeping.release();
                    }
                });

                // set onclick of the assistant with the corresponding soundfile
                popupAssistant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "popupAssistant click!");

                        popupAssistant.startAnimation(animation);
                        mm_popup_sleeping.seekTo(0);
                        mm_popup_sleeping.start();
                        mm_popup_sleeping.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mm_popup_sleeping.release();
                            }
                        });

                    }
                });

                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "onclick3");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_sleeping.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.SM_Bathroom_ImageView:
                Log.d("mytag", "switch4");
                mm_popup_bathroom.start();

                mm_popup_bathroom.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mm_popup_bathroom.release();
                    }
                });

                // set onclick of the assistant with the corresponding soundfile
                popupAssistant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "popupAssistant click!");

                        popupAssistant.startAnimation(animation);
                        mm_popup_bathroom.seekTo(0);
                        mm_popup_bathroom.start();
                        mm_popup_bathroom.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mm_popup_bathroom.release();
                            }
                        });

                    }
                });

                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "onclick4");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_bathroom.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.MM_Living_ImageView:
                Log.d("mytag", "switch5");
                mm_popup_living.start();

                mm_popup_living.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mm_popup_living.release();
                    }
                });

                // set onclick of the assistant with the corresponding soundfile
                popupAssistant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "popupAssistant click!");

                        popupAssistant.startAnimation(animation);
                        mm_popup_living.seekTo(0);
                        mm_popup_living.start();
                        mm_popup_living.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mm_popup_living.release();
                            }
                        });

                    }
                });

                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "onclick5");
                        myDialog.dismiss();
                        Intent testIntent = new Intent(getApplicationContext(), Activity_livingroom.class);
                        startActivity(testIntent);
                    }
                });
                break;

            case R.id.MM_Basement_ImageView:
                Log.d("mytag", "switch6");
                mm_popup_basement.start();

                mm_popup_basement.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mm_popup_basement.release();
                    }
                });

                // set onclick of the assistant with the corresponding soundfile
                popupAssistant.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "popupAssistant click!");

                        popupAssistant.startAnimation(animation);
                        mm_popup_basement.seekTo(0);
                        mm_popup_basement.start();
                        mm_popup_basement.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mm_popup_basement.release();
                            }
                        });

                    }
                });

                imgCheck.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("mytag", "onclick6");
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

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialog.dismiss();
            }
        });


        myDialog.show();

    }

    public void onSupervisorClick(View view) {
        Intent intent = new Intent(this, Activity_skype.class);
        startActivityForResult(intent, 1);
    }

    public void onAssistantClick(View view) {
        animateAssistant();
        final MediaPlayer introduction = MediaPlayer.create(this, R.raw.introduction);

        final MediaPlayer mm_status = MediaPlayer.create(this, R.raw.mm_status);


        if (playAudio) {
            introduction.start();
        }

        playAudio = false;
        introduction.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                animateAssistant();
                introduction.release();
                mm_status.start();
                playAudio = true;
            }
        });

        mm_status.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mm_status.release();
            }
        });
    }

    private void animateAssistant() {
        assistant = (ImageView) findViewById(R.id.assistant_ImageView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake1);
        assistant.startAnimation(animation);
    }

}
