package com.qlkh.doanplq.qlkh.materiallogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import com.qlkh.doanplq.qlkh.R;
import org.w3c.dom.Text;

public class TinhTrangActivity extends AppCompatActivity {

    TextView tv_MaTinhTrang,tv_TenTinhTrang;
    EditText et_MaTinhTrang,et_TenTinhTrang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_trang);
    }
}
