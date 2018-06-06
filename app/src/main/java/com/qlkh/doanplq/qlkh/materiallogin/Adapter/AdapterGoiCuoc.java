package com.qlkh.doanplq.qlkh.materiallogin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
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




        final GoiCuoc goiCuoc = list.get(position);

        txtTenGC.setText(goiCuoc.TenGoiCuoc);
        txtCuocTB.setText(goiCuoc.CuocThueBao + "");
        txtMaGC.setText(goiCuoc.MaGoiCuoc +"");
        txtGiaCN.setText(goiCuoc.GiaCuocNgay+"");
        txtGiaCD.setText(goiCuoc.GiaCuocDem+"");
        return row;
    }
}
