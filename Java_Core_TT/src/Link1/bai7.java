package Link1;

import java.util.Scanner;

public class bai7 {
    public static int[] check=new int[1000000+1];
    public static void Sang(){
        for (int i = 2; i < 1000000+1; i++) {
            check[i] =1;
        }

        for (int i = 2; i <= Math.sqrt(1000000+1); i++) {
            if (check[i] == 1) {
                for (int j = 2 * i; j < 1000000+1; j += i) {
                    check[j] = 0;
                }
            }
        }
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Sang();
        int n=sc.nextInt();
        for(int i=2;i<n;i++){
            if(check[i]==1) System.out.print(i+" ");
        }
    }
}
