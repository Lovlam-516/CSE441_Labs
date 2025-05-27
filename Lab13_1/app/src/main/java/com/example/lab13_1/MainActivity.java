package com.example.lab13_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView selection;
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;

    // Dữ liệu gợi ý
    String arr[] = {"Hà Nội", "Huế", "Sài Gòn", "Hà Giang", "Hội An", "Kiên Giang", "Lâm Đồng", "Long Khánh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gán các thành phần trong layout
        selection = findViewById(R.id.selection);
        singleComplete = findViewById(R.id.editauto);
        multiComplete = findViewById(R.id.multiAutoCompleteTextView);

        // Adapter dùng chung cho cả 2
        ArrayAdapter<String> myadapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, arr
        );

        // Gán adapter cho AutoCompleteTextView
        singleComplete.setAdapter(myadapter);

        // Gán adapter và tokenizer cho MultiAutoCompleteTextView
        multiComplete.setAdapter(myadapter);
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        // Theo dõi nội dung người dùng nhập và hiển thị lên TextView
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                selection.setText(singleComplete.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}
