package String;

import java.util.Scanner;

public class bai5 {
    public static void solveFullName(String s){
        String[] tmp = s.split("\\s+");
        String result="";

        for (int i =tmp.length-1; i >=0 ; i--) {

            result+=Character.toUpperCase(tmp[i].charAt(0));
            result+=tmp[i].substring(1,tmp[i].length()).toLowerCase();
            result+=" ";
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solveFullName(s);
    }
}
