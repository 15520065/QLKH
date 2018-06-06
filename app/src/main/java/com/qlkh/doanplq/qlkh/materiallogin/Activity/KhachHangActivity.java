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
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class KhachHangActivity extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    TextView tv_MaKH,tv_TenKH,tv_CMND,tv_DiaChi,tv_NgheNghiep;
    EditText et_MaKH,et_TenKH,et_CMND,et_DiaChi,et_NgheNghiep;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khach_hang);
        init();
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String MaKH = et_MaKH.getText().toString();
                String TenKH = et_TenKH.getText().toString();
                String CMND = et_CMND.getText().toString();
                String DiaChi = et_DiaChi.getText().toString();
                String NgheNghiep = et_NgheNghiep.getText().toString();
//                String MaHopDong = et_MaHopDongDK.getText().toString();
//                String DiaChiCaiDat = et_DiaChiCaiDat.getText().toString();
//                String DiaChiGuiHD = et_DiaChiGuiHD.getText().toString();
//                String SDT = et_SDT.getText().toString();
//                String SoLuongTK = et_SoLuongTK.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put("TenKH", TenKH);
                contentValues.put("CMND", CMND);
                contentValues.put("DiaChi", DiaChi);
                contentValues.put("NgheNghiep", NgheNghiep);
//                contentValues.put("DiaChiCaiDat", DiaChiCaiDat);
//                contentValues.put("DiaChiGuiHD", DiaChiGuiHD);
//                contentValues.put("SDT", SDT);
//                contentValues.put("SoLuongTK", SoLuongTK);
                database = Database.initDatabase(KhachHangActivity.this, DATABASE_NAME);
                database.insert("KhachHang", null, contentValues);


                Intent intent = new Intent(KhachHangActivity.this, LoginSuccessActivity.class);

                startActivity(intent);


            }
        });


//

    }


    private void init() {
        tv_MaKH = findViewById(R.id.tv_MaKH);
        tv_TenKH = findViewById(R.id.tv_TenKH);
        tv_CMND = findViewById(R.id.tv_CMND);
        tv_DiaChi = findViewById(R.id.tv_DiaChi);
        tv_NgheNghiep = findViewById(R.id.tv_NgheNghiep);

        et_MaKH = findViewById(R.id.et_MaKH1);
        et_TenKH = findViewById(R.id.et_TenKH);
        et_CMND = findViewById(R.id.et_CMND);
        et_DiaChi = findViewById(R.id.et_DiaChi);
        et_NgheNghiep = findViewById(R.id.et_NgheNghiep);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
