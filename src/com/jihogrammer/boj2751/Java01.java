package com.jihogrammer.boj2751;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Java01 {

    private static BufferedWriter bw;
    private static PriorityQueue<Integer> pq;

    /**
     * 입력될 수(N)만큼 수를 입력받고, PriorityQueue에 offer
     * @throws IOException because of System.in.read()
     */
    private static void initBOJ2751() throws IOException {

        // 필요한 변수 선언
        int N, num, c;

        // 사용할 객체 생성
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        pq = new PriorityQueue<>();

        // N값 입력받기
        N = System.in.read() - '0';
        while ((c = System.in.read()) > 13) N = 10 * N + c - '0';
        // System.in.read();

        // N만큼 수(num) 입력받기
        while (N-->0) {
             // 입력할 수가 양수인지 음수인지 판별해야 하므로 우선 읽는다.
            num = System.in.read();

            if (num == '-') { // num이 음수일 경우 c를 계속해서 빼줌
                num = 0;
                while ((c = System.in.read()) > 13) num = 10 * num - (c - '0');
            } else {          // num이 양수일 경우 N을 입력받은 것과 동일하게 받음
                num -= '0';
                while ((c = System.in.read()) > 13) num = 10 * num + (c - '0');
            } // System.in.read();

            pq.offer(num); // 입력받은 수를 Queue에 offer
        }

    }

    /**
     * PriorityQueue에 저장된 값을 하나씩 poll하여 bw로 출력.
     * pq가 자동으로 오름차순 정렬해주기 때문에 그냥 poll한다.
     * @throws IOException because of BufferedWriter
     */
    private static void printASC() throws IOException {

        while (!pq.isEmpty()) bw.append(pq.poll() + "\n");
        bw.close();

    }

    public static void main(String[] args) throws IOException {

        initBOJ2751(); // 1. N개의 수를 입력받고 Queue에 offer
        printASC();    // 2. 결과를 하나씩 출력

    }

}
