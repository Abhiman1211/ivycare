package com.example.zsfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class doclogin extends AppCompatActivity {
    EditText aemail, pass;
    TextView reg;
    Button login;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doclogin);
        aemail = findViewById(R.id.editTextTextPersonName4);
        pass = findViewById(R.id.editTextTextPersonName5);
        reg = findViewById(R.id.editTextTextPersonName7);
        login = findViewById(R.id.button);
        mAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), docreg.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
//                Intent i = new Intent(getApplicationContext(), dashboard.class);
//                startActivity(i);
            }
        });
    }
    private void loginUser(){
        String email = aemail.getText().toString();
        String password = pass.getText().toString();

        if(TextUtils.isEmpty(email)){
            aemail.setError("Email cannot be empty.");
            aemail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            pass.setError("Password cannot be empty.");
            pass.requestFocus();
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "Logged in successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), schedule.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Login error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            });
        }
    }

}