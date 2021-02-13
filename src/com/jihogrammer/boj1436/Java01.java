package com.jihogrammer.boj1436;

public class Java01 {

    private static int N, C;

    /**
     * N을 입력받습니다.
     * @throws Exception System.in.read()로 인한 오류처리. 원래는 IOException 발생.
     */
    private static void initBOJ1436() throws Exception {

        N = System.in.read() - '0';
        while ((C = System.in.read()) > 13) N = 10 * N + C - '0';

    }

    /** 
     * 666부터 순차적으로 1씩 증가시켜 문자열로 변환한 수가 "666"을 포함하고 있는지 확인
     */
    private static void end666() {

        C = 665; // 첫 숫자가 666이지만 ++ 연산자로 접근하므로 665부터 시작

        while (true)                                    // N이 0이 될 때까지 무한반복하여
            if (Integer.toString(++C).contains("666"))  // C가 666을 포함한다면
                if (--N < 1) return;                    // N을 1 감소시켜 조건문을 만족하면 return

    }

    public static void main(String[] args) throws Exception {

        initBOJ1436();          // 1. N 입력받기
        end666();               // 2. N번 째 666 포함 숫자 찾기
        System.out.print(C);    // 3. 결과 출력

    }

}
