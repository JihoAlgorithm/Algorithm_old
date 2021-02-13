package com.jihogrammer.boj2775;

import java.io.*;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K, N;
        
        System.out.print("테스트 개수: ");
        for (int T = Integer.parseInt(br.readLine()); T>0; T--) {
            System.out.print("층: "); K = Integer.parseInt(br.readLine());
            System.out.print("호: "); N = Integer.parseInt(br.readLine());
            System.out.println("==> " + (K*100 + N ) + "호에는 " + printApartment(K+1, N) + "명이 산다.");
        }
    }

    private static int printApartment(int K, int N) {
        int[][] A = new int[K][N];  // 매개값을 통해 배열을 동적으로 생성
        
    // 배열에 값 채우기
        for (int i=0; i<N; i++) A[0][i] = i + 1; // 0층에는 i호에 i명이 산다.
        for (int i=1; i<K; i++) A[i][0] = 1;     // 층에 관계없이 1호에는 1명이 산다. 0층은 다 찼으므로 1층부터 시작.
        // 이중 for문을 사용하여 아파트 상에서 좌, 하 방의 거주민 수를 더해준다.
        for (int i=1; i<K; i++) for (int j=1; j<N; j++) A[i][j] = A[i-1][j] + A[i][j-1];

    // Print Structure
        // Header
        System.out.print("부녀회장 ┌");
        for (int i=0; i<N-1; i++) System.out.print("─────────┬");
        System.out.println("─────────┐");

        for (int i=K-1; i>-1; i--) {
            // Content
            System.out.printf("%6d 층", i);
            for (int j=0; j<N; j++) System.out.printf("│%9d", A[i][j]);
            System.out.print("│\n");

            if (i != 0) { // Dividing Line
                System.out.print("         ├");
                for (int l=0; l<N-1; l++) System.out.print("─────────┼");
                System.out.println("─────────┤");
            } else { // Footer
                System.out.print("         └");
                for (int l=0; l<N-1; l++) System.out.print("─────────┴");
                System.out.print("─────────┘\nApartment");
                for (int l=0; l<N; l++) System.out.printf("%5d 호  ", l+1);
                System.out.println("\n");
            }
        }

        return A[K-1][N-1];
    }
}
