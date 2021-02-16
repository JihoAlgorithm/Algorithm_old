package com.jihogrammer.boj2961;

public class Java01 {

    private static int N, flavorDiff;
    private static int[] S, B;

    public static void main(String[] args) throws Exception {

        init_BOJ2961();
        ready();
        bestIngredients(1<<N);
        System.out.print(flavorDiff);

    }

    private static void init_BOJ2961() throws Exception {

        int c;

        while ((c = System.in.read()) > 13) N = 10 * N + (c - '0');
        // System.in.read();

        S = new int[N];
        B = new int[N];
        flavorDiff = Integer.MAX_VALUE;

    }

    private static void ready() throws Exception {

        int c;

        for (int i = 0; i < N; i++) {

            while ((c = System.in.read()) > 32) S[i] = 10 * S[i] + (c - '0');
            while ((c = System.in.read()) > 13) B[i] = 10 * B[i] + (c - '0');
            // System.in.read();

        }

    }

    private static void bestIngredients(int caseCount) {

        for (int flag = 1; flag < caseCount; flag++) {

            int s = 1;
            int b = 0;

            for (int i = 0; i < N; i++) {

                if ((flag & 1<<i) > 0) {
                    s *= S[i];
                    b += B[i];
                }

            }

            flavorDiff = Math.min(flavorDiff, Math.abs(s-b));

        }

    }

}
