package com.qlkh.doanplq.qlkh.materiallogin.Table;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;

import com.qlkh.doanplq.qlkh.materiallogin.Activity.HopDongDKActivity;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;

import java.util.LinkedList;
import java.util.List;

public class TaiKhoan implements Parcelable {
    private int MaTK;
    private int MaKH;
    private int MaGoiCuoc;
    private String Email;
    private String MatKhau;

    final static String DATABASE_NAME = "QuanLyKhachHang.sqlite";

    public static void insertDS(Activity activity, List<TaiKhoan> dsTK) {
        for (TaiKhoan tk : dsTK) {
            SQLiteDatabase database = Database.initDatabase(activity, DATABASE_NAME);

            ContentValues contentValues = new ContentValues();
            contentValues.put("MaKH", tk.getMaKH());
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

            database.update("TaiKhoan", contentValues, "MaTK = ?", new String[]{tk.getMaTK() + ""});


        }
    }

    public static void deleteDS(Activity activity, List<TaiKhoan> dsTK) {
        for (TaiKhoan tk : dsTK) {
            SQLiteDatabase database = Database.initDatabase(activity,DATABASE_NAME );
            database.delete("TaiKhoan", "MaTK = ?", new String[]{tk.getMaTK() + ""});

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
            String Email = cursor.getString(1);
            String MatKhau = cursor.getString(2);
            int MaKH = cursor.getInt(3);
            int MaGoiCuoc = cursor.getInt(4);

            list.add(new TaiKhoan(MaTK, MaKH, MaGoiCuoc, Email, MatKhau));
        }

        return list;
    }

    public TaiKhoan(int maTK, int maKH, int maGoiCuoc, String email, String matKhau) {
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

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }


    public static final class Builder {
        private int MaTK;
        private int MaKH;
        private int MaGoiCuoc;
        private String Email;
        private String MatKhau;

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

        public Builder setMatKhau(String MatKhau) {
            this.MatKhau = MatKhau;
            return this;
        }

        public TaiKhoan build() {
            TaiKhoan taiKhoan = new TaiKhoan(0, 0, 0, null, null);
            taiKhoan.setMaTK(MaTK);
            taiKhoan.setMaKH(MaKH);
            taiKhoan.setMaGoiCuoc(MaGoiCuoc);
            taiKhoan.setEmail(Email);
            taiKhoan.setMatKhau(MatKhau);
            return taiKhoan;
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.MaTK);
        dest.writeInt(this.MaKH);
        dest.writeInt(this.MaGoiCuoc);
        dest.writeString(this.Email);
        dest.writeString(this.MatKhau);
    }

    protected TaiKhoan(Parcel in) {
        this.MaTK = in.readInt();
        this.MaKH = in.readInt();
        this.MaGoiCuoc = in.readInt();
        this.Email = in.readString();
        this.MatKhau = in.readString();
    }

    public static final Parcelable.Creator<TaiKhoan> CREATOR = new Parcelable.Creator<TaiKhoan>() {
        @Override
        public TaiKhoan createFromParcel(Parcel source) {
            return new TaiKhoan(source);
        }

        @Override
        public TaiKhoan[] newArray(int size) {
            return new TaiKhoan[size];
        }
    };
}
