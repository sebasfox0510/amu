package com.example.isw4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import com.example.isw4.Equiposlab;

import java.util.ArrayList;
import java.util.List;


public class eventosActivity extends AppCompatActivity {

    TextView tvEventos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        conectar();

        //Instancia a la base de datos
        FirebaseDatabase fdb = FirebaseDatabase.getInstance();
        //apuntamos al nodo que queremos leer
        DatabaseReference myRef = fdb.getReference("Equiposlab");

        //Agregamos un ValueEventListener para que los cambios que se hagan en la base de datos
        //se reflejen en la aplicacion
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //leeremos un objeto de tipo Estudiante
                GenericTypeIndicator<Equiposlab> t = new GenericTypeIndicator<Equiposlab>() {};
                Equiposlab equipolab= snapshot.getValue(t);

                //formamos el resultado en un string
                String resultado = "Como objeto java:\n\n";
                resultado += equipolab + "\n";
                resultado += "Propiedad Equipo:\nNombre completo: " +equipolab.getEquipo();

                //Tambien podemos leer los datos como un string
                resultado += "\n\n-----------------------------\n\n";
                resultado += "Eventos realizados:\n\n";
                resultado += snapshot.getValue().toString();




                //mostramos en el textview
                tvEventos.setText(resultado);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("ERROR FIREBASE",error.getMessage());
            }
        });


    }



    public void conectar(){

        tvEventos=findViewById(R.id.tvEventos);
    }
}