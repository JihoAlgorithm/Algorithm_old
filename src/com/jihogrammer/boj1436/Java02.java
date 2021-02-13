package com.jihogrammer.boj1436;

public class Java02 {

    private static int N, C;

    private static void initBOJ1436() throws Exception {

        N = System.in.read() - '0';
        while ((C = System.in.read()) > 13) N = 10 * N + C - '0';

    }

    /**
     * TC를 분석하여 N에 따라 쉽게 수를 유추할 수 있는 패턴을 찾아 적용
     */
    private static void end666() {
        
        if (N == 1) C = 666;
        else if (N <= 1800)             end666(0);    // A
        else if (1800 < N && N <= 2800) end666(1800); // B
        else if (N <= 5500)             end666(2800); // A
        else if (5500 < N && N <= 6500) end666(5500); // B
        else if (N <= 9200)             end666(6500); // A
        else if (9200 < N)              end666(9200); // B

    }

    /**
     * 범위 기준값에 따라 다른 연산 적용
     * @param end N의 범위 기준값 -> 일종의 블랙박스 테스트랄까
     */
    private static void end666(int end) {

        C = N - end - 1;
        N -= end;

        switch (end) {
            case 1800: C +=  666000; return; // B
            case 5500: C += 1666000; return;   // B에 해당하는 N의 범위는 일련적으로
            case 9200: C += 2666000; return;   // (어떤 수) + C를 해주고 메소드 종료시키기

            case 0:    C  = 665;     break;  // A
            case 2800: C  = 667665;  break;    // B에서 적용한 범위 외에 수들은
            case 6500: C  = 1667665; break;    // 기존 방식대로 답 도출
        }

        while (true)
            if (Integer.toString(++C).contains("666"))
                if (--N < 1) return;

    }

    public static void main(String[] args) throws Exception {

        initBOJ1436();
        end666();
        System.out.print(C);

    }

}
