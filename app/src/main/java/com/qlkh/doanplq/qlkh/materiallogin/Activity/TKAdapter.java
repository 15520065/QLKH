package com.qlkh.doanplq.qlkh.materiallogin.Activity;

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
    protected void convert(BaseViewHolder helper, TaiKhoan item) {
        helper.setText(R.id.txt_MaTK, item.getMaTK())
                .setText(R.id.txt_Email, item.getEmail())
                .setText(R.id.txt_MK, item.getMaTK());

        String maGoiCuocArr[] = new String[goiCuocList.size()];
        for (int i = 0; i < goiCuocList.size(); i++) {
            maGoiCuocArr[i] = String.valueOf(goiCuocList.get(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext
                ,android.R.layout.simple_spinner_item
                ,maGoiCuocArr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        helper.setAdapter(R.id.spinner_MaGoiCuoc, adapter);
    }
}