package Poly_Abs;


import java.util.Scanner;
public class KeKhai implements QuanLiImpl{
    private int size=0;
    private GiangVien[] giangVien;
    private MonHoc[] monHoc;
    private QLGiaoVienKeKhai[] qlGiaoVienKeKhai;

    public KeKhai( int sLGiangVien, int sLCacMonHoc) {
        giangVien=new GiangVien[sLGiangVien];
        monHoc=new MonHoc[sLCacMonHoc];
        qlGiaoVienKeKhai=new QLGiaoVienKeKhai[sLGiangVien*200];
    }


    @Override
    public void nhapDSMonHoc(Scanner sc) {
        System.out.println("hãy nhập danh sách môn học mới :");
        for(int i=0;i<monHoc.length;i++) {
            System.out.print("Nhập tên môn học thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập tổng số tiết: ");
            int tongTiet=Integer.parseInt(sc.nextLine());
            System.out.print("Số tiết lí thuyết: ");
            int tongTietLT=Integer.parseInt(sc.nextLine());
            System.out.print("mức kinh phí: ");
            long kinhPhi=Long.parseLong(sc.nextLine());
            System.out.println();
            monHoc[i] = new MonHoc(ten,tongTiet,tongTietLT,kinhPhi);
        }
    }

    @Override
    public void nhapDSGiangVien(Scanner sc) {
        System.out.println("-nhập danh sách giảng viên: ");
        for(int i=0;i<giangVien.length;i++) {
            System.out.print("nhập tên giảng viên thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("nhập địa chỉ giảng viên: ");
            String diachi=sc.nextLine();
            System.out.print("nhập sdt giảng viên: ");
            String sdt=sc.nextLine();
            System.out.print("Nhập trình độ giảng viên: ");
            String trinhDo=sc.nextLine();
            System.out.println();
            giangVien[i] = new GiangVien(ten,diachi,sdt,trinhDo);
        }
    }

    @Override
    public void lapBangKe(Scanner sc) {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        System.out.print("Nhập mã giảng viên VD(00001): ");
        int maGiangVien=Integer.parseInt(sc.nextLine());

        System.out.print("Nhập mã môn học VD(00001): ");
        int maMonHoc=Integer.parseInt(sc.nextLine());

        System.out.print("Nhập môn học này sẽ dạy ở bao nhiêu lớp : ");
        int soLuongLop=Integer.parseInt(sc.nextLine());
        System.out.println("");

        boolean checkGiangVien=false,checkMonHoc=false; // check xem quyển sách và bạn đọc có tồn tại trong mảng k.
        GiangVien gv=new GiangVien();
        MonHoc mh=new MonHoc();
        for(int i=0;i<giangVien.length;i++){
            if(Integer.parseInt(giangVien[i].getId())==maGiangVien) {
                checkGiangVien=true;
                gv=giangVien[i];
                break;
            }
        }
        for(int i=0;i<monHoc.length;i++){
            if(Integer.parseInt(monHoc[i].getId())==maMonHoc) {
                checkMonHoc=true;
                mh=monHoc[i];
                break;
            }
        }
        if(!checkGiangVien || !checkMonHoc ){
            System.out.println("Giảng viên hoặc Môn học không tồn tại !");
            return;
        }

        if(gv.getTongSoTietDaDay()<=200){
            boolean check=false;
            for(int i=0;i<size;i++){
                if(qlGiaoVienKeKhai[i].getGiangVien().getId()== gv.getId() && qlGiaoVienKeKhai[i].getMonHoc().getId()==mh.getId()){
                    if(qlGiaoVienKeKhai[i].getSlMonMoiLop()+soLuongLop>3) {
                        System.out.println("Không được dạy môn này nhiều lớp thế !");
                        System.out.println();
                        return;
                    }
                    else{
                        qlGiaoVienKeKhai[i].setSlMonMoiLop(qlGiaoVienKeKhai[i].getSlMonMoiLop()+soLuongLop);
                        System.out.println("môn học thêm vào lớp thành công !");
                        System.out.println();
                        return;
                    }
                }
            }
            if(soLuongLop>3 && !check) {
                System.out.println("Không được dạy nhiều lớp thế !");
                System.out.println();
                return;
            }
            else {
                gv.setTongSoTietDaDay(gv.getTongSoTietDaDay()+mh.getTongSoTiet()); // cập nhật số tiết của gv;
                qlGiaoVienKeKhai[size]=new QLGiaoVienKeKhai(gv,mh,soLuongLop);
                size++;
            }
            return;
        }
    }
    public void xemTrangThaiCuaGVvaMH(){
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("Tình trạng môn học ở mỗi lớp của mỗi giảng viên:");
        for(int i=0;i<size;i++){
            System.out.println(qlGiaoVienKeKhai[i]);
        }
        System.out.println();
        return;
    }

    @Override
    public void sapXepTheoTen() {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(qlGiaoVienKeKhai[i].getGiangVien().getTen().compareToIgnoreCase(qlGiaoVienKeKhai[j].getGiangVien().getTen())>0){
                    QLGiaoVienKeKhai tmp=qlGiaoVienKeKhai[i];
                    qlGiaoVienKeKhai[i]=qlGiaoVienKeKhai[j];
                    qlGiaoVienKeKhai[j]=tmp;
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(qlGiaoVienKeKhai[i]);
        }
        System.out.println("sắp xếp theo tên thành công\n");
        return;
    }

    @Override
    public void sapXepTheoSoTiet() {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(qlGiaoVienKeKhai[i].getGiangVien().getTongSoTietDaDay()<qlGiaoVienKeKhai[j].getGiangVien().getTongSoTietDaDay()){
                    QLGiaoVienKeKhai tmp=qlGiaoVienKeKhai[i];
                    qlGiaoVienKeKhai[i]=qlGiaoVienKeKhai[j];
                    qlGiaoVienKeKhai[j]=tmp;
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(qlGiaoVienKeKhai[i]);
        }
        System.out.println("sắp xếp theo số lượng thành công\n");
        return;
    }

    @Override
    public void tinhToan() {
            for(int i=0;i<size;i++){
                int stThucHanh=qlGiaoVienKeKhai[i].getMonHoc().getTongSoTiet()-qlGiaoVienKeKhai[i].getMonHoc().getStLyThuyet();
                System.out.print("Giảng viên "+qlGiaoVienKeKhai[i].getGiangVien().getId()+"-"+qlGiaoVienKeKhai[i].getGiangVien().getTen()+" có thu nhập cho môn "+qlGiaoVienKeKhai[i].getMonHoc().getId()+"-"+ qlGiaoVienKeKhai[i].getMonHoc().getTen()+" là: ");
                long kinhPhiMonLT=qlGiaoVienKeKhai[i].getMonHoc().getKinhPhi()*qlGiaoVienKeKhai[i].getMonHoc().getStLyThuyet();
                Double kinhPhiMonTH=stThucHanh*0.7;
                System.out.println(String.format("%.2f",kinhPhiMonLT+kinhPhiMonTH));

            }
            return;
    }



}
