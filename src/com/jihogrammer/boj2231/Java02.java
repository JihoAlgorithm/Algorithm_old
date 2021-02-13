package com.jihogrammer.boj2231;

import java.io.*;

public class Java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] place = new int[6];
        int N = Integer.parseInt(br.readLine()), Num, Temp, Min = N;

        for (Num = N-54; Num < N+54; Num++) {
            if (Num < 1) Num = 1;
            place[0] = Num / 100000;
            place[1] = Num % 100000 / 10000;
            place[2] = Num % 10000 / 1000;
            place[3] = Num % 1000 / 100;
            place[4] = Num % 100 / 10;
            place[5] = Num % 10;
            Temp = Num;
            for (int i=0; i<6; i++) Temp += place[i];
            if (Temp == N && Num < Min) Min = Num;
        }

        if (Min == N) Min = 0;
        bw.write(Integer.toString(Min)); bw.close();
    }
}
