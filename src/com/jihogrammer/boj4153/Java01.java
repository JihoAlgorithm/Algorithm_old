package com.jihogrammer.boj4153;

import java.io.*;
import java.util.StringTokenizer;

public class Java01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s;

        while (!(s = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st.nextToken()),
                b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken());
            if      (a*a + b*b == c*c) sb.append("right");
            else if (b*b + c*c == a*a) sb.append("right");
            else if (c*c + a*a == b*b) sb.append("right");
            else sb.append("wrong");
            sb.append('\n');
        }

        bw.write(sb.toString()); bw.close();
    }
}
