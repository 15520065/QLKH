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
import com.qlkh.doanplq.qlkh.materiallogin.Adapter.AdapterKhuyenMai;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.GoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhuyenMai;

import java.util.ArrayList;
import java.util.Date;

public class QuanLyKhuyenMai extends AppCompatActivity {

    Button btnThem;
    ListView listView;
    ArrayList<KhuyenMai> list;
    AdapterKhuyenMai adapter;
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_khuyen_mai);
        addControls();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyKhuyenMai.this, KhuyenMaiActivity.class);
                startActivity(intent);
            }
        });
        readData();


    }

    private void readData() {
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM KhuyenMai", null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String TenKM = cursor.getString(1);
            String NoiDung = cursor.getString(2);
            String NgayBD = cursor.getString(3);
            String NgayKT = cursor.getString(4);
            Float HSKMN = cursor.getFloat(5);
            Float HSKMD = cursor.getFloat(6);
            Float HSKMTB = cursor.getFloat(7);




            list.add(new KhuyenMai(id, TenKM, NoiDung, NgayBD, NgayKT,HSKMN ,HSKMD ,HSKMTB ));
        }
        adapter.notifyDataSetChanged();
    }

    private void addControls() {
        listView = findViewById(R.id.listview1);
        btnThem = findViewById(R.id.btnThem1);
        list = new ArrayList<>();
        adapter = new AdapterKhuyenMai(this, list);
        listView.setAdapter(adapter);

    }
}
