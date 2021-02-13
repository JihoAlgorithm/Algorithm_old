package com.jihogrammer.boj1978;

import java.io.*;
import java.util.StringTokenizer;

public class Java01 {
    private static final int MAX = 1001;
    private static boolean[] prime = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = 0;
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        primeArray();
        while (st.hasMoreTokens()) if(!prime[Integer.parseInt(st.nextToken())]) X++;
        System.out.print(X);
        printArray();
    }

    private static void primeArray() {
        for (int i=2; i*i<=MAX; i++) {
            if (prime[i]) continue;
            for (int j=i+i; j<MAX; j+=i) prime[j] = true;
        }
        prime[0] = true;
        prime[1] = true;
    }

    private static void printArray() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<MAX; i++) {
            if (i%10==1) sb.append('\n');
            if (!prime[i]) sb.append(i).append('\t');
            else sb.append('X').append('\t');
        }
        System.out.println(sb);
    }
}
