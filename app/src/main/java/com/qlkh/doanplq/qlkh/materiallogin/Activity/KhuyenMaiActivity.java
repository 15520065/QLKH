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

public class KhuyenMaiActivity extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;

    EditText et_MaKM,et_TenKM,et_NoiDung,et_NgayBD,et_NgayKT,et_HeSoKMNgay,et_HeSoKMDem,et_HeSoKMThueBao;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khuyen_mai);
        init();

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String MaKH = et_MaKH.getText().toString();
                String TenKM = et_TenKM.getText().toString();
                String NoiDung = et_NoiDung.getText().toString();
                String NgayBD = et_NgayBD.getText().toString();
                String NgayKT = et_NgayKT.getText().toString();
                float HSKMN = Float.parseFloat(et_HeSoKMNgay.getText().toString());
                float HSKMD = Float.parseFloat(et_HeSoKMDem.getText().toString());
                float HSTBKM = Float.parseFloat(et_HeSoKMThueBao.getText().toString());

                ContentValues contentValues = new ContentValues();
                contentValues.put("TenKM", TenKM);
                contentValues.put("NoiDung", NoiDung);
                contentValues.put("NgayBD", NgayBD);
                contentValues.put("NgayKT", NgayKT);
                contentValues.put("HeSoKMNgay", HSKMN);
                contentValues.put("HeSoKMDem", HSKMD);
                contentValues.put("HeSoKMThueBao", HSTBKM);


                database = Database.initDatabase(KhuyenMaiActivity.this, DATABASE_NAME);
                database.insert("KhuyenMai", null, contentValues);


                Intent intent = new Intent(KhuyenMaiActivity.this, LoginSuccessActivity.class);

                startActivity(intent);


            }
        });





    }



    private void init() {
        et_TenKM = findViewById(R.id.et_TenKM);
        et_NoiDung = findViewById(R.id.et_NoiDung);
        et_NgayBD = findViewById(R.id.et_NgayBD);
        et_NgayKT = findViewById(R.id.et_NgayKT);
        et_HeSoKMNgay = findViewById(R.id.et_HeSoKMNgay);
        et_HeSoKMDem = findViewById(R.id.et_HeSoKMDem);
        et_HeSoKMThueBao = findViewById(R.id.et_HeSoKMThueBao);
        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
