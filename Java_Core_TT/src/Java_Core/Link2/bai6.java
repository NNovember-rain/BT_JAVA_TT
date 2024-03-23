package Java_Core.Link2;

import java.util.Arrays;
import java.util.Scanner;

public class bai6 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int p=sc.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        a[n]=p;
        Arrays.sort(a);
        for (int i = 0; i <= n; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
