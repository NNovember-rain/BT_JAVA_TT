package Link2;

import java.util.Arrays;
import java.util.Scanner;

public class bai3 {
    //TODO: Code thoáng ra
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        //TODO: Không nên fix cứng giá trị
        int[] cnt=new int[1000000];
        int r=0,m=0;
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
            cnt[a[i]]++;
            if(m<cnt[a[i]]){
                m=cnt[a[i]];
                r=a[i];
            }
        }
        for(int i=0;i<n;i++){
            if(cnt[a[i]]!=0) {
                System.out.print(a[i] + " " + cnt[a[i]] + " ");
                cnt[a[i]]=0;
            }
        }
        System.out.println("\nso co so lan xh nhieu nhat: "+r+" "+m);
    }
}
