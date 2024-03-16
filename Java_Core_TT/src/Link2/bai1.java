package Link2;

import java.util.Scanner;

public class bai1 {
    //TODO: Code thoáng ra
    //TODO: câu từ ghi chi tiết hơn, như Bài 1 Link 1
    public static boolean check(int[] a,int n){
        for(int i=0;i<n/2;i++){
            if(a[i]!=a[n-i-1]) return false;
        }
        return true;
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int[] a=new int[n+1];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        if (check(a,n)) System.out.println("yes");
        else System.out.println("no");


    }
}
