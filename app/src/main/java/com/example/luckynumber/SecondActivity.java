package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView welcomeTxt,luckyNumberTxt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeTxt = findViewById(R.id.textView2);
        luckyNumberTxt = findViewById(R.id.lucky_number_text);
        share_btn = findViewById(R.id.share_btn);
        //receiving the data from mainActivity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("name");
        //generating random numbers

        int random_num = generateRandomNumber();
        luckyNumberTxt.setText(""+random_num);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);
            }
        });

    }
    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
    public void shareData(String userName,int randomNum){
        //Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //extra Information
        i.putExtra(Intent.EXTRA_SUBJECT,userName+" got Lucky today ");
    i.putExtra(Intent.EXTRA_TEXT,"His Lucky Number is : "+randomNum+"\nAnd is very happy to inform that His App is working Awesome ");

    startActivity(Intent.createChooser(i,"Choose a Platform"));

    }
}