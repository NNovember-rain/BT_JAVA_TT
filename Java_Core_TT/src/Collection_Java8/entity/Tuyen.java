package Collection_Java8.entity;

public class Tuyen {
    private static int cnt =0;
    private String id;
    private int khoangCach,soDiemDung;

    public Tuyen( int khoangCach, int soDiemDung) {
        this.id=String.format("%03d",cnt++);
        this.khoangCach = khoangCach;
        this.soDiemDung = soDiemDung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getSoDiemDung() {
        return soDiemDung;
    }

    public void setSoDiemDung(int soDiemDung) {
        this.soDiemDung = soDiemDung;
    }

    public String toString(){
        return this.getId()+" "+this.getKhoangCach()+" "+this.soDiemDung;
    }
}
