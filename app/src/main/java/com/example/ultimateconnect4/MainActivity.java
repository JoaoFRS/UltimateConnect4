package com.example.ultimateconnect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Context mContex=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button easy=findViewById(R.id.main_easyButton);
        Button medium=findViewById(R.id.main_mediumButton);
        Button hard=findViewById(R.id.main_hardButton);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContex,GameActivity.class);
                i.putExtra("difficulty", "easy");
                startActivity(i);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContex,GameActivity.class);
                i.putExtra("difficulty", "medium");
                startActivity(i);
            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContex,GameActivity.class);
                i.putExtra("difficulty", "hard");
                startActivity(i);
            }
        });
    }
}