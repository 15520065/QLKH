package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class GoiCuocActivity extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    EditText et_TenGoiCuoc,et_CuocThueBao,et_GiaCuocNgay,et_GiaCuocDem;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_cuoc);

        init();
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String MaKH = et_MaKH.getText().toString();
                String TenKH = et_TenGoiCuoc.getText().toString();
                int CMND = Integer.parseInt(et_CuocThueBao.getText().toString());
                int DiaChi = Integer.parseInt(et_GiaCuocNgay.getText().toString());
                int NgheNghiep = Integer.parseInt(et_GiaCuocDem.getText().toString());
//                String MaHopDong = et_MaHopDongDK.getText().toString();
//                String DiaChiCaiDat = et_DiaChiCaiDat.getText().toString();
//                String DiaChiGuiHD = et_DiaChiGuiHD.getText().toString();
//                String SDT = et_SDT.getText().toString();
//                String SoLuongTK = et_SoLuongTK.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put("TenGoiCuoc", TenKH);
                contentValues.put("CuocThueBao", CMND);
                contentValues.put("GiaCuocNgay", DiaChi);
                contentValues.put("GiaCuocDem", NgheNghiep);
//                contentValues.put("DiaChiCaiDat", DiaChiCaiDat);
//                contentValues.put("DiaChiGuiHD", DiaChiGuiHD);
//                contentValues.put("SDT", SDT);
//                contentValues.put("SoLuongTK", SoLuongTK);
                database = Database.initDatabase(GoiCuocActivity.this, DATABASE_NAME);
                database.insert("GoiCuoc", null, contentValues);


                Intent intent = new Intent(GoiCuocActivity.this, LoginSuccessActivity.class);

                startActivity(intent);


            }
        });

    }

    private void init() {


        et_TenGoiCuoc = findViewById(R.id.et_TenGoiCuoc);
        et_CuocThueBao = findViewById(R.id.et_CuocThueBao);
        et_GiaCuocNgay = findViewById(R.id.et_GiaCuocNgay);
        et_GiaCuocDem = findViewById(R.id.et_GiaCuocDem);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
