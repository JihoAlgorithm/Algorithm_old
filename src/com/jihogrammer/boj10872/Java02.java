package com.jihogrammer.boj10872;

public class Java02 {
    public static void main(String[] args) throws Exception {
        int c, n=0;
        while ((c=System.in.read()) > 13) n = n*10 + c - 48;
        System.out.print(facorial(n));
    }

    private static int facorial(int n) {
        if (n==0) return 1;
        return n * facorial(n-1);
    }
}
