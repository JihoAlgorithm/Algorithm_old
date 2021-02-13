package com.jihogrammer.boj10250;

import java.io.*;
import java.util.StringTokenizer;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T>0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken()); st.nextToken();
            //  W = Integer.parseInt(st.nextToken()), // 쓰지도 않을 놈
            int N = Integer.parseInt(st.nextToken());
            
            if ((N % H) == 0) sb.append((H * 100) + (N / H)).append('\n');
            else sb.append((N % H * 100) + (N / H + 1)).append('\n');
        }

        bw.write(sb.toString()); bw.close();
    }
}
