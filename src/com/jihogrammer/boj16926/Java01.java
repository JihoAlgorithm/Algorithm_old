package com.jihogrammer.boj16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Java01 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static StringTokenizer st;
    private static int[][] arr;
    private static int N, M, R;

    private static void init() throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

    }
    
    private static void rotate() {

        int circle = Math.min(N, M) / 2;
        Queue<Integer> cq = new LinkedList<>();

        for (int c = 1; c <= circle; c++) {
            for (int i = c-1; i < M-c; i++) cq.add(arr[c-1][i]);
            for (int i = c-1; i < N-c; i++) cq.add(arr[i][M-c]);
            for (int i = M-c; i > c-1; i--) cq.add(arr[N-c][i]);
            for (int i = N-c; i > c-1; i--) cq.add(arr[i][c-1]);

            for (int i = 0; i < R; i++) cq.add(cq.poll());

            for (int i = c-1; i < M-c; i++) arr[c-1][i] = cq.poll();
            for (int i = c-1; i < N-c; i++) arr[i][M-c] = cq.poll();
            for (int i = M-c; i > c-1; i--) arr[N-c][i] = cq.poll();
            for (int i = N-c; i > c-1; i--) arr[i][c-1] = cq.poll();
        }

    }

    private static void print() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) sb.append(arr[i][j] + " ");
            sb.append('\n');
        }

        System.out.print(sb);

    }

    public static void main(String[] args) throws IOException {

        init();
        rotate();
        print();

    }

}
