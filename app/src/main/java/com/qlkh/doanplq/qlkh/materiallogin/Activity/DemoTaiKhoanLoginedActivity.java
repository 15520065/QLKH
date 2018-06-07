package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
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
import com.qlkh.doanplq.qlkh.materiallogin.Table.LanTruyCap;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TaiKhoan;
import com.qlkh.doanplq.qlkh.materiallogin.TimeUtils;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
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
        tv_ThoiGianBD.setText("Thời gian đăng nhập: " + TimeUtils.getCurrentTimeAsString());
        ngayBD = TimeUtils.getCurrentTimeAsDate();

        btn_DoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(DemoTaiKhoanLoginedActivity.this)
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

        initDateTimePicker();
    }

    Calendar selectedDateTime;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;

    private void initDateTimePicker() {
        selectedDateTime = Calendar.getInstance();

        // Date
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                selectedDateTime.set(year,monthOfYear,dayOfMonth);

                // start time picker
                if(timePickerDialog.isAdded())
                    return;

                timePickerDialog.show(getFragmentManager(),"timePickerDialog");
            }
        };


        datePickerDialog = DatePickerDialog.newInstance(dateSetListener, Calendar.getInstance());
        datePickerDialog.setVersion(DatePickerDialog.Version.VERSION_2);
        datePickerDialog.setAccentColor(ResourcesCompat.getColor(getResources(), R.color.title_bar_background_color_blue, null));

        // Time
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
                selectedDateTime.set(Calendar.HOUR_OF_DAY,hourOfDay);
                selectedDateTime.set(Calendar.MINUTE,minute);
                selectedDateTime.set(Calendar.SECOND,0);
                selectedDateTime.set(Calendar.MILLISECOND,0);

                // out va luu thong tin lan truy cap
                LanTruyCap lanTruyCap = LanTruyCap.Builder.aLanTruyCap()
                        .setMaTK(taiKhoan.getMaTK())
                        .setThoiGianBD(ngayBD)
                        .setThoiGianKT(selectedDateTime.getTime())
                        .build();

                List<LanTruyCap> list = new LinkedList<>();
                list.add(lanTruyCap);

                LanTruyCap.insertDS(DemoTaiKhoanLoginedActivity.this, list);


                // dùng code này lấy ds, chứ k coi đc trên sqlite
//                List<LanTruyCap> dsLanTruyCapCuaTK = LanTruyCap.getDB(DemoTaiKhoanLoginedActivity.this, "SELECT * FROM LanTruyCap WHERE MaTK = " + maTK);
//                dsLanTruyCapCuaTK.size();
            }
        };

        timePickerDialog = TimePickerDialog.newInstance(timeSetListener, true);
        timePickerDialog.setAccentColor(ResourcesCompat.getColor(getResources(), R.color.title_bar_background_color_blue, null));


        btn_DangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datePickerDialog.isAdded())
                    return;

                datePickerDialog.show(getFragmentManager(),"datePickerDialog");
            }
        });
    }
}
