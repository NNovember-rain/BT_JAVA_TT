package String;

import java.util.Scanner;

public class bai7 {

    public static void solveReplace(String s1,String s2){
        System.out.println(s1.replace(s2,""));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        solveReplace(s1,s2);
    }
}
