package Encap_Inher;
import java.util.Scanner;

public class QLmuonSach {
    private static int maxDauSach=5;
    private static int maxSoLuongDauSach=3;
    private BanDoc[] banDoc;
    private Sach[] sach;
    private int[][] qLSachMuon;


    public QLmuonSach(int soLuongBanDoc,int soLuongDauSach){
        banDoc=new BanDoc[soLuongBanDoc];
        sach=new Sach[soLuongDauSach];
        qLSachMuon=new int[soLuongBanDoc][soLuongDauSach];
    }

    public void nhapDSSach(Scanner sc){
        System.out.println("\n-hãy nhập danh sách gồm "+sach.length+" đầu sách mới :");
        for(int i=0;i<sach.length;i++) {
            System.out.print("Nhập tên đầu sách thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập tên tác giả: ");
            String diachi=sc.nextLine();
            System.out.print("Nhập chuyên ngành: ");
            String sdt=sc.nextLine();
            System.out.print("Nhập năm xuất bản: ");
            String loaibandoc=sc.nextLine();
            System.out.println();
            sach[i] = new Sach(ten,diachi,sdt,loaibandoc);
        }
        System.out.println("\nDanh sách sách: ");
        for(int i=0;i<sach.length;i++){
            System.out.println(sach[i]);
        }
        System.out.println();
    }
    public void nhapDSBanDoc(Scanner sc){
        System.out.println("\n-nhập danh sách gồm "+banDoc.length+" bạn đọc mới: ");
        for(int i=0;i<banDoc.length;i++) {
            System.out.print("nhập tên bạn đọc thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("nhập địa chỉ bạn đọc: ");
            String diachi=sc.nextLine();
            System.out.print("nhập sdt bạn đọc: ");
            String sdt=sc.nextLine();
            System.out.print("Nhập loại bạn đọc: ");
            String loaibandoc=sc.nextLine();
            System.out.println();
            banDoc[i] = new BanDoc(ten,diachi,sdt,loaibandoc);
        }
        System.out.println("\nDanh sách bạn đọc: ");
        for(int i=0;i<banDoc.length;i++){
            System.out.println(banDoc[i]);
        }
        System.out.println();
    }

    public void qLMuon(Scanner sc){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("-bạn đọc hiện có:");
        for(int i=0;i<banDoc.length;i++){
            System.out.println("+, "+banDoc[i]);
        }

        System.out.println("\n-đầu sách hiện có:");
        for(int i=0;i<sach.length;i++){
            System.out.println("+, "+sach[i]);
        }

        System.out.print("\nNhập số được gắn bên cạnh tên bạn đọc để chọn bạn đọc tương ứng : ");
        int maBanDoc=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số được gắn bên cạnh tên quyển sách để chọn sách tương ứng: ");
        int maSach=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số lượng: ");
        int soLuong=Integer.parseInt(sc.nextLine());

        int cnt=0;
        for(int i=0;i<sach.length;i++){
            if(qLSachMuon[maBanDoc][i]>0){
                cnt++;
            }
            if(cnt>maxSoLuongDauSach){
                System.out.println("Không được mượn nhiều sách như thế !");
                return;
            }
        }

        if(soLuong+qLSachMuon[maBanDoc][maSach]>3){
            System.out.println("Sách này bạn đã mượn quá nhiều !");
            return;
        }
        qLSachMuon[maBanDoc][maSach]+=soLuong;
        System.out.println("Mượn sách thành công !");
        return;
    }
    public void sapXepTheoTen(){
        if(banDoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 2 !!!");
            System.out.println();
            return;
        }

        for (int i = 0; i < banDoc.length - 1; i++) {
            for (int j = i + 1; j < banDoc.length; j++) {
                if (banDoc[i].getTen().compareTo(banDoc[j].getTen()) > 0) {
                    BanDoc tempBanDoc = banDoc[i];
                    banDoc[i] = banDoc[j];
                    banDoc[j] = tempBanDoc;

                    String tmpID=banDoc[i].getId();
                    banDoc[i].setId(banDoc[j].getId());
                    banDoc[j].setId(tmpID);

                    Sach tmpSach=sach[i];
                    sach[i]=sach[j];
                    sach[j]=tmpSach;

                    String tmpIDsach=sach[i].getId();
                    sach[i].setId(sach[j].getId());
                    sach[j].setId(tmpIDsach);

                    int[] temp = qLSachMuon[i];
                    qLSachMuon[i] = qLSachMuon[j];
                    qLSachMuon[j] = temp;
                }
            }
        }
    }
    public void sapXepTheoSoLuongMuon(){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        for(int i=0;i<banDoc.length-1;i++){
            for(int j=i+1;j<banDoc.length;j++){
                int sum=0,sum1=0;
                for(int l=0;l<sach.length;l++){
                    sum+=qLSachMuon[i][l];
                    sum1+=qLSachMuon[j][j];
                }
                if(sum<sum1){
                    BanDoc tmpBanDoc=banDoc[i];
                    banDoc[i]=banDoc[j];
                    banDoc[j]=tmpBanDoc;

                    String tmpID=banDoc[i].getId();
                    banDoc[i].setId(banDoc[j].getId());
                    banDoc[j].setId(tmpID);


                    Sach tmpSach=sach[i];
                    sach[i]=sach[j];
                    sach[j]=tmpSach;

                    String tmpIDsach=sach[i].getId();
                    sach[i].setId(sach[j].getId());
                    sach[j].setId(tmpIDsach);

                    int[] temp = qLSachMuon[i];
                    qLSachMuon[i] = qLSachMuon[j];
                    qLSachMuon[j] = temp;
                }
            }
        }
    }

    public void timKiemTheoTen(Scanner sc){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.print("Nhập tên bạn đọc muốn tìm kiếm: ");
        String name= sc.nextLine();
        for(int i=0;i<banDoc.length;i++){
            if(banDoc[i].getTen().compareTo(name)==0){
                System.out.println("Bạn đọc "+banDoc[i].getId()+"-"+banDoc[i].getTen()+" đã mượn những đầu sách sau:");
                for(int j=0;j<sach.length;j++){
                    if(qLSachMuon[i][j]>0){
                        System.out.println(sach[j].getId()+"-"+sach[j].getTen()+" --> "+qLSachMuon[i][j]+"quyển");
                    }
                }
                return;
            }
        }
        System.out.println("Bạn đọc không có tên trong danh sách !");
        return;
    }
    public void hienThiDanhSach(){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("\n* Trạng thái của các bạn đọc:");
        for(int i=0;i<banDoc.length;i++){
            System.out.println("-Bạn đọc "+banDoc[i].getTen().toUpperCase() +" đã mượn những đầu sách sau:");
            for(int j=0;j<sach.length;j++){
                if(qLSachMuon[i][j]>0){
                    System.out.println("  +, "+sach[j].getTen().toUpperCase()+" --> "+qLSachMuon[i][j]+"quyển");
                }
            }
            System.out.println();
        }
        System.out.println();
        }
}
