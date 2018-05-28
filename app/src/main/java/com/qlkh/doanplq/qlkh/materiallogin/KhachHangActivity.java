package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class KhachHangActivity extends AppCompatActivity {

    TextView tv_MaKH,tv_TenKH,tv_CMND,tv_DiaChi,tv_NgheNghiep;
    EditText et_MaKH,et_TenKH,et_CMND,et_DiaChi,et_NgheNghiep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);
    }
}
