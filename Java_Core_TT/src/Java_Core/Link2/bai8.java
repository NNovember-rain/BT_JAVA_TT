package Java_Core.Link2;

import java.util.Scanner;

public class bai8 {
    public static void main(String[] args) {
        int m, n, k;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        int[][] A = new int[m][n];
        int[][] B = new int[n][k];
        int[][] result = new int[m][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                B[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < n; l++) {
                    result[i][j] += A[i][l] * B[l][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }
}
