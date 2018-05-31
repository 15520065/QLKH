package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;

public class HoaDonDKActivity extends AppCompatActivity {


    TextView tv_MaHoaDonDK,tv_CuocDK,tv_NgayBDSD,tv_NgayLap;
    EditText et_MaHoaDonDK,et_CuocDK,et_NgayBDSD,et_NgayLap;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_dk);
        init();
    }

    private void init() {
        tv_MaHoaDonDK = findViewById(R.id.tv_MaHoaDonDK);
        tv_CuocDK = findViewById(R.id.tv_CuocDK);
        tv_NgayBDSD = findViewById(R.id.tv_NgayBDSD);
        tv_NgayLap = findViewById(R.id.tv_NgayLap);
        et_MaHoaDonDK = findViewById(R.id.et_MaHoaDonDK);
        et_CuocDK = findViewById(R.id.et_CuocDK);
        et_NgayBDSD = findViewById(R.id.et_NgayBDSD);
        et_NgayLap = findViewById(R.id.et_NgayLap);
        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);

    }
}
