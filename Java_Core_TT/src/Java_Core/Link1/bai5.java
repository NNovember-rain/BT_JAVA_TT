package Java_Core.Link1;

import java.util.Scanner;

public class bai5 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        String n=sc.nextLine();
        int sum=0;
        for (int i=0;i<n.length();i++){
            //TODO: dùng cách khác không được sử dụng .parseInt()
            sum+= Integer.parseInt(n.charAt(i)+"");
        }
        System.out.println(sum);
    }
}
