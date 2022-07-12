package com.rajarshigoala.brainitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class level1 extends AppCompatActivity {
int result = 8;
Toast currentToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        getSupportActionBar().hide();
// view variables

        Button submit;
        EditText input;
        submit = (Button) findViewById(R.id.submitlv1);
        input = (EditText)findViewById(R.id.youranswerlv1);


        Button switch1,switch2,button,toggle,hidden1,hidden2,hidden3;
        switch1 = findViewById(R.id.switch5lv1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "This is a switch button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });
        switch2 = findViewById(R.id.switch6lv1);
        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "This is a switch button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });

        button = findViewById(R.id.button2lv1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "This is a normal button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });
        toggle = findViewById(R.id.toggleButton1lv1);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "This is a toggle button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });

        hidden1 = findViewById(R.id.hiddenswitch1lv1);
        hidden1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "You've found a hidden button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });
        hidden2 = findViewById(R.id.hiddenswitch2lv1);
        hidden2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "You've found a hidden button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });
        hidden3 = findViewById(R.id.hiddenswitch3lv1);
        hidden3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(level1.this, "You've found a hidden button", Toast.LENGTH_SHORT);
                currentToast.show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().matches("")){
                    if(currentToast != null)
                        currentToast.cancel();
                    currentToast = Toast.makeText(level1.this, "You have not entered anything! Please enter a number.", Toast.LENGTH_SHORT);
                    currentToast.show();
                }
                else{
                    int inputreceived =  Integer.parseInt(input.getText().toString());
                    if(result==inputreceived){
                        afterSubmit();
                    }
                    else{
                        if(currentToast != null)
                            currentToast.cancel();
                        currentToast = Toast.makeText(level1.this, "That is not the correct number. Please check again!", Toast.LENGTH_SHORT);
                        currentToast.show();
                    }

                }

            }
        });



    }
    public void afterSubmit(){
        Button continuebutton;
        ImageView thumbsup = findViewById(R.id.thumbsuplv1);
        TextView textView = findViewById(R.id.answerlv1);
        textView.setVisibility(View.VISIBLE);
        thumbsup.setVisibility(View.VISIBLE);
        continuebutton=findViewById(R.id.continuelv1);
        continuebutton.setVisibility(View.VISIBLE);
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(level1.this,Level2.class);
                startActivity(intent);
            }
        });




    }
}