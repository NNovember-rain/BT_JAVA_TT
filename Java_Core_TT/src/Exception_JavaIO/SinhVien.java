package Exception_JavaIO;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private static int cnt=0;
    private String id,Ten;
    private String diachi;
    private String sdt,lop;

    public SinhVien( String ten, String diachi, String sdt, String lop) {
        this.id=String.format("%05d",cnt++);
        Ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
        this.lop = lop;
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    public String toString(){
        return Integer.parseInt(this.getId())+"-"+this.getTen();
    }
}
