package com.example.lab05_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText editDuongLich;
    Button btnChuyenDoi;
    TextView txtAmLich;

    String[] CAN = {"Giáp", "Ất", "Bính", "Đinh", "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Quý"};
    String[] CHI = {"Tý", "Sửu", "Dần", "Mão", "Thìn", "Tỵ", "Ngọ", "Mùi", "Thân", "Dậu", "Tuất", "Hợi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDuongLich = findViewById(R.id.editDuongLich);
        btnChuyenDoi = findViewById(R.id.btnChuyenDoi);
        txtAmLich = findViewById(R.id.txtAmLich);

        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = editDuongLich.getText().toString().trim();
                if (!input.isEmpty()) {
                    int year = Integer.parseInt(input);
                    int baseYear = 1984; // Giáp Tý

                    int canIndex = (year - baseYear) % 10;
                    int chiIndex = (year - baseYear) % 12;

                    if (canIndex < 0) canIndex += 10;
                    if (chiIndex < 0) chiIndex += 12;

                    String namAm = CAN[canIndex] + " " + CHI[chiIndex];
                    txtAmLich.setText(namAm);
                } else {
                    txtAmLich.setText("Vui lòng nhập năm dương lịch.");
                }
            }
        });
    }
}
