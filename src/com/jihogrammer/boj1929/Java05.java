package com.jihogrammer.boj1929;

import java.io.*;
import java.util.StringTokenizer;

public class Java05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[N+1];

        prime[0] = prime[1] = true;
        for (int i=2; i*i<=N; i++) {
            if (prime[i]) continue;
            for(int j=i+i; j<=N; j+=i) prime[j]=true;
        }
        
        for (int i=M; i<=N; i++) if (!prime[i]) sb.append(i).append('\n');
        System.out.print(sb);
    }
}