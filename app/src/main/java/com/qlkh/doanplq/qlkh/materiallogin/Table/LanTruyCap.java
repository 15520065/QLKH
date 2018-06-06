package com.qlkh.doanplq.qlkh.materiallogin.Table;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.TimeUtils;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class LanTruyCap {
    private int MaLanTruyCap;
    private int MaTK;
    private Date ThoiGianBD;
    private Date ThoiGianKT;

    public LanTruyCap(int maLanTruyCap, int maTK, Date thoiGianBD, Date thoiGianKT) {
        MaLanTruyCap = maLanTruyCap;
        MaTK = maTK;
        ThoiGianBD = thoiGianBD;
        ThoiGianKT = thoiGianKT;
    }

    final static String DATABASE_NAME = "QuanLyKhachHang.sqlite";

    public static void insertDS(Activity activity, List<LanTruyCap> list) {
        for (LanTruyCap item : list) {
            SQLiteDatabase database = Database.initDatabase(activity, DATABASE_NAME);

            ContentValues contentValues = new ContentValues();
            contentValues.put("ThoiGianBD", TimeUtils.dateToStrSysTem(item.getThoiGianBD()));
            contentValues.put("ThoiGianKT", TimeUtils.dateToStrSysTem(item.getThoiGianKT()));
            contentValues.put("MaTK", item.getMaTK());

            database.insert("LanTruyCap", null, contentValues);
        }
    }

    public static List<LanTruyCap> getDB(Activity activity, String query) {
        List<LanTruyCap> list = new LinkedList<>();


        SQLiteDatabase database = Database.initDatabase(activity,DATABASE_NAME);
        Cursor cursor = database.rawQuery(query, null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int MaLanTruyCap = cursor.getInt(0);
            Date ThoiGianBD =  TimeUtils.strToSystemDate(cursor.getString(1));
            Date ThoiGianKT = TimeUtils.strToSystemDate(cursor.getString(2));
            int MaTK = cursor.getInt(3);

            list.add(new LanTruyCap(MaLanTruyCap,MaTK, ThoiGianBD, ThoiGianKT ));
        }

        return list;
    }


    public int getMaLanTruyCap() {
        return MaLanTruyCap;
    }

    public void setMaLanTruyCap(int maLanTruyCap) {
        MaLanTruyCap = maLanTruyCap;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public Date getThoiGianBD() {
        return ThoiGianBD;
    }

    public void setThoiGianBD(Date thoiGianBD) {
        ThoiGianBD = thoiGianBD;
    }

    public Date getThoiGianKT() {
        return ThoiGianKT;
    }

    public void setThoiGianKT(Date thoiGianKT) {
        ThoiGianKT = thoiGianKT;
    }


    public static final class Builder {
        private int MaLanTruyCap;
        private int MaTK;
        private Date ThoiGianBD;
        private Date ThoiGianKT;

        private Builder() {
        }

        public static Builder aLanTruyCap() {
            return new Builder();
        }

        public Builder setMaLanTruyCap(int MaLanTruyCap) {
            this.MaLanTruyCap = MaLanTruyCap;
            return this;
        }

        public Builder setMaTK(int MaTK) {
            this.MaTK = MaTK;
            return this;
        }

        public Builder setThoiGianBD(Date ThoiGianBD) {
            this.ThoiGianBD = ThoiGianBD;
            return this;
        }

        public Builder setThoiGianKT(Date ThoiGianKT) {
            this.ThoiGianKT = ThoiGianKT;
            return this;
        }

        public LanTruyCap build() {
            LanTruyCap lanTruyCap = new LanTruyCap(0, 0, null, null);
            lanTruyCap.setMaLanTruyCap(MaLanTruyCap);
            lanTruyCap.setMaTK(MaTK);
            lanTruyCap.setThoiGianBD(ThoiGianBD);
            lanTruyCap.setThoiGianKT(ThoiGianKT);
            return lanTruyCap;
        }
    }
}
