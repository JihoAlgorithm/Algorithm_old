package com.jihogrammer.boj10870;

public class Java03 {
    public static void main(String[] args) throws Exception {
        int c, n = 0;
        while ((c = System.in.read()) > 13) n = n * 10 + c - 48;
        System.out.print(fibonacci(n));
    }

    static int fibonacci(int n) {
        if (n < 2) return n;
        int f[] = new int[n+1]; f[1]++;
        for (int i=2; i <= n; i++) f[i] = f[i-1] + f[i-2];
        return f[n];
    }
}
