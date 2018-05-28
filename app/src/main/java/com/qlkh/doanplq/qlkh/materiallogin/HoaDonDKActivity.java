package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;

public class HoaDonDKActivity extends AppCompatActivity {


    TextView tv_MaHoaDonDK,tv_CuocDK,tv_NgayBDSD,tv_NgayLap;
    EditText et_MaHoaDonDK,et_CuocDK,et_NgayBDSD,et_NgayLap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_dk);
    }
}
