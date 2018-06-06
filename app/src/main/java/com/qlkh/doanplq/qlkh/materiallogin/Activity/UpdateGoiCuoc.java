package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class UpdateGoiCuoc extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    int MaGoiCuoc = -1;
    EditText et_MaKH,et_TenKH,et_CMND,et_DiaChi,et_NgheNghiep;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_goi_cuoc);

        addControls();
        initUI();



    }

    private void initUI() {
        Intent intent = getIntent();
        MaGoiCuoc = intent.getIntExtra("maGoiCuoc", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM GoiCuoc WHERE MaGoiCuoc = ?", new String[]{MaGoiCuoc + ""});
        cursor.moveToFirst();
        String TenKH = cursor.getString(1);
        int CMND = cursor.getInt(2);
        int DiaChi = cursor.getInt(3);
        int NgheNghiep = cursor.getInt(4);

        et_CMND.setText(CMND);
        et_DiaChi.setText(DiaChi);
        et_NgheNghiep.setText(NgheNghiep);
        et_TenKH.setText(TenKH);

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update();
            }
        });



    }

    private void addControls() {
        et_MaKH = findViewById(R.id.et_MaGC);
        et_TenKH = findViewById(R.id.et_TenGC);
        et_CMND = findViewById(R.id.et_CuocTB1);
        et_DiaChi = findViewById(R.id.et_GiaCD);
        et_NgheNghiep = findViewById(R.id.et_GiaCD);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }

    private void Update()
    {
        String TenKH = et_TenKH.getText().toString();
        String CMND = et_CMND.getText().toString();
        String DiaChi = et_DiaChi.getText().toString();
        String NgheNghiep = et_NgheNghiep.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("TenKH", TenKH);
        contentValues.put("CMND", CMND);
        contentValues.put("DiaChi", DiaChi);
        contentValues.put("NgheNghiep", NgheNghiep);

        SQLiteDatabase database = Database.initDatabase(UpdateGoiCuoc.this, "QuanLyKhachHang.sqlite");
        database.update("GoiCuoc", contentValues, "MaGoiCuoc = ?", new String[]{MaGoiCuoc + ""});
        Intent intent = new Intent(this, QuanLyGoiCuoc.class);
        startActivity(intent);
    }
}
