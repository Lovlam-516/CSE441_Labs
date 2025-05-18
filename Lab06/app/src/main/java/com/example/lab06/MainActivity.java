package com.example.lab06;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    EditText edtHoTen, edtCMND, edtThongTinBS;
    RadioButton rdoTrungCap, rdoCaoDang, rdoDaiHoc;
    CheckBox chkDocBao, chkDocSach, chkDocCode;
    Button btnGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khai báo các view
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtThongTinBS = findViewById(R.id.edtThongTinBS);
        rdoTrungCap = findViewById(R.id.rdoTrungCap);
        rdoCaoDang = findViewById(R.id.rdoCaoDang);
        rdoDaiHoc = findViewById(R.id.rdoDaiHoc);
        chkDocBao = findViewById(R.id.chkDocBao);
        chkDocSach = findViewById(R.id.chkDocSach);
        chkDocCode = findViewById(R.id.chkDocCode);
        btnGui = findViewById(R.id.btnGui);

        // Mặc định chọn Đại học
        rdoDaiHoc.setChecked(true);

        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString().trim();
                String cmnd = edtCMND.getText().toString().trim();
                String thongTinBS = edtThongTinBS.getText().toString().trim();

                // Kiểm tra Họ tên
                if (TextUtils.isEmpty(hoTen) || hoTen.length() < 3) {
                    edtHoTen.setError("Họ tên phải có ít nhất 3 ký tự");
                    edtHoTen.requestFocus();
                    return;
                }

                // Kiểm tra CMND
                if (!cmnd.matches("\\d{9}")) {
                    edtCMND.setError("CMND phải có đúng 9 chữ số");
                    edtCMND.requestFocus();
                    return;
                }

                // Kiểm tra sở thích
                if (!chkDocBao.isChecked() && !chkDocSach.isChecked() && !chkDocCode.isChecked()) {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn ít nhất một sở thích", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lấy bằng cấp
                String bangCap = "";
                if (rdoTrungCap.isChecked()) bangCap = "Trung cấp";
                else if (rdoCaoDang.isChecked()) bangCap = "Cao đẳng";
                else bangCap = "Đại học";

                // Lấy sở thích
                StringBuilder soThich = new StringBuilder();
                if (chkDocBao.isChecked()) soThich.append("Đọc báo, ");
                if (chkDocSach.isChecked()) soThich.append("Đọc sách, ");
                if (chkDocCode.isChecked()) soThich.append("Đọc coding, ");
                if (soThich.length() > 0)
                    soThich.setLength(soThich.length() - 2); // xóa dấu , cuối

                // Tổng hợp thông tin
                String thongTin = "Họ tên: " + hoTen + "\n"
                        + "CMND: " + cmnd + "\n"
                        + "Bằng cấp: " + bangCap + "\n"
                        + "Sở thích: " + soThich + "\n"
                        + "Thông tin bổ sung: "+"\n" + thongTinBS;

                // Hiển thị AlertDialog
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Thông tin cá nhân")
                        .setMessage(thongTin)
                        .setPositiveButton("Đóng", null)
                        .show();
            }
        });
    }
}
