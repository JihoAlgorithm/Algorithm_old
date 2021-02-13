package com.jihogrammer.boj2563;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java01 {

    /** 색종이의 수 */
    private static int N;
    private static final int X = 0, Y = 1;
    /** 색칠된 넓이 */
    private static int area = 0;
    /** 색종이 좌표 */
    private static int[][] coloredPaper;
    /** 도화지 */
    private static boolean[][] drawingPaper; 
    /* 문제 상에서 도화지의 한계가 100이기 때문에,
     * 그냥 101*101 크기로 고정하는 게 성능에 더 도움이 될 수도 있다.
     * 색종이의 좌표의 최댓값을 얻는 과정에서 비용이 더 부담되기 때문이다.
     * 만약 도화지 크기의 제한이 없다면 색종이의 최대, 최소 좌표를 구해야 할 것이다.
     */

    /**
     * TC를 입력받아 색종이 좌표의 목록과 크기가 맞는 도화지를 생성한다.
     * @throws Exception
     */
    private static void init() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼 생성
        StringTokenizer st; // TC에서 색종이의 좌표가 공백을 두고 한 줄로 주어지는데, 이를 자를 StringTokenizer 선언

        int maxX = 0; // 색종이 목록 중 X좌표의 최댓값을 저장할 변수를 0으로 초기화
        int maxY = 0; // 색종이 목록 중 Y좌표의 최댓값을 저장할 변수를 0으로 초기화

        N = Integer.parseInt(br.readLine()); // 색종이의 수를 String으로 받아 정수로 파싱하여 N에 대입

        coloredPaper = new int[N][2]; // 색종이의 수만큼의 행과 X, Y 좌표를 저장할 열을 가진 2차원 배열 생성

        // TC에서 한 줄씩 입력받아 색종이의 좌표값을 대입하고, 더불어 maxX, maxY의 값도 구한다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            // 색종이 좌표 값 저장
            coloredPaper[i][X] = Integer.parseInt(st.nextToken());
            coloredPaper[i][Y] = Integer.parseInt(st.nextToken());

            // 색종이 X, Y 좌표의 최댓값 계산 
            maxX = Math.max(maxX, coloredPaper[i][X]);
            maxY = Math.max(maxY, coloredPaper[i][Y]);
        }

        // 색종이의 좌하단 좌표가 주어지는 것이고, 배열의 인덱스를 조정하기 위해 11을 더해준다.
        maxX += 11;
        maxY += 11;

        // 도화지 배열 생성
        drawingPaper = new boolean[maxX][maxY];

    }

    /**
     * 색종이의 수만큼 오버로딩된 메소드를 반복 호출한다.
     */
    private static void paint() {

        for (int i = 0; i < N; i++)
            paint(coloredPaper[i][X], coloredPaper[i][Y]);

    }

    /**
     * 도화지에 색종이 좌표를 활용하여 색칠되면 true로 바꿔준다.
     * 이때, 접근한 인덱스의 값이 이미 색칠되어 있으면 넘어가게끔 설정하고,
     * true로 변경 시 area 값을 1 올려준다.
     * @param x 색종이의 X 좌표
     * @param y 색종이의 Y 좌표
     */
    private static void paint(int x, int y) {

        int w = x + 10; // (최적화) 색종이의 너비
        int h = y + 10; // (최적화) 색종이의 높이

        // 100번(색종이의 넓이) 반복하여 도화지의 각 인덱스 값에 접근하여 색칠(paint)한다.
        for (int i = x; i < w; i++)
            for (int j = y; j < h; j++) {
                if (!drawingPaper[i][j]) {     // 접근한 값이 false라면 색칠해준다.
                    area++;                    // 색칠했으니 넓이값을 1 올려준다.
                    drawingPaper[i][j] = true; // 색칠했으니 true로 바꿔준다.
                }
            }

    }

    public static void main(String[] args) throws Exception {

        init();                     // 1. 색종이 및 도화지 초기화
        paint();                    // 2. 도화지 색칠 및 넓이 계산
        System.out.print(area);     // 3. 넓이 출력

    }

}
