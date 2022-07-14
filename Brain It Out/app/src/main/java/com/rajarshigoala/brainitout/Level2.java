package com.rajarshigoala.brainitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Level2 extends AppCompatActivity {
    final String url1 = "https://www.google.com", url2 = "www.google.com";
    Toast currentToast;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        getSupportActionBar().hide();
        // View variables declaration

        TextView text1,text2;
        EditText urllv2 = findViewById(R.id.enterurllv2);
        Button fixlv2;
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);
        fixlv2 = findViewById(R.id.fixButtonlv2);

        WebView webView = findViewById(R.id.webpagelv2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://mrdoob.com/projects/chromeexperiments/google-gravity/");


        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(count==1){
                    text1.setVisibility(View.INVISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    urllv2.setVisibility(View.VISIBLE);
                    fixlv2.setVisibility(View.VISIBLE);
                    count++;
                    webView.setWebViewClient(new WebViewClient() {
                        public boolean shouldOverrideUrlLoading (WebView view, String url){
                            return true;
                        }
                    });

                }

                return false;
            }
        });

        fixlv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputURL = urllv2.getText().toString();
                if (inputURL.equals(url1) || inputURL.equals(url2)){

                    text2.setVisibility(View.INVISIBLE);
                    urllv2.setVisibility(View.INVISIBLE);
                    fixlv2.setVisibility(View.INVISIBLE);
                    afterfix();
                }
                else{
                    if(currentToast != null)
                        currentToast.cancel();
                    Toast.makeText(Level2.this, "The website is still not fixed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public void afterfix(){
        TextView textView3 = findViewById(R.id.textView3);
        Button nextButton = findViewById(R.id.nextButton);
        ImageView imageView = findViewById(R.id.thumbsuplv2);
        imageView.setVisibility(View.VISIBLE);
        textView3.setVisibility(View.VISIBLE);
        nextButton.setVisibility(View.VISIBLE);
        WebView webView = findViewById(R.id.webpagelv2);
        webView.loadUrl("https://www.google.com");
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading (WebView view, String url){
                return false;
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Level2.this,Level3.class);
                String user = getIntent().getStringExtra("uname");
                intent.putExtra("uname",user);
                startActivity(intent);
            }
        });



    }
}