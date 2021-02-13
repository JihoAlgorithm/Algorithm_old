package com.jihogrammer.boj10870;

public class Java01 {
    public static void main(String[] args) throws Exception {
        int c, n = 0;
        while ((c = System.in.read()) > 13) n = n * 10 + c - 48;
        System.out.print(fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
