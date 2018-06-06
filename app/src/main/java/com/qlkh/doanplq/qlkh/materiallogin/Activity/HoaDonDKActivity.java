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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        et_CuocDK.setText("100000");

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        final String ngayBD = df.format(Calendar.getInstance().getTime());
        final String ngayLap = df.format(Calendar.getInstance().getTime());






        et_NgayBDSD.setText(ngayBD);
        et_NgayLap.setText(ngayLap);




        Intent intent = getIntent();
        final String MaHD = intent.getStringExtra("maHD");
        final String MaKH = intent.getStringExtra("maKH");

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CuocDK = String.valueOf(et_CuocDK.getText());

                ContentValues contentValues = new ContentValues();
                contentValues.put("CuocDK", CuocDK);
                contentValues.put("NgayBDSD", ngayBD);
                contentValues.put("NgayLap",ngayLap);
                contentValues.put("MaHopDongDK", MaHD);


                database = Database.initDatabase(HoaDonDKActivity.this, DATABASE_NAME);
                database.insert("HoaDonDK", null, contentValues);


                Intent intent = new Intent(HoaDonDKActivity.this, InHoaDonDK.class);
                intent.putExtra("maHD", MaHD);
                intent.putExtra("maKH", MaKH);
                startActivity(intent);


            }
        });




    }

    private void init() {

        et_CuocDK = findViewById(R.id.et_CuocDK);
        et_NgayBDSD = findViewById(R.id.et_NgayBDSD);
        et_NgayLap = findViewById(R.id.et_NgayLap);
        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);

    }
}