package Poly_Abs;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng giảng viên : ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng môn học : ");
        int m = Integer.parseInt(sc.nextLine());

        KeKhai keKhai=new KeKhai(n,m);

        System.out.println();

        while(true) {
            System.out.println("-Pick your choise ->:");
            System.out.println("+,Lựa chọn 1: Nhập danh sách môn học mới ");
            System.out.println("+,Lựa chọn 2: nhập danh sách giảng viên mới");
            System.out.println("+,Lựa chọn 3: QL danh sách môn học của từng giảng viên theo lớp( nhập mã giảng viên và mã môn học cùng với số lượng lớp muốn dạy cho môn học đó)");
            System.out.println("+,Lựa chọn 4: Sắp xếp quản lí theo họ tên giảng viên ");
            System.out.println("+,Lựa chọn 5: Sắp xếp quản lí theo số lượng tiết giảm dần");
            System.out.println("+,Lựa chọn 6: tính toán lập bảng tính tiền công cho mỗi giảng viên");
            System.out.println("+,Lựa chọn 7: Xem tình trạng môn học của mỗi giảng viên theo lớp");
            System.out.println("+,Lựa chọn 8: Out !");

            System.out.print("=>Chọn :");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    keKhai.nhapDSMonHoc(sc);
                    break;
                case 2:
                    keKhai.nhapDSGiangVien(sc);
                    break;
                case 3:
                    keKhai.lapBangKe(sc);
                    break;
                case 4:
                    keKhai.sapXepTheoTen();
                    break;
                case 5:
                    keKhai.sapXepTheoSoTiet();
                    break;
                case 6:
                    keKhai.tinhToan();
                    break;
                case 7:
                    keKhai.xemTrangThaiCuaGVvaMH();
                    break;
                default:
                    return;

            }
        }
    }
}
