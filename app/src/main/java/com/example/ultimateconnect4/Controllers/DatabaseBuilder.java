package com.example.ultimateconnect4.Controllers;

import com.example.ultimateconnect4.Models.Utilizador;

public class DatabaseBuilder {

    Database db;

    public DatabaseBuilder(Database database) {
        this.db = database;
    }
    public void builduser(){
        UtilizadorController utilizadorController=new UtilizadorController(db);
        Utilizador user=new Utilizador(1);
        utilizadorController.insertUtilizador(user);
    }
}
