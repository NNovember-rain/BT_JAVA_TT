package String;

import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] tmp = s.split("\\s+");
        String result="";

        for (int i = 0; i < tmp.length; i++) {
            result+=Character.toUpperCase(tmp[i].charAt(0));
            result+=tmp[i].substring(1,tmp[i].length()).toLowerCase();
            result+=" ";
        }
        System.out.println(result);
    }
}
