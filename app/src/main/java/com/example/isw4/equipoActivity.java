package com.example.isw4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class equipoActivity extends AppCompatActivity {

    Button btnEditar1,btnEditar2,btnEditar3,btnEditar4,btnEditar5,btnEditar6,
            btnInfo1,btnInfo2,btnInfo3,btnInfo4,btnInfo5,btnInfo6;

    TextView tvBalanza;

    private DatabaseReference Descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipo);
        conectar();

        btnEditar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), editarActivity.class);
                startActivity(i);
            }
        });

        btnEditar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(), editarActivity.class);
                startActivity(i2);
            }
        });

        btnEditar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(getApplicationContext(), editarActivity.class);
                startActivity(i3);
            }
        });

        btnEditar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(getApplicationContext(), editarActivity.class);
                startActivity(i4);
            }
        });

        btnEditar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(getApplicationContext(), editarActivity.class);
                startActivity(i5);
            }
        });

        btnEditar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(getApplicationContext(), editarActivity.class);
                startActivity(i6);
            }
        });

    }

    private void conectar(){
        btnEditar1=findViewById(R.id.btnEditar1);
        btnEditar2=findViewById(R.id.btnEditar2);
        btnEditar3=findViewById(R.id.btnEditar3);
        btnEditar4=findViewById(R.id.btnEditar4);
        btnEditar5=findViewById(R.id.btnEditar5);
        btnEditar6=findViewById(R.id.btnEditar6);

        btnInfo1=findViewById(R.id.btnInfo1);
        btnInfo2=findViewById(R.id.btnInfo2);
        btnInfo3=findViewById(R.id.btnInfo3);
        btnInfo4=findViewById(R.id.btnInfo4);
        btnInfo5=findViewById(R.id.btnInfo5);
        btnInfo6=findViewById(R.id.btnInfo6);

        tvBalanza=findViewById(R.id.tvBalanza);
    }
}