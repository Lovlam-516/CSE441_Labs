package com.example.demo_constrain;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtRS;
    Button btnT;
    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtRS = findViewById(R.id.edtRS);
        btnT = findViewById(R.id.btnT);

        btnT.setOnClickListener(v -> {
            int a = Integer.parseInt(edtA.getText().toString());
            int b = Integer.parseInt(edtB.getText().toString());
            int c = a + b;
            edtRS.setText(c+"");
        });
    }
}