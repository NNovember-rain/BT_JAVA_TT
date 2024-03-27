package Exception_JavaIO;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private static int cnt=0;
    private String id,Ten;
    private int dVHocTrinh;
    private String loaiMon;

    public MonHoc(String ten, int dVHocTrinh, String loaiMon) {
        this.id=String.format("%03d",cnt++);
        Ten = ten;
        this.dVHocTrinh = dVHocTrinh;
        this.loaiMon = loaiMon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getdVHocTrinh() {
        return dVHocTrinh;
    }

    public void setdVHocTrinh(int dVHocTrinh) {
        this.dVHocTrinh = dVHocTrinh;
    }

    public String getLoaiMon() {
        return loaiMon;
    }

    public void setLoaiMon(String loaiMon) {
        this.loaiMon = loaiMon;
    }

    public String toString(){
        return Integer.parseInt(this.getId())+"-"+this.getTen();
    }
}
