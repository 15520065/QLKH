package com.qlkh.doanplq.qlkh.materiallogin.Table;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

import java.util.LinkedList;
import java.util.List;

public class GoiCuoc {
    public int MaGoiCuoc;
    public String TenGoiCuoc;
    public int CuocThueBao;
    public int GiaCuocNgay;
    public int GiaCuocDem;

    final static String DATABASE_NAME = "QuanLyKhachHang.sqlite";

    public static List<GoiCuoc> getDB(Activity activity) {
        List<GoiCuoc> goiCuocList = new LinkedList<>();


        SQLiteDatabase database = Database.initDatabase(activity,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM GoiCuoc", null);
        goiCuocList.clear();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int MaGoiCuoc = cursor.getInt(0);
            String TenGoiCuoc = cursor.getString(1);
            int CuocThueBao = cursor.getInt(2);
            int GiaCuocNgay = cursor.getInt(3);
            int GiaCuocDem = cursor.getInt(4);

            goiCuocList.add(new GoiCuoc(MaGoiCuoc, TenGoiCuoc, CuocThueBao, GiaCuocNgay, GiaCuocDem));
        }

        return goiCuocList;
    }

    public GoiCuoc(int maGoiCuoc, String tenGoiCuoc, int cuocThueBao, int giaCuocNgay, int giaCuocDem) {
        MaGoiCuoc = maGoiCuoc;
        TenGoiCuoc = tenGoiCuoc;
        CuocThueBao = cuocThueBao;
        GiaCuocNgay = giaCuocNgay;
        GiaCuocDem = giaCuocDem;
    }
}
