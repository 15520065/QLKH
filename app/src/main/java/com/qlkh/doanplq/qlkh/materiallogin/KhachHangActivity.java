package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class KhachHangActivity extends AppCompatActivity {

    TextView tv_MaKH,tv_TenKH,tv_CMND,tv_DiaChi,tv_NgheNghiep;
    EditText et_MaKH,et_TenKH,et_CMND,et_DiaChi,et_NgheNghiep;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);
        init();
    }

    private void init() {
        tv_MaKH = findViewById(R.id.tv_MaKH);
        tv_TenKH = findViewById(R.id.tv_TenKH);
        tv_CMND = findViewById(R.id.tv_CMND);
        tv_DiaChi = findViewById(R.id.tv_DiaChi);
        tv_NgheNghiep = findViewById(R.id.tv_NgheNghiep);

        et_MaKH = findViewById(R.id.et_MaKH);
        et_TenKH = findViewById(R.id.et_TenKH);
        et_CMND = findViewById(R.id.et_CMND);
        et_DiaChi = findViewById(R.id.et_DiaChi);
        et_NgheNghiep = findViewById(R.id.et_NgheNghiep);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
