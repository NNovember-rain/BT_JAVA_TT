package Java_Core.Link2;

import java.util.Scanner;

public class bai4 {
    //TODO: Code thoáng ra
    public static boolean checkNT(int x){
        if (x<2) return false;
        //TODO: Viết hàm thay thế cho sqrt
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] a=new int[n];
        int near=Integer.MAX_VALUE,index=0,check=0;
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            if(checkNT(a[i])) {
                //TODO: Viết hàm thay thế cho abs
                int tmp=Math.abs(a[i]-x);
                if(tmp<near) {
                    near=tmp;
                    index=i;
                }
                check=1;
            }
        }
        if(check==1) System.out.println(index);
        else System.out.println("khong co snt trong mang");

    }
}
