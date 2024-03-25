package Poly_Abs3;

public class GiangVien extends Person{
    private static int cnt=0;
    private String id,trinhDo;

    public GiangVien(String ten, String sdt, String diaChi, String trinhDo) {
        super(ten, sdt, diaChi);
        this.id=String.format("%03d",cnt++);
        this.trinhDo = trinhDo;
    }
    public GiangVien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String toString(){
        return Integer.parseInt(this.id)+"-"+this.getTen();
    }
}
