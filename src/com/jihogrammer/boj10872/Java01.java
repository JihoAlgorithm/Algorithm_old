package com.jihogrammer.boj10872;

import java.io.*;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if (N <= 1) bw.write(49);
        else bw.write(String.valueOf(facorial(N)));
        bw.close();
    }

    private static int facorial(int n) {
        if (n==1) return 1;
        return n * facorial(n-1);
    }
}
