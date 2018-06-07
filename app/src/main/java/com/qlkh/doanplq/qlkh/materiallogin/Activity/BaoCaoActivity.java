package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;


public class BaoCaoActivity extends AppCompatActivity {

    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    TextView txtThang, txtTien, txtTG;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao);
        txtThang = findViewById(R.id.txtThang);
        txtTien = findViewById(R.id.txtTongTien);
        txtTG =findViewById(R.id.txtTongTG);
        Float tong;
        tong = Float.valueOf(0);
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM HoaDonThang WHERE HoaDonThang.Thang = 1", null);

        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            Float Tien = Float.valueOf(cursor.getString(3));
            tong = tong + Tien;
        }

        String a = String.valueOf(tong);

        txtThang.setText("Báo cáo tháng: 1");
        txtTien.setText("Tổng doanh thu: "+ a);



    }
}
