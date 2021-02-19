package com.example.ruleta;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
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

        fondo = (View) findViewById(R.id.fondo);

        fondo.setBackgroundColor(R.color.purple_200);
        SystemClock.sleep(2000);
        fondo.setBackgroundColor(R.color.purple_500);
        SystemClock.sleep(2000);
        fondo.setBackgroundColor(R.color.purple_700);
        SystemClock.sleep(2000);

        boton.setVisibility(View.VISIBLE);

    }
}