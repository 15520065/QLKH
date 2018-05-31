package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;

public class GoiCuocActivity extends AppCompatActivity {

    TextView  tv_MaGoiCuoc, tv_TenGoiCuoc,tv_CuocThueBao,tv_GiaCuocNgay,tv_GiaCuocDem;
    EditText et_MaGoiCuoc,et_TenGoiCuoc,et_CuocThueBao,et_GiaCuocNgay,et_GiaCuocDem;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_cuoc);

        init();
    }

    private void init() {
        tv_MaGoiCuoc = findViewById(R.id.tv_MaGoiCuoc);
        tv_TenGoiCuoc = findViewById(R.id.tv_TenGoiCuoc);
        tv_CuocThueBao = findViewById(R.id.tv_CuocThueBao);
        tv_GiaCuocNgay = findViewById(R.id.tv_GiaCuocNgay);
        tv_GiaCuocDem = findViewById(R.id.tv_GiaCuocDem);

        et_MaGoiCuoc = findViewById(R.id.et_MaGoiCuoc);
        et_TenGoiCuoc = findViewById(R.id.et_TenGoiCuoc);
        et_CuocThueBao = findViewById(R.id.et_CuocThueBao);
        et_GiaCuocNgay = findViewById(R.id.et_GiaCuocNgay);
        et_GiaCuocDem = findViewById(R.id.et_GiaCuocDem);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}