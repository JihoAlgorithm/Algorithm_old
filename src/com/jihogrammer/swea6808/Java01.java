package com.jihogrammer.swea6808;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Java01 {

    private static BufferedWriter bw;
    private static int[] KY;
    private static int[] IY;
    private static boolean[] CARD;
    private static boolean[] selected;
    private static int TC;
    private static int WIN;

    private static final int NINE_FACTORIAL = 362880;

    private static void initSWEA6808() throws IOException {

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TC = 0;
        while ((WIN = System.in.read()) > 13) TC = 10 * TC + WIN - '0';
        System.in.read();

    }

    private static void draw() throws IOException {

        int n = 0, i = 0;

        KY = new int[9];
        IY = new int[9];
        CARD = new boolean[19];
        selected = new boolean[9];

        while ((WIN = System.in.read()) > 13) {

            if (WIN == ' ') {
                KY[i++] = n;
                CARD[n] = true;
                n = 0;
            } else n = 10 * n + WIN - '0';

        } System.in.read();
        KY[i] = n;
        CARD[n] = true;

        for (i = 1, n = 0; i < 19; i++) {
            if (CARD[i]) continue;
            IY[n++] = i;
        }

        WIN = 0;

    }

    private static void permutation(int round, int kyScore, int iyScore) {

        if (round == 9) {
            if (kyScore > iyScore) WIN++;
            return;
        }

        for (int i = 0; i < 9; i++) {

            if (!selected[i]) {

                selected[i] = true;

                if (KY[round] > IY[i])
                    permutation(round+1, kyScore+KY[round]+IY[i], iyScore);
                else
                    permutation(round+1, kyScore, iyScore+KY[round]+IY[i]);
                
                selected[i] = false;

            }

        }

    }

    public static void main(String[] args) throws IOException {

        initSWEA6808();
        for (int i = 1; i <= TC; i++) {
            draw();
            permutation(0, 0, 0);
            bw.append("#" + i + " " + WIN + " " + (NINE_FACTORIAL - WIN));
            bw.newLine();
        } bw.close();

    }

}
