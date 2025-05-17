package com.example.lab04_2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab04_2.R;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnBMI;
    EditText editTen, editChieucao, editCannang, editBMI, editChandoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBMI = findViewById(R.id.btnBMI);
        editTen = findViewById(R.id.editTen);
        editChieucao = findViewById(R.id.editChieucao);
        editCannang = findViewById(R.id.editCannang);
        editBMI = findViewById(R.id.editBMI);
        editChandoan = findViewById(R.id.editChandoan);

        DecimalFormat dcf = new DecimalFormat("#.0");

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = editTen.getText().toString().trim();
                String chieuCaoStr = editChieucao.getText().toString();
                String canNangStr = editCannang.getText().toString();

                if (ten.isEmpty()) {
                    editTen.setError("Tên không được để trống");
                    editTen.requestFocus();
                    editBMI.setText("");
                    editChandoan.setText("");
                    return;
                } else if (ten.length() < 3) {
                    editTen.setError("Tên phải có ít nhất 3 ký tự");
                    editTen.requestFocus();
                    editTen.selectAll();
                    editBMI.setText("");
                    editChandoan.setText("");
                    return;
                } else {
                    editTen.setError(null);
                }

                if (chieuCaoStr.isEmpty()) {
                    editChieucao.setError("Chiều cao không được để trống");
                    editChieucao.requestFocus();
                    editBMI.setText("");
                    editChandoan.setText("");
                    return;
                } else {
                    editChieucao.setError(null);
                }

                if (canNangStr.isEmpty()) {
                    editCannang.setError("Cân nặng không được để trống");
                    editCannang.requestFocus();
                    editBMI.setText("");
                    editChandoan.setText("");
                    return;
                } else {
                    editCannang.setError(null);
                }

                try {
                    double H = Double.parseDouble(chieuCaoStr);
                    double W = Double.parseDouble(canNangStr);

                    if (H <= 0 || W <= 0) {
                        Toast.makeText(MainActivity.this, "Chiều cao và cân nặng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                        editBMI.setText("");
                        editChandoan.setText("");
                        return;
                    }

                    double BMI = W / Math.pow(H, 2);

                    String chandoan = "";
                    if (BMI < 18) {
                        chandoan = "Bạn gầy";
                    } else if (BMI <= 24.9) {
                        chandoan = "Bạn bình thường";
                    } else if (BMI <= 29.9) {
                        chandoan = "Bạn béo phì độ 1";
                    } else if (BMI <= 34.9) {
                        chandoan = "Bạn béo phì độ 2";
                    } else {
                        chandoan = "Bạn béo phì độ 3";
                    }

                    editBMI.setText(dcf.format(BMI));
                    editChandoan.setText(chandoan);

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập số hợp lệ cho chiều cao và cân nặng", Toast.LENGTH_SHORT).show();
                    editBMI.setText("");
                    editChandoan.setText("");
                }
            }
        });
    }
}