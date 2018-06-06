package com.qlkh.doanplq.qlkh.materiallogin.Table;

import java.util.Date;

public class KhuyenMai  {

    public int MaKM;
    public String TenKM;
    public String NoiDung;
    public String NgayBD;
    public String NgayKT;
    public Float HeSoKMNgay;
    public Float HeSoKMDem;
    public Float HeSoKMThueBao;

    public KhuyenMai(int maKM, String tenKM, String noiDung, String ngayBD, String ngayKT, Float heSoKMNgay, Float heSoKMDem, Float heSoKMThueBao) {
        MaKM = maKM;
        TenKM = tenKM;
        NoiDung = noiDung;
        NgayBD = ngayBD;
        NgayKT = ngayKT;
        HeSoKMNgay = heSoKMNgay;
        HeSoKMDem = heSoKMDem;
        HeSoKMThueBao = heSoKMThueBao;
    }
}
