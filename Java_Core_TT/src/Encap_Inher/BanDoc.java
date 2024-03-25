package Encap_Inher;

public class BanDoc extends Person {
    private static int cnt=0;
    private String id;
    private String loaiBanDoc;
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


    @Override
    public String toString(){
        return Integer.parseInt(this.getId())+"-"+this.getTen();
    }
}

