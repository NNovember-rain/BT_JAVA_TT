package Exception_JavaIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Scanner;

public class BangDiem implements QLIMPL{

    private MonHoc[] monHoc;
    private SinhVien[] sinhVien;
    private int[][] qLBangDiem;

    public BangDiem(int slSinhVien,int slMonHoc) {
        monHoc=new MonHoc[slMonHoc];
        sinhVien=new SinhVien[slSinhVien];
        qLBangDiem=new int[slSinhVien][slMonHoc];
    }


    @Override
    public void nhapSinhVien(Scanner sc) {
        SinhVien[] sinhVientmp=new SinhVien[sinhVien.length];
        System.out.println("\n-hãy nhập danh sách gồm "+sinhVien.length+" sinh viên mới :");
        for(int i=0;i<sinhVien.length;i++) {
            System.out.print("Nhập tên sinh viên thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập địa chỉ sinh viên: ");
            String diachi=sc.nextLine();
            System.out.print("Nhập Sđt: ");
            String sdt=sc.nextLine();
            System.out.print("Nhập lớp của sinh viên: ");
            String lop=sc.nextLine();
            System.out.println();
            sinhVientmp[i] = new SinhVien(ten,diachi,sdt,lop);
        }
        try{
            FileOutputStream fileOut=new FileOutputStream("sinhvien.txt");
            ObjectOutputStream objectOut=new ObjectOutputStream(fileOut);
            FileInputStream fileIn=new FileInputStream("sinhvien.txt");
            ObjectInputStream objectIn=new ObjectInputStream(fileIn);

            //ghi
            objectOut.writeObject(sinhVientmp);
            objectOut.close();
            fileOut.close();

            //đọc
            sinhVien=(SinhVien[])objectIn.readObject();
            objectIn.close();
            fileIn.close();

            for(int i=0;i<sinhVien.length;i++){
                System.out.println(sinhVien[i]);
            }
            System.out.println();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void nhapMonHoc(Scanner sc) {
        MonHoc[] monHoctmp=new MonHoc[monHoc.length];
        System.out.println("\n-hãy nhập danh sách gồm "+monHoc.length+" môn học mới :");
        for(int i=0;i<sinhVien.length;i++) {
            System.out.print("Nhập tên môn học thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập số đơn vị học trình: ");
            int dvht=Integer.parseInt(sc.nextLine());
            System.out.print("Nhập loại môn: ");
            String loai=sc.nextLine();
            System.out.println();
            monHoctmp[i] = new MonHoc(ten,dvht,loai);
        }
        try{
            FileOutputStream fileOut=new FileOutputStream("monhoc.txt");
            ObjectOutputStream objectOut=new ObjectOutputStream(fileOut);
            FileInputStream fileIn=new FileInputStream("monhoc.txt");
            ObjectInputStream objectIn=new ObjectInputStream(fileIn);

            //ghi
            objectOut.writeObject(monHoctmp);
            objectOut.close();
            fileOut.close();

            //đọc
            monHoc=(MonHoc[])objectIn.readObject();
            objectIn.close();
            fileIn.close();

            for(int i=0;i<monHoc.length;i++){
                System.out.println(monHoc[i]);
            }
            System.out.println();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void nhapDiem(Scanner sc) {
        if(sinhVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("-sinh viên hiện có:");
        for(int i=0;i<sinhVien.length;i++){
            System.out.println("+, "+sinhVien[i]);
        }

        System.out.println("\n-môn học hiện có:");
        for(int i=0;i<monHoc.length;i++){
            System.out.println("+, "+monHoc[i]);
        }

        System.out.print("\nNhập số được gắn bên cạnh tên sinh viên để chọn sinh viên tương ứng : ");
        int maSinhVien=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số được gắn bên cạnh tên môn học để chọn môn học tương ứng: ");
        int maMonHoc=Integer.parseInt(sc.nextLine());
        if(qLBangDiem[maSinhVien][maMonHoc]>0) {
            System.out.println("\nBạn chỉ có thể chấm điểm 1 môn cho 1 bạn sinh viên !");
            System.out.println("=>Bạn đã chấm điểm môn "+ monHoc[maMonHoc]+" cho bạn sinh viên "+sinhVien[maSinhVien]+" với số điểm là: "+qLBangDiem[maSinhVien][maMonHoc]+"\n");
            return;
        }
        int sodiem;
        do{
            System.out.print("Nhập điểm: ");
            sodiem=Integer.parseInt(sc.nextLine());
            if(sodiem>10) System.out.println("bạn chỉ có thể chấm điểm từ 0->10 điểm , hãy chấm lại lại !");
        }while(sodiem>10);

        qLBangDiem[maSinhVien][maMonHoc]=sodiem;
        System.out.println(qLBangDiem[maSinhVien][maMonHoc]);

    }

    @Override
    public void sapXepTheoTen() {
        if(sinhVien[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 2 !!!");
            System.out.println();
            return;
        }

        for (int i = 0; i < sinhVien.length - 1; i++) {
            for (int j = i + 1; j < sinhVien.length; j++) {
                if (sinhVien[i].getTen().compareTo(sinhVien[j].getTen()) > 0) {
                    SinhVien tempSinhVien = sinhVien[i];
                    sinhVien[i] = sinhVien[j];
                    sinhVien[j] = tempSinhVien;

                    String tmpID=sinhVien[i].getId();
                    sinhVien[i].setId(sinhVien[j].getId());
                    sinhVien[j].setId(tmpID);

                    MonHoc tmpMonHoc=monHoc[i];
                    monHoc[i]=monHoc[j];
                    monHoc[j]=tmpMonHoc;

                    String tmpIDmonHoc=monHoc[i].getId();
                    monHoc[i].setId(monHoc[j].getId());
                    monHoc[j].setId(tmpIDmonHoc);

                    int[] temp = qLBangDiem[i];
                    qLBangDiem[i] = qLBangDiem[j];
                    qLBangDiem[j] = temp;
                }
            }
        }
    }

    @Override
    public void sapXepTheoMH() {
        if(sinhVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }

        for (int i = 0; i < monHoc.length - 1; i++) {
            for (int j = i + 1; j < monHoc.length; j++) {
                if (monHoc[i].getTen().compareTo(monHoc[j].getTen()) > 0) {
                    SinhVien tempSinhVien = sinhVien[i];
                    sinhVien[i] = sinhVien[j];
                    sinhVien[j] = tempSinhVien;

                    String tmpID=sinhVien[i].getId();
                    sinhVien[i].setId(sinhVien[j].getId());
                    sinhVien[j].setId(tmpID);

                    MonHoc tmpMonHoc=monHoc[i];
                    monHoc[i]=monHoc[j];
                    monHoc[j]=tmpMonHoc;

                    String tmpIDmonHoc=monHoc[i].getId();
                    monHoc[i].setId(monHoc[j].getId());
                    monHoc[j].setId(tmpIDmonHoc);

                    int[] temp = qLBangDiem[i];
                    qLBangDiem[i] = qLBangDiem[j];
                    qLBangDiem[j] = temp;
                }
            }
        }
    }

    @Override
    public void tinhTrang() {
        if(sinhVien[0]==null || monHoc[0]==null){
            System.out.println("Hình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("\n* Trạng thái của các sinh viên:");
        for(int i=0;i<sinhVien.length;i++){
            System.out.println("-sinh viên "+sinhVien[i].getTen().toUpperCase() +" có điểm số cho từng môn học như sau:");
            for(int j=0;j<monHoc.length;j++){
                if(qLBangDiem[i][j]>0){
                    System.out.println("  +, "+monHoc[j].getTen().toUpperCase()+" --> "+qLBangDiem[i][j]+" điểm");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void tongKet() {

    }
}
