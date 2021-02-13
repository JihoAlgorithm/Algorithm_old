package com.jihogrammer.boj3009;

import java.io.*;
import java.util.StringTokenizer;

public class Java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append(br.readLine()).append(' ').append(br.readLine()).append(' ').append(br.readLine());
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int x1 = Integer.parseInt(st.nextToken()), y1 = Integer.parseInt(st.nextToken()),
            x2 = Integer.parseInt(st.nextToken()), y2 = Integer.parseInt(st.nextToken()),
            x3 = Integer.parseInt(st.nextToken()), y3 = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        sb.append(x1 == x2 ? x3 : x2 == x3 ? x1 : x2).append(' ')
          .append(y1 == y2 ? y3 : y2 == y3 ? y1 : y2);

        bw.write(sb.toString()); bw.close();
    }
}