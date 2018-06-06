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

    Button btnGoiCuoc, btnKhachHang, btnKhuyenMai, btnTinhTrang, btnDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        btnGoiCuoc = findViewById(R.id.btnGoiCuoc);

        btnKhachHang = findViewById(R.id.btnKhachHang);
        btnKhuyenMai = findViewById(R.id.btnKhuyenMai);
        btnDemo= findViewById(R.id.btn_Demo);
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
                Intent intent = new Intent(LoginSuccessActivity.this, QuanLyTinhTrang.class);
                startActivity(intent);
            }
        });

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, MainActivity.class);
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




        btnKhachHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginSuccessActivity.this, QuanLyKhachHang.class);
                startActivity(intent);
            }
        });








    }
}
