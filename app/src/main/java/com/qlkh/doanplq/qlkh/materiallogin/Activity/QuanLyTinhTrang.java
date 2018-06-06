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
import com.qlkh.doanplq.qlkh.materiallogin.Adapter.AdapterKhuyenMai;
import com.qlkh.doanplq.qlkh.materiallogin.Adapter.AdapterTinhTrang;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhuyenMai;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TinhTrang;

import java.util.ArrayList;


public class QuanLyTinhTrang extends AppCompatActivity {
    Button btnThem;
    ListView listView;
    ArrayList<TinhTrang> list;
    AdapterTinhTrang adapter;
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly_tinh_trang);
        addControls();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLyTinhTrang.this, TinhTrangActivity.class);
                startActivity(intent);
            }
        });
        readData();
    }

    private void readData() {
        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM TinhTrang", null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String TenTT = cursor.getString(1);





            list.add(new TinhTrang(id, TenTT));
        }
        adapter.notifyDataSetChanged();
    }

    private void addControls() {
        listView = findViewById(R.id.listview2);
        btnThem = findViewById(R.id.btnThem2);
        list = new ArrayList<>();
        adapter = new AdapterTinhTrang(this, list);
        listView.setAdapter(adapter);

    }
}
