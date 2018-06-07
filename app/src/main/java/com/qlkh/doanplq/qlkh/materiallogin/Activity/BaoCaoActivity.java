package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Table.LanTruyCap;
import com.qlkh.doanplq.qlkh.materiallogin.TimeUtils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaoCaoActivity extends AppCompatActivity {

    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    TextView txtThang, txtTien, txtTG;
    EditText ed_Thang,et_Nam;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao);
        txtThang = findViewById(R.id.txtThang);
        txtTien = findViewById(R.id.txtTongTien);
        txtTG =findViewById(R.id.txtTongTG);
        ed_Thang = findViewById(R.id.et_Thang);
        et_Nam = findViewById(R.id.et_Nam);

        txtThang.setText("Báo cáo tháng: ");
        txtTien.setText("Tổng doanh thu: ");
        txtTG.setText("Tổng thời gian đã được sử dụng: ");


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float tong = 0f;

                int thang = Integer.parseInt(ed_Thang.getText().toString());

                database = Database.initDatabase(BaoCaoActivity.this,DATABASE_NAME);
                Cursor cursor = database.rawQuery("SELECT * FROM HoaDonThang WHERE HoaDonThang.Thang = " + thang, null);

                for(int i = 0; i < cursor.getCount(); i++)
                {
                    cursor.moveToPosition(i);
                    Float Tien = Float.valueOf(cursor.getString(3));
                    tong = tong + Tien;
                }

                String a = String.valueOf(tong);

                txtThang.setText("Báo cáo tháng: " + thang);
                txtTien.setText("Tổng doanh thu: "+ a);


                List<LanTruyCap> list = LanTruyCap.getDB(BaoCaoActivity.this, "Select * FROM LanTruyCap");

                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(et_Nam.getText().toString()),thang - 1,1);
                Date checkMonth = calendar.getTime();

                List<LanTruyCap> filterList = new LinkedList<>();

                int TotalTimeInMonth = 0;
                for (LanTruyCap lanTruyCap : list) {
                    Date start = lanTruyCap.getThoiGianBD();
                    Date end = lanTruyCap.getThoiGianKT();

                    if (start == null || end == null) {
                        continue;
                    }

                    int timeInMonth = between(checkMonth, start, end);
                    if (timeInMonth != -1) {
                        filterList.add(lanTruyCap);
                        TotalTimeInMonth += timeInMonth;
                    }
                }

                txtTG.setText("Tổng thời gian đã được sử dụng: " + TotalTimeInMonth);



            }
        });
    }
    public int monthsBetweenDates(Date startDate, Date endDate){

        Calendar start = Calendar.getInstance();
        start.setTime(startDate);

        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        int monthsBetween = 0;
        int dateDiff = end.get(Calendar.DAY_OF_MONTH)-start.get(Calendar.DAY_OF_MONTH);

        if(dateDiff<0) {
            int borrrow = end.getActualMaximum(Calendar.DAY_OF_MONTH);
            dateDiff = (end.get(Calendar.DAY_OF_MONTH)+borrrow)-start.get(Calendar.DAY_OF_MONTH);
            monthsBetween--;

            if(dateDiff>0) {
                monthsBetween++;
            }
        }
        else {
            monthsBetween++;
        }
        monthsBetween += end.get(Calendar.MONTH)-start.get(Calendar.MONTH);
        monthsBetween  += (end.get(Calendar.YEAR)-start.get(Calendar.YEAR))*12;
        return monthsBetween;
    }

    public static int GetLeftDay(Date date) {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth =  cal.get(Calendar.DAY_OF_MONTH);
        int lastDayOfMonth =  cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        return  lastDayOfMonth - dayOfMonth;
    }

    public static int between(Date date, Date dateStart, Date dateEnd) {
        int monthDate = TimeUtils.getMonthFromDate(date);
        int monthStart = TimeUtils.getMonthFromDate(dateStart);
        int monthEnd = TimeUtils.getMonthFromDate(dateEnd);

        int yearDate = TimeUtils.getYearFromDate(date);
        int yearStart = TimeUtils.getYearFromDate(dateStart);
        int yearEnd = TimeUtils.getYearFromDate(dateEnd);

        if (date.before(dateStart) && yearDate == yearStart) {
            if (monthDate == monthStart ) {
                if (monthEnd == monthStart) {
                    return GetTotalDay(dateStart, dateEnd);
                } else {
                    return GetLeftDay(dateStart);
                }
            }
        }

        if (TimeUtils.getYearFromDate(date) == TimeUtils.getYearFromDate(dateEnd)) {
            if (monthDate == monthEnd) {
                if (monthStart == monthEnd) {
                    return GetTotalDay(dateStart, dateEnd);
                } else {
                    return GetDayOfMonth(dateEnd);
                }
            }
        }

        if (date != null && dateStart != null && dateEnd != null) {
            if (date.after(dateStart) && date.before(dateEnd)) {
                return GetLastDayOfMonth(date);
            }
            else {
                return -1;
            }
        }
        return -1;
    }

    private static int GetDayOfMonth(Date dateEnd) {
        Calendar cal = Calendar.getInstance();
        return  cal.get(Calendar.DAY_OF_MONTH);
    }

    private static int GetLastDayOfMonth(Date dateEnd) {
        Calendar cal = Calendar.getInstance();
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private static int GetTotalDay(Date dateStart, Date dateEnd) {
        long diff = dateEnd.getTime() - dateStart.getTime();
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
}
