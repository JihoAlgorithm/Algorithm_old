package com.jihogrammer.swea6808;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Java03 {

    private static BufferedWriter bw;
    private static int[] KY;
    private static int[] IY;
    private static int WIN;

    private static final int CARD_NUM = 9;
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

        KY = new int[CARD_NUM];
        IY = new int[CARD_NUM];

        while ((c = System.in.read()) > 13) {

            if (c == ' ') {
                KY[i++] = n;
                flag |= 1 << n;
                n = 0;
            } else n = 10 * n + c - '0';

        } System.in.read();

        KY[i] = n;
        flag |= 1 << n;

        for (i = 1, n = 0; i < 19; i++)
            if ((flag & 1 << i) == 0) IY[n++] = i;

        Arrays.sort(IY);

    }

    private static void play() {

        int kyScore, iyScore;

        do {

            kyScore = 0;
            iyScore = 0;

            for (int i = 0; i < CARD_NUM; i++)
                if (KY[i] > IY[i]) kyScore += KY[i] + IY[i];
                else iyScore += KY[i] + IY[i];

            if (kyScore > iyScore) WIN++;

        } while (nextPermutation());

    }

    private static boolean nextPermutation() {

        int i = CARD_NUM - 1;
        while (i > 0 && IY[i-1] >= IY[i]) i--;

        if (i == 0) return false;

        int j = CARD_NUM - 1;
        while (IY[i-1] >= IY[j]) j--;

        swap(i-1, j);

        j = CARD_NUM - 1;
        while (i < j) swap(i++, j--);

        return true;

    }

    private static void swap(int i, int j) {

        int tmp = IY[i];
        IY[i] = IY[j];
        IY[j] = tmp;

    }

    public static void main(String[] args) throws IOException {

        int T = initSWEA6808();

        for (int tc = 1; tc <= T; tc++) {

            draw();
            play();

            bw.write("#" + tc + " " + WIN + " " + (NINE_FACTORIAL - WIN));
            bw.newLine();

        }

        bw.close();

    }

}
