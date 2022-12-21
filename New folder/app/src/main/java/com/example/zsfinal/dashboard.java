package com.example.zsfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {
    Button medcam, appt, docreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        medcam = findViewById(R.id.medcam);
        appt = findViewById(R.id.appointment);
        docreview = findViewById(R.id.docreview);
        medcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), predictmed.class);
                startActivity(i);
            }
        });
        appt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), appointment.class);
                startActivity(i);
            }
        });
        docreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), predictdisease.class);
                startActivity(i);
            }
        });
    }
}