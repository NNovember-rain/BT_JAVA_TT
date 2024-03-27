package String;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] tmp = s.split("\\s+");

        for(int i=0;i<tmp.length-1;i++){
            for(int j=i+1;j<tmp.length;j++){
                if(tmp[i].compareToIgnoreCase(tmp[j])>0){
                    String x=tmp[i];
                    tmp[i]=tmp[j];
                    tmp[j]=x;
                }
            }
        }
    }

}
