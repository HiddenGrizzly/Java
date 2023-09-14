package Lap6;

import java.util.Scanner;

public class UncheckedException {
    public UncheckedException() {
    }

    public static void main(String[] args) {
        int i, n = 2;
        int a[] = new int[n];
        java.util.Scanner input = new java.util.Scanner(System.in);

        for (i=0; i<=n; i++) {
            System.out.printf("a[%d] = ", i);
            a[i] = input.nextInt();
        }
    }
}
