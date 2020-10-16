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

    public Nodes(){

    }

    public Nodes(int profundidade,int[][] disposição){
        this.profundidade=profundidade;
        this.disposição=disposição;
    }

    public Nodes(int profundidade,int[][] disposição,int turno){
        //this.custo=custo;
        this.profundidade=profundidade;
        //this.filhos=filhos;
        //this.pai=pai;
        this.disposição=disposição;
        this.turno=turno;

    }


    public Nodes(int custo, int profundidade, int[][] disposição,int turno,int coluna ){
        this.custo=custo;
        this.profundidade=profundidade;
        //this.filhos=filhos;
        //this.pai=pai;
        this.disposição=disposição;
        this.turno=turno;
        this.coluna=coluna;

    }

    public Nodes(int custo, int profundidade, LinkedList<Nodes> filhos, int[][] disposição, int turno ) {
        this.custo = custo;
        this.profundidade = profundidade;
        this.filhos = filhos;
        //this.pai=pai;
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
    public static void updateStatus(int value,Nodes node){
        if (value==0){
            node.vezesvisitado++;
        }
        if(value==1){
            node.vezesvisitado++;
            node.numerovitorias++;
        }
    }
}
