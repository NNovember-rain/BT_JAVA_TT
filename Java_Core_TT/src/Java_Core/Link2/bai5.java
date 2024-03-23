package Java_Core.Link2;

import java.util.Scanner;

public class bai5 {
    //TODO: Code thoáng ra
    public static void InsertArray(int[] a,int[] b, int n,int m, int p){
        for(int i=0;i<p;i++){
            System.out.print(a[i]+" ");
        }
        for(int i=0;i<m;i++){
            System.out.print(b[i]+" ");
        }
        for(int i=p;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Nhap n m p: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        System.out.print("Nhap mang a:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("Nhap mang b:");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        InsertArray(a,b,n,m,p);
    }
}
