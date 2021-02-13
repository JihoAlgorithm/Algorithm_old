package com.jihogrammer.boj1018;

import java.io.FileReader;
import java.util.StringTokenizer;

public class JavaFileInputExample {
    /**
     * text 파일을 1부터 n개 까지 자동으로 읽어들여 테스트하는 프로그램
     */
    
    static final int TEST = 4; // Test Case 개수 입력

    public static void main(String[] paths) throws Exception {
        paths = new String[TEST];
        StringTokenizer st;
        String input;
        int CASE, N, M, count;

        // TestCase 만큼 for문 반복
        for (CASE=0; CASE<TEST; CASE++) {
            // 경로는 알아서 조정하자~
            paths[CASE] = "src/bj01018/case" + (CASE+1) + ".txt";

            // readFile() 호출
            input = readFile(paths[CASE]);

            // StringTokenizer로 N,M 대입
            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println("【 " + (CASE+1) + "번 Test 】");
            System.out.println("* N: " + N + "\tM: " + M);
            count = seek(N, M, st); // 답 찾는 seek() 함수 호출
            System.out.println("* testcase " + (CASE+1) + " 의 변경 최솟값: " + count + "\n\n");
        }
    }

    // .txt 파일 읽어들이는 함수
    private static String readFile(String path) throws Exception {
        FileReader reader = new FileReader(path);
        StringBuilder sb = new StringBuilder();
        char[] cbuf = new char[100];
        int charNo;

        while ((charNo = reader.read(cbuf)) != -1)
            sb.append(new String(cbuf, 0, charNo));

        reader.close();
        return sb.toString();
    }

    // 8*8 크기의 배열 출력
    static void printBoard(boolean[][] draw, int x) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (draw[i][j]) sb.append('B');  // 'B'
                else sb.append('W');  // 'W'
            }
            sb.append('\n');
        }
        System.out.println(sb);
        System.out.println("count: " + x + "회\n");
    }

    private static int seek(int N, int M, StringTokenizer st) {
        char[][] chess = new char[N][M];
        boolean flag, draw[][];
        int i, j, x, count = 64;

        System.out.println("** 원본 입력 상태 **");
        for (i=0; i<N; i++) {
            chess[i] = st.nextToken().toCharArray();
            System.out.println(chess[i]);
        }

        // 세로 탐색
        for (i=0; i<N-7; i++) {
            // 가로 탐색
            for (j=0; j<M-7; j++) {
                System.out.println("\n[(" + i + ", " + j + ") 부터 8*8 탐색]");
                draw = new boolean[8][8];
                x = 0;

                if (chess[i][j] == 66) flag = true;
                else flag = false;

                // draw 배열에 대입 및 count 계산
                for (int row=0; row<8; row++) {
                    for (int col=0; col<8; col++) {
                        if (chess[i+row][j+col] == 66) draw[row][col] = true;

                        if (draw[row][col] != flag) x++;
                        flag = !flag;
                    }
                    flag = !flag;
                }

                // x > 32일 경우 그 반대를 바꾸는 경우도 있으므로 값 조정
                if (x > 32) x = 64 - x;

                // draw 출력
                printBoard(draw, x);
                
                // 최솟값 대입
                if (x < count) count = x;
            }
        }

        return count;
    }
}
