package Collection_Java8.entity;

public class LaiXe {
    private static int cnt =0;
    private String id;
    private String ten,diaChi,soDT,trinhDo;

    public LaiXe(String ten, String diaChi, String soDT, String trinhDo) {
        this.id=String.format("%05d",cnt++);
        this.ten = ten;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.trinhDo = trinhDo;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String toString(){
        return this.getId()+" "+this.getTen()+" "+this.getSoDT()+" "+this.getTrinhDo();
    }
}
