package com.example.birthdaycard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1= findViewById(R.id.img1);
    }

    public void nextImage(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}



