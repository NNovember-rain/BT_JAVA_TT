package String;

import java.util.Scanner;

public class bai1 {
    public static boolean checkTN(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i = (int) Math.pow(10,5); i<Math.pow(10,6); i++){
            String s=i+"";
            if(checkTN(s)){
                System.out.println(s+" YES");
            }
            else{
                System.out.println( s+" NO");
            }
        }
    }
}
