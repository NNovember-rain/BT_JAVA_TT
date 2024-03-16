package Link1;

import java.util.Scanner;

public class bai3 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static int gcd(int a,int b){
        if(b==0) return a;
        else return gcd(b,a%b);
    }

    public static int lcd(int a,int b){
       return a*b/gcd(a,b);
    }
    public static void main(String[] args) {
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(gcd(a,b)+" "+lcd(a,b));
    }
}
