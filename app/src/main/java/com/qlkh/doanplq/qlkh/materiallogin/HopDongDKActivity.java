package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;

import org.w3c.dom.Text;

public class HopDongDKActivity extends AppCompatActivity {

    TextView tv_MaHopDongDK, tv_DiaChiCaiDat,tv_DiaChiGuiHD,tv_SDT,tv_SoLuongTK;
    EditText et_MaHopDongDK,et_DiaChiCaiDat, et_DiaChiGuiHD,et_SDT,et_SoLuongTK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong_dk);
    }
}
