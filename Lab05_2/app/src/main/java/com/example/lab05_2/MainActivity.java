package com.example.lab05_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText edta, edtb, edtc;
    Button btnGiai, btnTiepTuc, btnThoat;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtc = findViewById(R.id.edtc);
        btnGiai = findViewById(R.id.btnGiai);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnThoat = findViewById(R.id.btnThoat);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());
                double c = Double.parseDouble(edtc.getText().toString());

                if (a == 0) {
                    if (b == 0) {
                        txtKetQua.setText(c == 0 ? "Phương trình vô số nghiệm" : "Phương trình vô nghiệm");
                    } else {
                        txtKetQua.setText("Phương trình có 1 nghiệm: x = " + (-c / b));
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        txtKetQua.setText("Phương trình vô nghiệm");
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        txtKetQua.setText("Phương trình có nghiệm kép: x = " + x);
                    } else {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        txtKetQua.setText("Phương trình có 2 nghiệm: x1 = " + x1 + ", x2 = " + x2);
                    }
                }
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edta.setText("");
                edtb.setText("");
                edtc.setText("");
                txtKetQua.setText("");
                edta.requestFocus();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // thoát app
            }
        });
    }
}
