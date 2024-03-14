package Link2;

import java.util.Arrays;
import java.util.Scanner;

public class bai9 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] a=new int[n*m];
        for(int i=0;i<m*n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);

        for(int i=0;i<n*m;i++){
            if((i+1)%m==0) System.out.println();
            else{
                System.out.print(a[i]+" ");
            }
        }
    }
}
