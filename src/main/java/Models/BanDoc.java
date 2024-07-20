package Models;

public class BanDoc {
    private static int nextId = 10000;
    private int maBanDoc;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;
    private String loaiBanDoc;

    public BanDoc(String hoTen, String diaChi, String soDienThoai, String loaiBanDoc) {
        this.maBanDoc = nextId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.loaiBanDoc = loaiBanDoc;
    }

    public BanDoc() {
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    @Override
    public String toString() {
        return "maBanDoc=" + maBanDoc + ", hoTen='" + hoTen + ", diaChi='" + diaChi + ", soDienThoai='" + soDienThoai + ", loaiBanDoc='" + loaiBanDoc + '\'';
    }
}
