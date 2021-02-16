package com.jihogrammer.boj2839;

public class Java01 {

    public static void main(String[] args) throws Exception {

        int X, N = 0;
        while ((X = System.in.read()) > 13) N = 10 * N + X - 48;

        if (N == 4 || N == 7) X = -1;
        else switch (N % 5) {
            case 0: X = N / 5; break;
            case 1: case 3: X = N / 5 + 1; break;
            case 2: case 4: X = N / 5 + 2; break;
        }

        System.out.print(X);

    }

}
