package com.jihogrammer.boj9020;

import java.io.*;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int MAX = 10000;
        boolean[] prime = new boolean[MAX+1];
        prime[0] = prime[1] = true;
        for (int i=2; i*i<=MAX; i++) {
            if (prime[i]) continue;
            for(int j=i*i; j<=MAX; j+=i) prime[j] = true;
        }

        for(int T = Integer.parseInt(br.readLine()); T>0; T--) {
            int n = Integer.parseInt(br.readLine());
            for (int i=n/2; i>1; i--) {
                if (prime[i]) continue;
                if (!prime[i] && !prime[n-i]) {
                    sb.append(i + " " + (n-i) + "\n");
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
