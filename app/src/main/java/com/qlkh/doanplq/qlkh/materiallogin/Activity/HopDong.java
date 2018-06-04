package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class HopDong extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    TextView txtten, txtcm, txtdiachi, txtnghe, txtdccai, txtdcgui, txtsdt, txtsl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong);


        txtten = findViewById(R.id.txtten);
        txtcm = findViewById(R.id.txtcmnd);
        txtdiachi = findViewById(R.id.txtdiachi);
        txtnghe = findViewById(R.id.txtnghenghiep);
        txtdccai = findViewById(R.id.txtdccaidat);
        txtdcgui = findViewById(R.id.txtdiachiguihd);
        txtsdt = findViewById(R.id.txtsdt);
        txtsl = findViewById(R.id.txtsltk);
        database = Database.initDatabase(this,DATABASE_NAME);

        Cursor cursor = database.rawQuery("SELECT * FROM KhachHang, HopDongDK WHERE KhachHang.MaKH = HopDongDK.MaKH", null);
        cursor.moveToFirst();
        String TenKH = cursor.getString(1);
        String CMND = cursor.getString(2);
        String DiaChi = cursor.getString(3);
        String NgheNghiep = cursor.getString(4);
        String DiaChiCaiDat = cursor.getString(5);
        String DiaChiGuiHopDong = cursor.getString(6);
        String SDT = cursor.getString(7);
        String SoLuongTK = cursor.getString(8);

        txtten.setText(TenKH);
        txtcm.setText(CMND);
        txtdiachi.setText(DiaChi);
        txtnghe.setText(NgheNghiep);
        txtdccai.setText(DiaChiCaiDat);
        txtdcgui.setText(DiaChiGuiHopDong);
        txtsdt.setText(SDT);
        txtsl.setText(SoLuongTK);



    }
}
