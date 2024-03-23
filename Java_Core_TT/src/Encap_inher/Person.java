package Encap_inher;

public class Person {
    private String ten,diachi,sdt;

    public Person(String ten, String diachi, String sdt) {
        this.ten = ten;
        this.diachi = diachi;
        this.sdt = sdt;
    }
    public Person() {

    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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
}
