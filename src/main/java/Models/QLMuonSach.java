package Models;

public class QLMuonSach {
    private int idBanDoc;
    private int idSach;
    private int soLuong;

    public QLMuonSach(int idBanDoc, int idSach, int soLuong) {
        this.idBanDoc = idBanDoc;
        this.idSach = idSach;
        this.soLuong = soLuong;
    }

    public int getIdSach() {
        return idSach;
    }

    public int getIdBanDoc() {
        return idBanDoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    @Override
    public String toString() {
        return "idBanDoc=" + idBanDoc + ", idSach=" + idSach + ", soLuong=" + soLuong;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setIdBanDoc(int idBanDoc) {
        this.idBanDoc = idBanDoc;
    }
}
