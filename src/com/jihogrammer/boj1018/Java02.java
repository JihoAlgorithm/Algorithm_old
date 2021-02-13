package com.jihogrammer.boj1018;

import java.io.*;

public class Java02 {
    public static void main(String[] in) throws IOException {
    // 객체 및 변수 선언
        // 입력 버퍼 객체 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // [입력1] main() 매개변수 재활용, N과 M을 문자열로 읽어들임
        in = br.readLine().split(" ");
        
        // in에 읽어들인 문자열을 N과 M에 숫자로 매칭
        // 필요한 변수들 미리 생성
            // i, j, r(row), c(colomn), x(count), min(64보다 클 수 없다.)
        int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]),
            i = 0, j, r, c, x, min = 64;
        
        // flag: 이를 기준으로 chess판 분석
        // chess: 입력받을 값 저장. N*M 크기로 생성
        boolean flag, chess[][] = new boolean[N][M];

    // 입력 받기
        while (true) {
            // 위에서 사용한 String[]의 0번 인덱스를 재활용.
            // 한 줄씩 읽어들인 후 문자 하나씩 분류하는데,
            // 문자가 B(66)이면 false로 초기화된 chess에 true를 입력해준다.
            in[0] = br.readLine();
            for (j=0; j<M; j++) if(in[0].charAt(j) == 66) chess[i][j] = true;
            if (++i == N) break; // 선언부에서 i=0으로 초기화되어 있다.
        }

    // 체스판 8칸씩 돌리기
        // (N-7)과 (M-7)인 이유는 체스판이 8*8 크기이므로,
        // 8*8보다 크거나 같은 크기의 입력을 8*8씩 나누어 생각해야 한다.
        for (i=0; i<N-7; i++) {
            for (j=0; j<M-7; j++) {
                // flag, x 값 리셋
                flag = true;
                x = 0;
                
                // 이제부터 8*8 크기의 chess판을 분석한다.
                for (r=0; r<8; r++) {
                    for (c=0; c<8; c++) {
                        // flag의 값을 기준으로 해당 chess 칸이 다를 경우 x++
                        // i와 j에 각각 row, colomn을 더한다.
                        if (chess[i+r][j+c] != flag) x++;
                        // 흑백이 번갈아가며 대입되므로 flag를 계속 바꾼다.
                        flag = !flag;
                    }
                    // 한 줄의 입력이 끝났을 경우 다시 반대로 바꾼다.
                    // 1열의 끝이 W이면, 2열의 처음도 W이어야 한다.
                    flag = !flag;
                }
                // x가 32보다 큰 경우. 반대로 나머지 절반을 바꾸는 경우도 있으므로 64에서 빼준다.
                if (x > 32) x = 64 - x;
                // 최솟값 대입
                if (x < min) min = x;
            }
        }

        // 정답 출력
        System.out.print(min);
    }
}