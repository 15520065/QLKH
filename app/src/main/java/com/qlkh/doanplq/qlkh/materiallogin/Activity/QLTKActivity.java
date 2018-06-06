package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.GoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TaiKhoan;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class QLTKActivity extends AppCompatActivity {

    private RecyclerView rccv_tk;

    int soLuongTK;
    int maKH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qltk);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                soLuongTK = 0;
                maKH = 0;
            } else {
                soLuongTK = extras.getInt("soLuongTK");
                maKH = extras.getInt("maKH");
            }
        } else {
            soLuongTK = (Integer) savedInstanceState.getInt("soLuongTK");
            maKH = (Integer) savedInstanceState.getInt("maKH");
        }

    }

    private void initRecyclerView() {
        rccv_tk = findViewById(R.id.rccv_tk);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rccv_tk.setLayoutManager(llm);
    }

    public List<TaiKhoan> getDSTK() {
        List<GoiCuoc> dsGoiCuoc = GoiCuoc.getDB(this);
        List<TaiKhoan> dsTk = new LinkedList<>();

        if (dsGoiCuoc.size() == 0) {
            Toast.makeText(getApplicationContext(), "Chưa có gói cước mặc định!", Toast.LENGTH_LONG);
            finish();
        }

        for (int i = 0; i < soLuongTK; i++) {
            TaiKhoan taiKhoan = TaiKhoan.Builder.aTaiKhoan()
                    .setMaKH(maKH)
                    .setMaGoiCuoc(dsGoiCuoc.get(0).MaGoiCuoc)
                    .setMaKH(123)
                    .build();

            dsTk.add(taiKhoan);
        }

        TaiKhoan.insertDS(this,dsTk);

        return TaiKhoan.getDB(this, "SELECT * FROM KhachHang WHERE MaKH = " + maKH + "" );
    }

    private void refreshList(boolean enableLoading) {

        List<GoiCuoc> dsGoiCuoc = GoiCuoc.getDB(this);
        List<TaiKhoan> dsTk = getDSTK();

        TKAdapter adapter = new TKAdapter(dsTk, dsGoiCuoc);
//        adapter.setOnItemChildClickListener((adapter1, view, position) -> {
//            if (view.getId() == R.id.iv_menu) {
//                showTopRightMenuItem(position, view);
//            }
//            if (view.getId() == R.id.btn_request_state) {
//                btnRequestStateClick(position);
//            }
//        });

        rccv_tk.setAdapter(adapter);

    }
}
