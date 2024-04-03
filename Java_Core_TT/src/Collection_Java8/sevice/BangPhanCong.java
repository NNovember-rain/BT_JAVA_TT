package Collection_Java8.sevice;

import Collection_Java8.PhanCongIMPL;
import Collection_Java8.entity.LaiXe;
import Collection_Java8.entity.Tuyen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;



public class BangPhanCong implements PhanCongIMPL {
    private int soluotMax=15;
    private int sLLaiXe; //số lượng lái xe
    private int sLTuyen; // số lượng tuyến
    private ArrayList<LaiXe> laiXe; // danh sách lái xe
    private ArrayList<Tuyen> tuyen; // danh sách tuyến
    private Map<LaiXe,ArrayList<Tuyen>>phanCongTuyen; // ý tường là , tạo map<LaiXe,ArrayList<Tuyen>> lưu key là 1 lái xe ứng với 1 list các tuyến
    private Map<String,Map<String,Integer>>phanCongLuotLai ; // tạo thêm  map<String,Map<String,Integer>>  lưu key là mã lái xe ứng với value là cặp mã tuyến và số lượt

    public BangPhanCong(int sLLaiXe, int sLTuyen) {
        this.sLLaiXe = sLLaiXe;
        this.sLTuyen = sLTuyen;
        laiXe=new ArrayList<>();
        tuyen=new ArrayList<>();
        phanCongTuyen =new HashMap<>();
        phanCongLuotLai=new HashMap<>();
    }

    @Override
    public void nhapDSLaiXe(Scanner sc) {
        System.out.println("\n-hãy nhập danh sách gồm "+sLLaiXe+" lái xe mới :");
        for(int i=0;i<sLLaiXe;i++) {
            System.out.print("Nhập tên lái xe thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập địa chỉ lái xe: ");
            String diachi=sc.nextLine();
            System.out.print("Nhập Sđt: ");
            String sdt=sc.nextLine();
            System.out.print("Nhập trình độ: ");
            String trinhDo=sc.nextLine();
            System.out.println();
            LaiXe lx = new LaiXe(ten,diachi,sdt,trinhDo);
            laiXe.add(lx);
            phanCongTuyen.put(lx,null);
        }
        System.out.println("-Danh sách lái xe: ");
        for(int i=0;i<sLLaiXe;i++){
            System.out.println(" +," + laiXe.get(i));
        }
        System.out.println();
    }

    @Override
    public void nhapDSTuyen(Scanner sc) {
        if (laiXe.isEmpty()) {
            System.out.println("\nhãy chọn thao tác 1 trước !\n");
            return;
        }

        System.out.println("\n-hãy nhập danh sách gồm "+sLTuyen+" tuyến mới :");
        for(int i=0;i<sLTuyen;i++) {
            System.out.print("Nhập khoảng cách tuyến thứ "+(i+1)+": ");
            int khoangCach=Integer.parseInt(sc.nextLine());
            System.out.print("Nhập số điểm dừng: ");
            int sLDiemDung=Integer.parseInt(sc.nextLine());
            System.out.println();
            Tuyen t=new Tuyen(khoangCach,sLDiemDung);
            tuyen.add(t);
        }
        System.out.println("-Danh sách tuyến:");
        for(int i=0;i<sLTuyen;i++){
            System.out.println(" +,"+ tuyen.get(i));
        }
        System.out.println();

        for(int i=0;i<sLLaiXe;i++){
            phanCongTuyen.put(laiXe.get(i),tuyen);
        }
    }

