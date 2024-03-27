package String;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String tmp = "";

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) tmp += Character.toUpperCase(s.charAt(i));
            else tmp += Character.toLowerCase(s.charAt(i));
        }
        System.out.println(tmp);
    }
}
