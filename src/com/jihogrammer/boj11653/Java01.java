package com.jihogrammer.boj11653;

public class Java01 {

    /** 정답 출력할 내용을 담는 StringBuilder */
    private static StringBuilder sb;

    /**
     * System.in.read()를 사용하여 N에 숫자를 읽어 return하고,
     * StringBuilder를 생성합니다.
     * @return 소인수분해를 수행할 숫자
     * @throws Exception 실제로는 IOException이 발생합니다.
     */
    private static int initBOJ11653() throws Exception {

        int N, C;
        sb = new StringBuilder();   // static field initialize

        // System.in.read()를 활용하여 N값 입력받기
        N = System.in.read() - '0';
        while ((C = System.in.read()) > 13) N = N * 10 + C - '0';

        return N;

    }

    /**
     * 소인수분해 할 숫자를 입력 받아
     * 작은 수부터 소인수분해를 재귀로 수행하여
     * StringBuilder에 소인수를 하나씩 쌓아줍니다.
     * @param N - 소인수분해 할 숫자
     */
    private static void primeFactorization(int N) {

        /* 문제에서 N값이 1일 경우 아무것도 출력하지
         * 말라는 조건이 있어 바로 메소드를 종료합니다. */
        if (N == 1) return;

        /* 1은 생각하지 않고, 2 이상 N 미만의 범위를 지정하여
         * 작은 수부터 하나씩 나누어 떨어지는지 탐색합니다. */
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {               // N이 i로 나누어 떨어질 경우
                sb.append(i).append('\n');  // 그 때의 i를 출력하고
                primeFactorization(N / i);  // N을 i로 나눈 몫을 재귀로 넘겨줍니다.
                break;                      // 재귀로 넘어갔으니 그냥 종료해줍니다.
            }
        }

    }

    public static void main(String[] args) throws Exception {

        int N = initBOJ11653(); // 1. N값 읽기 및 sb 초기화
        primeFactorization(N);  // 2. N을 매개변수로 넘겨 소인수분해 재귀 시작
        System.out.print(sb);   // 3. 결과 출력

    }

}
