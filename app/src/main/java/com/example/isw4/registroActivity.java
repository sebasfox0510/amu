package com.example.isw4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.ArrayList;

public class registroActivity extends AppCompatActivity {

    Button btnRegistro;
    EditText txtNombre;
    EditText txtApellido;
    EditText txtEmail;
    EditText txtContraseña;
    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        conectar();

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

    }

    private void registrarUsuario(){
        String nombre = txtNombre.getText().toString().trim();
        String apellido = txtApellido.getText().toString().trim();
        String email = txtEmail.getText().toString().trim();
        String contraseña = txtContraseña.getText().toString().trim();

        if(TextUtils.isEmpty(nombre)){
            Toast.makeText(this, "Se debe ingresar un nombre",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(apellido)){
            Toast.makeText(this, "Se debe ingresar un apellido",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this, "Se debe ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(registroActivity.this, "Se ha registrado el usuario con el email: "+ txtEmail.getText(), Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(registroActivity.this, "Ese usuario ya existe", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(registroActivity.this, "No se pudo registrar el usuario", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void conectar(){
        btnRegistro=findViewById(R.id.btnRegistro);
        txtNombre=findViewById(R.id.txtNombre);
        txtApellido=findViewById(R.id.txtApellido);
        txtEmail=findViewById(R.id.txtEmail);
        txtContraseña=findViewById(R.id.txtContraseña);
    }
}