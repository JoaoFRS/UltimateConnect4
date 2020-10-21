package com.example.ultimateconnect4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.ultimateconnect4.Controllers.Database;
import com.example.ultimateconnect4.Controllers.DatabaseBuilder;
import com.example.ultimateconnect4.Controllers.UtilizadorController;
import com.example.ultimateconnect4.Models.Utilizador;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Context mContex=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean doesDatabaseExist = DatabaseExist(this, "Database");
        if(!doesDatabaseExist) {
            Database db = new Database(mContex);
            DatabaseBuilder databaseBuilder=new DatabaseBuilder(db);
            databaseBuilder.builduser();
        }
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
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
    private static boolean DatabaseExist(Context context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}