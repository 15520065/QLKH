package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;


public class UpdateTinhTrang extends AppCompatActivity {

    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    int MaTT = -1;
    EditText et_TenTT;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tinh_trang);

        addControls();
        initUI();


    }


    private void initUI() {
        Intent intent = getIntent();
        MaTT = intent.getIntExtra("maTinhTrang", -1);
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM TinhTrang WHERE MaTinhTrang = ?", new String[]{MaTT + ""});
        cursor.moveToFirst();
        String TenTT = cursor.getString(1);


        et_TenTT.setText(TenTT);

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update();
            }
        });



    }

    private void addControls() {
        et_TenTT = findViewById(R.id.et_TenTinhTrang);


        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }

    private void Update()
    {
        String TenKH = et_TenTT.getText().toString();


        ContentValues contentValues = new ContentValues();
        contentValues.put("TenTinhTrang", TenKH);

        SQLiteDatabase database = Database.initDatabase(UpdateTinhTrang.this, "QuanLyKhachHang.sqlite");
        database.update("TinhTrang", contentValues, "MaTinhTrang = ?", new String[]{MaTT + ""});
        Intent intent = new Intent(this, QuanLyTinhTrang.class);
        startActivity(intent);
    }
}
