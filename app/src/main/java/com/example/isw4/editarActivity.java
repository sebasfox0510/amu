package com.example.isw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class editarActivity extends AppCompatActivity {

    Button btnEditar;
    EditText txtEquipos,txtPeso,txtMasa,txtDensidad;

    private DatabaseReference Equiposlab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        conectar();
        Equiposlab=FirebaseDatabase.getInstance().getReference("Equiposlab");

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarEquipos();
            }
        });

    }

    public void editarEquipos(){
        String equipo=txtEquipos.getText().toString();
        String peso=txtPeso.getText().toString();
        String masa=txtMasa.getText().toString();
        String densidad=txtDensidad.getText().toString();

        if (!TextUtils.isEmpty(equipo)){
            String id=Equiposlab.push().getKey();
            com.example.isw4.Equiposlab datosEquipo=new Equiposlab(id,equipo,peso,masa,densidad);
            Equiposlab.child(id).setValue(datosEquipo);

            Toast.makeText(this,"Edicion registrada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe introducir un equipo", Toast.LENGTH_LONG).show();
        }
    }

    public void conectar(){
        btnEditar=findViewById(R.id.btnEditar);

        txtEquipos=findViewById(R.id.txtEquipos);
        txtPeso=findViewById(R.id.txtPeso);
        txtMasa=findViewById(R.id.txtMasa);
        txtDensidad=findViewById(R.id.txtDensidad);
    }
}