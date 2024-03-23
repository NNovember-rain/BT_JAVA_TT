package Java_Core.Link1;

import java.util.Scanner;

public class bai6 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int n=sc.nextInt();
        for(int i=2;i<=n/2;i++){
            while(n%i==0){
                System.out.print(i+" ");
                n/=i;
            };
        }
        if(n!=1) System.out.println(n);
    }
}
