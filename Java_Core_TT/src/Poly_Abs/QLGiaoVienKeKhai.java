package Poly_Abs;

public class QLGiaoVienKeKhai {
    private GiangVien giangVien;
    private MonHoc monHoc;
    private int slMonMoiLop;

    public QLGiaoVienKeKhai(GiangVien giangVien, MonHoc monHoc, int slMonMoiLop) {
        this.giangVien = giangVien;
        this.monHoc = monHoc;
        this.slMonMoiLop = slMonMoiLop;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public int getSlMonMoiLop() {
        return slMonMoiLop;
    }

    public void setSlMonMoiLop(int slMonMoiLop) {
        this.slMonMoiLop = slMonMoiLop;
    }

    public String toString(){
        return "Giảng viên "+ this.giangVien.getId()+"-"+ this.giangVien.getTen()+" đã dạy môn "+this.monHoc.getId()+"-"+this.monHoc.getTen() +" ở "+this.slMonMoiLop;
    }
}
