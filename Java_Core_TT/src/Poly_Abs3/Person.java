package Poly_Abs3;

public class Person {
    private String ten,sdt,diaChi;

    public Person(String ten, String sdt, String diaChi) {
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public Person() {
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
