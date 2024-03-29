package Poly_Abs;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng giảng viên : ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng môn học : ");
        int m = Integer.parseInt(sc.nextLine());


        QLGiaoVienKeKhai qlGiaoVienKeKhai=new QLGiaoVienKeKhai(n,m);

        System.out.println();

        while(true) {
            System.out.println("-Pick your choise ->:");
            System.out.println("+,Lựa chọn 1: Nhập danh sách môn học mới ");
            System.out.println("+,Lựa chọn 2: nhập danh sách giảng viên mới");
            System.out.println("+,Lựa chọn 3: QL danh sách của từng giảng viên( nhập mã giảng viên và mã môn học cùng với số lớp mà giảng viên đó sẽ dạy môn học đó)");
            System.out.println("+,Lựa chọn 4: Sắp xếp quản lí theo tên giảng viên ");
            System.out.println("+,Lựa chọn 5: Sắp xếp quản lí theo số lượng tiết học giảm dần");
            System.out.println("+,Lựa chọn 6: tính thu nhập và lập bảng tính cho mỗi giảng viên");
            System.out.println("+,Lựa chọn 7: Xem tình trạng giảng dạy của giảng viên");
            System.out.println("+,Lựa chọn 8: Out !");

            System.out.print("=>hãy chọn từ 1-->8 : ");
            try{
                int choice=Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        qlGiaoVienKeKhai.nhapDSMonHoc(sc);
                        break;
                    case 2:
                        qlGiaoVienKeKhai.nhapDSGiangVien(sc);
                        break;
                    case 3:
                        qlGiaoVienKeKhai.lapBangKe(sc);
                        break;
                    case 4:
                        qlGiaoVienKeKhai.sapXepTheoTen();
                        qlGiaoVienKeKhai.xemTrangThaiCuaGVvaMH();
                        break;
                    case 5:
                        qlGiaoVienKeKhai.sapXepTheoSoTiet();
                        qlGiaoVienKeKhai.xemTrangThaiCuaGVvaMH();
                        break;
                    case 6:
                        qlGiaoVienKeKhai.tinhToan();
                        break;
                    case 7:
                        qlGiaoVienKeKhai.xemTrangThaiCuaGVvaMH();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("\n=> nằm ngoài phạm vi lựa chọn !!!\n");
                }
            }catch (Exception e){
                System.out.println("\nBạn đã nhập sai định dạng số nguyên hoặc môn học hay giảng viên không có tên , hãy chọn một số nguyên từ 1->8 để sử dụng các lựa chọn !\n");
            }
        }
    }
}
