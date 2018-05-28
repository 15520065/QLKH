package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.R;
public class TaiKhoanActivity extends AppCompatActivity {

    TextView tv_MaTK,tv_Email,tv_MatKhau;
    EditText et_MaTK,et_Email,et_MatKhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
    }
}
