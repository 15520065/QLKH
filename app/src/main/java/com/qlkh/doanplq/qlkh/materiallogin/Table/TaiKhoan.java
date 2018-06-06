package com.qlkh.doanplq.qlkh.materiallogin.Table;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qlkh.doanplq.qlkh.materiallogin.Activity.HopDongDKActivity;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

import java.util.LinkedList;
import java.util.List;

public class TaiKhoan {
    private int MaTK;
    private int MaKH;
    private int MaGoiCuoc;
    private String Email;
    private int MatKhau;

    final static String DATABASE_NAME = "QuanLyKhachHang.sqlite";

    public static void insertDS(Activity activity, List<TaiKhoan> dsTK) {
        for (TaiKhoan tk : dsTK) {
            SQLiteDatabase database = Database.initDatabase(activity, DATABASE_NAME);

            ContentValues contentValues = new ContentValues();
            contentValues.put("MaKH", tk.getMaKH());
            contentValues.put("MaGoiCuoc", tk.getMaGoiCuoc());
            contentValues.put("MatKhau", tk.getMatKhau());

            database.insert("TaiKhoan", null, contentValues);
        }
    }

    public static void updateDS(Activity activity, List<TaiKhoan> dsTK) {
        for (TaiKhoan tk : dsTK) {
            SQLiteDatabase database = Database.initDatabase(activity, DATABASE_NAME);

            ContentValues contentValues = new ContentValues();
            contentValues.put("MaKH", tk.getMaKH());
            contentValues.put("MaGoiCuoc", tk.getMaGoiCuoc());
            contentValues.put("Email", tk.getEmail());
            contentValues.put("MatKhau", tk.getMatKhau());

            database.update("TaiKhoan", contentValues, "MaTK = ?", new String[]{tk.getMaKH() + ""});

        }
    }

    public static List<TaiKhoan> getDB(Activity activity, String query) {
        List<TaiKhoan> list = new LinkedList<>();


        SQLiteDatabase database = Database.initDatabase(activity,DATABASE_NAME);
        Cursor cursor = database.rawQuery(query, null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int MaTK = cursor.getInt(0);
            int MaKH = cursor.getInt(1);
            int MaGoiCuoc = cursor.getInt(2);
            String Email = cursor.getString(3);
            int MatKhau = cursor.getInt(4);

            list.add(new TaiKhoan(MaTK, MaKH, MaGoiCuoc, Email, MatKhau));
        }

        return list;
    }

    public TaiKhoan(int maTK, int maKH, int maGoiCuoc, String email, int matKhau) {
        MaTK = maTK;
        MaKH = maKH;
        MaGoiCuoc = maGoiCuoc;
        Email = email;
        MatKhau = matKhau;
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int maTK) {
        MaTK = maTK;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int maKH) {
        MaKH = maKH;
    }

    public int getMaGoiCuoc() {
        return MaGoiCuoc;
    }

    public void setMaGoiCuoc(int maGoiCuoc) {
        MaGoiCuoc = maGoiCuoc;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(int matKhau) {
        MatKhau = matKhau;
    }


    public static final class Builder {
        private int MaTK;
        private int MaKH;
        private int MaGoiCuoc;
        private String Email;
        private int MatKhau;

        private Builder() {
        }

        public static Builder aTaiKhoan() {
            return new Builder();
        }

        public Builder setMaTK(int MaTK) {
            this.MaTK = MaTK;
            return this;
        }

        public Builder setMaKH(int MaKH) {
            this.MaKH = MaKH;
            return this;
        }

        public Builder setMaGoiCuoc(int MaGoiCuoc) {
            this.MaGoiCuoc = MaGoiCuoc;
            return this;
        }

        public Builder setEmail(String Email) {
            this.Email = Email;
            return this;
        }

        public Builder setMatKhau(int MatKhau) {
            this.MatKhau = MatKhau;
            return this;
        }

        public TaiKhoan build() {
            TaiKhoan taiKhoan = new TaiKhoan(0, 0, 0, null, 0);
            taiKhoan.setMaTK(MaTK);
            taiKhoan.setMaKH(MaKH);
            taiKhoan.setMaGoiCuoc(MaGoiCuoc);
            taiKhoan.setEmail(Email);
            taiKhoan.setMatKhau(MatKhau);
            return taiKhoan;
        }
    }
}
