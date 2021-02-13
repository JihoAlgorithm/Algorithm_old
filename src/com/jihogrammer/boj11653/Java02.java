package com.jihogrammer.boj11653;

public class Java02 {

    private static StringBuilder sb;
    private static int N;

    private static void initBOJ11653() throws Exception {

        int C;

        sb = new StringBuilder();

        N = System.in.read() - '0';
        while ((C = System.in.read()) > 13) N = N * 10 + C - '0';

    }

    private static void primeFactorization() {

        if (N == 1) return;

        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                sb.append(i).append('\n');
                N /= i; // N값을 나누어준다.
                i = 1;  // 다시 2부터 소인수분해하려면 for문 끝에서 ++되므로 1로 바꿔준다
            }
        }

    }

    public static void main(String[] args) throws Exception {

        initBOJ11653();
        primeFactorization();
        System.out.print(sb);

    }

}
