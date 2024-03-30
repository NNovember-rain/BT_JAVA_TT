package Exception_JavaIO.service;

import Exception_JavaIO.QLIMPL;
import Exception_JavaIO.entity.MonHoc;
import Exception_JavaIO.entity.SinhVien;

import java.io.*;
import java.util.Scanner;

public class BangDiem implements QLIMPL {

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
            sinhVien[i] = new SinhVien(ten,diachi,sdt,lop);
        }
        System.out.println("-Danh sách sinh viên: ");
        for(int i=0;i<sinhVien.length;i++){
            System.out.println(" +,"+sinhVien[i]);
        }
        System.out.println();

    }

    @Override
    public void nhapMonHoc(Scanner sc) {
        System.out.println("\n-hãy nhập danh sách gồm "+monHoc.length+" môn học mới :");
        for(int i=0;i<monHoc.length;i++) {
            System.out.print("Nhập tên môn học thứ "+(i+1)+": ");
            String ten=sc.nextLine();
            System.out.print("Nhập số đơn vị học trình: ");
            int dvht=Integer.parseInt(sc.nextLine());
            System.out.print("Nhập loại môn: ");
            String loai=sc.nextLine();
            System.out.println();
            monHoc[i] = new MonHoc(ten,dvht,loai);
        }
        System.out.println("-Danh sách môn học:");
        for(int i=0;i<monHoc.length;i++){
            System.out.println(" +,"+monHoc[i]);
        }
        System.out.println();

    }

    @Override
    public void nhapDiem(Scanner sc) {
        if(sinhVien[0]==null || monHoc[0]==null){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("\n-sinh viên hiện có:");
        for(int i=0;i<sinhVien.length;i++){
            System.out.println("+, "+Integer.parseInt(sinhVien[i].getId())+"-"+sinhVien[i].getTen());
        }

        System.out.println("\n-môn học hiện có:");
        for(int i=0;i<monHoc.length;i++){
            System.out.println("+, "+Integer.parseInt(monHoc[i].getId())+"-"+monHoc[i].getTen());
        }

        System.out.print("\nNhập số được gắn bên cạnh tên sinh viên để chọn sinh viên tương ứng : ");
        int maSinhVien=Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số được gắn bên cạnh tên môn học để chọn môn học tương ứng: ");
        int maMonHoc=Integer.parseInt(sc.nextLine());
        if(qLBangDiem[maSinhVien][maMonHoc]>0) {
            System.out.println("\nBạn chỉ có thể chấm điểm 1 môn cho 1 bạn sinh viên !");
            System.out.println("=>Bạn đã chấm điểm môn "+ monHoc[maMonHoc].getTen().toUpperCase()+" cho bạn sinh viên "+sinhVien[maSinhVien].getTen().toUpperCase()+" với số điểm là: "+qLBangDiem[maSinhVien][maMonHoc]+"\n");
            return;
        }
        int sodiem;
        do{
            System.out.print("Nhập điểm: ");
            sodiem=Integer.parseInt(sc.nextLine());
            if(sodiem>10) System.out.println("bạn chỉ có thể chấm điểm từ 0->10 điểm , hãy chấm lại lại !");
        }while(sodiem>10);
        qLBangDiem[maSinhVien][maMonHoc]=sodiem;
        System.out.println("nhập điểm thành công !");
        System.out.println();

    }

    @Override
    public void sapXepTheoTen() {
        if(sinhVien[0]==null){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 2 !!!");
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
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println();
        for (int i = 0; i < monHoc.length; i++) {
            System.out.println("Môn học "+monHoc[i].getTen().toUpperCase()+" :");
            for(int j=0;j<sinhVien.length;j++){
                boolean check=false;
                if(qLBangDiem[j][i]>0){
                    check=true;
                    System.out.println(" +, sinh viên "+ sinhVien[j].getTen().toUpperCase()+" có số điểm cho môn này là: "+qLBangDiem[j][i]);
                }
                if(!check) System.out.println(" +, sinh viên "+sinhVien[j].getTen().toUpperCase()+ " chưa có điểm môn này !");
            }

        }
        System.out.println();
    }

    @Override
    public void tongKet() {
        System.out.println();
        for (int i = 0; i < sinhVien.length; i++) {
            System.out.println("Sinh viên "+sinhVien[i].getTen().toUpperCase()+" có những đầu điểm sau :");
            int tongHocTrinh=0;
            int tongDiemTichLuy=0;
            boolean check=false;
            for(int j=0;j<monHoc.length;j++){
                if(qLBangDiem[i][j]>0){
                    check=true;
                    System.out.println(" +, môn "+ monHoc[j].getTen().toUpperCase()+" số học trình là "+monHoc[j].getdVHocTrinh()+" học trình với số điểm cho môn này là : "+qLBangDiem[i][j]+" điểm");
                    tongHocTrinh+=monHoc[j].getdVHocTrinh();
                    tongDiemTichLuy+=qLBangDiem[i][j]*monHoc[j].getdVHocTrinh();
                }
            }
            if(check) {
                System.out.print("=>Tổng kết :"+String.format("%.2f",(double)tongDiemTichLuy/tongHocTrinh)+"\n");
            }
            else System.out.println("Bạn này chưa có điểm cho môn học nào !\n");
        }
        System.out.println();
    }

    @Override
    public void luuSVVaoFile(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(s))) {
            for (int i = 0; i < sinhVien.length; i++) {
                writer.write( sinhVien[i].getId()+"-"+sinhVien[i].getTen()+"-"+sinhVien[i].getDiachi()+"-"+sinhVien[i].getSdt()+"-"+sinhVien[i].getLop()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void luuMHVaoFile(String s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(s))) {
            for (int i = 0; i < monHoc.length; i++) {
                writer.write( monHoc[i].getId()+"-"+monHoc[i].getTen()+"-"+monHoc[i].getLoaiMon()+"-"+monHoc[i].getdVHocTrinh()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void tinhTrang() {
        if(sinhVien[0]==null || monHoc[0]==null){
            System.out.println("\nHình như bạn quên chưa chọn thao tác 1 hoặc 2 !!!");
            System.out.println();
            return;
        }
        System.out.println("\n* Trạng thái của các sinh viên:\n");
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

}
