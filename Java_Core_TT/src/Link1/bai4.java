package Link1;

import java.util.Scanner;

public class bai4 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);

    public static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }
    public static void main(String[] args) {
        int a=sc.nextInt();
        int b=sc.nextInt();
        for(int i=a;i<b;i++){
            for(int j=i+1;j<=b;j++){
                if(gcd(i,j)==1) System.out.println(i+" "+j);
            }
        }
    }
}
