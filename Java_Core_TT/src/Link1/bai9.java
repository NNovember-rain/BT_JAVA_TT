package Link1;

import java.util.Scanner;

public class bai9 {
    //TODO: Xem lại chú thích bài 8
    //TODO: Code thoáng ra
    public static boolean checkTN(String s){
        StringBuilder sb=new StringBuilder(s);
        if(s.equals(sb.reverse().toString())) return true;
        else return false;
    }
    public static Boolean SumTen(long x){
        String s=x+"";
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=Integer.parseInt(s.charAt(i)+"");
        }
        if(sum%10==0) return true;
        else return false;
    }
    public static boolean OnlyNB(String n){
        for(int i=0;i<n.length();i++){
            //TODO: không sử dụng charAt
            if(n.charAt(i)!='6' && n.charAt(i)!='0' && n.charAt(i)!='8') return false;
        }
        return true;
    }
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        for(long i=(long)Math.pow(10,6);i<(long)Math.pow(10,8);i++){
            if(checkTN(i+"") && OnlyNB(i+"") && SumTen(i) ) System.out.print(i+" ");
        }
    }
}
