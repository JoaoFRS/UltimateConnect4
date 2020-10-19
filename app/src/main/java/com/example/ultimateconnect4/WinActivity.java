package com.example.ultimateconnect4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.LinkedList;

public class WinActivity extends AppCompatActivity {
    private Handler handler = new Handler();
    private Runnable runnable;
    private final int interval = 1000;
    Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        runnable = new Runnable(){
            public void run() {
                Intent start =new Intent(mContext,MainActivity.class);
                startActivity(start);
            }
        };
        handler.postDelayed(runnable, interval);
    }
}