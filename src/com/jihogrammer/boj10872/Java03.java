package com.jihogrammer.boj10872;

public class Java03 {
    public static void main(String[] x) throws Exception {
        int[] f = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        int c, n=0;
        while ((c=System.in.read()) > 13) n = n*10 + c - 48;
        System.out.print(f[n]);
    }
}
