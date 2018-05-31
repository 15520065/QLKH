package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class HoaDonThangActivity extends AppCompatActivity {


    TextView tv_MaHoaDonThang, tv_TongCuocThang,tv_Thang;
    EditText et_MaHoaDonThang, et_TongCuocThang, et_Thang;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_thang);
        init();
    }

    private void init() {
        tv_MaHoaDonThang = findViewById(R.id.tv_MaHoaDonThang);
        tv_TongCuocThang = findViewById(R.id.tv_TongCuocThang);
        tv_Thang = findViewById(R.id.tv_Thang);

        et_MaHoaDonThang = findViewById(R.id.et_MaHoaDonThang);
        et_TongCuocThang = findViewById(R.id.et_TongCuocThang);
        et_Thang = findViewById(R.id.et_Thang);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);


    }
}
