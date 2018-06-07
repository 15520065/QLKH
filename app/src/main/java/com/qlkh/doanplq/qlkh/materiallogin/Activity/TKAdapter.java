package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Table.GoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TaiKhoan;

import java.util.LinkedList;
import java.util.List;


public class TKAdapter extends BaseQuickAdapter<TaiKhoan, BaseViewHolder> {

    List<GoiCuoc> goiCuocList;


    public TKAdapter(List data, List<GoiCuoc> goiCuocList) {
        super(R.layout.row_tk, data);
        this.goiCuocList = goiCuocList;
    }

    @Override
    protected void convert(BaseViewHolder helper, final TaiKhoan item) {
        helper.setText(R.id.txt_MaTK, String.valueOf(item.getMaTK()))
                .setText(R.id.txt_Email, item.getEmail())
                .setText(R.id.txt_MK, String.valueOf(item.getMatKhau()));

        String maGoiCuocArr[] = new String[goiCuocList.size()];
        for (int i = 0; i < goiCuocList.size(); i++) {
            maGoiCuocArr[i] = String.valueOf(String.valueOf(goiCuocList.get(i).MaGoiCuoc));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext
                ,android.R.layout.simple_spinner_item
                ,maGoiCuocArr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        helper.setAdapter(R.id.spinner_MaGoiCuoc, adapter);

        AdapterView.OnItemSelectedListener onItemSelectedListener = null;
        onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int maGoiCuoc = Integer.parseInt(parent.getItemAtPosition(position).toString());

                item.setMaGoiCuoc(maGoiCuoc);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };

        helper.setOnItemSelectedClickListener(R.id.spinner_MaGoiCuoc, onItemSelectedListener);
    }
}