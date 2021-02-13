package com.jihogrammer.boj2231;

import java.io.*;

public class Java03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        int N = Integer.parseInt(S), min = N, tmp, sum;
        
        for (int i = N - (9*S.length()); i < N + (9*S.length()); i++) {
            if (i < 1) i = 1;
            sum = tmp = i;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum == N && i < min) min = i;
        }

        if (min == N) min = 0;
        bw.write(Integer.toString(min)); bw.close();
    }
}
