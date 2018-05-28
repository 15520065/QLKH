package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.R;
public class TaiKhoanActivity extends AppCompatActivity {

    TextView tv_MaTK,tv_Email,tv_MatKhau;
    EditText et_MaTK,et_Email,et_MatKhau;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        init();
    }

    private void init() {
        tv_MaTK = findViewById(R.id.tv_MaTK);
        tv_Email = findViewById(R.id.tv_Email);
        tv_MatKhau = findViewById(R.id.tv_MatKhau);

        et_MaTK = findViewById(R.id.et_MaTK);
        et_Email = findViewById(R.id.et_Email);
        et_MatKhau = findViewById(R.id.et_MatKhau);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
