package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

public class HoaDonDKActivity extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;


    EditText et_MaHoaDonDK,et_CuocDK,et_NgayBDSD,et_NgayLap;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_dk);
        init();

        Intent intent = getIntent();
        final String MaHD = intent.getStringExtra("maHD");

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CuocDK = et_CuocDK.getText().toString();
                String ngayBDSD = et_NgayBDSD.getText().toString();
                String ngayLap = et_NgayLap.getText().toString();

                ContentValues contentValues = new ContentValues();

                contentValues.put("NgayBDSD", ngayBDSD);
                contentValues.put("NgayLap", ngayLap);
                contentValues.put("PhiDK", CuocDK);
                contentValues.put("MaHopDongDK", MaHD);

                database = Database.initDatabase(HoaDonDKActivity.this, DATABASE_NAME);
                database.insert("HoaDonDK", null, contentValues);


                Intent intent = new Intent(HoaDonDKActivity.this, LoginSuccessActivity.class);

                startActivity(intent);


            }
        });




    }

    private void init() {

        et_MaHoaDonDK = findViewById(R.id.et_MaHoaDonDK);
        et_CuocDK = findViewById(R.id.et_CuocDK);
        et_NgayBDSD = findViewById(R.id.et_NgayBDSD);
        et_NgayLap = findViewById(R.id.et_NgayLap);
        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);

    }
}
