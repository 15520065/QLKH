package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class LanTruyCapActivity extends AppCompatActivity {

    TextView tv_MaLanTruyCap,tv_ThoiGianBD,tv_ThoiGianKT;
    EditText et_MaLanTruyCap,et_ThoiGianBD,et_ThoiGianKT;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lan_truy_cap);
        init();
    }

    private void init() {
        tv_MaLanTruyCap = findViewById(R.id.tv_MaLanTruyCap);
        tv_ThoiGianBD = findViewById(R.id.tv_ThoiGianBD);
        tv_ThoiGianKT = findViewById(R.id.tv_ThoiGianKT);

        et_MaLanTruyCap = findViewById(R.id.et_MaLanTruyCap);
        et_ThoiGianBD = findViewById(R.id.et_ThoiGianBD);
        et_ThoiGianKT = findViewById(R.id.et_ThoiGianKT);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
