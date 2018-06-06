package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Adapter.AdapterGoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Adapter.AdapterKhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.GoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;

import java.util.ArrayList;

public class QuanLyGoiCuoc extends AppCompatActivity {

    Button btnThem;
    ListView listView;
    ArrayList<GoiCuoc> list;
    AdapterGoiCuoc adapter;
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_goi_cuoc);
        addControls();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyGoiCuoc.this, GoiCuocActivity.class);
                startActivity(intent);
            }
        });
        readData();
    }

    private void readData() {
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM GoiCuoc", null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String tenKH = cursor.getString(1);
            int CMND = cursor.getInt(2);
            int DiaChi = cursor.getInt(3);
            int NgheNghiep = cursor.getInt(4);
            list.add(new GoiCuoc(id, tenKH, CMND, DiaChi, NgheNghiep));
        }
        adapter.notifyDataSetChanged();
    }

    private void addControls() {
        listView = findViewById(R.id.listviewGC);
        btnThem = findViewById(R.id.btnThemGC);
        list = new ArrayList<>();
        adapter = new AdapterGoiCuoc(this, list);
        listView.setAdapter(adapter);

    }
}
