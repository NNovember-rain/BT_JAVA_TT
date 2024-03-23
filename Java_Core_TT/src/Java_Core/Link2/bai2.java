package Java_Core.Link2;

import java.util.Arrays;
import java.util.Scanner;

public class bai2 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        //TODO: ko sử dụng .sort()
        Arrays.sort(a);
        for(int i=0;i<n;i++){
            System.out.print(a[i]+" ");
        }

    }
}
