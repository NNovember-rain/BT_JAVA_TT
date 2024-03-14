package Link1;

import java.util.Scanner;

public class bai2 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int cnt=0;
        int x=sc.nextInt();
        for(int i=1;i<=Math.sqrt(x);i++){
            if(x%i==0){
                System.out.print(i+" ");
                cnt+=1;
                if((x/i)!=i){
                    System.out.print(x/i+" ");
                    cnt+=1;
                }
            }
        }
        System.out.println("\nso luong uoc la: "+cnt);
    }
}
