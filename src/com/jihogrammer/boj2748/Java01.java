package com.jihogrammer.boj2748;

import java.io.IOException;

public class Java01 {

    public static void main(String[] args) throws IOException {

        int c, N = 0; // 필요한 변수 선언

        // N 입력받기
        while ((c = System.in.read()) > 13) N = 10 * N + (c - '0');

        // 인덱스 값으로 피보나치수를 계산하기 때문에 N+1 크기로 생성
        long[] fibo = new long[N+1]; // N+1 크기의 long 배열 생성
        fibo[1] = 1;                 // F(1)의 값을 1로 변경
        // Java에서는 long배열의 기본값이 0으로 초기화되어 있기 때문에
        // fibo[0]의 값을 0으로 할당할 필요가 없어서 생략했다.

        // 상향식 접근을 통한 피보나치 수열 계산
        for (int i = 2; i <= N; i++)
            fibo[i] = fibo[i-2] + fibo[i-1];

        System.out.print(fibo[N]); // 결과 출력

    }

}
