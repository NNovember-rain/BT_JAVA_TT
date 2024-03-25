package Encap_Inher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng bạn đọc : ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng sách : ");
        int m = Integer.parseInt(sc.nextLine());


        QLmuonSach qLmuonSach=new QLmuonSach(n,m);

        System.out.println();

        while(true) {
            System.out.println("-Pick your choise ->:");
            System.out.println("+,Lựa chọn 1: Nhập danh sách đầu sách mới ");
            System.out.println("+,Lựa chọn 2: nhập danh sách bạn đọc mới");
            System.out.println("+,Lựa chọn 3: QL danh sách của từng bạn đọc( nhập mã bạn đọc và mã sách cùng với lượng mượn cuốn sách đó)");
            System.out.println("+,Lựa chọn 4: Sắp xếp quản lí theo tên bạn đọc ");
            System.out.println("+,Lựa chọn 5: Sắp xếp quản lí theo số lượng sách được mượn giảm dần");
            System.out.println("+,Lựa chọn 6: Tìm kiếm và hiển thị danh sách mượn theo tên bạn đọc");
            System.out.println("+,Lựa chọn 7: Xem tình trạng mượn sách của mỗi bạn đọc");
            System.out.println("+,Lựa chọn 8: Out !");

            System.out.print("=>hãy chọn từ 1-->8 : ");
            try{
                int choice=Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        qLmuonSach.nhapDSSach(sc);
                        break;
                    case 2:
                        qLmuonSach.nhapDSBanDoc(sc);
                        break;
                    case 3:
                        qLmuonSach.qLMuon(sc);
                        break;
                    case 4:
                        qLmuonSach.sapXepTheoTen();
                        qLmuonSach.hienThiDanhSach();
                        break;
                    case 5:
                        qLmuonSach.sapXepTheoSoLuongMuon();
                        qLmuonSach.hienThiDanhSach();
                        break;
                    case 6:
                        qLmuonSach.timKiemTheoTen(sc);
                        break;
                    case 7:
                        qLmuonSach.hienThiDanhSach();
                        break;
                    case 8:
                        return;
                    default:
                        System.out.println("\n=> nằm ngoài phạm vi lựa chọn !!!\n");
                }
            }catch (Exception e){
                System.out.println("\nBạn đã nhập sai định dạng số nguyên hoặc quyển sách hay người đọc không có tên , hãy chọn một số nguyên từ 1->8 để sử dụng các lựa chọn !\n");
            }
        }
    }
}
