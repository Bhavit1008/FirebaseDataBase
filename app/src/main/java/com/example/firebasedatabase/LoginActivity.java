package com.example.firebasedatabase;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText emailLogin,passwordLogin;
    Button login_btn;
    FirebaseAuth auth;
    TextView contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = (EditText)findViewById(R.id.emailLogin);
        passwordLogin = (EditText)findViewById(R.id.passwordLogin);
        login_btn = (Button)findViewById(R.id.login_btn);
        contact = findViewById(R.id.contact);

        passwordLogin.setError("required");

        auth = FirebaseAuth.getInstance();

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7597917007"));
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailLogin.getText().toString().equals("")&&passwordLogin.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Blanks are not allowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    auth.signInWithEmailAndPassword(emailLogin.getText().toString(),passwordLogin.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                        Intent i  =new Intent(LoginActivity.this,Details.class);
                                        startActivity(i);
                                    }
                                    else{
                                        Toast.makeText(LoginActivity.this, "Login unsuccessful ! please try again", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(LoginActivity.this,MainActivity.class);
                                        startActivity(i);
                                    }

                                }
                            });
                }
            }
        });
    }
}
