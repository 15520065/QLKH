package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TaiKhoan;
import com.qlkh.doanplq.qlkh.materiallogin.TimeUtils;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DemoTaiKhoanLoginedActivity extends AppCompatActivity {

    TextView tv_MaTK, tv_Email, tv_ThoiGianBD;
    Button btn_DoiMatKhau, btn_DangXuat;

    TaiKhoan taiKhoan;

    Date ngayBD;
    Date ngayKT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_tai_khoan_logined);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                taiKhoan = null;
            } else {
                taiKhoan = extras.getParcelable("taiKhoan");
            }
        } else {
            taiKhoan = (TaiKhoan) savedInstanceState.getParcelable("taiKhoan");
        }

        if (taiKhoan == null) {
            finish();
        }

        init();


    }

    private void init() {
        tv_MaTK = findViewById(R.id.tv_MaTK);
        tv_Email = findViewById(R.id.tv_Email);
        tv_ThoiGianBD = findViewById(R.id.tv_ThoiGianBD);

        btn_DoiMatKhau = findViewById(R.id.btn_DoiMatKhau);
        btn_DangXuat = findViewById(R.id.btn_DangXuat);

        tv_MaTK.setText("Mã tài khoản: " + taiKhoan.getMaTK());
        tv_Email.setText("Email: " + taiKhoan.getEmail());
        tv_ThoiGianBD.setText("Thời gian đăng nhập: " + TimeUtils.curTimeToUserTimeStr());
        ngayBD = TimeUtils.getCurrentTimeAsDate();

        btn_DoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(getApplicationContext())
                        .title("Mật khẩu mới")
                        .inputType(InputType.TYPE_TEXT_VARIATION_PASSWORD)
                        .input("******", null, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                                if (!TextUtils.isEmpty(input.toString())) {
                                    taiKhoan.setMatKhau(input.toString());

                                    List<TaiKhoan> taiKhoans = new LinkedList<>();
                                    taiKhoans.add(taiKhoan);
                                    TaiKhoan.updateDS(DemoTaiKhoanLoginedActivity.this, taiKhoans);

                                    Toast.makeText(getApplicationContext(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .titleColor(getResources().getColor(R.color.title_bar_background_color_blue))
                        .positiveColor(getResources().getColor(R.color.title_bar_background_color_blue))
                        .positiveText("Xác nhận")
                        .negativeText("Hủy")
                        .widgetColorRes(R.color.title_bar_background_color_blue)
                        .buttonRippleColorRes(R.color.title_bar_background_color_blue)
                        .show();
            }
        });

        btn_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngayKT = TimeUtils.getCurrentTimeAsDate();


            }
        });
    }
}