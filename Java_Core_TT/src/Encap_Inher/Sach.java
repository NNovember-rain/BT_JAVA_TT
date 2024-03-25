package Encap_Inher;

public class Sach {
    private static int cnt=0;
    private String id;
    private String ten,tacGia,chuyenNganh,namXB;

    public Sach( String ten, String tacGia, String chuyenNganh, String namXB) {
        this.id = String.format("%05d",cnt++);
        this.ten = ten;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namXB = namXB;
    }

    public Sach() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getNamXB() {
        return namXB;
    }

    public void setNamXB(String namXB) {
        this.namXB = namXB;
    }
    @Override
    public String toString(){
        return Integer.parseInt(this.getId())+"-"+this.getTen();
    }
}
