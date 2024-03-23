package Encap_inher;


public class QLMuonSach {
    private BanDoc banDoc;
    private Sach sach;
    private int  soLuong;


    public QLMuonSach(BanDoc banDoc, Sach sach, int soLuong) {
        this.banDoc = banDoc;
        this.sach = sach;
        this.soLuong = soLuong;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }

    public Sach getSach() {
        return sach;
    }

    public void setSach(Sach sach) {
        this.sach = sach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String toString(){
        return "Bạn "+ this.banDoc.getId()+"-"+ this.banDoc.getTen()+" đã mượn quyển "+this.sach.getId()+"-"+this.sach.getTen() +" với số lượng là "+this.soLuong;
    }
}
