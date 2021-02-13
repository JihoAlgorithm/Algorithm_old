package com.jihogrammer.boj7568;

import java.io.*;

public class Java01 {
    static final int WEIGHT = 0, HEIGHT = 1, RANK = 2;
    static int N;
    static int[][] BULK, SORT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        N = Integer.parseInt(br.readLine());
        BULK = new int[N][3];
        SORT = new int[N][3];

        for (i=0; i<N; i++) {
            args = br.readLine().split(" ");
            SORT[i][WEIGHT] = BULK[i][WEIGHT] = Integer.parseInt(args[WEIGHT]);
            SORT[i][HEIGHT] = BULK[i][HEIGHT] = Integer.parseInt(args[HEIGHT]);
        }
        
        sort(WEIGHT);
        sort(HEIGHT);
        SORT[0][RANK]++;

        rank();
        match();

        printBulk();

        bw.write(String.valueOf(BULK[0][RANK]));
        for (i=1; i<N; i++) bw.write(" " + BULK[i][RANK]);
        bw.close();
    }

    private static void sort(final int KEY) {
        int i, j, tmpW, tmpH;
        for (i=0; i<N-1; i++) {
            for (j=1; j<N; j++) {
                if (SORT[j-1][KEY] < SORT[j][KEY]) {
                    tmpW = SORT[j][WEIGHT];
                    tmpH = SORT[j][HEIGHT];
                    SORT[j][WEIGHT] = SORT[j-1][WEIGHT];
                    SORT[j][HEIGHT] = SORT[j-1][HEIGHT];
                    SORT[j-1][WEIGHT] = tmpW;
                    SORT[j-1][HEIGHT] = tmpH;
                }
            }
        }
    }

    private static void rank() {
        int stack = 1;
        for (int i=1; i<N; i++) {
            if ((SORT[i-1][WEIGHT] >= SORT[i][WEIGHT])
             && (SORT[i-1][HEIGHT] >= SORT[i][HEIGHT])
             && (SORT[i-1][WEIGHT]+SORT[i-1][HEIGHT] > SORT[i][WEIGHT]+SORT[i][HEIGHT])) {
                SORT[i][RANK] = SORT[i-1][RANK] + stack;
                stack = 1;
            } else {
                SORT[i][RANK] = SORT[i-1][RANK];
                stack++;
            }
        }
    }

    private static void match() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if ((BULK[i][WEIGHT] == SORT[j][WEIGHT]) && (BULK[i][HEIGHT] == SORT[j][HEIGHT])) {
                    BULK[i][RANK] = SORT[j][RANK];
                }
            }
        }
    }

    private static void printBulk() {
        for (int i=0; i<N; i++) System.out.println(BULK[i][WEIGHT] + "\t" + BULK[i][HEIGHT] + "\t" + BULK[i][RANK]);
    }
}
