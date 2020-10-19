package com.example.ultimateconnect4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Timer;

public class GameActivity extends AppCompatActivity {
    Context mContext=this;
    int move=0;
    String difficulty;
    int[][] board=new int[6][7];
    private final int interval = 1;
    private final int longinterval = 500;
    private Handler handler = new Handler();
    private Runnable runnable;
    ImageView myTurn, cpTurn;
    int look_ahead;
    private Timer t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        difficulty= intent.getStringExtra("difficulty");
        ConstraintLayout change_color=findViewById(R.id.paint_diff);
        myTurn=findViewById(R.id.you_turn);
        myTurn.setVisibility(View.VISIBLE);
        cpTurn=findViewById(R.id.computer_turn);
        TextView num_vit_me=findViewById(R.id.num_vitorias_jogador);
        TextView num_vit_computer=findViewById(R.id.num_vitorias_computador);
        if(difficulty.equals("easy")){
            change_color.setBackgroundColor(Color.parseColor("#47a64a"));
            look_ahead=1;
        }
        if(difficulty.equals("medium")){
            change_color.setBackgroundColor(Color.parseColor("#bbbf47"));
            look_ahead=3;
        }
        if(difficulty.equals("hard")){
            change_color.setBackgroundColor(Color.parseColor("#CD3B3B"));
            look_ahead=5;
        }
        LinearLayout l0=findViewById(R.id.l0); //j=0
        LinearLayout l1=findViewById(R.id.l1); //j=1
        LinearLayout l2=findViewById(R.id.l2); //j=2
        LinearLayout l3=findViewById(R.id.l3); //j=3
        LinearLayout l4=findViewById(R.id.l4); //j=4
        LinearLayout l5=findViewById(R.id.l5); //j=5
         for(int i=0; i<7;i++){
             final int aux=i;
             ImageButton aux0=new ImageButton(mContext);
             ImageButton aux1=new ImageButton(mContext);
             ImageButton aux2=new ImageButton(mContext);
             ImageButton aux3=new ImageButton(mContext);
             ImageButton aux4=new ImageButton(mContext);
             ImageButton aux5=new ImageButton(mContext);
             ImageButton aux6=new ImageButton(mContext);
             aux0.setImageResource(R.drawable.elipse_1);
             aux1.setImageResource(R.drawable.elipse_1);
             aux2.setImageResource(R.drawable.elipse_1);
             aux3.setImageResource(R.drawable.elipse_1);
             aux4.setImageResource(R.drawable.elipse_1);
             aux5.setImageResource(R.drawable.elipse_1);
             aux6.setImageResource(R.drawable.elipse_1);
             aux0.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux1.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux2.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux3.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux4.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux5.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux6.setBackgroundColor(Color.parseColor("#1B8BBF"));
             aux0.setPadding(20,0,20,0);
             aux1.setPadding(20,0,20,0);
             aux2.setPadding(20,0,20,0);
             aux3.setPadding(20,0,20,0);
             aux4.setPadding(20,0,20,0);
             aux5.setPadding(20,0,20,0);
             aux6.setPadding(20,0,20,0);
             LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                     LinearLayout.LayoutParams.WRAP_CONTENT,
                     LinearLayout.LayoutParams.WRAP_CONTENT,1f);
             params.setMargins(10,0,10,0);
             aux0.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     coloca_peca(aux);
                 }
             });
             aux0.setId(i);
             l0.addView(aux0,params);
             aux1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     coloca_peca(aux);
                 }
             });
             aux1.setId(1*10+i);
             l1.addView(aux1,params);
             aux2.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     coloca_peca(aux);
                 }
             });
             aux2.setId(2*10+i);
             l2.addView(aux2,params);
             aux3.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     coloca_peca(aux);
                 }
             });
             aux3.setId(3*10+i);
             l3.addView(aux3,params);
             aux4.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     coloca_peca(aux);
                 }
             });
             aux4.setId(4*10+i);
             l4.addView(aux4,params);
             aux5.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     coloca_peca(aux);
                 }
             });
             aux5.setId(5*10+i);
             l5.addView(aux5,params);
         }
    }

    public void coloca_peca(int col){
        if(move==1) {
            Toast.makeText(mContext, "Computer turn", Toast.LENGTH_SHORT).show();
            return;
        }
        for(int i=0;i<6;i++){
            if(board[i][col]==0) {
                final ImageButton imButton = findViewById(i * 10 + col);
                board[i][col] = 1;
                final int final_i=i;
                final int final_coluna=col;
                t=new java.util.Timer();
                t.schedule(new java.util.TimerTask() {
                    int j=5;
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                run_handler(j,final_coluna,final_i);
                                j=j-1;
                            }
                        });
                    }
                },50,50);
                return;
            }
        }
    }
    public void run_handler_opp(int j,int col,int i){
        final ImageButton but =  findViewById(j*10+col);
        if(j==5) {
            but.setImageResource(R.drawable.yellow);
        }
        else{
            final ImageButton but2 =  findViewById((j+1)*10+col);
            but2.setImageResource(R.drawable.elipse_1);
            but.setImageResource(R.drawable.yellow);
        }
        if(j==i) {
            t.cancel();
            int check=avaliador(board);
            if(check==512){
                runnable = new Runnable(){
                    public void run() {
                        Intent lost =new Intent(mContext,LoseActivity.class);
                        startActivity(lost);
                    }
                };
                handler.postDelayed(runnable, interval);
            }
            else if(!moveleft(board)){
                runnable = new Runnable(){
                    public void run() {
                        Intent tie =new Intent(mContext,TieActivity.class);
                        startActivity(tie);
                    }
                };
                handler.postDelayed(runnable, interval);
            }
            move=0;
            myTurn.setVisibility(View.VISIBLE);
            cpTurn.setVisibility(View.INVISIBLE);
        }
    }

    public void run_handler(int j, int col,int i){
        Log.d("j",String.valueOf(j));
        Log.d("i",String.valueOf(i));
        final ImageButton but =  findViewById(j*10+col);
        if(j==5) {
            but.setImageResource(R.drawable.red);
        }
        else{
            final ImageButton but2 =  findViewById((j+1)*10+col);
            but2.setImageResource(R.drawable.elipse_1);
            but.setImageResource(R.drawable.red);
        }
        if(j==i){
            t.cancel();
            move = 1;
            cpTurn.setVisibility(View.VISIBLE);
            myTurn.setVisibility(View.INVISIBLE);
            int check = avaliador(board);
            if (check == -512) {
                //U WON
                runnable = new Runnable(){
                    public void run() {
                        Intent won =new Intent(mContext,WinActivity.class);
                        startActivity(won);
                    }
                };
                handler.postDelayed(runnable, longinterval);
            }
            else if(!moveleft(board)){
                runnable = new Runnable(){
                    public void run() {
                        Intent tie =new Intent(mContext,TieActivity.class);
                        startActivity(tie);
                    }
                };
                handler.postDelayed(runnable, longinterval);
            }
            else{
                runnable = new Runnable(){
                    public void run() {
                        LinkedList<Nodes> filhos = new LinkedList<>();
                        Nodes pai = new Nodes(0, 0, filhos, board, 1);
                        alphabeta(pai);
                    }
                };
                handler.postDelayed(runnable, interval);
            }
        }
    }

    public int avaliador(int[][] aaa){
        int conta=0;
        int aux;
        int[] help =new int[4];
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                if(j<=3){
                    help[0]=aaa[i][j];
                    help[1]=aaa[i][j+1];
                    help[2]=aaa[i][j+2];
                    help[3]=aaa[i][j+3];
                    aux=valor(help);
                    if(aux==512|| aux==-512)
                        return aux;
                    conta+=aux;
                }
                if(i>=3){
                    help[0]=aaa[i][j];
                    help[1]=aaa[i-1][j];
                    help[2]=aaa[i-2][j];
                    help[3]=aaa[i-3][j];
                    aux=valor(help);
                    if(aux==512|| aux==-512)
                        return aux;
                    conta+=aux;
                }
                if(j<=3 && i>=3){
                    help[0]=aaa[i][j];
                    help[1]=aaa[i-1][j+1];
                    help[2]=aaa[i-2][j+2];
                    help[3]=aaa[i-3][j+3];
                    aux=valor(help);
                    if(aux==512|| aux==-512)
                        return aux;
                    conta+=aux;
                }
                if(j>=3 && i>=3){
                    help[0]=aaa[i][j];
                    help[1]=aaa[i-1][j-1];
                    help[2]=aaa[i-2][j-2];
                    help[3]=aaa[i-3][j-3];
                    aux=valor(help);
                    if(aux==512|| aux==-512)
                        return aux;
                    conta+=aux;
                }
            }
        }
        if (move==0)
            conta-=16;
        else if (move==1)
            conta+=16;
        return conta;
    }

    public int valor(int[] help){
        int conta_computador=0;
        int conta_outro=0;
        int aux=0;
        for(int i=0;i<4;i++){
            if(help[i]==0) continue;
            else if(help[i]==2) conta_computador++;
            else  conta_outro++;
        }
        if((conta_outro>0 && conta_computador>0) || (conta_computador==0 && conta_outro==0)) {
            aux=0;
            return aux;
        }
        else if(conta_computador==1){
            aux=1;
            return aux;
        }
        else if (conta_computador==2){
            aux=10;
            return aux;
        }
        else if (conta_computador==3){
            aux=look_ahead*10;
            return aux;
        }
        else if (conta_computador==4){
            aux=512;
            return aux;
        }
        else if(conta_outro==1){
            aux=-1;
            return aux;
        }
        else if (conta_outro==2){
            aux=-10;
            return aux;
        }
        else if (conta_outro==3){
            aux=-look_ahead*10;
            return aux;
        }
        else if (conta_outro==4){
            aux=-512;
            return aux;
        }
        return 10000000;
    }
    public boolean moveleft(int[][] aa) {
        for (int j = 0; j < 7; j++) {
            if (aa[5][j] == 0) return true;
        }
        return false;
    }

    public boolean testa_coluna(int[][] aa,int col){
        if(aa[5][col]==0) return true;
        else return false;

    }

    public int[][] insert_peca(int[][] mat_aux, int coluna, int simbolo){
        for(int i=0;i<6;i++){
            if(mat_aux[i][coluna]==0) {
                mat_aux[i][coluna]=simbolo;
                break;
            }
        }
        return mat_aux;
    }

    public int[][] duplica(int[][] aa){
        int[][] b=new int[6][7];
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                b[i][j]=aa[i][j];

            }
        }
        return b;
    }

    //Dificil
    public void alphabeta(Nodes atual) {
        Nodes retorno;
        int maximizar_retorno;
        //cria_successores(atual);
        for(int i=0;i<7;i++){
            if(testa_coluna(atual.disposição,i)){
                int[][] aux=duplica(atual.disposição);
                aux=insert_peca(aux,i,2);
                Nodes filho= new Nodes(0,atual.profundidade+1,aux,0,i);
                atual.filhos.add(filho);
                filho.custo=min_value(filho,Integer.MIN_VALUE,Integer.MAX_VALUE);
            }
        }
        atual.custo =max_value(atual,Integer.MIN_VALUE,Integer.MAX_VALUE);
        maximizar_retorno=atual.filhos.get(0).custo;
        retorno=atual.filhos.get(0);
        for(int i=1;i<atual.filhos.size();i++) {
            if (atual.filhos.get(i).custo > maximizar_retorno) {
                retorno = atual.filhos.get(i);
                maximizar_retorno = atual.filhos.get(i).custo;
            }
        }
        for(int i=0;i<6;i++){
            if(board[i][retorno.coluna]==0){
                ImageButton ib = findViewById(i * 10 + retorno.coluna);
                board[i][retorno.coluna]=2;
                final int final_i=i;
                final int final_coluna=retorno.coluna;
                t=new java.util.Timer();
                t.schedule(new java.util.TimerTask() {
                    int j=5;
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                run_handler_opp(j,final_coluna,final_i);
                                j=j-1;
                            }
                        });
                    }
                },50,50);
                return;
            }
        }
    }

    public int max_value(Nodes atual, int alpha, int beta){
        int v;
        int avaliador_value=avaliador(atual.disposição);
        if(atual.profundidade==(look_ahead+2) || avaliador_value==512 || avaliador_value==-512 || !moveleft(atual.disposição))
            return avaliador_value;
        v=Integer.MIN_VALUE;
        for(int j=0;j<=6;j++){
            if(testa_coluna(atual.disposição,j)){
                int[][] aux=duplica(atual.disposição);
                aux=insert_peca(aux,j,2);
                Nodes filho= new Nodes(atual.profundidade+1,aux,0);
                v=Math.max(v, min_value(filho,alpha,beta));
                if(v>=beta)
                    return v;

            }
            alpha=Math.max(alpha,v);
        }
        return v;
    }

    public int min_value(Nodes atual,int alpha,int beta){
        int v;
        int avaliador_value=avaliador(atual.disposição);
        if(atual.profundidade==(look_ahead+2) || avaliador_value==512 || avaliador_value==-512 || !moveleft(atual.disposição))
            return avaliador_value;
        v=Integer.MAX_VALUE;
        for(int j=0;j<=6;j++){
            if(testa_coluna(atual.disposição,j)){
                int[][] aux=duplica(atual.disposição);
                aux=insert_peca(aux,j,1);
                Nodes filho= new Nodes(atual.profundidade+1,aux,1);
                v=Math.min(v, max_value(filho,alpha,beta));
                if(v<=alpha)
                    return v;
            }
            beta=Math.min(beta,v);
        }
        return v;
    }

    //fim dificil
}