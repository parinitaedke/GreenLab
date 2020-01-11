package com.example.green;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private Button registerButton;
    private FirebaseAuth mAuth;
    final EditText emailEditText = findViewById(R.id.username);
    final EditText passwordEditText = findViewById(R.id.password);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.this.register();
            }
        });
    }
    private void register(){
//        mAuth.signInWithEmailAndPassword(emailEditText.getText().toString(), passwordEditText.getText().toString())
//                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
//
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            startActivity(new Intent(Register.this, HomeActivity.class));
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Toast.makeText(Register.this, task.getException().getMessage(),
//                                    Toast.LENGTH_LONG).show();
//
//                        }
//                    }
//                });
    }
}
