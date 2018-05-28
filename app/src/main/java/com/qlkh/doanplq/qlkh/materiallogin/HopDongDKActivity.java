package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;

import org.w3c.dom.Text;

public class HopDongDKActivity extends AppCompatActivity {

    TextView tv_MaHopDongDK, tv_DiaChiCaiDat,tv_DiaChiGuiHD,tv_SDT,tv_SoLuongTK;
    EditText et_MaHopDongDK,et_DiaChiCaiDat, et_DiaChiGuiHD,et_SDT,et_SoLuongTK;
    Button btn_luu,btn_huy;

    TextView tv_MaKH,tv_TenKH,tv_CMND,tv_DiaChi,tv_NgheNghiep;
    EditText et_MaKH,et_TenKH,et_CMND,et_DiaChi,et_NgheNghiep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong_dk);
        init();
    }

    private void init() {
        tv_MaHopDongDK = findViewById(R.id.tv_MaHopDongDK);
        tv_DiaChiCaiDat = findViewById(R.id.tv_DiaChiCaiDat);
        tv_DiaChiGuiHD = findViewById(R.id.tv_DiaChiGuiHD);
        tv_SDT = findViewById(R.id.tv_SDT);
        tv_SoLuongTK = findViewById(R.id.tv_SoLuongTK);

        et_MaHopDongDK = findViewById(R.id.et_MaHopDongDK);
        et_DiaChiCaiDat = findViewById(R.id.et_DiaChiCaiDat);
        et_DiaChiGuiHD = findViewById(R.id.et_DiaChiGuiHD);
        et_SDT = findViewById(R.id.et_SDT);
        et_SoLuongTK = findViewById(R.id.et_SoLuongTK);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);

        tv_MaKH = findViewById(R.id.tv_MaKH);
        tv_TenKH = findViewById(R.id.tv_TenKH);
        tv_CMND = findViewById(R.id.tv_CMND);
        tv_DiaChi = findViewById(R.id.tv_DiaChi);
        tv_NgheNghiep = findViewById(R.id.tv_NgheNghiep);

        et_MaKH = findViewById(R.id.et_MaKH);
        et_TenKH = findViewById(R.id.et_TenKH);
        et_CMND = findViewById(R.id.et_CMND);
        et_DiaChi = findViewById(R.id.et_DiaChi);
        et_NgheNghiep = findViewById(R.id.et_NgheNghiep);
    }
}
