package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class KhuyenMaiActivity extends AppCompatActivity {

    TextView tv_MaKM,tv_TenKM,tv_NoiDung,tv_NgayBD,tv_NgayKT,tv_HeSoKMNgay,tv_HeSoKMDem,tv_HeSoKMThueBao;
    EditText et_MaKM,et_TenKM,et_NoiDung,et_NgayBD,et_NgayKT,et_HeSoKMNgay,et_HeSoKMDem,et_HeSoKMThueBao;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai);
        init();
    }

    private void init() {
        tv_MaKM = findViewById(R.id.tv_MaKM);
        tv_TenKM = findViewById(R.id.tv_TenKM);
        tv_NoiDung = findViewById(R.id.tv_NoiDung);
        tv_NgayBD = findViewById(R.id.tv_NgayBD);
        tv_NgayKT = findViewById(R.id.tv_NgayKT);
        tv_HeSoKMNgay = findViewById(R.id.tv_HeSoKMNgay);
        tv_HeSoKMDem = findViewById(R.id.tv_HeSoKMDem);
        tv_HeSoKMThueBao = findViewById(R.id.tv_HeSoKMThueBao);

        et_MaKM = findViewById(R.id.et_MaKM);
        et_TenKM = findViewById(R.id.et_TenKM);
        et_NoiDung = findViewById(R.id.et_NoiDung);
        et_NgayBD = findViewById(R.id.et_NgayBD);
        et_NgayKT = findViewById(R.id.et_NgayKT);
        et_HeSoKMNgay = findViewById(R.id.et_HeSoKMNgay);
        et_HeSoKMDem = findViewById(R.id.et_HeSoKMDem);
        et_HeSoKMThueBao = findViewById(R.id.et_HeSoKMThueBao);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
