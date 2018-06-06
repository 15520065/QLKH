package com.qlkh.doanplq.qlkh.materiallogin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhachHang;
import com.qlkh.doanplq.qlkh.materiallogin.Table.KhuyenMai;

import java.util.ArrayList;

public class AdapterKhuyenMai extends BaseAdapter {
    Context context;
    ArrayList<KhuyenMai> list;

    public AdapterKhuyenMai(Context context, ArrayList<KhuyenMai> list) {
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
        View row = inflater.inflate(R.layout.listview_khuyenmai, null);
        final TextView txtMaKM = (TextView) row.findViewById(R.id.txtMaKM);
        TextView txtTenKM = (TextView) row.findViewById(R.id.txtTenKM);
        TextView txtNoiDung = (TextView) row.findViewById(R.id.txtNoiDung);
        TextView txtNgayBD = (TextView) row.findViewById(R.id.txtNgayBD);
        TextView txtNgayKT = (TextView) row.findViewById(R.id.txtNgayKT);
        TextView txtHSKMN = (TextView) row.findViewById(R.id.txtHSKMN);
        TextView txtHSKMD = (TextView) row.findViewById(R.id.txtHSKMD);
        TextView txtHSKMTB = (TextView) row.findViewById(R.id.txtHSKMTB);


        final KhuyenMai khuyenMai = list.get(position);
        txtTenKM.setText("Tên KM: " + khuyenMai.TenKM);
        txtNoiDung.setText("Nội dung: " +khuyenMai.NoiDung);
        txtNgayBD.setText("Ngày BD: " +khuyenMai.NgayBD + "");
        txtMaKM.setText("Mã KM: " +khuyenMai.MaKM + "");

        txtNgayKT.setText("Ngày KT: " +khuyenMai.NgayKT+"");
        txtHSKMN.setText("Hệ số KM Ngày: " +khuyenMai.HeSoKMNgay +"");
        txtHSKMD.setText("Hệ số Km Đêm: " +khuyenMai.HeSoKMDem +"");
        txtHSKMTB.setText("Hệ số KM Thuê bao: " +khuyenMai.HeSoKMThueBao+"");


        return row;
    }
}
