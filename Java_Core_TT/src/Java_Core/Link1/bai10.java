package Java_Core.Link1;

import java.util.Scanner;

public class bai10 {
    //TODO: xem lại chú thích bài 8 9
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static boolean checkNT1(Long x){
        if(x<2) return false;
        for(int i=2;i<=Math.sqrt(x);i++){
            if(x%i==0) return false;
        }
        return true;
    }
    public static boolean checkNT2(String x){
        for(int i=0;i<x.length();i++){
            if(!checkNT1(Long.parseLong(x.charAt(i)+""))) return false;
        }
        return true;
    }

    public static boolean checkNT3(String s){
        StringBuilder sb=new StringBuilder(s);
        if(checkNT1(Long.parseLong(sb.reverse().toString()))) return true;
        else return false;
    }
    public static void main(String[] args) {
        for(long i=(long)Math.pow(10,6);i<(long)Math.pow(10,7);i++){
            if(checkNT1(i) && checkNT2(i+"") && checkNT3(i+"") ) System.out.print(i+" ");
        }
    }
}
