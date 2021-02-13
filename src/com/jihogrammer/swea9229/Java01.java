package com.jihogrammer.swea9229;

import java.io.*;
import java.util.StringTokenizer;

public class Java01 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static int N, M, max, snack[], dp[];

    public static void main(String[] args) throws Exception {

        final int T = Integer.parseInt(br.readLine()) + 1;

        for (int tc = 1; tc < T; tc++) {

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M + 1];
            snack = new int[N];
            max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                snack[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, snack[i]);
            }

            for (int i = 0; i < N; i++) {
                for (int j = M; j >= snack[i]; j--)
                if (dp[j] < snack[i] + dp[j - snack[i]])
                    dp[j] = snack[i] + dp[j - snack[i]];
            }
            
            if (dp[M] - max <= 0) dp[M] = -1;
            bw.append("#" + tc + " " + dp[M] + "\n");
        }

        bw.close();
        
    }
    
}
