package Collection_Java8.main;

import Collection_Java8.sevice.BangPhanCong;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng lái xe: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng tuyến : ");
        int m = Integer.parseInt(sc.nextLine());
        String fileMonHoc="monhoc.txt",fileSinhVien="sinhvien.txt";


        BangPhanCong bangPhanCong=new BangPhanCong(n,m);

        System.out.println();

        while(true) {
            System.out.println("-Pick your choise ->:");
            System.out.println("+,Lựa chọn 1: Nhập danh sách Lái Xe mới và lưu vào file");
            System.out.println("+,Lựa chọn 2: nhập danh sách các Tuyến và lưu vào file");
            System.out.println("+,Lựa chọn 3: QL số lượt lái mỗi tuyến của từng Lái Xe( nhập mã Lái Xe và mã Tuyến cùng với số lượt)");
            System.out.println("+,Lựa chọn 4: Sắp xếp quản lí theo họ tên Lái Xe ");
            System.out.println("+,Lựa chọn 5: Sắp xếp quản lí số lượng tuyến đảm nhận (giảm dần)");
            System.out.println("+,Lựa chọn 6: Lập bảng thống kê khoảng cách chạy xe trong ngày của mỗi lái xe");
            System.out.println("+,Lựa chọn 7: Xem tình trạng điểm của mỗi lái xe");
            System.out.println("+,Lựa chọn 8: Out !");

            System.out.print("=>hãy chọn từ 1-->8 : ");
            try{
                int choice=Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        bangPhanCong.nhapDSLaiXe(sc);
                        bangPhanCong.luuLaiXeFile("laixe.txt");
                        break;
                    case 2:
                        bangPhanCong.nhapDSTuyen(sc);
                        bangPhanCong.luuTuyenFile("tuyen.txt");
                        break;
                    case 3:
                        bangPhanCong.phanCong(sc);
                        break;
                    case 4:
                        bangPhanCong.sapXepTen();
                        bangPhanCong.trangThai();
                        break;
                    case 5:
                        bangPhanCong.sapXepSLTuyen();
                        bangPhanCong.trangThai();
                        break;
                    case 6:
                        bangPhanCong.thongKe();
                        break;
                    case 7:
                        bangPhanCong.trangThai();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("\n=> nằm ngoài phạm vi lựa chọn !!!\n");
                }
            }catch (Exception e){
                System.out.println("\nBạn đã nhập sai định dạng, hãy chọn một số nguyên từ 1->8 để sử dụng các lựa chọn !\n");

            }
        }
    }
}
