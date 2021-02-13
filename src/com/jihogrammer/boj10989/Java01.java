package com.jihogrammer.boj10989;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Java01 {

    /** 1부터 10000까지의 수가 몇 번 입력되었는지 저장 */
    private static int[] nums;
    private static BufferedWriter bw;

    /**
     * N개의 수를 입력받고, nums 배열 해당 인덱스의 값을 1씩 증가
     * @throws IOException because of System.in.read()
     */
    private static void initBOJ10989() throws IOException {

        int N, num, c; // 필요한 변수 선언

        // 필요한 객체 생성
        nums = new int[10001];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N값 입력받기
        N = System.in.read() - '0';
        while ((c = System.in.read()) > 13) N = 10 * N + c - '0';
        // System.in.read();

        while (N-->0) { // N개의 수를 입력받기

            // 숫자 읽기
            num = System.in.read() - '0';
            while ((c = System.in.read()) > 13) num = 10 * num + c - '0';
            // System.in.read();

            nums[num]++; // 읽은 숫자를 인덱스로 하는 값을 1 증가

        }

    }

    /**
     * repeat() 메소드를 활용하여 bw로 간단하게 출력
     * @throws IOException because of {@link BufferedWriter}
     */
    private static void printASC() throws IOException {

        // nums는 0으로 초기화 되어 있으므로 repeat()을 만나 0이면 출력 안 함
        for (int i = 1; i < 10001; i++) // 0은 자연수가 아니라 생략
            bw.write( (i + "\n").repeat(nums[i]) );

        bw.close(); // 최종 출력

    }

    public static void main(String[] args) throws IOException {

        initBOJ10989();
        printASC();

    }

}
