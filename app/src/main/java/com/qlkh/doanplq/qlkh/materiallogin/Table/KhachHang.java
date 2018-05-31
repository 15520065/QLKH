package com.qlkh.doanplq.qlkh.materiallogin.Table;

public class KhachHang {
    public int MaKH;
    public String TenKH;
    public String CMND;
    public String DiaChi;
    public String NgheNghiep;


    public KhachHang(int maKH, String tenKH, String CMND, String diaChi, String ngheNghiep) {
        MaKH = maKH;
        TenKH = tenKH;
        this.CMND = CMND;
        DiaChi = diaChi;
        NgheNghiep = ngheNghiep;
    }
}
