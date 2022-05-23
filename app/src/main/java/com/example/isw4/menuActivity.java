package com.example.isw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menuActivity extends AppCompatActivity {

    CardView equipo;
    CardView eventos;
    CardView notificaciones;
    CardView perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        conectar();

        equipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), equipoActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"iniciando vista de equipos", Toast.LENGTH_SHORT).show();
            }
        });

        eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(), eventosActivity.class);
                startActivity(i2);
                Toast.makeText(getApplicationContext(),"iniciando vista de eventos", Toast.LENGTH_SHORT).show();
            }
        });

        notificaciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(), notificacionesActivity.class);
                startActivity(i3);
                Toast.makeText(getApplicationContext(),"iniciando vista de notificaciones", Toast.LENGTH_SHORT).show();
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getApplicationContext(), perfilActivity2.class);
                startActivity(i4);
                Toast.makeText(getApplicationContext(),"iniciando vista de perfil", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void conectar(){
        equipo=findViewById(R.id.equipo);
        eventos=findViewById(R.id.eventos);
        notificaciones=findViewById(R.id.notificaciones);
        perfil=findViewById(R.id.perfil);
    }
}