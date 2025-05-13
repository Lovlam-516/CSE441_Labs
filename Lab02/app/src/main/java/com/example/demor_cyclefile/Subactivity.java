package com.example.demor_cyclefile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Subactivity extends AppCompatActivity {
    Button btnok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);
        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                finish();
            }
        });
    }
}
