package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.qlkh.doanplq.qlkh.R;
import org.w3c.dom.Text;

public class TinhTrangActivity extends AppCompatActivity {

    TextView tv_MaTinhTrang,tv_TenTinhTrang;
    EditText et_MaTinhTrang,et_TenTinhTrang;
    Button btn_luu,btn_huy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_trang);
        init();
    }

    private void init() {
        tv_MaTinhTrang = findViewById(R.id.tv_MaTinhTrang);
        tv_TenTinhTrang = findViewById(R.id.tv_TenTinhTrang);

        et_MaTinhTrang = findViewById(R.id.et_MaTinhTrang);
        et_TenTinhTrang = findViewById(R.id.et_TenTinhTrang);

        btn_luu=findViewById(R.id.btn_luu);
        btn_huy=findViewById(R.id.btn_huy);
    }
}
