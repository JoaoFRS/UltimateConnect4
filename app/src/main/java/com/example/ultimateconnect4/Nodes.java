package com.example.ultimateconnect4;

import java.util.LinkedList;
import java.util.List;

public class Nodes{
    int custo;
    double numerovitorias;
    double vezesvisitado;
    int profundidade;
    List<Nodes> filhos;
    Nodes pai;
    int[][] disposição;
    int turno;
    int coluna;


    public Nodes(int profundidade,int[][] disposição){
        this.profundidade=profundidade;
        this.disposição=disposição;
    }

    public Nodes(int profundidade,int[][] disposição,int turno){
        this.profundidade=profundidade;
        this.disposição=disposição;
        this.turno=turno;

    }


    public Nodes(int custo, int profundidade, int[][] disposição,int turno,int coluna ){
        this.custo=custo;
        this.profundidade=profundidade;;
        this.disposição=disposição;
        this.turno=turno;
        this.coluna=coluna;

    }

    public Nodes(int custo, int profundidade, LinkedList<Nodes> filhos, int[][] disposição, int turno ) {
        this.custo = custo;
        this.profundidade = profundidade;
        this.filhos = filhos;
        this.disposição = disposição;
        this.turno = turno;

    }

    public Nodes(double numerovitorias,double vezesvisitado,int profundidade, LinkedList<Nodes> filhos,Nodes pai, int[][] disposição,int turno){
        this.numerovitorias=numerovitorias;
        this.vezesvisitado=vezesvisitado;
        this.profundidade=profundidade;
        this.filhos=filhos;
        this.pai=pai;
        this.disposição=disposição;
        this.turno=turno;

    }
}
