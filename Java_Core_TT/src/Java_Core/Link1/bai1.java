package Java_Core.Link1;

import java.util.Scanner;

public class bai1 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        Long sum=0L;
        int n=sc.nextInt();
        if(n%2==0){
            for(int i=2;i<=n;i+=2){
                sum+=i;
            }
        }
        else{
            for(int i=1;i<=n;i+=2){
                sum+=i;
            }
        }
        System.out.println("phan a :"+sum);

        int n1=sc.nextInt();
        Double sum1=1D;
        for (int i=2;i<=n1;i++){
            sum1+=(1.0/i);
        }
        System.out.println("phan b :"+sum1);
    }
}