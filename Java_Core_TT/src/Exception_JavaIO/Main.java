package Exception_JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng môn học : ");
        int m = Integer.parseInt(sc.nextLine());


        BangDiem bangDiem=new BangDiem(n,m);

        System.out.println();

        while(true) {
            System.out.println("-Pick your choise ->:");
            System.out.println("+,Lựa chọn 1: Nhập danh sách môn học mới ");
            System.out.println("+,Lựa chọn 2: nhập danh sách sinh viên mới");
            System.out.println("+,Lựa chọn 3: QL danh sách điểm của từng sinh viên( nhập mã sinh viên và mã môn học cùng với số điểm)");
            System.out.println("+,Lựa chọn 4: Sắp xếp quản lí theo tên sinh viên ");
            System.out.println("+,Lựa chọn 5: Sắp xếp quản lí theo tên môn học");
            System.out.println("+,Lựa chọn 6: Tính điểm tổng kết của mỗi sinh viên");
            System.out.println("+,Lựa chọn 7: Xem tình trạng điểm của mỗi sinh viên");
            System.out.println("+,Lựa chọn 8: Out !");

            System.out.print("=>hãy chọn từ 1-->8 : ");
            try{
                int choice=Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        bangDiem.nhapMonHoc(sc);
                        break;
                    case 2:
                        bangDiem.nhapSinhVien(sc);
                        break;
                    case 3:
                        bangDiem.nhapDiem(sc);
                        break;
                    case 4:
                        bangDiem.sapXepTheoTen();
                        bangDiem.tinhTrang();
                        break;
                    case 5:
                        bangDiem.sapXepTheoMH();
                        break;
                    case 6:
                        bangDiem.tongKet();
                        break;
                    case 7:
                        bangDiem.tinhTrang();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("\n=> nằm ngoài phạm vi lựa chọn !!!\n");
                }
            }catch (Exception e){
                System.out.println("\nBạn đã nhập sai định dạng số nguyên hoặc môn học hay sinh viên không có tên trong danh sách, hãy chọn một số nguyên từ 1->8 để sử dụng các lựa chọn !\n");
            }
        }
    }
}



