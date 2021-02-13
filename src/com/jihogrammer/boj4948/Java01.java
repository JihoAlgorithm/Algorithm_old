package com.jihogrammer.boj4948;

import java.io.*;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N;

        final int MAX = 123456 * 2;
        boolean[] prime = new boolean[MAX+1];
        prime[0] = prime[1] = true;
        for (int i=2; i*i<=MAX; i++) {
            if (prime[i]) continue;
            for(int j=i+i; j<=MAX; j+=i) prime[j]=true;
        }

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            int cnt = 0;
            for (int i=N+1; i<=2*N; i++) if (!prime[i]) cnt++;
            sb.append(cnt).append('\n');
        }
        
        System.out.print(sb);
    }
}