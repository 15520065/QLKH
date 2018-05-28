package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class HoaDonThangActivity extends AppCompatActivity {


    TextView tv_MaHoaDonThang, tv_TongCuocThang,tv_Thang;
    EditText et_MaHoaDonThang, et_TongCuocTahng, et_Thang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_thang);
    }
}
