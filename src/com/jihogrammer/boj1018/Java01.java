package com.jihogrammer.boj1018;

import java.io.*;

public class Java01 {
    public static void main(String[] in) throws IOException {
        // 객체 생성 및 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]),
            i = 0, j, k, w, h, c, count = 64;
            
        boolean[][] chess = new boolean[N][M];
        boolean[] draw;

        while (true) {
            in[0] = br.readLine();
            for (j=0; j<M; j++) if(in[0].charAt(j) == 66) chess[i][j] = true;
            if (++i == N) break;
        }

        for (i=0; i<=N-8; i++) {
            for (j=0; j<=M-8; j++) {
                c = 0; k = 0; draw = new boolean[64];
                for (h=0; h<8; h++) {
                    for (w=0; w<8; w++) {
                        draw[k++] = chess[i+h][j+w];
                    }
                }

                for (k=1; k<63; k++) {
                    if (draw[k-1] == draw[k]) {
                        if (k % 8 == 0) continue;
                        draw[k] = !draw[k];
                        c++;
                    } else if ((k % 8 == 0) && draw[k-1] != draw[k]) {
                        draw[k] = !draw[k];
                        c++;
                    }
                }
                
                if (c > 32) c = 64 - c;
                if (c < count) count = c;
            }
        }

        System.out.print(count);
    }

    /* static void printBoard(boolean[][] chess, int N, int M) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++)
                if (chess[i][j]) System.out.print('B');
                else System.out.print('W');
            System.out.println();
        }
    }

    static void printBoard(boolean[] draw, int c) {
        for (int i=0; i<64; i++) {
            if (draw[i]) System.out.print('B');
            else System.out.print('W');

            if (i%8 == 7) System.out.println();
        }
        System.out.println("count: " + c);
    } */
}
