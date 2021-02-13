package com.jihogrammer.swea5215;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Java02 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static int N, L, score, cal;

    public static void main(String[] args) throws Exception {

        FileOutputStream fos = new FileOutputStream("data" + File.separatorChar + "5215.txt");
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(fos));

        final int T = Integer.parseInt(br.readLine()) + 1;

        for (int tc = 1; tc < T; tc++) {

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            int[] dp = new int[L + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                score = Integer.parseInt(st.nextToken());
                cal = Integer.parseInt(st.nextToken());

                int j;
                for (j = L; j >= cal; j--)
                    if (dp[j] < score + dp[j - cal])
                        dp[j] = score + dp[j - cal];
                        
                writeFile(bf, i, j+1, dp);
            }
 
            bw.append("#" + tc + " " + dp[L] + "\n");
        }

        bf.close();
        bw.close();
    }

    private static void writeFile(BufferedWriter bf, int i, int j, int[] dp) throws IOException {

        int len = dp.length;
        bf.append("[  " + i + ", " + j + "  ]\n");
        
        for (int k = 1; k < len; k++) {
            bf.append(dp[k] + " ");
            if (k % 25 == 0) bf.append('\n');
        }
    }

}
