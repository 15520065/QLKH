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
import com.qlkh.doanplq.qlkh.materiallogin.Activity.UpdateGoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.UpdateKhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.GoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;

import java.util.ArrayList;

public class AdapterGoiCuoc extends BaseAdapter {

    Context context;
    ArrayList<GoiCuoc> list;

    public AdapterGoiCuoc(Context context, ArrayList<GoiCuoc> list) {
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
        View row = inflater.inflate(R.layout.listview_goicuoc, null);
        final TextView txtMaGC = (TextView) row.findViewById(R.id.txtMaGC);
        TextView txtTenGC = (TextView) row.findViewById(R.id.txtTenGC);
        TextView txtCuocTB = (TextView) row.findViewById(R.id.txtCuocTB);
        TextView txtGiaCN = (TextView) row.findViewById(R.id.txtGiaCN);
        TextView txtGiaCD = (TextView) row.findViewById(R.id.txtGiaCD);

        Button btnXoa = (Button) row.findViewById(R.id.buttonXoa);
        Button btnSua = (Button) row.findViewById(R.id.buttonSua);




        final GoiCuoc goiCuoc = list.get(position);

        txtTenGC.setText(goiCuoc.TenGoiCuoc);
        txtCuocTB.setText(goiCuoc.CuocThueBao + "");
        txtMaGC.setText(goiCuoc.MaGoiCuoc +"");
        txtGiaCN.setText(goiCuoc.GiaCuocNgay+"");
        txtGiaCD.setText(goiCuoc.GiaCuocDem+"");


        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, UpdateGoiCuoc.class);
                intent.putExtra("maGoiCuoc", goiCuoc.MaGoiCuoc);
                context.startActivity(intent);
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(goiCuoc.MaGoiCuoc);
            }
        });


        return row;
    }
    private void delete(int maGoiCuoc) {
        SQLiteDatabase database = Database.initDatabase((Activity) context,"QuanLyKhachHang.sqlite" );
        database.delete("GoiCuoc", "MaGoiCuoc = ?", new String[]{maGoiCuoc + ""});
        list.clear();
        Cursor cursor = database.rawQuery("SELECT * FROM GoiCuoc", null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String tenKH = cursor.getString(1);
            int CMND = cursor.getInt(2);
            int DiaChi = cursor.getInt(3);
            int NgheNghiep = cursor.getInt(4);
            list.add(new GoiCuoc(id, tenKH, CMND, DiaChi, NgheNghiep));
        }
        notifyDataSetChanged();
    }
}
