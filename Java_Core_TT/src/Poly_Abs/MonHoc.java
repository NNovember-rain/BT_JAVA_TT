package Poly_Abs;

public class MonHoc {
    private static int cnt=0;
    private String id,Ten;
    private int TongSoTiet,stLyThuyet;
    private Long KinhPhi;

    public MonHoc( String ten, int tongSoTiet, int stLyThuyet, Long kinhPhi) {
        this.id=String.format("%03d",cnt++);
        this.Ten = ten;
        this.TongSoTiet = tongSoTiet;
        this.stLyThuyet = stLyThuyet;
        this.KinhPhi = kinhPhi;
    }

    public MonHoc() {

    }

    // bên trên là 2 contructer sử dụng tính đa hình

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

    public int getTongSoTiet() {
        return TongSoTiet;
    }

    public void setTongSoTiet(int tongSoTiet) {
        TongSoTiet = tongSoTiet;
    }

    public int getStLyThuyet() {
        return stLyThuyet;
    }

    public void setStLyThuyet(int stLyThuyet) {
        this.stLyThuyet = stLyThuyet;
    }

    public Long getKinhPhi() {
        return KinhPhi;
    }

    public void setKinhPhi(Long kinhPhi) {
        KinhPhi = kinhPhi;
    }


}
