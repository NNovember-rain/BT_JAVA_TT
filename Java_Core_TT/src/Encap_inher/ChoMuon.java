package Encap_inher;

import java.util.Scanner;

public class ChoMuon {
    private int size=0; // kích cỡ của mảng đối tượng QLMuonSach sau mỗi lần có thêm bạn đọc mượn sách
    private BanDoc[] banDoc;
    private Sach[] sach;
    private QLMuonSach[] qlMuonSach;

    public ChoMuon(int slBanDoc, int slDauSach) {
        this.banDoc = new BanDoc[slBanDoc];
        this.sach = new Sach[slDauSach];
        this.qlMuonSach=new QLMuonSach[slBanDoc*5]; // kích cỡ *5 , bởi 1 bạn đọc  chỉ có thế mượn 5 đầu sách khác nhau nên tối đa sẽ là slBanDoc*5
    }

    public void nhapDSSach(Scanner sc){
        System.out.println("hãy nhập "+sach.length+" đầu sách mới :");
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
    }
    public void nhapDSBanDoc(Scanner sc){
        System.out.println("-nhập danh sách bạn đọc: ");
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
    }

    public void qlChoMuon(Scanner sc){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }


        System.out.print("Nhập mã bạn đọc VD(00001): ");
        int maBanDoc=Integer.parseInt(sc.nextLine());

        System.out.print("Nhập mã sách VD(00001): ");
        int maSach=Integer.parseInt(sc.nextLine());

        System.out.print("Nhập số lượng mượn đầu sách này : ");
        int soLuongMuon=Integer.parseInt(sc.nextLine());
        System.out.println("");

        boolean checkBanDoc=false,checkSach=false; // check xem quyển sách và bạn đọc có tồn tại trong mảng k.
        BanDoc b=new BanDoc();
        Sach s=new Sach();
        for(int i=0;i<banDoc.length;i++){
            if(Integer.parseInt(banDoc[i].getId())==maBanDoc) {
                checkBanDoc=true;
                b=banDoc[i];
                break;
            }
        }
        for(int i=0;i<sach.length;i++){
            if(Integer.parseInt(sach[i].getId())==maSach) {
                checkSach=true;
                s=sach[i];
                break;
            }
        }
        if(!checkBanDoc || !checkSach ){
            System.out.println("Bạn đọc hoặc Sách không tồn tại !");
            return;
        }

        // bởi vì max của 1 thằng chỉ mượn tối đa 5 đầu sách nên em sẽ chỉ
        // chia làm 2 TH : 1, nếu mượn đủ bằng đúng 5 quyển rồi thì check xem quyển sách đang muốn mượn có nằm trong số sách đã mượn chưa , nếu rồi thì check tiếp xem quyển sách này đã mượn quá 3 lần chưa, nếu chưa thì ta chỉ cần cộng thêm số lượng;
        if(b.getSoDauSachDaMuon()==5){
            for(int i=0;i<size;i++){
                if(qlMuonSach[i].getBanDoc().getId()== b.getId() && qlMuonSach[i].getSach().getId()==s.getId()){
                    if(qlMuonSach[i].getSoLuong()+soLuongMuon>3) {
                        System.out.println("Không được mượn đầu sách này nhiều thế !");
                        System.out.println();
                        return;
                    }
                    else{
                        qlMuonSach[i].setSoLuong(qlMuonSach[i].getSoLuong()+soLuongMuon);
                        System.out.println("Mượn sách thành công !");
                        System.out.println();
                        return;
                    }
                }
            }
            System.out.println("Bạn đã đủ số đầu sách !");
            System.out.println();
            return;
        }
        //      2, nếu số lượng đầu sách đã mượn nhỏ hơn 5 , thì ta sẽ check đúng như trên nhưng nếu nó chưa nằm trong danh sách quản lí và số lượng mượn <3 thì ta sẽ thêm nó vào DS QLmuonSach đồng thời tăng size
        else if(b.getSoDauSachDaMuon()<5){
            for(int i=0;i<size;i++){
                if(qlMuonSach[i].getBanDoc().getId()== b.getId() && qlMuonSach[i].getSach().getId()==s.getId()){
                    if(qlMuonSach[i].getSoLuong()+soLuongMuon>3) {
                        System.out.println("Không được mượn đầu sách này nhiều thế !");
                        System.out.println();
                        return;
                    }
                    else{
                        qlMuonSach[i].setSoLuong(qlMuonSach[i].getSoLuong()+soLuongMuon);
                        System.out.println("Mượn sách thành công !");
                        System.out.println();
                        return;
                    }
                }

            }
            // nếu như nó không nằm trong list ds quản lí thì chỉ cần set cho nó với 3 nếu nhỏ hơn thì tức là quyển sách này lần đầu người đọc mượn
            if(soLuongMuon>3) {
                System.out.println("Không được mượn đầu sách này nhiều thế !");
                System.out.println();
                return;
            }
            else {
                b.setSoDauSachDaMuon(b.getSoDauSachDaMuon()+1);// thêm
                qlMuonSach[size]=new QLMuonSach(b,s,soLuongMuon);
                size++;

            }
            return;
        }
    }

    public void sapXepTheoTen(){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(qlMuonSach[i].getBanDoc().getTen().compareToIgnoreCase(qlMuonSach[j].getBanDoc().getTen())>0){
                    QLMuonSach tmp=qlMuonSach[i];
                    qlMuonSach[i]=qlMuonSach[j];
                    qlMuonSach[j]=tmp;
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(qlMuonSach[i]);
        }
        System.out.println("sắp xếp theo tên thành công\n");
        return;
    }

    public void sapXepTheoSoLuongMuon(){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(qlMuonSach[i].getSoLuong()<qlMuonSach[j].getSoLuong()){
                    QLMuonSach tmp=qlMuonSach[i];
                    qlMuonSach[i]=qlMuonSach[j];
                    qlMuonSach[j]=tmp;
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.println(qlMuonSach[i]);
        }
        System.out.println("sắp xếp theo số lượng thành công\n");
        return;
    }

    public void timKiemTheoTen(Scanner sc){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        String name=sc.nextLine();
        boolean check=false;
        for(int i=0;i<size;i++){
            if(qlMuonSach[i].getBanDoc().getTen().equals(name)){
                System.out.println(qlMuonSach[i]);
                check=true;
            }
        }
        if(!check) System.out.println("Bạn này chưa mượn sách !");
        return;
    }

    public void hienThiTrangThai(){
        if(banDoc[0]==null || sach[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        System.out.println("Tình trạng mượn sách của mỗi bạn đọc:");
        for(int i=0;i<size;i++){
            System.out.println(qlMuonSach[i]);
        }
        System.out.println();
        return;
    }
}
