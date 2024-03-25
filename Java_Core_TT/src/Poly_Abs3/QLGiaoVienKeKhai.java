package Poly_Abs3;


import java.util.Scanner;

public class QLGiaoVienKeKhai implements QuanLiImpl{
   private GiangVien[] giangVien;
   private MonHoc[] monHoc;

   private int qlGiangday[][];

   public QLGiaoVienKeKhai(int slGiangVien,int slMonHoc){
       giangVien=new GiangVien[slGiangVien];
       monHoc=new MonHoc[slMonHoc];
       qlGiangday=new int[slGiangVien][slMonHoc];
   }


    @Override
    public void nhapDSMonHoc(Scanner sc) {
        System.out.println("\n-hãy nhập danh sách gồm "+monHoc.length+" môn học mới :");
        for(int i=0;i<monHoc.length;i++) {
            System.out.print("Nhập tên môn học thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập tổng số tiết: ");
            int tongTiet=Integer.parseInt(sc.nextLine());
            System.out.print("Nhập số tiết lí thuyết: ");
            int soTietLT=Integer.parseInt(sc.nextLine());
            System.out.print("Nhập mức kinh phí: ");
            long kinhPhi=Long.parseLong(sc.nextLine());
            monHoc[i] = new MonHoc(ten,tongTiet,soTietLT,kinhPhi);
        }
        System.out.println("\nDanh sách môn học: ");
        for(int i=0;i<monHoc.length;i++){
            System.out.println(monHoc[i]);
        }
        System.out.println();
    }

    @Override
    public void nhapDSGiangVien(Scanner sc) {
        System.out.println("\n-nhập danh sách gồm "+giangVien.length+" giảng viên mới: ");
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
        System.out.println("\nDanh sách giảng viên: ");
        for(int i=0;i<giangVien.length;i++){
            System.out.println(giangVien[i]);
        }
        System.out.println();
    }

    @Override
    public void lapBangKe(Scanner sc) {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        System.out.println("-giảng viên hiện có:");
        for(int i=0;i<giangVien.length;i++){
            System.out.println("+, "+giangVien[i]);
        }

        System.out.println("\n-môn học hiện có:");
        for(int i=0;i<monHoc.length;i++){
            System.out.println("+, "+monHoc[i]);
        }


        System.out.print("\nNhập số được gắn bên cạnh tên giảng viên để chọn giảng viên tương ứng: ");
        int magiangVien=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số được gắn bên cạnh tên môn học để chọn môn học tương ứng: ");
        int maMonHoc=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng lớp sẽ dạy: ");
        int soLuong=Integer.parseInt(sc.nextLine());

        int cnt=0;
        int tongTietCua1GV=0;
        for(int j=0;j<monHoc.length;j++){
            if(qlGiangday[magiangVien][j]>0){ // check xem giảng viên có dạy môn học j ko
                tongTietCua1GV+=monHoc[magiangVien].getTongSoTiet();
            }
            if(tongTietCua1GV>200) {
                System.out.println("Tổng số tiết giảng dạy của bạn đã vượt quá giới hạn !");
                return;
            }
        }

        if(soLuong+qlGiangday[magiangVien][maMonHoc]>3){
            System.out.println("môn này này bạn đã dạy quá nhiều lớp !");
            return;
        }
        qlGiangday[magiangVien][maMonHoc]+=soLuong;
        System.out.println("Phân lớp thành công !");
        return;
    }



