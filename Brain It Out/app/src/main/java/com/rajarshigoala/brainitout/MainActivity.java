package com.rajarshigoala.brainitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // Public variables declaration.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //views declaration
        TextView greetings = (TextView) findViewById(R.id.greetingsText);
        Button continueButton;

        // Text animation alpha and translation
        greetings.animate().alpha(1).setDuration(2000);
        greetings.animate().translationY(-40).setStartDelay(3000).setDuration(1000);


        // button action
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.animate().alpha(1).setStartDelay(5000).setDuration(500);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,main_menu.class);
                startActivity(intent);

            }
        });
    }
}