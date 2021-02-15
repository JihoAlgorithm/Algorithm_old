package com.jihogrammer.swea6808;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Java02 {

    private static BufferedWriter bw;
    private static int[] KY;
    private static int[] IY;
    private static int WIN;

    private static final int NINE_FACTORIAL = 362880;

    private static int initSWEA6808() throws IOException {

        int c;

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = 0;
        while ((c = System.in.read()) > 13) T = 10 * T + c - '0';
        System.in.read();

        return T;

    }

    private static void draw() throws IOException {

        int c, n = 0, i = 0, flag = 0;

        WIN = 0;

        KY = new int[9];
        IY = new int[9];

        while ((c = System.in.read()) > 13) {

            if (c == ' ') {
                KY[i++] = n;
                flag |= 1 << n;
                n = 0;
            } else n = 10 * n + c - '0';

        } System.in.read();

        KY[i] = n;
        flag |= 1 << n;

        for (i = 1, n = 0; i < 19; i++) {
            if ((flag & 1<<i) > 0) continue;
            IY[n++] = i;
        }

    }

    private static void permutation(int round, int flag, int kyScore, int iyScore) {

        if (round == 9) {
            if (kyScore > iyScore) WIN++;
            return;
        }

        for (int i = 0; i < 9; i++) {

            if ((flag & 1 << i) > 0) continue;

            if (KY[round] > IY[i])
                permutation(round+1, flag | 1 << i, kyScore+KY[round]+IY[i], iyScore);
            else permutation(round+1, flag | 1 << i, kyScore, iyScore+KY[round]+IY[i]);

        }

    }

    public static void main(String[] args) throws IOException {

        int T = initSWEA6808();

        for (int tc = 1; tc <= T; tc++) {

            draw();
            permutation(0, 0, 0, 0);

            bw.write("#" + tc + " " + WIN + " " + (NINE_FACTORIAL - WIN));
            bw.newLine();

        }

        bw.close();

    }

}
