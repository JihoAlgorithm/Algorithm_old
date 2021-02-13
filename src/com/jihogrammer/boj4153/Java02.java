package com.jihogrammer.boj4153;

import java.io.*;
import java.util.StringTokenizer;

public class Java02 {
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
                c = Integer.parseInt(st.nextToken()),
                h = Math.max(Math.max(a, b), c);
            if (a*a + b*b + c*c == 2*h*h) sb.append("right");
            else sb.append("wrong");
            sb.append('\n');
        }

        bw.write(sb.toString()); bw.close();
    }
}
