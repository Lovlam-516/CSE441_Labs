package com.example.lab04_1;
import java.text.DecimalFormat;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends Activity {
    EditText edtdoC,edtdoF;
    Button btncf,btnfc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtdoC = findViewById(R.id.edtdoC);
        edtdoF = findViewById(R.id.edtdoF);
        btncf = findViewById(R.id.btncf);
        btnfc = findViewById(R.id.btnfc);
        btnfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doF = edtdoF.getText().toString();
                if (!doF.isEmpty()) {
                    int F = Integer.parseInt(doF);
                    double C = (F - 32) / 1.8;
                    edtdoC.setText(dcf.format(C));
                }
            }
        });

        btncf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = edtdoC.getText().toString();
                if (!doC.isEmpty()) {
                    int C = Integer.parseInt(doC);
                    double F = C * 1.8 + 32;
                    edtdoF.setText(dcf.format(F));
                }
            }
        });
    }
}