package com.example.firebasedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontActivity extends AppCompatActivity {
    Button student_section,admin_section;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_main);

        student_section = findViewById(R.id.student_section);
        admin_section = findViewById(R.id.admin_section);

        student_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

        admin_section.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FrontActivity.this,AdminLogin.class);
                startActivity(i);
            }
        });
    }
}
