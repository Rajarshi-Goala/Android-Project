package com.rajarshigoala.brainitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Rewardspage extends AppCompatActivity {
Toast currentToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewardspage);
        //View variables declaration
        TextView heading,text1,code1,text2,code2,messagebox,gmailad;
        text1 = findViewById(R.id.award1);
        code1 = findViewById(R.id.award1code);
        text2 = findViewById(R.id.award2);
        code2 = findViewById(R.id.award2code);
        messagebox = findViewById(R.id.messagebox9);
        ImageButton gmail,github,map;
        gmailad = findViewById(R.id.email);
        gmail = findViewById(R.id.gmail);
        github = findViewById(R.id.github);
        map = findViewById(R.id.map);
        messagebox.setVisibility(View.INVISIBLE);
        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(Rewardspage.this, ":rajarshigoala101@gmail.com", Toast.LENGTH_LONG);
                currentToast.show();
            }
        });
        gmail.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("mailto:rajarshigoala101@gmail.com"));
                startActivity(intent);

                return false;
            }
        });
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(Rewardspage.this, "https://github.com/Rajarshi-Goala", Toast.LENGTH_LONG);
                currentToast.show();
            }
        });
        github.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/Rajarshi-Goala"));
                startActivity(intent);

                return false;
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentToast != null)
                    currentToast.cancel();
                currentToast = Toast.makeText(Rewardspage.this, "Dept of Computer Science and Engineering\nTriguna Sen School of Technology\nAssam University Silchar", Toast.LENGTH_LONG);
                currentToast.show();
            }
        });
        map.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://goo.gl/maps/6et7cBvwSy5T4r8j6"));
                startActivity(intent);

                return false;
            }
        });


        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code1.setText("GJUKQSREXJB8WA6");
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code2.setText("BIO-COU");
                messagebox.setVisibility(View.VISIBLE);
            }
        });

// Hi message
        heading = findViewById(R.id.heading);
        String uname = getIntent().getStringExtra("uname");
        heading.setText("Hi " + uname + " !!!");
        heading.setGravity(Gravity.CENTER);
        heading.setTextSize(20);
    }

}