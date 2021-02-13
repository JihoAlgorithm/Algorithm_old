package com.jihogrammer.boj2775;

import java.io.*;

public class Java03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[][] A;
        
        for(int T = Integer.parseInt(br.readLine()); T>0; T--) {
            int K = Integer.parseInt(br.readLine()) + 1,
                N = Integer.parseInt(br.readLine());
                A = new int[K][N];
            /** 
             * K, N 입력값이 작을수록 유리하겠지. 다만, T가 커지면 모르겠다.
             * K, N의 범위가 지정되지 않아도 int 범위 내에서 해결 가능
             **/
    
            for (int i=0; i<N; i++) A[0][i] = i + 1;
            for (int i=1; i<K; i++) A[i][0] = 1;
            for (int i=1; i<K; i++) for (int j=1; j<N; j++) A[i][j] = A[i-1][j] + A[i][j-1];
            
            sb.append(A[K-1][N-1]).append('\n');
        }
        
        bw.write(sb.toString()); bw.close();
    }
}
