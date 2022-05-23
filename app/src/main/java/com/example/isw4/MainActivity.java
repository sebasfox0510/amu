package com.example.isw4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView tvSincuenta;
    EditText txtEmailLogin;
    EditText txtContraseñaLogin;
    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loguearUsuario();
            }
        });

        tvSincuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(), registroActivity.class);
                startActivity(i2);
            }
        });

    }

    private void loguearUsuario(){
        String email = txtEmailLogin.getText().toString().trim();
        String contraseña = txtContraseñaLogin.getText().toString().trim();


        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se debe ingresar un email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(contraseña)){
            Toast.makeText(this, "Se debe ingresar la contraseña",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando consulta en linea...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,contraseña)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Bienvenido: "+ txtEmailLogin.getText(), Toast.LENGTH_LONG).show();
                            Intent i1=new Intent(getApplicationContext(), menuActivity.class);
                            startActivity(i1);
                        }else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(MainActivity.this, "Ese usuario ya existe", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "Este usuario no existe, intente registrarse", Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private void conectar(){
        btnLogin=findViewById(R.id.btnLogin);
        tvSincuenta=findViewById(R.id.tvSincuenta);
        txtEmailLogin=findViewById(R.id.txtEmailLogin);
        txtContraseñaLogin=findViewById(R.id.txtContraseñaLogin);
    }
}