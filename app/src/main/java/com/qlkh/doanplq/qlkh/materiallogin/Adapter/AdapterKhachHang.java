package com.qlkh.doanplq.qlkh.materiallogin.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.HopDongDKActivity;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.KhachHangActivity;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.LoginSuccessActivity;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.QuanLyKhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.UpdateKhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;

import java.util.ArrayList;

public class AdapterKhachHang extends BaseAdapter {

    Context context;
    ArrayList<KhachHang> list;

    public AdapterKhachHang(Context context, ArrayList<KhachHang> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listview_khachhang, null);
        TextView txtMaKH = (TextView) row.findViewById(R.id.txtMaKH);
        TextView txtCMND = (TextView) row.findViewById(R.id.txtCMND);
        TextView txtDiaChi = (TextView) row.findViewById(R.id.txtDiaChi);
        TextView txtNgheNghiep = (TextView) row.findViewById(R.id.txtNgheNghiep);
        TextView txtTenKH = (TextView) row.findViewById(R.id.txtTenKH);
        Button btnXoa = (Button) row.findViewById(R.id.btnXoa);
        Button btnSua = (Button) row.findViewById(R.id.btnSua);
        Button btnDK = (Button) row.findViewById(R.id.btnDKHD);


        final KhachHang khachHang = list.get(position);
        txtCMND.setText(khachHang.CMND);
        txtDiaChi.setText(khachHang.DiaChi);
        txtMaKH.setText(khachHang.MaKH + "");
        txtNgheNghiep.setText(khachHang.NgheNghiep);
        txtTenKH.setText(khachHang.TenKH);

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, UpdateKhachHang.class);
                intent.putExtra("MaKH", khachHang.MaKH);
                context.startActivity(intent);
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(khachHang.MaKH);
            }
        });

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HopDongDKActivity.class);
                context.startActivity(intent);
            }
        });
        return row;
    }

    private void delete(int maKH) {
        SQLiteDatabase database = Database.initDatabase((Activity) context,"QuanLyKhachHang.sqlite" );
        database.delete("khachHang", "MaKH = ?", new String[]{maKH + ""});
        list.clear();
        Cursor cursor = database.rawQuery("SELECT * FROM KhachHang", null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String tenKH = cursor.getString(1);
            String CMND = cursor.getString(2);
            String DiaChi = cursor.getString(3);
            String NgheNghiep = cursor.getString(4);
            list.add(new KhachHang(id, tenKH, CMND, DiaChi, NgheNghiep));
        }
        notifyDataSetChanged();
    }
}
