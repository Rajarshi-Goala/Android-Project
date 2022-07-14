package com.rajarshigoala.brainitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Level3 extends AppCompatActivity {
    double answer = 0.56;
    Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        getSupportActionBar().hide();

        // view Variables
        EditText editText = findViewById(R.id.answernumber);
        Button check = findViewById(R.id.checkButton);


        VideoView videoView = findViewById(R.id.videoViewlv3);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1lv3);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        calculate();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")){
                    if (currentToast != null)
                        currentToast.cancel();
                    currentToast = Toast.makeText(Level3.this, "Write a probability value before clicking submit.", Toast.LENGTH_SHORT);
                    currentToast.show();
                }
                else{
                    double inputans = Double.parseDouble(editText.getText().toString());
                    if (inputans == answer) {
                        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.congratulations);
                        videoView.start();
                        aftercheck(check);
                    } else {
                        if (currentToast != null)
                            currentToast.cancel();
                        currentToast = Toast.makeText(Level3.this, "Nope this is not the correct answer", Toast.LENGTH_SHORT);
                        currentToast.show();
                    }

                }

            }
        });
    }

    public void calculate() {

        EditText editText1, editText2;
        TextView answertext, equaltext;
        editText1 = findViewById(R.id.inputnum1);
        editText2 = findViewById(R.id.inputno2);


        equaltext = findViewById(R.id.equaltotext);
        answertext = findViewById(R.id.answerbox);
        equaltext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num1, num2, result;
                num1 = Double.parseDouble(editText1.getText().toString());
                num2 = Double.parseDouble(editText2.getText().toString());
                result = num1 / num2;
                answertext.setText(String.valueOf(result));
            }
        });


    }

    public void aftercheck(Button next) {
        TextView intro, heading;
        ImageView imageView = findViewById(R.id.thumbsuplv3);
        heading = findViewById(R.id.textView2);
        intro = findViewById(R.id.textView7);
        imageView.setVisibility(View.VISIBLE);
        heading.setText("Congratulations!!\nThat is the correct answer, I see you know you probability theory.");
        heading.setGravity(Gravity.CENTER);
        intro.setText("You can now claim your rewards on the next page!!");
        next.setText("Next");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level3.this,Rewardspage.class);
                String user = getIntent().getStringExtra("uname");
                intent.putExtra("uname",user);
                startActivity(intent);
            }
        });

    }
}

