package Link1;

import java.util.Scanner;

public class bai8 {
    //TODO: Code thoáng ra
    public static boolean checkTN(String s){
        //TODO: Không dùng StringBuilder dùng cách khác
        StringBuilder sb=new StringBuilder(s);
        //TODO: Không dùng equals, reverse, toString dùng cách khác
        if(s.equals(sb.reverse().toString())) return true;
        else return false;
    }
    public static int SumTen(int x){
        String s=x+"";
        int sum=0;
        for(int i=0;i<s.length();i++){
            //TODO: Không dùng parseInt dùng cách khác
            sum+=Integer.parseInt(s.charAt(i)+"");
        }
        return sum;
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        int cnt=0;
        int[] a=new int[100000];
        System.out.println("\n so TN : ");
        //TODO: Java core nên ko nên dùng Math.pow dùng cách khác
        for(int i = (int) Math.pow(10,5); i<Math.pow(10,6); i++){
            if(checkTN(i+"")) {
                System.out.print(i+" ");
                a[cnt++]=i;
            }
        }
        System.out.println("\n so TN co tong 10: ");

        for(int i=0;i<cnt;i++){
            if(SumTen(a[i])==10) System.out.print(a[i]+" ");
        }
    }
}
