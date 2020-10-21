package com.example.ultimateconnect4.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ultimateconnect4.Models.Utilizador;

public class UtilizadorController {
    Database database;

    public UtilizadorController(Database database) {
        this.database = database;
    }

    public void insertUtilizador(Utilizador utilizador){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(database.VITORIAS_FACIL_UTILIZADOR, utilizador.getM_vitorias_facil());
        values.put(database.VITORIAS_FACIL_COMPUTADOR, utilizador.getM_derrotas_facil());
        values.put(database.VITORIAS_MEDIA_UTILIZADOR, utilizador.getM_vitorias_media());
        values.put(database.VITORIAS_MEDIA_COMPUTADOR, utilizador.getM_derrotas_media());
        values.put(database.VITORIAS_DIFICIL_UTILIZADOR, utilizador.getM_vitorias_dificil());
        values.put(database.VITORIAS_DIFICIL_COMPUTADOR, utilizador.getM_derrotas_dificil());

        db.insert(database.TABELA_UTILIZADOR, null, values);
        db.close();
    }

    public int updateUtilizador(Utilizador utilizador ){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(database.VITORIAS_FACIL_UTILIZADOR, utilizador.getM_vitorias_facil());
        values.put(database.VITORIAS_FACIL_COMPUTADOR, utilizador.getM_derrotas_facil());
        values.put(database.VITORIAS_MEDIA_UTILIZADOR, utilizador.getM_vitorias_media());
        values.put(database.VITORIAS_MEDIA_COMPUTADOR, utilizador.getM_derrotas_media());
        values.put(database.VITORIAS_DIFICIL_UTILIZADOR, utilizador.getM_vitorias_dificil());
        values.put(database.VITORIAS_DIFICIL_COMPUTADOR, utilizador.getM_derrotas_dificil());

        return db.update(database.TABELA_UTILIZADOR, values, database.KEY_ID_UTILIZADOR + "=?", new String[]{String.valueOf(utilizador.getM_id())});
    }
    public void deleteUtilizador(Utilizador utilizador) {
        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(database.TABELA_UTILIZADOR,database.KEY_ID_UTILIZADOR + "=?", new String[]{String.valueOf(utilizador.getM_id())});

        db.close();
    }

    public Utilizador getUtilizador(){
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor cursor = db.query(database.TABELA_UTILIZADOR, null, null, null, null, null, null);

        if (cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
        }

        Utilizador utilizador=new Utilizador();
        utilizador.setM_id(cursor.getInt(0));
        utilizador.setM_vitorias_facil(cursor.getInt(1));
        utilizador.setM_derrotas_facil(cursor.getInt(2));
        utilizador.setM_vitorias_media(cursor.getInt(3));
        utilizador.setM_derrotas_media(cursor.getInt(4));
        utilizador.setM_vitorias_dificil(cursor.getInt(5));
        utilizador.setM_derrotas_dificil(cursor.getInt(6));
        db.close();
        cursor.close();
        return utilizador;
    }
}
