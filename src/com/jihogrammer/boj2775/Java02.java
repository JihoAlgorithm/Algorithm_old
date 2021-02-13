package com.jihogrammer.boj2775;

import java.io.*;

/**
 * 함수를 사용해서 처리
 * 배열의 크기를 동적으로 받아 처리한다.
 */

public class Java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        for(int T = Integer.parseInt(br.readLine()); T>0; T--)
            sb.append(apartment(Integer.parseInt(br.readLine())+1, Integer.parseInt(br.readLine()))).append('\n');
        
        bw.write(sb.toString()); bw.close();
    }

    private static int apartment(int K, int N) {
        int[][] a = new int[K][N];
        
        for (int i=0; i<N; i++) a[0][i] = i + 1;
        for (int i=1; i<K; i++) a[i][0] = 1;
        for (int i=1; i<K; i++) for (int j=1; j<N; j++) a[i][j] = a[i-1][j] + a[i][j-1];

        return a[K-1][N-1];
    }
}
