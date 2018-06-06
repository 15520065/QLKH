package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class InHoaDonDK extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    TextView txtTen, txtCMND, txtDCCD, txtDCTT, txtChiPhi, txtBD, txtTaiKhoan, txtMK, txtMail;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_hoa_don_dk);
        Intent intent = getIntent();
        final String MaHD = intent.getStringExtra("maHD");
        final String MaKH = intent.getStringExtra("maKH");
        int a = Integer.parseInt(MaHD);
        int b = Integer.parseInt(MaKH);

        editText = findViewById(R.id.et_MaGC);
        txtTen = findViewById(R.id.txtTenKH);
        txtCMND = findViewById(R.id.txtCMND);
        txtDCCD = findViewById(R.id.txtDiaChiCD);
        txtDCTT = findViewById(R.id.txtDCGuiTT);
        txtChiPhi = findViewById(R.id.txtChiPhi);
        txtTaiKhoan = findViewById(R.id.txtTenTK);
        txtBD = findViewById(R.id.txtNgayBD);
        txtMK = findViewById(R.id.txtMatKhau);
        txtMail = findViewById(R.id.txtMail);

        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM KhachHang, HopDongDK WHERE KhachHang.MaKH = HopDongDK.MaKH " +
                "AND HopDongDK.MaKH = "+b+"", null);
        cursor.moveToLast();

        Cursor cursor1 = database.rawQuery("SELECT * FROM HoaDonDK, HopDongDK WHERE HopDongDK.MaHopDongDK = HoaDonDK.MaHopDongDK " +
                "AND HopDongDK.MaHopDongDK = "+a+"", null);
        cursor1.moveToLast();

        String TenKH = cursor.getString(1);
        txtTen.setText(TenKH);
        String CMND = cursor.getString(2);
        txtCMND.setText(CMND);
        String DiaChiCaiDat = cursor1.getString(6);
        String DiaChiGuiHD = cursor1.getString(7);
        String PhiDKTT = cursor1.getString(1);
        String NgayBDSD = cursor1.getString(2);
        txtDCCD.setText(DiaChiCaiDat);
        txtDCTT.setText(DiaChiGuiHD);
        txtChiPhi.setText(PhiDKTT);
        txtBD.setText(NgayBDSD);











    }
}
