package com.rajarshigoala.brainitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class main_menu extends AppCompatActivity {
// Public variables declaraion
    int count = 0;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        // Declaration of Views objects
        EditText editText = (EditText) findViewById(R.id.username);
        Button submit;


        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = editText.getText().toString();
                aftersubmit();
            }
        });
    }
    public void aftersubmit(){
        TextView textView1,textView2;
        textView1 = (TextView) findViewById(R.id.introStartText);
        textView1.animate().alpha(1).setDuration(10);
        textView2 = (TextView) findViewById(R.id.startindark);
        textView2.animate().alpha(1).setDuration(10);
        Button nextdummy = (Button) findViewById(R.id.nextdummyButton);
        nextdummy.animate().alpha(1).setDuration(10);
        nextdummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count<10){
                    Toast.makeText(main_menu.this, "Umm..I said press the Start in the dark, why press next?", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(main_menu.this, "Hint only for 1st level - Turn on Dark Mode", Toast.LENGTH_SHORT).show();
                }

            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_menu.this,level1.class);
                intent.putExtra("usernname",user);
                startActivity(intent);
            }
        });
    }
}