    @Override
    public void luuLaiXeFile(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(s))) {
            for (int i = 0; i < sLLaiXe; i++) {
                writer.write( laiXe.get(i).getId()+"-"+ laiXe.get(i).getTen()+"-"+ laiXe.get(i).getDiaChi()+"-"+ laiXe.get(i).getSoDT()+"-"+ laiXe.get(i).getTrinhDo()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void luuTuyenFile(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(s))) {
            for (int i = 0; i < sLTuyen; i++) {
                writer.write( tuyen.get(i).getId()+"-"+tuyen.get(i).getKhoangCach()+"-"+tuyen.get(i).getSoDiemDung()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void phanCong(Scanner sc) {
        if(laiXe.isEmpty() || tuyen.isEmpty()){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        System.out.println("\n-Lai xe hiện có:");
        for(int i=0;i<sLLaiXe;i++){
            System.out.println("+, "+laiXe.get(i));
        }

        System.out.println("\n-Tuyến hiện có:");
        for(int i=0;i<sLTuyen;i++){
            System.out.println("+, "+ tuyen.get(i));
        }

        String maLaiXe; // nhập mã lái xe
        do{
            System.out.print("\nNhập mã người lái xe muốn giao : ");
            maLaiXe=sc.nextLine();
            if(maLaiXe.length()!=5) System.out.println("! hãy nhập đúng định dạng gồm 5 chữ số !");
        }while(maLaiXe.length()!=5);

        String maTuyen; // nhập mã tuyến
        do{
            System.out.print("Nhập mã tuyến muốn giao: ");
            maTuyen=sc.nextLine();
            if(maTuyen.length()!=3) System.out.println("! hãy nhập đúng định dạng gồm 3 chữ số !");
        }while(maTuyen.length()!=3);

        System.out.print("Nhập số lượt lái của tuyến trong ngày :"); // nhập số lượt
        int soLuotTrongNgay=Integer.parseInt(sc.nextLine());
        if(soLuotTrongNgay>soluotMax){
            System.out.println("\nBạn đã lái đủ tuyến này trong ngày hôm nay rồi !!!\n");
            return;
        }


        // check xem mã lái xe và mã tuyến có tồn tại không
        if(Integer.parseInt(maLaiXe)>=sLLaiXe || Integer.parseInt(maTuyen)>=sLTuyen) {
            System.out.println("\nLái xe hoặc tuyến không tồn tại ,hãy chọn lại thao tác 3 để phân công lại !!!\n");
            return;
        }


        // phanCongLuotLai lưu key là mã lái xe ứng với value là cặp mã tuyến và số lượt
        // check xem thằng mã lái xe đã nằm trong map chưa
        if(phanCongLuotLai.containsKey(maLaiXe)){
            Map<String,Integer> mp=  phanCongLuotLai.get(maLaiXe); // mp lấy cái map<String,Integer> lưu mã tuyến và số lượt tương ứng
            if(mp.get(maTuyen)!=null) {
                if ((mp.get(maTuyen) + soLuotTrongNgay) > soluotMax) { // check quá giới hạn
                    System.out.println("\nBạn đã lái đủ tuyến này trong ngày hôm nay rồi !!!\n");
                    return;
                }
                mp.put(maTuyen, soLuotTrongNgay + mp.get(maTuyen)); // nếu tồn tại cả mã lái xe và mã tuyến rồi thì cập nhật
                phanCongLuotLai.put(maLaiXe, mp);
            }
            else {
                mp.put(maTuyen, soLuotTrongNgay); // trường hợp này rơi vào nếu trước đó ta chọn thằng lái xe 00000 với tuyến 001 , lần sau chọn tiếp thằng 00000 với 001 mp.get(maTuyen) sẽ null gây lỗi
                phanCongLuotLai.put(maLaiXe, mp);
            }
        }
        else{ // thêm vào
            Map<String,Integer> mp=new HashMap<>();
            mp.put(maTuyen,soLuotTrongNgay);
            phanCongLuotLai.put(maLaiXe,mp);
        }

        System.out.println("\nPhân công được chấp thuận !\n");

    }

    @Override
    public void sapXepTen() {
        if(laiXe.isEmpty() || tuyen.isEmpty()){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        Collections.sort(laiXe, new Comparator<LaiXe>() {
            @Override
            public int compare(LaiXe o1, LaiXe o2) {
                return o1.getTen().compareTo(o2.getTen());
            }
        });
    }

    public int cntTuyen(LaiXe x){
        int cnt=0;
        if(phanCongLuotLai.get(x.getId())==null) return 0;
        for(int i=0;i<sLTuyen;i++){
            if(phanCongLuotLai.get(x.getId()).get(tuyen.get(i).getId())!=null) cnt++;
        }
        return cnt;
    }
    @Override
    public void sapXepSLTuyen() {
        if(laiXe.isEmpty() || tuyen.isEmpty()){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        Collections.sort(laiXe, new Comparator<LaiXe>() {
            @Override
            public int compare(LaiXe o1, LaiXe o2) {
                if(cntTuyen(o1)>cntTuyen(o2)) return -1;
                else return 1;
            }
        });
    }

    @Override
    public void trangThai() {
        if(laiXe.isEmpty() || tuyen.isEmpty()){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        for(LaiXe lx:laiXe){
            System.out.println("\n-Phân công cho lái xe "+lx.getId()+"-"+lx.getTen()+" là:");
            for(Tuyen t:tuyen){
                if(phanCongLuotLai.containsKey(lx.getId()) && phanCongLuotLai.get(lx.getId()).containsKey(t.getId())){
                    System.out.println(" +,Số lượt cho tuyến "+t.getId()+": "+phanCongLuotLai.get(lx.getId()).get(t.getId())+" lượt");
                }
                else System.out.println(" +,Tuyến "+t.getId()+" chưa được phân công");
            }
        }
        System.out.println();
    }

    @Override
    public void thongKe() {
        if(laiXe.isEmpty() || tuyen.isEmpty()){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        for(int i=0;i<sLLaiXe;i++) {
            int total = 0;
            System.out.println("\nPhân công cho lái xe "+ laiXe.get(i).getId()+"-"+laiXe.get(i).getTen()+" là:");
            if(phanCongLuotLai.get(laiXe.get(i).getId())!=null){
                for (int j = 0; j < sLTuyen; j++) {
                    if (phanCongLuotLai.get(laiXe.get(i).getId()).get(tuyen.get(j).getId()) != null) {
                        int soLuot=phanCongLuotLai.get(laiXe.get(i).getId()).get(tuyen.get(j).getId());
                        int khoangCach=soLuot*tuyen.get(j).getKhoangCach();
                        System.out.println(" +,Tuyến "+ tuyen.get(j).getId()+" có khoảng cách là "+tuyen.get(j).getKhoangCach() +" số lượt là "+soLuot +"=> đường đi của tuyến: "+khoangCach);
                        total+=khoangCach;
                    }
                    else{
                        System.out.println(" +,tuyến "+tuyen.get(j).getId() +" chưa được phân công ");
                    }
                }
                System.out.println("=>Tổng hành trình phải đi là :"+ total);
            }
            else {
                System.out.println("Lái xe "+laiXe.get(i).getId()+"-"+laiXe.get(i).getTen()+" chưa được phân tuyến !");
            }
            System.out.println();
        }
    }
}
