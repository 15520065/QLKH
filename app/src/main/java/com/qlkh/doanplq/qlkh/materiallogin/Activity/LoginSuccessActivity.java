package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;

public class LoginSuccessActivity extends AppCompatActivity {

    Button btnHopDongDK, btnGoiCuoc, btnHoaDonDK, btnHoaDonThang, btnKhachHang, btnKhuyenMai, btnLanTruyCap, btnTaiKhoan, btnTinhTrang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        btnGoiCuoc = findViewById(R.id.btnGoiCuoc);
        btnHoaDonDK = findViewById(R.id.btnHoaDonDK);
        btnHoaDonThang = findViewById(R.id.btnHoaDonThang);
        btnKhachHang = findViewById(R.id.btnKhachHang);
        btnKhuyenMai = findViewById(R.id.btnKhuyenMai);
        btnLanTruyCap = findViewById(R.id.btnLanTruyCap);
        btnTaiKhoan = findViewById(R.id.btnTaiKhoan);
        btnTinhTrang = findViewById(R.id.btnTinhTrang);

        Explode explode = new Explode();
        explode.setDuration(500);
        getWindow().setExitTransition(explode);
        getWindow().setEnterTransition(explode);


        btnGoiCuoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, QuanLyGoiCuoc.class);
                startActivity(intent);
            }
        });

        btnTinhTrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, TinhTrangActivity.class);
                startActivity(intent);
            }
        });

        btnTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, TaiKhoanActivity.class);
                startActivity(intent);
            }
        });

        btnLanTruyCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, LanTruyCapActivity.class);
                startActivity(intent);
            }
        });

        btnKhuyenMai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, QuanLyKhuyenMai.class);
                startActivity(intent);
            }
        });


        btnHoaDonDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, HoaDonDKActivity.class);
                startActivity(intent);
            }
        });

        btnKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, QuanLyKhachHang.class);
                startActivity(intent);
            }
        });

        btnHoaDonThang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, HoaDonThangActivity.class);
                startActivity(intent);
            }
        });







    }
}
