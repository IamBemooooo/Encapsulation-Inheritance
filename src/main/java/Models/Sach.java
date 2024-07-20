package Models;

import java.util.Scanner;

public class Sach {
    private static int nextId = 10000;
    private int maSach;
    private String tenSach;
    private String tacGia;
    private String chuyenNganh;
    private int namXuatBan;

    public Sach(String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
        this.maSach = nextId++;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXuatBan = namXuatBan;
    }

    public Sach() {
    }

    public static void setNextId(int nextId) {
        Sach.nextId = nextId;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    @Override
    public String toString() {
        return "maSach=" + maSach + ", tenSach='" + tenSach + ", tacGia='" + tacGia + ", chuyenNganh='" + chuyenNganh + ", namXuatBan=" + namXuatBan + '\'';
    }
}
