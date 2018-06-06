package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TaiKhoan;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText et_Email;
    private EditText et_MatKhau;
    private Button bt_DangNhap;
    private CardView cv;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView() {
        et_Email = findViewById(R.id.et_Email);
        et_MatKhau = findViewById(R.id.et_MatKhau);
        bt_DangNhap = findViewById(R.id.bt_DangNhap);
        cv = findViewById(R.id.cv);
        fab = findViewById(R.id.fab);
    }

    private void setListener() {
        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<TaiKhoan> taiKhoanList = TaiKhoan.getDB(MainActivity.this, "SELECT * FROM TaiKhoan)");

                for (TaiKhoan taiKhoan :
                        taiKhoanList) {
                    if (et_Email.getText().toString().equals(taiKhoan.getEmail())
                            && et_MatKhau.getText().toString().equals(taiKhoan.getMatKhau())) {

                        Intent i = new Intent(MainActivity.this,LoginSuccessActivity.class);
                        i.putExtra("taiKhoan", taiKhoan);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Sai Email hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        fab.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fab.setVisibility(View.VISIBLE);
    }
}
