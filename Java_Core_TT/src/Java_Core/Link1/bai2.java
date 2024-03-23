package Java_Core.Link1;

import java.util.Scanner;

public class bai2 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int cnt = 0;
        int x = sc.nextInt();

        //CÓ thể viết hàm thay thế cho Math.sqrt() như hàm squareRoot()
        for(int i = 1; i <= Math.sqrt(x); i++){
            if(x%i==0){
                System.out.print(i+" ");
                cnt+=1;
                if((x/i)!=i){
                    System.out.print(x/i+" ");
                    cnt+=1;
                }
            }
        }
        System.out.println("\nso luong uoc la: "+cnt);
    }

    //Hàm tính căn bậc 2
    public static double squareRoot(double x) {
        double result = x / 2;
        double epsilon = 0.00001; //Đặt giá trị nhỏ nhất cho độ chính xác

        while (absoluteValue(x - (result * result)) > epsilon) {
            result = (result + (x / result)) / 2;
        }

        return result;
    }

    //Hàm lấy giá trị tuyệt đối thay thế cho Math.abs()
    public static double absoluteValue(double number) {
        double absoluteValue = number >= 0 ? number : -number;
        return absoluteValue;
    }



}
