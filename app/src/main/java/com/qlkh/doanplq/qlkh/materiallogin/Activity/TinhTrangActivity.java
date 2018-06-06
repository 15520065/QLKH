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

public class TinhTrangActivity extends AppCompatActivity {

    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;

    EditText et_MaTinhTrang,et_TenTinhTrang;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_trang);
        init();

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String MaKH = et_MaKH.getText().toString();
                String TenTT = et_TenTinhTrang.getText().toString();


                ContentValues contentValues = new ContentValues();
                contentValues.put("TenTinhTrang", TenTT);



                database = Database.initDatabase(TinhTrangActivity.this, DATABASE_NAME);
                database.insert("TinhTrang", null, contentValues);


                Intent intent = new Intent(TinhTrangActivity.this, LoginSuccessActivity.class);

                startActivity(intent);


            }
        });


    }

    private void init() {


        et_MaTinhTrang = findViewById(R.id.et_phidk);
        et_TenTinhTrang = findViewById(R.id.et_TenTinhTrang);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
