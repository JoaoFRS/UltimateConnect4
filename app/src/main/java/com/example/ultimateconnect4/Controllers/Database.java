package com.example.ultimateconnect4.Controllers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Database";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static final String TABELA_UTILIZADOR = "Utilizador";
    public static final String KEY_ID_UTILIZADOR= "Id_utilizador";
    public static final String VITORIAS_FACIL_UTILIZADOR = "Vitorias_facil_utilizador";
    public static final String VITORIAS_FACIL_COMPUTADOR= "Vitorias_facil_computador";
    public static final String VITORIAS_MEDIA_UTILIZADOR = "Vitorias_media_utilizador";
    public static final String VITORIAS_MEDIA_COMPUTADOR= "Vitorias_media_computador";
    public static final String VITORIAS_DIFICIL_UTILIZADOR = "Vitorias_dificil_utilizador";
    public static final String VITORIAS_DIFICIL_COMPUTADOR= "Vitorias_dificil_computador";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABELA_UTILIZADOR= "Create Table " + TABELA_UTILIZADOR + "(" +
                KEY_ID_UTILIZADOR  + " INTEGER PRIMARY KEY AUTOINCREMENT," + VITORIAS_FACIL_UTILIZADOR + " INTEGER,"+
                VITORIAS_FACIL_COMPUTADOR + " INTEGER," + VITORIAS_MEDIA_UTILIZADOR + " INTEGER," + VITORIAS_MEDIA_COMPUTADOR
                +" INTEGER," + VITORIAS_DIFICIL_UTILIZADOR +  " INTEGER," + VITORIAS_DIFICIL_COMPUTADOR+ " INTEGER" + ")";

        db.execSQL(CREATE_TABELA_UTILIZADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_UTILIZADOR);
        onCreate(db);

    }
}
