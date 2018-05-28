package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class KhuyenMaiActivity extends AppCompatActivity {

    TextView tv_MaKM,tv_TenKM,tv_NoiDung,tv_NgayBD,tv_NgayKT,tv_HeSoKMNgay,tv_HeSoKMDem,tv_HeSoKMThueBao;
    EditText et_MaKM,et_TenKM,et_NoiDung,et_NgayBD,et_NgayKT,et_HeSoKMNgay,et_HeSoKMDem,et_HeSoKMThueBao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai);
    }
}
