package com.jihogrammer.boj1436;

public class Java03 {

    private static int N, C;

    private static void initBOJ1436() throws Exception {

        N = System.in.read() - '0';
        while ((C = System.in.read()) > 13) N = 10 * N + C - '0';

    }

    private static void end666() {
        
        if (N == 1) C = 666;
        else if (N <= 1800)             end666(0);
        else if (1800 < N && N <= 2800) end666(1800);
        else if (N <= 5500)             end666(2800);
        else if (5500 < N && N <= 6500) end666(5500);
        else if (N <= 9200)             end666(6500);
        else if (9200 < N)              end666(9200);

    }

    private static void end666(int end) {

        int cnt = 0; // 밑에서 시작값(C)과 N이 변하므로 0부터 천천히 카운트

        C = N - end - 1;
        N -= end;

        switch (end) {
            case    0: C  =     665; break;

            case 1800: C +=  666000; return;
            case 2800: C  =  667665; break;

            case 5500: C += 1666000; return;
            case 6500: C  = 1667665; break;

            case 9200: C += 2666000; return;
        }

        // 원하는 N번째 수를 찾을 때까지 반복
        while (cnt != N) if (isEnd(++C)) cnt++;

    }

    /**
     * 종말이 수인지 판별
     * @param C static 변수와 이름이 겹치지만 여기서는 local 변수이다.
     * 계속 사용하던 변수라 이름을 통일시켜 관리한다.
     * @return C가 종말의 수면 true 반환
     */
    private static boolean isEnd(int C) {

        int continuous6Cnt = 0;

        while (C > 0) {

            if (C % 10 == 6) continuous6Cnt++;
            else continuous6Cnt = 0;

            if (continuous6Cnt == 3) break;

            C /= 10;
        }

        return continuous6Cnt == 3;

    }

    public static void main(String[] args) throws Exception {

        initBOJ1436();
        end666();
        System.out.print(C);

    }

}