    @Override
    public void sapXepTheoTen() {
        if(giangVien[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 2 !!!");
            System.out.println();
            return;
        }

        for (int i = 0; i < giangVien.length - 1; i++) {
            for (int j = i + 1; j < giangVien.length; j++) {
                if (giangVien[i].getTen().compareTo(giangVien[j].getTen()) > 0) {
                    GiangVien tempGiangVien = giangVien[i];
                    giangVien[i] = giangVien[j];
                    giangVien[j] = tempGiangVien;

                    String tmpIDGiangVien=giangVien[i].getId();
                    giangVien[i].setId(giangVien[j].getId());
                    giangVien[j].setId(tmpIDGiangVien);

                    MonHoc tmpmonHoc=monHoc[i];
                    monHoc[i]=monHoc[j];
                    monHoc[j]=tmpmonHoc;

                    String tmpIDSach=monHoc[i].getId();
                    monHoc[i].setId(monHoc[j].getId());
                    monHoc[j].setId(tmpIDSach);

                    int[] temp = qlGiangday[i];
                    qlGiangday[i] = qlGiangday[j];
                    qlGiangday[j] = temp;
                }
            }
        }
    }

    @Override
    public void sapXepTheoSoTiet() {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        for(int i=0;i<giangVien.length;i++){
            for(int j=i+1;j<giangVien.length;j++){
                int sum=0,sum1=0;
                for(int l=0;l<monHoc.length;l++){
                    if(qlGiangday[i][l]>0){ // check xem giảng viên i có dạy môn học l không
                        sum+=monHoc[l].getTongSoTiet();
                    }
                    if(qlGiangday[j][l]>0){
                        sum1+=monHoc[l].getTongSoTiet();
                    }
                }
                if(sum<sum1){
                    GiangVien tempGiangVien = giangVien[i];
                    giangVien[i] = giangVien[j];
                    giangVien[j] = tempGiangVien;

                    String tmpIDGiangVien=giangVien[i].getId();
                    giangVien[i].setId(giangVien[j].getId());
                    giangVien[j].setId(tmpIDGiangVien);

                    MonHoc tmpmonHoc=monHoc[i];
                    monHoc[i]=monHoc[j];
                    monHoc[j]=tmpmonHoc;

                    String tmpIDSach=monHoc[i].getId();
                    monHoc[i].setId(monHoc[j].getId());
                    monHoc[j].setId(tmpIDSach);

                    int[] temp = qlGiangday[i];
                    qlGiangday[i] = qlGiangday[j];
                    qlGiangday[j] = temp;
                }
            }
        }
    }

    @Override
    public void tinhToan() {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        System.out.println("\n-Bảng tiền công: ");
        for(int i=0;i<giangVien.length;i++) {
            System.out.println("+,tiền công cho giảng viên "+giangVien[i].getId()+"-"+giangVien[i].getTen()+" :");
            Long tongTienCong=0L;
            boolean check=false;
            for(int l=0;l<monHoc.length;l++) {
                if (qlGiangday[i][l] > 0) {
                    check=true;
                    int tongst=monHoc[l].getTongSoTiet();
                    int tietMonLT=monHoc[l].getStLyThuyet();
                    int tietMonTH=tongst-tietMonLT;
                    long cpMonHoc=(long)(monHoc[l].getKinhPhi()*tietMonLT+monHoc[l].getKinhPhi()*tietMonTH*0.7);
                    System.out.println("  * môn "+monHoc[l].getId()+"-"+monHoc[l].getTen()+" với "+tietMonLT+" tiết môn lí thuyết và " +tietMonTH+" tiết môn thực hành nên tiền công cho môn này là "+cpMonHoc);
                    tongTienCong+=cpMonHoc;
                }
            }
            if(!check){
                System.out.println("giảng viên "+giangVien[i].getTen()+" không dạy môn nào");
            }
            else{
                System.out.println("=>tổng tiền công các môn của giảng viên "+giangVien[i].getTen()+" là: "+tongTienCong);
                System.out.println();
            }
        }

    }
    @Override
    public void xemTrangThaiCuaGVvaMH() {
        if(giangVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("\n* Trạng thái của các giảng viên:");
        for(int i=0;i<giangVien.length;i++){
            System.out.println("- giảng viên "+giangVien[i].getTen() +" đã dạy những môn học sau:");
            for(int j=0;j<monHoc.length;j++){
                if(qlGiangday[i][j]>0){
                    System.out.println("  +,"+monHoc[j].getTen()+" --> "+qlGiangday[i][j]+" lớp");
                }
            }
        }
        System.out.println();
        return;
    }
}
