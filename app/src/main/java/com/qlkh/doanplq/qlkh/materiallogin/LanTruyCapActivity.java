package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
public class LanTruyCapActivity extends AppCompatActivity {

    TextView tv_MaLanTruyCap,tv_ThoiGianBD,tv_ThoiGianKT;
    EditText et_MaLanTruyCap,et_ThoiGianBD,et_ThoiGianKT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lan_truy_cap);
    }
}
