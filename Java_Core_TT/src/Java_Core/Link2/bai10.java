package Java_Core.Link2;

import java.util.Scanner;

public class bai10 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        int cc=0,cp=0;
        int[][] a=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) cc+=a[i][j];
                if(n==i+j+1) cp+=a[i][j];
            }
        }
        System.out.println(cc+" "+cp);
    }
}
//3
//2 1 3
//9 8 2
//0 2 1
