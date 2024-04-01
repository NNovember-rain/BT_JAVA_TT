package String;

import java.util.Scanner;

public class bai4 {
    public static void solve(String s){
        String[] tmp = s.split("\\s+");
        int viTri = 0;
        String rc = tmp[0];

        for (int i = 1; i < tmp.length; i++) {
            if (tmp[i].length() > rc.length()) {
                rc = tmp[i];
                viTri = i + 1;
            }
        }

        System.out.println("từ dài nhất là " + rc + " ở vị trí thứ " + (viTri+1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solve(s);
    }
}
