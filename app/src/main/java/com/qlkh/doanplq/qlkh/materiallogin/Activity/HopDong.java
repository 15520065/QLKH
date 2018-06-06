package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;

public class HopDong extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    TextView txtten, txtcm, txtdiachi, txtnghe, txtdccai, txtdcgui, txtsdt, txtsl, txtMaHD;
    Button btnDongTien;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong);

        Intent intent = getIntent();
        final String maKH = intent.getStringExtra("MaKH");
        txtten = findViewById(R.id.txtten);
        txtcm = findViewById(R.id.txtcmnd);
        txtdiachi = findViewById(R.id.txtdiachi);
        txtnghe = findViewById(R.id.txtnghenghiep);
        txtdccai = findViewById(R.id.txtdccaidat);
        txtdcgui = findViewById(R.id.txtdiachiguihd);
        txtsdt = findViewById(R.id.txtsdt);
        txtsl = findViewById(R.id.txtsltk);
        txtMaHD = findViewById(R.id.txtMaHD);
        btnDongTien = findViewById(R.id.btnDongTien);

        database = Database.initDatabase(this,DATABASE_NAME);
        int a = Integer.parseInt(maKH);

        Cursor cursor = database.rawQuery("SELECT * FROM KhachHang, HopDongDK WHERE KhachHang.MaKH = HopDongDK.MaKH " +
                "AND HopDongDK.MaKH = "+a+"", null);
        cursor.moveToLast();
        String TenKH = cursor.getString(1);
        String CMND = cursor.getString(2);
        String DiaChi = cursor.getString(3);
        String NgheNghiep = cursor.getString(4);
        final String MaHD = cursor.getString(6);
        String DiaChiCaiDat = cursor.getString(7);
        String DiaChiGuiHopDong = cursor.getString(8);
        String SDT = cursor.getString(9);
        final String SoLuongTK = cursor.getString(10);

        txtten.setText("Tên: " + TenKH);
        txtcm.setText("Số CMND: "+CMND);
        txtdiachi.setText("Địa chỉ: "+DiaChi);
        txtnghe.setText("Nghề nghiệp: "+NgheNghiep);
        txtdccai.setText("Địa chỉ cài đặt: "+DiaChiCaiDat);
        txtdcgui.setText("Địa chỉ gửi HD: "+DiaChiGuiHopDong);
        txtsdt.setText("Số điện thoại: "+SDT);
        txtsl.setText("Số lượng tài khoản: "+ SoLuongTK);
        txtMaHD.setText("Mã hợp đồng: "+MaHD);


        btnDongTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HopDong.this, HoaDonDKActivity.class);
                intent.putExtra("maHD", MaHD);
                intent.putExtra("maKH", maKH);
                intent.putExtra("SoLuongTK", SoLuongTK);
                startActivity(intent);
            }
        });


    }
}
