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
    private void beber(int posicion_vaso, ImageButton vaso_elegido){
        vaso_elegido.setBackgroundResource((vaso_envenenado == posicion_vaso)
                ? R.drawable.veneno
                : R.drawable.vaso_vacio);
        if(vaso_envenenado == posicion_vaso){ game_over(); }
    }
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
    private void envenenar_al_azar(){
        vaso_envenenado = 10;
        while (vaso_envenenado>6) {
            vaso_envenenado = (int) (Math.random() * 10) + 1;
        }
        System.out.println(vaso_envenenado);
    }
}