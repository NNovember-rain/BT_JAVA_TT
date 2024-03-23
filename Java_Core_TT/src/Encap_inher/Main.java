package Encap_inher;




import java.util.Scanner;

// ý tưởng là tạo 1 class qlMuonSach để lưu 2 class là Sach và BanDoc và lưu số lượng mượn sách của bạn đọc tương ứng với quyển sách đó, thêm một biến static để lưu kích cỡ của mảng đối tượng QLMuon Sach mỗi khi ta thêm 1 phần tử mới
// sắp xếp và tìm kiếm trên mảng đối tượng QLMuonSach
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng bạn đọc : ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng sách : ");
        int m = Integer.parseInt(sc.nextLine());

        ChoMuon choMuon=new ChoMuon(n,m);

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

            System.out.print("=>Chọn :");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    choMuon.nhapDSSach(sc);
                    break;
                case 2:
                    choMuon.nhapDSBanDoc(sc);
                    break;
                case 3:
                    choMuon.qlChoMuon(sc);
                    break;

                case 4:
                    choMuon.sapXepTheoTen();
                    break;
                case 5:
                    choMuon.sapXepTheoSoLuongMuon();
                    break;
                case 6:
                    choMuon.timKiemTheoTen(sc);
                    break;
                case 7:
                    choMuon.hienThiTrangThai();
                    break;
                default:
                    return;

            }
        }
    }
}
