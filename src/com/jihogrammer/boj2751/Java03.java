package com.jihogrammer.boj2751;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Java03 {

    /** 수의 범위 만큼의 배열 */
    private static boolean[] range;
    private static BufferedWriter bw;

    /**
     * range 배열 인덱스(입력 받을 수 + 백만)의 값을 true로 변경
     * @throws IOException because of System.in.read()
     */
    private static void initBOJ2751() throws IOException {

        int N, num, c; // 사용할 변수 선언

        // 사용할 객체 생성
        range = new boolean[2000001];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N값 입력받기
        N = System.in.read() - '0';
        while ((c = System.in.read()) > 13) N = 10 * N + c - '0';
        // System.in.read();

        // N개 만큼 수를 입력받기
        while (N-->0) {

            num = System.in.read();

            if (num == '-') {
                num = 0;
                while ((c = System.in.read()) > 13) num = 10 * num - (c - '0');
            } else {
                num -= '0';
                while ((c = System.in.read()) > 13) num = 10 * num + (c - '0');
            }// System.in.read();

            // 읽은 수에 해당하는 인덱스의 값을 true로 변경
            range[num + 1000000] = true;

        }

    }

    /**
     * range를 전체탐색하여 값이 true인 인덱스에서 백만을 빼고 출력
     * @throws IOException because of {@link BufferedWriter}
     */
    private static void printASC() throws IOException {

        for (int i = 0; i < 2000001; i++) if (range[i]) bw.append((i - 1000000) + "\n");
        bw.close();

    }

    public static void main(String[] args) throws IOException {

        initBOJ2751();
        printASC();

    }

}
