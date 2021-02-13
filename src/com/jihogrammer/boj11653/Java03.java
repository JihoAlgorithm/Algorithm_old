package com.jihogrammer.boj11653;

public class Java03 {

    private static StringBuilder sb;

    private static int initBOJ11653() throws Exception {

        int N, C;
        sb = new StringBuilder();

        N = System.in.read() - '0';
        while ((C = System.in.read()) > 13) N = N * 10 + C - '0';

        return N;

    }

    private static void primeFactorization(int N) {

        if (N == 1) return;

        // '에라토스테네스의 체' 개념을 활용한 접근
        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }

        // 위 for문에서 N이 소수일 경우 출력되지 않으므로 N도 출력한다.
        // N이 1일 경우는 소수들로 나누어 떨어졌다는 의미이므로 출력하지 않는다.
        if (N != 1) sb.append(N);

    }

    public static void main(String[] args) throws Exception {

        int N = initBOJ11653();
        primeFactorization(N);
        System.out.print(sb);

    }

}