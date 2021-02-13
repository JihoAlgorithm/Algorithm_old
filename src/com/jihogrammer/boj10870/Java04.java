package com.jihogrammer.boj10870;

import java.util.Scanner;

public class Java04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print(fibonacci(s.nextInt()));
        s.close();
    }
    static int fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
