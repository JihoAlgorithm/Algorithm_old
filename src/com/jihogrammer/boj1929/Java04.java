package com.jihogrammer.boj1929;

import java.io.*;
import java.util.StringTokenizer;

public class Java04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        final int MAX = 1000001;
        boolean[] prime = new boolean[MAX];

        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());

        prime[0] = prime[1] = true;
        for (int i=2; i*i<=MAX; i++) {
            if (prime[i]) continue;
            for(int j=i+i; j<MAX; j+=i) prime[j] = true;
        }
        
        for (int i=M; i<=N; i++) if (!prime[i]) sb.append(i).append('\n');
        System.out.print(sb);
    }
}
