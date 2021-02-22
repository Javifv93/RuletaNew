package com.example.ruleta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;

public class Ruleta extends AppCompatActivity {
    private ImageButton imgbutt_12;
    private ImageButton imgbutt_2;
    private ImageButton imgbutt_4;
    private ImageButton imgbutt_6;
    private ImageButton imgbutt_8;
    private ImageButton imgbutt_10;
    private View fondo_game_over;
    private int vaso_envenenado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruleta);

        getSupportActionBar().hide();
        fondo_game_over = (View) findViewById(R.id.game_over);
        fondo_game_over.setVisibility(View.GONE);

        envenenar_al_azar();

        imgbutt_2 = (ImageButton) findViewById(R.id.imgbutt_2);
        imgbutt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beber(1, imgbutt_2);
            }
        });
        imgbutt_4 = (ImageButton) findViewById(R.id.imgbutt_4);
        imgbutt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beber(2, imgbutt_4);
            }
        });
        imgbutt_6 = (ImageButton) findViewById(R.id.imgbutt_6);
        imgbutt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beber(3, imgbutt_6);
            }
        });
        imgbutt_8 = (ImageButton) findViewById(R.id.imgbutt_8);
        imgbutt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beber(4, imgbutt_8);
            }
        });
        imgbutt_10 = (ImageButton) findViewById(R.id.imgbutt_10);
        imgbutt_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beber(5, imgbutt_10);
            }
        });
        imgbutt_12 = (ImageButton) findViewById(R.id.imgbutt_12);
        imgbutt_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beber(6, imgbutt_12);
            }
        });
    }
    /**Metodo al que se llama cada vez que se clicka un vaso. Se le pasa por parametro la posicion del vaso y el ImageButton de ese vaso.
     * Si la posicion del vaso es igual que la del vaso envenenada, settea el fondo al de veneno, y si no, settea el fondo del vaso vacio.
     * Además, si es el vaso envenenado hace una llamada al metodo game_over*/
    private void beber(int posicion_vaso, ImageButton vaso_elegido){
        vaso_elegido.setBackgroundResource((vaso_envenenado == posicion_vaso)
                ? R.drawable.veneno
                : R.drawable.vaso_vacio);
        if(vaso_envenenado == posicion_vaso){ game_over(); }
    }
    /**Metodo que se ejecuta cuando se pulsa en el vaso envenenado. Hace visible el View fondo_game_over y le settea el fondo game_over_2.
     * Genera una animacion de fading y le settea a la View un onClick que nos llevará a la activity principal*/
    private void game_over(){
        fondo_game_over.setVisibility(View.VISIBLE);
        fondo_game_over.setBackgroundResource(R.drawable.game_over_2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        fondo_game_over.startAnimation(alphaAnimation);
        fondo_game_over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(Ruleta.this, MainActivity.class);
                startActivity(intnt);
                finish();
            }
        });
    }
    /**Metodo que le settea a la variable vaso_envenenado un valor entero aleatorio entre el 1 y el 6*/
    private void envenenar_al_azar(){
        vaso_envenenado = 10;
        while (vaso_envenenado>6) {
            vaso_envenenado = (int) (Math.random() * 10) + 1;
        }
    }
}