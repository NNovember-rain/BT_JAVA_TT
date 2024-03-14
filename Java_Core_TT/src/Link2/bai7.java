package Link2;

import java.util.Scanner;

public class bai7 {
        public static Scanner sc=new Scanner(System.in);
        public static void main(String[] args) {
            int n=sc.nextInt();
            int[] a = new int[n+1];
            int indexFirt=0,size=0,cnt=1;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n-1; i++) {
               if(a[i]<=a[i+1]){
                   cnt++;
                   if(cnt>size) {
                       size=cnt;
                       indexFirt=i;
                   }
               }
               else {
                   cnt=1;
               }
            }
            System.out.println("vi tri "+(indexFirt-size+2)+" dai "+size);
        }
}
