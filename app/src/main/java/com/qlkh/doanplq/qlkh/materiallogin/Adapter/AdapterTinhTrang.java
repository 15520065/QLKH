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
import com.qlkh.doanplq.qlkh.materiallogin.Activity.UpdateKhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Activity.UpdateTinhTrang;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhuyenMai;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TinhTrang;

import java.util.ArrayList;

public class AdapterTinhTrang extends BaseAdapter {
    Context context;
    ArrayList<TinhTrang> list;

    public AdapterTinhTrang(Context context, ArrayList<TinhTrang> list) {
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
        View row = inflater.inflate(R.layout.listview_tinhtrang, null);
        final TextView txtMaTT = (TextView) row.findViewById(R.id.txtMaTinhTrang);
        TextView txttenTT = (TextView) row.findViewById(R.id.txtTenTinhTrang);

        Button btnXoa = (Button) row.findViewById(R.id.btnXoaTT);
        Button btnSua = (Button) row.findViewById(R.id.btnSuaTT);


        final TinhTrang tinhTrang = list.get(position);
        txttenTT.setText("Tên Tình Trạng: " + tinhTrang.TenTinhTrang);

        txtMaTT.setText("Mã Tình Trạng: " +tinhTrang.MaTinhTrang + "");

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, UpdateTinhTrang.class);
                intent.putExtra("maTinhTrang", tinhTrang.MaTinhTrang);
                context.startActivity(intent);
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(tinhTrang.MaTinhTrang);
            }
        });



        return row;
    }

    private void delete(int maTT) {
        SQLiteDatabase database = Database.initDatabase((Activity) context,"QuanLyKhachHang.sqlite" );
        database.delete("TinhTrang", "MaTinhTrang = ?", new String[]{maTT + ""});
        list.clear();
        Cursor cursor = database.rawQuery("SELECT * FROM TinhTrang", null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String tenKH = cursor.getString(1);

            list.add(new TinhTrang(id, tenKH));
        }
        notifyDataSetChanged();
    }
}
