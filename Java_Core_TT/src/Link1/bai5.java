package Link1;

import java.util.Scanner;

public class bai5 {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String n=sc.nextLine();
        int sum=0;
        for (int i=0;i<n.length();i++){
            sum+= Integer.parseInt(n.charAt(i)+"");
        }
        System.out.println(sum);
    }
}
