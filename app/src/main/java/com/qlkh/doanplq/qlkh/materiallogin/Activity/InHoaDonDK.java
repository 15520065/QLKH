package com.qlkh.doanplq.qlkh.materiallogin.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.qlkh.doanplq.qlkh.R;
import com.qlkh.doanplq.qlkh.materiallogin.Database.Database;
import com.qlkh.doanplq.qlkh.materiallogin.Table.GoiCuoc;
import com.qlkh.doanplq.qlkh.materiallogin.Table.TaiKhoan;

import java.util.LinkedList;
import java.util.List;

public class InHoaDonDK extends AppCompatActivity {
    final String DATABASE_NAME = "QuanLyKhachHang.sqlite";
    SQLiteDatabase database;
    TextView txtTen, txtCMND, txtDCCD, txtDCTT, txtChiPhi, txtBD;

    private RecyclerView rccv_tk;
    int soLuongTK;
    int maKH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_hoa_don_dk);
        Intent intent = getIntent();
        final String MaHD = intent.getStringExtra("maHD");
        final String MaKH = intent.getStringExtra("maKH");
        int a = Integer.parseInt(MaHD);
        int b = Integer.parseInt(MaKH);
        maKH = b;

        txtTen = findViewById(R.id.txtTenKH);
        txtCMND = findViewById(R.id.txtCMND);
        txtDCCD = findViewById(R.id.txtDiaChiCD);
        txtDCTT = findViewById(R.id.txtDCGuiTT);
        txtChiPhi = findViewById(R.id.txtChiPhi);
        txtBD = findViewById(R.id.txtNgayBD);

        database = Database.initDatabase(this,DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM KhachHang, HopDongDK WHERE KhachHang.MaKH = HopDongDK.MaKH " +
                "AND HopDongDK.MaKH = "+b+"", null);
        cursor.moveToLast();

        Cursor cursor1 = database.rawQuery("SELECT * FROM HoaDonDK, HopDongDK WHERE HopDongDK.MaHopDongDK = HoaDonDK.MaHopDongDK " +
                "AND HopDongDK.MaHopDongDK = "+a+"", null);
        cursor1.moveToLast();

        String TenKH = cursor.getString(1);
        txtTen.setText(TenKH);
        String CMND = cursor.getString(2);
        txtCMND.setText(CMND);
        String DiaChiCaiDat = cursor1.getString(6);
        String DiaChiGuiHD = cursor1.getString(7);
        String PhiDKTT = cursor1.getString(1);
        String NgayBDSD = cursor1.getString(2);
        txtDCCD.setText(DiaChiCaiDat);
        txtDCTT.setText(DiaChiGuiHD);
        txtChiPhi.setText(PhiDKTT);
        txtBD.setText(NgayBDSD);


        String soLuongTKStr;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                soLuongTKStr = null;
                finish();
            } else {
                soLuongTKStr = extras.getString("SoLuongTK");
            }
        } else {
            soLuongTKStr = (String) savedInstanceState.getString("SoLuongTK");
        }
        soLuongTK = Integer.parseInt(soLuongTKStr);

        initRecyclerView();
        refreshList();

    }

    private void initRecyclerView() {
        rccv_tk = findViewById(R.id.rccv_tk);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rccv_tk.setLayoutManager(llm);
    }

    public List<TaiKhoan> getDSTK() {
        List<TaiKhoan> dsTk = new LinkedList<>();

        for (int i = 0; i < soLuongTK; i++) {
            TaiKhoan taiKhoan = TaiKhoan.Builder.aTaiKhoan()
                    .setMaKH(maKH)
                    .setMatKhau("123456")
                    .build();

            dsTk.add(taiKhoan);
        }

        TaiKhoan.insertDS(this,dsTk);

        return TaiKhoan.getDB(this, "SELECT * FROM TaiKhoan WHERE ifnull(Email, '') = '' AND MaKH = " + maKH );
    }

    private void refreshList() {

        final List<GoiCuoc> dsGoiCuoc = GoiCuoc.getDB(this);
        final List<TaiKhoan> dsTk = getDSTK();


        for (int i = 0; i < dsTk.size(); i++) {

            dsTk.get(i).setEmail("user"+ dsTk.get(i).getMaKH()+ dsTk.get(i).getMaTK()+"@buudien1890.com");

        }




        TKAdapter adapter = new TKAdapter(dsTk, dsGoiCuoc);

        rccv_tk.setAdapter(adapter);

        findViewById(R.id.btn_luu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TaiKhoan.updateDS(InHoaDonDK.this, dsTk);

                // xuat hoa don
            }
        });
    }
}
