package com.example.ruleta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private View activity;
    private int contador;
    private View fondo;
    private Button boton;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        boton = (Button) findViewById(R.id.boton);
        boton.setVisibility(View.INVISIBLE);

        activity = (View) findViewById(R.id.activity);
        fondo = (View) findViewById(R.id.fondo);
        contador = 0;
        fondo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (contador){
                    case 0:
                        splash(R.drawable.fondo_uno);
                        contador++;
                        break;
                    case 1:
                        activity.setBackgroundResource(R.drawable.fondo_uno);
                        splash(R.drawable.fondo_dos);
                        contador++;
                        break;
                    case 2:
                        activity.setBackgroundResource(R.drawable.fondo_dos);
                        splash(R.drawable.fondo_tres);
                        contador++;
                        break;
                    case 3:
                        activity.setBackgroundResource(R.drawable.fondo_tres);
                        splash(R.drawable.fondo_cuatro);
                        contador++;
                        break;
                    case 4:
                        cargarMenuPrincipal();
                        break;
                }
            }
        });
    }
    public void splash(int value){
        fondo.setBackgroundResource(value);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        fondo.startAnimation(alphaAnimation);
    }
    private void cargarMenuPrincipal(){
        boton.setVisibility(View.VISIBLE);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnt = new Intent(MainActivity.this, Ruleta.class);
                startActivity(intnt);
            }
        });
    }
}