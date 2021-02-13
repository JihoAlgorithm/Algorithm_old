package com.jihogrammer.boj2447;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Java02 {
    
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[][] carpet;
    private static int N;
    
    private static void init() throws IOException {
        
        int C = N = 0;
        while ((C = System.in.read()) > 13) N = N * 10 + C - '0';
        
        carpet = new char[N][N];
        
    }
    
    private static void star(int n, int x, int y, boolean isStar) {

        int k  = n / 3;
        
        if (n == 1) {
            if (isStar) carpet[x][y] = '*';
            else carpet[x][y] = ' ';
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 1 && j == 1) || !isStar) star(k, x + i*k, y + j*k, false);
                else star(k, x + i*k, y + j*k, true);
            }
        }
        
    }
    
    private static void print() throws IOException {

        for (int i = 0; i < N; i++) {
            bw.write(carpet[i]);
            bw.newLine();
        }

        bw.close();

    }

    public static void main(String[] args) throws Exception {

        init();
        star(N, 0, 0, true);
        print();

    }

}
