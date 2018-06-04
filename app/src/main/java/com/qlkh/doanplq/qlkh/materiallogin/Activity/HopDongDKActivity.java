package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class HopDongDKActivity extends AppCompatActivity {

    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;

    EditText et_MaKH,et_DiaChiCaiDat, et_DiaChiGuiHD,et_SDT,et_SoLuongTK;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong_dk);
        init();
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String MaKH = et_MaKH.getText().toString();
                String DiaChiCaiDat = et_DiaChiCaiDat.getText().toString();
                String DiaChiGuiHD = et_DiaChiGuiHD.getText().toString();
                String SDT = et_SDT.getText().toString();
                String SoLuongTK = et_SoLuongTK.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put("MaKH", MaKH);
                contentValues.put("DiaChiCaiDat", DiaChiCaiDat);
                contentValues.put("DiaChiGuiHopDong", DiaChiGuiHD);
                contentValues.put("SDT", SDT);
                contentValues.put("SoLuongTK", SoLuongTK);

                database = Database.initDatabase(HopDongDKActivity.this, DATABASE_NAME);
                database.insert("HopDongDK", null, contentValues);

                Intent intent = new Intent(HopDongDKActivity.this, HopDong.class);
                startActivity(intent);



            }
        });

    }


    private void init() {

        et_MaKH = findViewById(R.id.et_MaKH1);
        et_DiaChiCaiDat = findViewById(R.id.et_DiaChiCaiDat);
        et_DiaChiGuiHD = findViewById(R.id.et_DiaChiGuiHD);
        et_SDT = findViewById(R.id.et_SDT);
        et_SoLuongTK = findViewById(R.id.et_SoLuongTK);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);


    }
}
