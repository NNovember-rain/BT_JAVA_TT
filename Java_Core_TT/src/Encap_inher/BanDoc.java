package Encap_inher;

public class BanDoc extends Person{
    private static int cnt=0;
    private String id;
    private String loaiBanDoc;
    private int soDauSachDaMuon=0; // lưu số đầu sách của bạn đọc thứ i đã mượn

    public BanDoc(String ten, String diaChi, String SDT, String loaiBanDoc) {
        super(ten,diaChi,SDT);
        this.id=String.format("%05d",cnt++);
        this.loaiBanDoc = loaiBanDoc;
    }


    public BanDoc() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getLoaiBanDoc() {
        return loaiBanDoc;
    }

    public void setLoaiBanDoc(String loaiBanDoc) {
        this.loaiBanDoc = loaiBanDoc;
    }

    public static int getCnt() {
        return cnt;
    }

    public static void setCnt(int cnt) {
        BanDoc.cnt = cnt;
    }

    public int getSoDauSachDaMuon() {
        return soDauSachDaMuon;
    }

    public void setSoDauSachDaMuon(int soDauSachDaMuon) {
        this.soDauSachDaMuon = soDauSachDaMuon;
    }

    @Override
    public String toString(){
        return this.getId()+"-"+this.getTen()+"-"+this.getDiachi()+"-"+this.getSdt()+"-"+this.getLoaiBanDoc();
    }
}
